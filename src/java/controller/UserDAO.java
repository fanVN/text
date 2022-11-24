/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;


public class UserDAO {
    private static String SELLECT_USERNAME = "SELECT * FROM user WHERE username =?";
    private static String SELLECT_USERNAME_BY_ID = "SELECT * FROM user WHERE id =?";
    private static String SELLECT_ALL = "SELECT * FROM user";
    private static String INSERT_USER = 
            "INSERT INTO user (username,password, email, phone) VALUES (?, ?, ?, ?)";
    private static String UPDATE_USER = 
            "UPDATE user SET username=?, password=?, email=?, phone=? WHERE id=?";
    private static String DELETE_USER = "DELETE FROM user WHERE id=?";
    
    public static User selectUser(String username){
        Connection con = MyConnection.getConnection("root", "");
        User u = new User();
        try {
            PreparedStatement ps = con.prepareStatement(SELLECT_USERNAME);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setId(rs.getLong("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;        
    }  
    public static User selectUser(long id){
        Connection con = MyConnection.getConnection("root", "");
        User u = new User();
        try {
            PreparedStatement ps = con.prepareStatement(SELLECT_USERNAME_BY_ID);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setId(rs.getLong("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;        
    }  
    public static Vector <User> selectALL(){
        Vector <User> listUser = new Vector();
        Connection con = MyConnection.getConnection("root", "");
        try {
            PreparedStatement ps = con.prepareStatement(SELLECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getLong("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));   
                listUser.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUser;
    }
    
    public static int insertUser(String username, String password, String email,
            String phone){
        Connection con = MyConnection.getConnection("root", "");
        int record_number = 0;
        try {
            PreparedStatement ps = con.prepareStatement(INSERT_USER);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, phone);
            record_number= ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return record_number;        
    }
    public static int updateUser(long id, String username, String password, String email,
            String phone){
        Connection con = MyConnection.getConnection("root", "");
        int record_number = 0;
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE_USER);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setLong(5, id);
            record_number= ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return record_number;        
    }
    public static int deleteUser(long id){
        Connection con = MyConnection.getConnection("root", "");
        int record_number = 0;
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_USER);
            ps.setLong(1, id);
            record_number= ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return record_number;        
    }
}
