package softtronix.in.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EmployeeController {

	public static void main(String[] args) {
		  
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true)
			{
				System.out.println("-----------------------Select operation to perform----------------------");
				System.out.println("Select 1 for ADD Employee");
				System.out.println("Select 2 for Search Employee");
				System.out.println("Select 3 for Update Employee");
				System.out.println("Select 4 for Delete Employee");
				System.out.println("Select 5 for Exit");
				System.out.println("");
				
				System.out.println("Select options from [1,2,3,4,5] : ");
				int option = Integer.parseInt(br.readLine());
				 int eid ;
				 String ename;
				 float esal ;
				 String eaddr;
				 
				switch(option)
				{
				case 1 :
					System.out.println("***********Add Employee Details***********");
					 System.out.println("Enter the Employee ID : ");
					 eid = Integer.parseInt(br.readLine());
					 
					 System.out.println("Enter the Employee Name : ");
					  ename = br.readLine();
					 
					 System.out.println("Enter the Employee Salary : ");
					  esal = Float.parseFloat(br.readLine());
					 
					 System.out.println("Enter the Employee Address : ");
					  eaddr = br.readLine();
					 
					 System.out.println();
					 
					 break;
					 
				case 2:
					System.out.println("********Search the Employee***********");
					System.out.println("Enter the Employee ID : ");
					eid = Integer.parseInt(br.readLine());
					break;
				case 3:
					System.out.println("********Update the Employee*******");
					break;
				case 4: 
					break;
				case 5:
					break;
				}
				
			}
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
        finally
        {
        	
        }
	}

}
