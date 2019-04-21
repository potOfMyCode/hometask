package model.dao.impl;

import model.dao.CheckDao;
import model.dao.mapper.CheckMapper;
import model.entity.Check;
import model.entity.Product;
import model.entity.myException.ProductNotExistException;
import model.service.UserService;
import model.service.productMakerService.ProductMakerService;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCCheckFactory implements CheckDao {
    private Connection connection;

    public JDBCCheckFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Check check) {
        String query1 = "insert into cashmachine.check (idCheck, price) values (?,?)";
        String query2 = "insert into worker_has_check (worker_idWorker, check_idCheck) values (?,?)";
        try(PreparedStatement ps1 = connection.prepareCall(query1); PreparedStatement ps2 = connection.prepareCall(query2)){

            ps1.setInt(1, check.getidCheck());
            ps1.setInt(2, check.getPrice());
            ps1.executeUpdate();

            ps2.setInt(1,check.getidWorker());
            ps2.setInt(2, check.getidCheck());
            ps2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void addProductToCheck(Check check, Product product) {
        String query2 = "insert into check_has_product (check_idCheck, product_idProduct, product_attributeValue) values (?,?,?)";
        try(PreparedStatement ps2 = connection.prepareCall(query2)){

            ps2.setInt(1, check.getidCheck());
            ps2.setInt(2, product.getidProduct());
            ps2.setInt(3, check.getProducts().get(product.getidProduct()));
            ps2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Check check) {
        String query1 = "update cashmachine.check set price=(?) where idCheck=(?)";
        String query2 = "update cashmachine.check_has_product set product_attributeValue=(?) where check_idCheck=(?) and product_idProduct=(?)";
        try(PreparedStatement ps1 = connection.prepareCall(query1);
            PreparedStatement ps2 = connection.prepareCall(query2)){

            ps1.setInt(1, check.getPrice());
            ps1.setInt(2, check.getidCheck());
            ps1.executeUpdate();


            for (Map.Entry<Integer, Integer> entry : check.getProducts().entrySet()) {
                System.out.println("check.getProducts().entrySet() " + check.getProducts().entrySet());
                ps2.setInt(1, entry.getValue());
                ps2.setInt(2, check.getidCheck());
                ps2.setInt(3, entry.getKey());
                ps2.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query1 = "delete from cashmachine.check_has_product where check_idCheck = (?);";
        String query2 = "delete from cashmachine.worker_has_check where check_idCheck = (?);";
        String query3 = "delete from cashmachine.check where idCheck = (?);";

        try(PreparedStatement ps1 = connection.prepareCall(query1);
            PreparedStatement ps2 = connection.prepareCall(query2);
            PreparedStatement ps3 = connection.prepareCall(query3)){
            connection.setAutoCommit(false);

            ps1.setInt(1, id);
            ps1.executeUpdate();

            ps2.setInt(1, id);
            ps2.executeUpdate();

            ps3.setInt(1, id);
            ps3.executeUpdate();

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
    public void deleteProductFromCheck(Check check, int id, int attribute_value) throws ProductNotExistException {
        String query;
        ProductMakerService productMakerService = new ProductMakerService();
        for (Map.Entry<Integer, Integer> entry : check.getProducts().entrySet()) {
            if (entry.getKey() == id){
                if(attribute_value>=entry.getValue()) {
                    check.setPrice(check.getPrice() - entry.getValue() * productMakerService.getProduct(id).getPrice());
                    query = "delete from cashmachine.check_has_product where check_idCheck = (?) and product_idProduct = (?)";
                    try(PreparedStatement ps1 = connection.prepareCall(query)){

                        ps1.setInt(1, check.getidCheck());
                        ps1.setInt(2, id);
                        ps1.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    update(check);
                    return;
                }
            }
        }
        check.setPrice(check.getPrice()- attribute_value*productMakerService.getProduct(id).getPrice());
        Map<Integer, Integer> products = check.getProducts();
        int newAttr = check.getProducts().get(id) - attribute_value;
        products.remove(id);
        products.put(id, newAttr);
        check.setProducts(products);
        update(check);

    }

    @Override
    public Map<Integer, Integer> getZReport() {
        Map<Integer, Integer> products = new HashMap<>();

        final String query = "select product_idProduct, sum(product_attributeValue) from check_has_product group by product_idProduct";

        try(Statement st = connection.createStatement()){

            ResultSet rs =st.executeQuery(query);

            while(rs.next()){
                int idProduct = rs.getInt("product_idProduct");
                int sum = rs.getInt("sum(product_attributeValue)");
                products.put(idProduct, sum);

            }

            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public  Map<String, Integer> getXReport() {
        Map<String, Integer> workers = new HashMap<>();
        final String query = "select worker_has_check.worker_idWorker, sum(cashmachine.check.price)\n" +
                " from cashmachine.check, worker_has_check\n" +
                " where cashmachine.check.idCheck=worker_has_check.check_idCheck group by worker_has_check.worker_idWorker";

        try(Statement st = connection.createStatement()){

            ResultSet rs =st.executeQuery(query);

            UserService userService = new UserService();
            while(rs.next()){
                int idWorker = rs.getInt("worker_idWorker");
                int sum = rs.getInt("sum(cashmachine.check.price)");

                workers.put(userService.getById(idWorker).getName(), sum);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return workers;
    }

    @Override
    public Check findById(int id) {
        Check result = null;
        String query = "select cashmachine.check.idCheck, cashmachine.check.price, worker_has_check.worker_idWorker, \n" +
                "check_has_product.product_idProduct, check_has_product.product_attributeValue\n" +
                " from cashmachine.check, worker_has_check, check_has_product\n" +
                "where cashmachine.check.idCheck = (?) and cashmachine.check.idCheck=worker_has_check.check_idCheck and cashmachine.check.idCheck = check_has_product.check_idCheck order by idCheck";
        try(PreparedStatement ps = connection.prepareCall(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            CheckMapper checkMapper = new CheckMapper();

            if(rs.next()){
                result = checkMapper.extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Check> findAll() {
        Map<Integer, Check> products = new HashMap<>();

        final String query = "select cashmachine.check.idCheck, cashmachine.check.price, worker_has_check.worker_idWorker, \n" +
                "check_has_product.product_idProduct, check_has_product.product_attributeValue\n" +
                " from cashmachine.check, worker_has_check, check_has_product\n" +
                "where cashmachine.check.idCheck=worker_has_check.check_idCheck and cashmachine.check.idCheck = check_has_product.check_idCheck order by idCheck";

        try(Statement st = connection.createStatement()){

            ResultSet rs =st.executeQuery(query);

            CheckMapper checkMapper = new CheckMapper();

            while(rs.next()){
                Check check =checkMapper.extractFromResultSet(rs);
                checkMapper.makeUnique(products, check);
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
