/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Rajiv
 */




public class BookInfo {
    
private String bookCode;
private String courseCode;

    public BookInfo(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Do you want to search with book code (B) or with course code (C)?");
        String searchOption = keyboard.nextLine();
        if (searchOption.equals("B") || searchOption.equals("b")){
            bookSearchWithBookCode();
        }
        else if (searchOption.equals("C") || searchOption.equals("c")){
            bookSearchWithCourseCode();
        }
        else {
            System.out.println("Invalid...");
        }
    }
    
    public void bookSearchWithBookCode(){
        System.out.println();
        Scanner keyboard = new Scanner (System.in);
        System.out.println("Enter Book Code: ");
        bookCode = keyboard.nextLine();
        
        try
                {
                    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://CaldwellLibrary.accdb");
            
                    Statement stment = conn.createStatement();
                    String qry = "SELECT * FROM bookInfo WHERE BookID='" + bookCode +"'";
                    ResultSet rs = stment.executeQuery(qry);
                    
                    System.out.println("Retrieving Information From Database...\n");
                    
                    if(rs.next())
			{
				do{
                                    
                                    String bookID = rs.getString("BookID");
                                    String bookName = rs.getString("BookName");
                                    String courseCode = rs.getString("CourseCode");
                                    String authorName = rs.getString("AuthorName");
                                    int edition = rs.getInt("Edition");
                                    
                                    System.out.println("Record Found. Your search is: \n");
                                    
                                    System.out.println("BookID: \t" + bookID);
                                    System.out.println("BookName: \t" + bookName);
                                    System.out.println("CourseCode: \t" + courseCode);
                                    System.out.println("AuthorName: \t" + authorName);
                                    System.out.println("Edition: \t" + edition);
				}
                                while(rs.next());
			}
			else
			{
				System.out.println("Record Not Found...");
			}
			conn.close();     
                }
        
        catch(Exception err)
            {
                    System.out.println(err);
            }
    }
    
    public void bookSearchWithCourseCode(){
        System.out.println();
        Scanner keyboard = new Scanner (System.in);
        System.out.println("Enter Course Code: ");
        courseCode = keyboard.nextLine();
        
        try
                {
                    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/razee/Desktop/FinalProject/LibraryManagement/CaldwellLibrary.accdb");
                    Statement stment = conn.createStatement();
                    String qry = "SELECT * FROM bookInfo WHERE CourseCode='" + courseCode +"'";
                    ResultSet rs = stment.executeQuery(qry);
                    
                    System.out.println("Retrieving Information From Database...\n");
                    
                    if(rs.next())
			{
				do{
                                    
                                    String bookID = rs.getString("BookID");
                                    String bookName = rs.getString("BookName");
                                    String courseCode = rs.getString("CourseCode");
                                    String authorName = rs.getString("AuthorName");
                                    int edition = rs.getInt("Edition");
                                    
                                    System.out.println("Record Found. Your search is: \n");
                                    
                                    System.out.println("BookID: \t" + bookID);
                                    System.out.println("BookName: \t" + bookName);
                                    System.out.println("CourseCode: \t" + courseCode);
                                    System.out.println("AuthorName: \t" + authorName);
                                    System.out.println("Edition: \t" + edition);
				}
                                while(rs.next());
			}
			else
			{
				System.out.println("Record Not Found...");
			}
			conn.close();     
                }
        
        catch(Exception err)
            {
                    System.out.println(err);
            }
    }
}
