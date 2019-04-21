package model.dao.impl;

import model.dao.UserDao;
import model.dao.mapper.UserMapper;
import model.entity.Worker;
import model.entity.myException.WorkerNotExistException;

import java.sql.*;
import java.util.*;

public class JDBCUserFactory implements UserDao {
    private Connection connection;

    public JDBCUserFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Worker> findByLogin(String login) {
        Optional<Worker> result = Optional.empty();
        String query = "select * from worker where login = ?";
        try(PreparedStatement ps = connection.prepareCall(query)){
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();

            UserMapper userMapper = new UserMapper();

            if(rs.next()){
                result = Optional.of(userMapper.extractFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void create(Worker worker) {
        String query = "insert into worker (idWorker, name, role, login, password) values (?,?,?,?,?) order by idWorker";
        try(PreparedStatement ps = connection.prepareCall(query)){
            ps.setInt(1, worker.getId());
            ps.setString(2, worker.getName());
            ps.setString(3, worker.getRole().toString().toLowerCase());
            ps.setString(4, worker.getLogin());
            ps.setString(5, worker.getPassword());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Worker entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Worker findById(int id) throws WorkerNotExistException{
        Worker worker = null;
        final String query = "select * from worker where idWorker=?";

        try(PreparedStatement ps = connection.prepareCall(query)){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            UserMapper userMapper = new UserMapper();

            while(rs.next()){
                worker = userMapper.extractFromResultSet(rs);
            }
            if (worker==null)
                throw new WorkerNotExistException("Sorry. worker doesn't exist");
            return worker;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new WorkerNotExistException("Sorry. worker doesn't exist");
}

    @Override
    public List<Worker> findAll() {
        Map<Integer, Worker> workers = new HashMap<>();

        final String query = "select * from worker";

        try(Statement st = connection.createStatement()){

            ResultSet rs = st.executeQuery(query);

            UserMapper userMapper = new UserMapper();

            while(rs.next()) {
                Worker worker = userMapper.extractFromResultSet(rs);
                userMapper.makeUnique(workers, worker);
            }

            return new ArrayList<>(workers.values());

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
