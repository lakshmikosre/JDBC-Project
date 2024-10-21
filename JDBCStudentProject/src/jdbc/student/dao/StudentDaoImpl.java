package jdbc.student.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.student.bean.Student;
import jdbc.student.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {
	
	Connection con = ConnectionFactory.getConnectionFactory();
	String status;
	Statement st = null;


	@Override
	public String add(Student s) {
		  try {
	        	 
				 st = con.createStatement();
				 int rowCount = st.executeUpdate("INSERT INTO student_info VALUES (" +   s.getRollno() + ", '" + s.getName() + "', '" + s.getBranch() + "', '" + s.getCity() + " ')");

			
		         if(rowCount ==1 )
		         {
		        	 status = "Student Data Insert Successfully";
		         }
		         else 
		         {
		        	 status = "Student Data Insertion Failure";   
			     }
		         
			} 
		         catch(Exception e)
			{
		        	 e.printStackTrace();
			}
				
				return status;
			}


	@Override
	public Student search(int rollno) {
		Student s = new Student();
		try {

			st=con.createStatement();
			ResultSet rs = st.executeQuery("select * from student_info where rollno="+rollno+" ");
			
			boolean b = rs.next();
			if(b==true)
			{

			s.setRollno(rs.getInt("rollno"));
			s.setName(rs.getString("name"));
			s.setBranch(rs.getString("branch"));
			s.setCity(rs.getString("city"));
		
			}
			else
			{
				return null;
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			 return s;
			
		}


	@Override
	public String update(Student s) {
		
		 try {
		    	
		    	int rowCount = st.executeUpdate("UPDATE student_info SET name = '" + s.getName() + 
                     "',branch  = '" + s.getBranch() + 
                     "', city = '" + s.getCity() + 
                     "' WHERE rollno = " + s.getRollno());
		    	
		    	if(rowCount==1) {
		    		status = "Employee Data Update Successfully";
		    	}
		    	else
		    	{
		    		status = "Employee Data Updation Failure";
		    	}
		    	
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
		return status;
	}


	@Override
	public Student delete(int rollno) {
		
		try {
        	st= con.createStatement();
        	
			int rowCount=st.executeUpdate("delete from student_info where rollno="+rollno+" ");
        	
        	if(rowCount==1) {
	    		status = "Student Data Delete Successfully";
	    	}
	    	else
	    	{
	    		status = " Data Deletion Failure";
	    	}
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

}



  
