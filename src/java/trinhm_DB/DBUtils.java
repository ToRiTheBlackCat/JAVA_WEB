package trinhm_DB;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class DBUtils implements Serializable{
    public static Connection makeConnection(){
        try{
            //1.Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.Tao connection string - protocol:localserver://diachiIP:port;tendb;teninstace
            String url = "jdbc:sqlserver://localhost:1433;databaseName=trinhmse184714_sp24";
            //3.Lay connection
            Connection con = DriverManager.getConnection(url,"sa","12345");
            //4.Tra connection cho doi tuong goi
            return con;
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        } catch( SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}
