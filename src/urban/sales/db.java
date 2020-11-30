/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package urban.sales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vicky
 */
public class db {
    
  public static Connection mycon() throws SQLException, ClassNotFoundException{
  
      
      Connection con = null;
      
      try{
       Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection("jdbc:mysql://localhost/urban_sales","root","");
       return con;
       
      }catch(SQLException e){
      
          System.out.println(e);
          return null;
          
      }
  }
    
}
