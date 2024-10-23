package PrepState.Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Hospital {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Patient ID:  ");
		int PatientID  = sc.nextInt();
		
		System.out.println("Enter Patient Name:  ");
		String PatientName = sc.next();
		
		System.out.println("Enter Patient Age :  ");
		int Age = sc.nextInt();
		
		System.out.println("Enter Disease : ");
		String Disease = sc.next();
		
		 Connection con = null;
		 PreparedStatement pst = null;
		 
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			pst=con.prepareStatement("insert into  patient values (?,?,?,?)"); // Parameter Positioning
			
			pst.setInt(1,PatientID  ); //  Indexing will start with 1 
			pst.setString(2,PatientName );
			pst.setInt(3,Age);
			pst.setString(4, Disease);
			
			pst.executeUpdate();
			System.out.println("Data Inserted Successfully......");
		}
		catch(Exception e) {
		
			e.printStackTrace();
		}
     
		sc.close();


	}

}
	
		

	


