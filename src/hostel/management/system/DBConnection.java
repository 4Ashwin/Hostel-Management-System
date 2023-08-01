/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hostel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author USER
 */
public class DBConnection {
    public static Connection con=null;
    
    
    public static Connection getConnection(){
        
     try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelmanagementsystem","root","dbms@123");
        if(con!=null)
        {
            System.out.println("successfully connected");
        }
        }catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Not Connected");

        }finally{
         return con;
     }   
    }
}
