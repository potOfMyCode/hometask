package model.service;

import model.dao.DaoFactroy;
import model.dao.UserDao;
import model.entity.Worker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class UserService {
    private DaoFactroy daoFactory = DaoFactroy.getInstance();

    public Optional<Worker> login(String login) {
        Optional<Worker> result;

        try (UserDao userDao = daoFactory.createUserDao()) {
            result = userDao.findByLogin(login);
        }

        return result;
    }

    public void addCashierToDB(Worker worker){
        try (UserDao userDao = daoFactory.createUserDao()) {
            userDao.create(worker);
        }
    }

    public List<Worker> getAllWorkers(){
        try (UserDao dao = daoFactory.createUserDao()){
            return dao.findAll();
        }
    }

    public Worker getById(int id){
        try (UserDao dao = daoFactory.createUserDao()){
            return dao.findById(id);
        }
    }

    public boolean validateData(Worker worker) throws IOException {
        Properties properties = new Properties();

        properties.load(new FileInputStream(
                "C:\\java\\javaTools\\git\\Projects\\hometask\\finalProject\\cashMachine\\src\\main\\java\\resources\\regex.properties"));
        String loginRegex = properties.getProperty("login.regex");
        String passwordRegex = properties.getProperty("password.regex");
        String nameRegex = properties.getProperty("name.regex");

        return worker.getName().matches(nameRegex)
                && worker.getLogin().matches(loginRegex)
                && worker.getPassword().matches(passwordRegex);
    }
}
