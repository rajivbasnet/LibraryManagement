/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Rajiv
 */
public class ReturnBook extends StudentInfo{
    
    public ReturnBook(){
       super();
       
       String stdID = super.getStudentID();
       String name = super.getStudentName();
       String bookID = super.getBookID();
       String date = super.getDate();
       
       removeFromDatabase(stdID, name, bookID, date);
      

    }
    
    public void  removeFromDatabase(String stdID, String name, String bookID, String date){
            
        try
                {
                    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://CaldwellLibrary.accdb");
                    
                    String insertNewRecordSQL = "DELETE FROM studentInfo WHERE StudentID  = '" + stdID + "' AND BookID = '" + bookID + "'";
                    PreparedStatement pstmt = conn.prepareStatement(insertNewRecordSQL);
                    pstmt.execute();
                    
                    System.out.println("\nRecord DELETED. Book Returned.");
                    
                    System.out.println("The following record has been REMOVED : \t" + stdID + "\t" + name + "\t" + bookID + "\t" + date);
                }
        
            catch(SQLException err)
                {
                    System.out.println(err);
                }
    }
}
