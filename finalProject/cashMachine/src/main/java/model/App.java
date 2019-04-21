package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello!");
//
//        Connection connection =
//                null;
//        try {
//            connection = DriverManager.
//                    getConnection("jdbc:" +
//                                    "mysql:" +
//                                    "//localhost:3306/" +
//                                    "cashmachine" +
//                                    "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
//                            "root",
//                            "root");
//
//
//            Statement query = connection.createStatement();
//            ResultSet rs = query.executeQuery("SELECT * FROM worker");
//            while (rs.next()) {
//                System.out.println(rs.getString("name"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        Properties properties = new Properties();

        String lang ="ua";
        try {
            properties.load(new FileInputStream(
                    "C:\\java\\javaTools\\git\\Projects\\hometask\\finalProject\\cashMachine\\src\\main\\java\\resources\\regex.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String loginRegex = properties.getProperty("login.regex");
        String passwordRegex = properties.getProperty("password.regex");
        String nameRegex = properties.getProperty("name.regex");



        System.out.println(nameRegex);
        System.out.println(loginRegex);
        System.out.println(passwordRegex);

        String name = "Dmytro";
        String login = "Dfdsf_0";
        String password = "1242gfdSD_3234";

        System.out.println("----------------------------------------------------------------");
        System.out.println(name.matches(nameRegex));
        System.out.println(login.matches(loginRegex));
        System.out.println(password.matches(passwordRegex));

    }
}
