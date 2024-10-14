package softtronix.in.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import softtronix.in.bean.Employee;
import softtronix.in.factory.ServiceFactory;
import softtronix.in.service.EmployeeService;

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
				 String epost;
				 String eaddr;
				 EmployeeService es =  ServiceFactory.getEmployeeService();
				String status = " ";
					
				 Employee emp = new Employee();
				switch(option)
				{
				case 1 :
					System.out.println("***********Add Employee Details***********");
					 System.out.println("Enter the Employee ID : ");
					 eid = Integer.parseInt(br.readLine());
					 
					 System.out.println("Enter the Employee Name : ");
					  ename = br.readLine();
					 
					 System.out.println("Enter the Employee Post : ");
					  epost = br.readLine();
					 
					 System.out.println("Enter the Employee Address : ");
					  eaddr = br.readLine();
					 
					 System.out.println();
					 
//					 Employee emp = new Employee();
					 
					 emp.setEid(eid);
					 emp.setEname(ename);
					 emp.setEpost(epost);
					 emp.setEaddr(eaddr);
					 
					
					 status = es.addEmployee(emp);
					
					System.out.println(status);
					 
					 break;
					 
				case 2:
					System.out.println("********Search the Employee***********");
					System.out.println("Enter the Employee ID : ");
					eid = Integer.parseInt(br.readLine());
					
					emp=es.searchEmployee(eid);
					if(emp!=null)
					{
					
					System.out.println("***********Add Employee Details***********");
					System.out.println("________________________________________");
					System.out.println("Employee ID    : " + emp.getEid());
					System.out.println("Employee Name    : " + emp.getEname());
					System.out.println("Employee Salary    : " + emp.getEpost());
					System.out.println("Employee Address    : " + emp.getEaddr());
					
					}
					else
					{
						System.out.println("No such Employee");
					}
					break;
				case 3:
					System.out.println("********Update the Employee*******");
					System.out.println("Employee ID :  ");
					eid= Integer.parseInt(br.readLine());
					emp=es.searchEmployee(eid);
					if(emp!=null)
					{
						System.out.println("Old employee name : "+ emp.getEname()+" Enter new name : ");
						String new_Name = br.readLine();
						if(new_Name == null || new_Name.equals(""))
						{
							new_Name=emp.getEname();
						}
						System.out.println("Old employee Addr : "+ emp.getEaddr()+" /Enter new Addr :  ");
						String new_Addr = br.readLine();
						if(new_Name == null || new_Addr.equals(""))
						{
							new_Addr=emp.getEaddr();
						}
						System.out.println("Old Post :" + emp.getEpost()+ "Enter new Post: ");
						String new_Post = br.readLine();
						
						emp.setEid(eid);
						emp.setEname(new_Name);
						emp.setEpost(new_Post);
						emp.setEaddr(new_Addr);
						status = es.updateEmployee(emp);
						System.out.println(status);
					}
						else
						{
							System.out.println("No such employee found");
						}
				
					break;
				case 4: 
					System.out.println("********Delete the Employee*******");
					System.out.println("Employee ID :  ");
					eid= Integer.parseInt(br.readLine());
					emp=es.searchEmployee(eid);
					if(emp!=null)
					{
					status = es.deleteEmployee(eid);
					System.out.println(status);
					}
					else
					{
						System.out.println("Employee not Exit");
					}
					break;
				case 5:
					System.out.println("===============Please Visit Again==============");
					System.exit(0);
					break;
					
					default:
						System.out.println("!!**Please provide a choice fromm[1,2,3,4,5] !!");
						
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
