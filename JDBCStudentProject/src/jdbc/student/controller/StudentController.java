package jdbc.student.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import jdbc.student.bean.Student;
import jdbc.student.factory.ServiceFactory;
import jdbc.student.service.StudentService;


public class StudentController {

	public static void main(String[] args) {
		 
try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true)
			{
				System.out.println("-----------------------Select operation to perform----------------------");
				System.out.println("Select 1 for ADD Student");
				System.out.println("Select 2 for Search Student");
				System.out.println("Select 3 for Update Student");
				System.out.println("Select 4 for Delete Student");
				System.out.println("Select 5 for Exit");
				System.out.println("");
				
				System.out.println("Select options from [1,2,3,4,5] : ");
				int option = Integer.parseInt(br.readLine());
				 int rollno ;
				 String name;
				 String branch;
				 String city;
				 StudentService ss =  ServiceFactory.getStudentService();
				String status = " ";
					
				 Student s = new Student();
				switch(option)
				{
				case 1 :
					System.out.println("***********Add Student Details***********");
					 System.out.println("Enter the Student RollNo : ");
					 rollno = Integer.parseInt(br.readLine());
					 
					 System.out.println("Enter the Student Name : ");
					  name = br.readLine();
					 
					 System.out.println("Enter the Student Branch : ");
					  branch = br.readLine();
					 
					 System.out.println("Enter the Student City : ");
					  city = br.readLine();
					 
					 System.out.println();
					 
					 
					  s.setRollno(rollno);
					 s.setName(name);
					 s.setBranch(branch);
					 s.setCity(city);
					 
					
					 status = ss.addStudent(s);
					
					System.out.println(status);
					 
					 break;
					 
				case 2:
					System.out.println("********Search the Employee***********");
					System.out.println("Enter the Student Roll No  : ");
					rollno = Integer.parseInt(br.readLine());
					
					s=ss.searchStudent(rollno);
					if(s!=null)
					{
					
					System.out.println("***********Add Student Details***********");
					System.out.println("________________________________________");
					System.out.println("Student RollNo    : " + s.getRollno());
					System.out.println("Student Name    : " + s.getName());
					System.out.println("Student Branch    : " + s.getBranch());
					System.out.println("Student City    : " + s.getCity());
					
					}
					else
					{
						System.out.println("No such Student");
					}
					break;
				case 3:
					System.out.println("********Update the Student*******");
					System.out.println("Student RollNo :  ");
					rollno= Integer.parseInt(br.readLine());
					s=ss.searchStudent(rollno);
					if(s!=null)
					{
						System.out.println("Old Student name :  "+ s.getName()+"  : Enter new name : ");
						String new_Name = br.readLine();
						if(new_Name == null || new_Name.equals(""))
						{
							new_Name=s.getName();
						}
						System.out.println("Old employee Branch: "+ s.getBranch()+" /Enter new Branch :  ");
						String new_Branch = br.readLine();
						if(new_Name == null || new_Branch.equals(""))
						{
							new_Branch=s.getBranch();
						}
						System.out.println("Old City :" + s.getCity()+ "  : Enter new City: ");
						String new_City = br.readLine();
						
						s.setRollno(rollno);
						s.setName(new_Name);
						s.setBranch(new_Branch);
						s.setCity(new_City);
						status = ss.updateStudent(s);
						System.out.println(status);
					}
						else
						{
							System.out.println("No such student found");
						}
				
					break;
				case 4: 
					System.out.println("********Delete the Student*******");
					System.out.println("Student RollNo :  ");
					rollno= Integer.parseInt(br.readLine());
					s=ss.searchStudent(rollno);
					if(s!=null)
					{
					s = ss.deleteStudent(rollno);
					System.out.println(status);
					}
					else
					{
						System.out.println("Student not Exit");
					}
					break;
				case 5:
					System.out.println("===============Please Visit Again==============");
					System.exit(0);
					break;
					
					default:
						System.out.println("!!**Please provide a choice from[1,2,3,4,5] !!");
						
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


