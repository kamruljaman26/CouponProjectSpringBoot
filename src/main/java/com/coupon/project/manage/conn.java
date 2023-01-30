package com.coupon.project.manage;
import java.sql.*;
//This is ConnectionPool Class
public class conn {
    Connection con;
    Statement stmt;
    
    public conn()
    {

        try {
        
        	con=getInstance();
            stmt=con.createStatement();
          
             

        } catch (Exception e) {
           e.printStackTrace();
        } 
    }
    public Connection getInstance()
  throws Exception  {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Admin1","root","");
        return con;
    }
    public void CloseAllConnection()
   throws Exception {
    	con.close();
    }
    public void restoreConnection(Connection con)
   throws Exception {
    	con.releaseSavepoint(null);
    }
    

    
    public static void main(String[] args)
   throws Exception {
              	new conn();
    }
    }

