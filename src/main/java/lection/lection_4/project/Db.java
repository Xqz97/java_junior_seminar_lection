package lection.lection_4.project;

import java.sql.*;

public class Db {

    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String user = "root";
    private static final String password = "12345";
    private static final String dbName = "test";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement statement = con.createStatement()) {
/*            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
            System.out.println("База данных 'test' успешно создана!");*/
/*            statement.execute("CREATE TABLE `test`.`table` (\n" +
                    " `id` INT NOT NULL,\n" +
                    " `firstname` VARCHAR(45) NULL,\n" +
                    " `lastname` VARCHAR(45) NULL,\n" +
                    " PRIMARY KEY (`id`));");*/
            statement.execute("INSERT INTO `test`.`table` (`id`,`firstname`,`lastname`)\n"
                    +
                    "VALUES (2,'Петров','Петр');");

            ResultSet set = statement.executeQuery("SELECT * FROM `test`.`table`;");
            while (set.next()){
                System.out.println(set.getString(3) + " " + set.getString(2) + " " + set.getInt(1));
            }


            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(String url, String user, String password){
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }


}