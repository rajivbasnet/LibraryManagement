/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Rajiv
 */
public class StudentInfo {
    private String studentID;
    private String studentName;
    private String bookID;
    private String date;
    
    public StudentInfo() {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter the following information: ");
        
        System.out.print("Enter Student ID: ");
        studentID = keyboard.nextLine();
        
        System.out.print("Enter Student Name: ");
        studentName = keyboard.nextLine();
        
        System.out.print("Enter Book ID: ");
        bookID = keyboard.nextLine();
        
    }
    
    public String getStudentID () {
        return studentID;
    }
    
    public String getStudentName () {
        return studentName;
    }
    
    public String getBookID () {
        return bookID;
    }
    
    public String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now();
	date = dtf.format(localDate); 
        return date;
    }
}
