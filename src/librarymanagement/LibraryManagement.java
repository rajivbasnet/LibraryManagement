package librarymanagement;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author Rajiv
 */
public class LibraryManagement {
private static String userN;
private static String pW;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {     
        if (logIn() == false ){
            System.out.println("Sorry! You do not have necessary permission to use the software.");
        }
        
        ReturnBook stdInfoObj = new ReturnBook();
        stdInfoObj.getDate();
    }
    
    public static boolean logIn() throws SQLException {
        Scanner keyboard = new Scanner(System.in);
        
        boolean notCorrect = true;
        int count = 0;
        boolean logInGrantedOrNot = false;
        
        while (notCorrect = true) {
            System.out.print("Enter your username: ");
            userN = keyboard.nextLine();
            System.out.print("Enter your password: ");
            pW = keyboard.nextLine();
            
            ConnectDatabase checkLoginObj = new ConnectDatabase();
            checkLoginObj.loginDatabase();
            if ( userN.equals(checkLoginObj.getUsername()) && pW.equals(checkLoginObj.getPassword())) {
                System.out.println("Access Granted\n");
                notCorrect = false;
                logInGrantedOrNot = true;
                break;
            }
            else {
                System.out.println("Access Denied\n");
                count ++;
                    if (count == 3) {
                    System.out.println("Number of login attempts exceeded.");
                    logInGrantedOrNot = false;
                    break;
                    }
            }
        }  
        
        return logInGrantedOrNot;
    }

}


    