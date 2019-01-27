package naztech.io.database;

/**
 * Hello world!
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
    {
       Class.forName("org.h2.Driver").newInstance();
       Connection con=DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mp");
       String sql = "CREATE TABLE IF NOT EXISTS Customer (\n"
               + "	id integer PRIMARY KEY,\n"
               + "	name text NOT NULL,\n"
               + "	salary real\n"
               + ");";
       Statement stmt = con.createStatement();
       stmt.execute(sql);
       String sql2 = "INSERT INTO Customer(id,name,salary) VALUES(32,'sop',21000)";
       stmt.execute(sql2);
       PreparedStatement statement = con.prepareStatement(
               "SELECT * FROM Customer");
       Statement stmt2 = con.createStatement();
       String query = "select * from Customer ;";
   //person is the table name
       ResultSet rs = stmt2.executeQuery(query);
       while (rs.next()) {
           String id = rs.getObject(1).toString();
           String name = rs.getObject(2).toString();
           String salary = rs.getObject(3).toString();
           System.out.println("Name of the person is " + id + " and his gender is " + name+"salary is"+salary);
  

       }
      
       String query3 = "select MAX(salary) from Customer ;";
   //person is the table name
       ResultSet rs3 = stmt2.executeQuery(query3);
       while (rs3.next()) {
          
           String salary = rs3.getString(1).toString();
           System.out.println("Maximum salary is " + salary );
  

       }
       String query4 = "select MIN(salary) from Customer ;";
       //person is the table name
           ResultSet rs4 = stmt2.executeQuery(query4);
           while (rs4.next()) {
              
               String salary = rs4.getString(1).toString();
               System.out.println("Minimum salary is " + salary);
      

           }
           
           String query5 = "select AVG(salary) from Customer ;";
           //person is the table name
               ResultSet rs5 = stmt2.executeQuery(query5);
               while (rs5.next()) {
                  
                   String salary = rs5.getString(1).toString();
                   System.out.println("Average salary is " + salary );
          

               }
               
               String query6 = "SELECT  MAX(salary) AS salary FROM Customer where  salary < (SELECT MAX(salary)FROM Customer);";
               ResultSet rs6 = stmt2.executeQuery(query6);
               while (rs6.next()) {
                  
                   String salary = rs6.getString(1).toString();
                   System.out.println("Second Highest salary is " + salary );
          
      } 
               
               String query7 = "SELECT  TOP 3 * FROM Customer ORDER BY salary DESC ;";
               ResultSet rs7 = stmt2.executeQuery(query7);
               while (rs7.next()) {
            	   String id = rs7.getString(1).toString();
            	   String name = rs7.getString(2).toString();
                   String salary = rs7.getString(3).toString();
                   System.out.println("id is"+id+"name is"+name+"Top 3 salary is " + salary );
          
      }
              
             
               
               String query9 = "SELECT  COUNT(id), salary FROM Customer GROUP BY salary HAVING COUNT(id)>15 ORDER BY  COUNT(id) DESC;";
               ResultSet rs9 = stmt2.executeQuery(query9);
               while (rs9.next()) {
            	   String id = rs9.getString(1).toString();
            	   String name = rs9.getString(2).toString();
                   String salary = rs9.getString(3).toString();
                   System.out.println(id+ name +" salary is " + salary );
          
      }
             
    }
    }

