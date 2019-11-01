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
public class BorrowBook extends StudentInfo{
    
    public BorrowBook(){
       super();
       
       String stdID = super.getStudentID();
       String name = super.getStudentName();
       String bookID = super.getBookID();
       String date = super.getDate();
       
       addToDatabase(stdID, name, bookID, date);
      

    }
    
    public void  addToDatabase(String stdID, String name, String bookID, String date){
            
        try
                {
                    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://CaldwellLibrary.accdb");
                    
                    String insertNewRecordSQL = "INSERT INTO studentInfo (StudentName, StudentID, BookID, Date) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(insertNewRecordSQL);
                    pstmt.setString(1, name);
                    pstmt.setString(2, stdID);
                    pstmt.setString(3, bookID);
                    pstmt.setString(4, date);
                    
                    pstmt.executeUpdate();
                    
                    System.out.println("\nRecord Added.");
                    
                    System.out.println("The following record has been added : \t" + stdID + "\t" + name + "\t" + bookID + "\t" + date);
                }
        
            catch(SQLException err)
                {
                    System.out.println(err);
                }
    }
}
