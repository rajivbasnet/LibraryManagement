/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;
import java.sql.*;
/**
 *
 * @author Rajiv
 */
public class ConnectDatabase {
    
    private String username;
    private String password;
    private Connection conn;
    
    public ConnectDatabase(){
        
            try
                {
                    conn = DriverManager.getConnection("jdbc:ucanaccess://CaldwellLibrary.accdb");
                    System.out.println("\nConnecting to the Database...");
                }
            catch(Exception err)
                {
                    System.out.println(err);
                }

    }
    
    public void loginDatabase() throws SQLException{
                Statement stment = conn.createStatement();
                String qry = "SELECT * FROM loginInfo";
                ResultSet rs = stment.executeQuery(qry);
                
                while(rs.next())
                {
                    username = rs.getString("Username");
                    password = rs.getString("Password");
                }
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
}
