package PrepState.ITCourses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ITCourses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int CID = 0;
        int CPrice = 0;
        String CName;
        
        while (true) {
            System.out.print("Enter Course ID :  ");
            try {
                CID = sc.nextInt();
                sc.nextLine();  
                break;  
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next();  
            }
        }

        System.out.print("Enter Course Name: ");
        CName = sc.nextLine(); 
        while (true) {
            System.out.print("Enter Course Price (integer only): ");
            try {
                CPrice = sc.nextInt();
                sc.nextLine();  
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next();  
            }
        }

        Connection con = null;
        PreparedStatement pst = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/courses", "root", "root");

            // Prepare the SQL insert statement
            pst = con.prepareStatement("INSERT INTO it_courses (CID, CName, CPrice) VALUES (?, ?, ?)");

            // Set parameter values
            pst.setInt(1, CID);
            pst.setString(2, CName);
            pst.setInt(3, CPrice);

            // Execute the insert operation
            pst.executeUpdate();
            System.out.println("Data inserted successfully.");

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        sc.close();
    }
}
     
            
       
   
