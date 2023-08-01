/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hostel.management.system;
import java.sql.*;
/**
 *
 * @author USER
 */
public class HostelManagementSystem {
    public static Connection con=null;
    
    
    public static void  main(){
        
     try{
             login lg = new login();
         lg.show();
        
       
        }catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Not Connected");

        }
    
   
}}
