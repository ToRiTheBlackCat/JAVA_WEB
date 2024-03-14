/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;


import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import trinhm_DB.DBUtils;
import java.sql.*;

/**
 *
 * @author Senti
 */
public class RegistrationDAO implements Serializable{
    public boolean checkLogin(String username, String password) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            con = DBUtils.makeConnection();
            if (con!=null){
                String sql = "Select username, password From Registration where username = ? and password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                // if there is an account
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if(rs!=null) {
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        
        return false;
    }
    
    private List<RegistrationDTO> listAccounts;
    
    public List<RegistrationDTO> getListAccounts(){
        return listAccounts;
    }
    
    public void searchLastname( String searchValue )throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try{
            con = DBUtils.makeConnection();
            
            if( con != null ){
                String sql = "Select * from Registration Where lastname like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                
                rs = stm.executeQuery();
                while( rs.next() ){
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    
                    RegistrationDTO dto = new RegistrationDTO(username, password, lastname, role);
                    
                    if( this.listAccounts == null ){
                        this.listAccounts = new ArrayList<RegistrationDTO>();
                        
                    }
                    this.listAccounts.add(dto);
                    
                }
            }
        } finally {
            if( rs != null ){
                rs.close();
            }
            if( stm != null ){
                stm.close();
            }
            if( con != null ){
                con.close();
            }
        }
    }
    
    public boolean deleteRecord( String username) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBUtils.makeConnection();
            if (con!=null){
                String sql = "delete Registration where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                int row = stm.executeUpdate();                
                // if there is an account
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        
        return false;
    }
    
     public boolean updateRecord(String username, String password,String fullName, boolean role) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBUtils.makeConnection();
            if (con!=null){
                String sql = "Update Registration Set password = ? , lastName = ?, isAdmin = ?  Where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setString(2, fullName);
                stm.setBoolean(3, role);
                stm.setString(4, username);
                
                int row = stm.executeUpdate();
                // if there is an account
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if(stm!=null) {
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        
        return false;
    }

    public boolean SignUp(String username, String password, String fullname, int role) throws SQLException {
    Connection con = null;
    PreparedStatement stm = null;
    
    try {
        con = DBUtils.makeConnection();
        if (con != null) {
            String sql = "INSERT INTO Registration (username, password, lastname, isAdmin) VALUES (?, ?, ?, ?)";
            stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, fullname);
            stm.setInt(4, role);
            int rowsAffected = stm.executeUpdate();
            if (rowsAffected > 0) {
                // Registration successful
                return true;
            } 
        }
    } finally {
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }
        return false;
    
}
     

}
