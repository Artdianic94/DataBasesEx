package database;

import java.sql.*;

public class DataBaseUtils {
    Connection connect;
    Statement statement;
    public void connect() {
        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/innowiseTrainee?"
                            + "user=root&password=200794juaza&useSSL=true&serverTimezone=GMT");
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public ResultSet selectFrom(String tableName) {
        try {
            return statement
                    .executeQuery(String.format("SELECT * FROM %s", tableName));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("Name");
            String lastName = resultSet.getString("LastName");
            System.out.println("ID: " + id);
            System.out.println("NAME: " + name);
            System.out.println("LAST Name: "+ lastName);
        }
    }
    public void close() {
        try {

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception ignored) {
        }
    }

}
