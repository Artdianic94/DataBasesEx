package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo {
    public static void main(String[] args) throws SQLException {
        DataBaseUtils dataBaseUtils = new DataBaseUtils();
        dataBaseUtils.connect();
        ResultSet selectResult = dataBaseUtils.selectFrom("Students");
        DataBaseUtils.writeResultSet(selectResult);
        dataBaseUtils.close();
    }
}
