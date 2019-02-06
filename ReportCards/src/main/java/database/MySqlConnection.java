package database;

import util.ReportCardsException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    private static final String url = "jdbc:mysql://localhost/userreport?serverTimezone=UTC";
    private static final String user = "ReportCards";
    private static final String pass = "1234";

    public static Connection getConnection(){
        try{
            Connection con = DriverManager.getConnection(url,user,pass);
            return con;

        }catch (SQLException ex){
            throw new ReportCardsException("No database found",ex);
        }
    }

}
