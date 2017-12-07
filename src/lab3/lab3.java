/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class lab3 {
    private Connection con = null;

    
    public Connection connector(){
                
                try{
                Class.forName("com.mysql.jdbc.Driver");   
                }catch(ClassNotFoundException e){
                System.out.println("Where is MySQL driver?");
                e.printStackTrace();
                return con;
                }
            
                try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306"
                        + "/ics2101?autoReconnect=true&useSSL=false","root", "");
                con.setAutoCommit(false);
                }catch(SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return con;
                }
                            if (con != null) {
                            System.out.println("You made it, take control your database now!");
                            } else {
                            System.out.println("Failed to make connection!");
                            }
                            return con;
    }
    
   
    public void closeDB(){
               try{
                   con.close();
               }catch(SQLException sql){
               System.out.println("Error: " + sql.getMessage());
               }
    }
}
