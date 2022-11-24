
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyConnection {
    public static Connection getConnection(String username, String password){
        Connection connect = null;
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/mvc_servlet";
            String driver = "org.gjt.mm.mysql.Driver";
            Class.forName(driver);
            connect = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connect;
    }
}
