package model.dao.impl;

import model.dao.ProductDao;
import model.dao.mapper.ProductMapper;
import model.entity.Product;
import model.entity.myException.ProductNotExistException;
import model.entity.myException.ProductOutOfStockException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCProductFactory implements ProductDao {
    private Connection connection;

    JDBCProductFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Product product) {
        String query1 = "insert into product (idProduct, name, price) values (?,?,?)";
        String query2 = "insert into product_attribute (idProduct, attribute_name, attribute_value) values (?,?,?)";
        try(PreparedStatement ps1 = connection.prepareCall(query1); PreparedStatement ps2 = connection.prepareCall(query2)){
            connection.setAutoCommit(false);
            ps1.setInt(1, product.getidProduct());
            ps1.setString(2, product.getName());
            ps1.setInt(3, product.getPrice());
            ps1.executeUpdate();

            ps2.setInt(1, product.getidProduct());
            ps2.setString(2, product.getAttribute());
            ps2.setInt(3, product.getAttribute_value());
            ps2.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        String query1 = "update cashmachine.product set name=(?), price=(?) where idProduct=(?)";
        String query2 = "update cashmachine.product_attribute set attribute_name=(?), attribute_value=(?) where idProduct=?";
        try(PreparedStatement ps1 = connection.prepareCall(query1); PreparedStatement ps2 = connection.prepareCall(query2)){
            connection.setAutoCommit(false);

            ps1.setString(1, product.getName());
            ps1.setInt(2, product.getPrice());
            ps1.setInt(3, product.getidProduct());
            ps1.executeUpdate();

            ps2.setString(1, product.getAttribute());
            ps2.setInt(2, product.getAttribute_value());
            ps2.setInt(3, product.getidProduct());
            ps2.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public Product findById(int id) throws ProductNotExistException{
        Product result = null;
        String query = "select * from product left join product_attribute using(idProduct) where idProduct=?";
        try(PreparedStatement ps = connection.prepareCall(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            ProductMapper productMapper = new ProductMapper();

            if(rs.next()){
                result = productMapper.extractFromResultSet(rs);
            }
            if (result == null)
                throw new ProductNotExistException("product can't be find");

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new ProductNotExistException("product can't be find");
    }
    @Override
    public Product findByIdForSale(int id, int attribute_value) throws ProductNotExistException, ProductOutOfStockException {
        Product result = null;
        String query = "select * from product left join product_attribute using(idProduct) where idProduct=? and attribute_value>=?";
        try(PreparedStatement ps = connection.prepareCall(query)){
            ps.setInt(1, id);
            ps.setInt(2, attribute_value);
            ResultSet rs = ps.executeQuery();

            ProductMapper productMapper = new ProductMapper();

            if(rs.next()){
                result = productMapper.extractFromResultSet(rs);
            }
            if (result == null)
                throw new ProductOutOfStockException("Sorry, product out od stock");

            result.setAttribute_value(result.getAttribute_value()-attribute_value);
            update(result);

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new ProductOutOfStockException("Sorry, product out od stock");
    }

    @Override
    public List<Product> findAll() {
        Map<Integer, Product> products = new HashMap<>();

        final String query = "select * from product left join product_attribute using(idProduct) order by idProduct";

        try(Statement st = connection.createStatement()){

            ResultSet rs =st.executeQuery(query);

            ProductMapper productMapper = new ProductMapper();

            while(rs.next()){
                Product product =productMapper.extractFromResultSet(rs);
                productMapper.makeUnique(products, product);
            }

            return new ArrayList<>(products.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
