package softtronix.in.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import softtronix.in.bean.Employee;
import softtronix.in.factory.ConnectionFactory;

public class EmployeeDaoImpl implements EmployeeDao {
  
	Connection con = ConnectionFactory.getConnectionFactory();
	String status;
	Statement st = null;
	
	@Override
	public String add(Employee emp) 
	{
         try {
        	 
		 st = con.createStatement();
		 int rowCount = st.executeUpdate("INSERT INTO employee_info VALUES (" +   emp.getEid() + ", '" + emp.getEname() + "', '" + emp.getEpost() + "', '" + emp.getEaddr() + " ')");

	
         if(rowCount ==1 )
         {
        	 status = "Employee Data Insert Successfully";
         }
         else 
         {
        	 status = "Employee Data Insertion Failure";   
	     }
         
	} 
         catch(Exception e)
	{
        	 e.printStackTrace();
	}
		
		return status;
	}

	@Override
	public Employee search(int eid) {
		Employee emp = new Employee();
		try {

		st=con.createStatement();
		ResultSet rs = st.executeQuery("select * from employee_info where eid="+eid+" ");
		
		boolean b = rs.next();
		if(b==true)
		{
			
//				Employee emp = new Employee();
		emp.setEid(rs.getInt("eid"));
		emp.setEname(rs.getString("ename"));
		emp.setEpost(rs.getString("epost"));
		emp.setEaddr(rs.getString("eaddr"));
	
		}
		else
		{
			return null;
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		 return emp;
		
	}

	@Override
	public String update(Employee emp) {
		    try {
		    	
		    	int rowCount = st.executeUpdate("UPDATE employee_info SET ename = '" + emp.getEname() + 
                        "', epost = '" + emp.getEpost() + 
                        "', eaddr = '" + emp.getEaddr() + 
                        "' WHERE eid = " + emp.getEid());
		    	
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
	public String delete(int eid) {
        try {
        	st= con.createStatement();
        	int rowCount=st.executeUpdate("delete from employee_info where eid="+eid+" ");
        	
        	if(rowCount==1) {
	    		status = "Employee Data Delete Successfully";
	    	}
	    	else
	    	{
	    		status = "Employee Data Deletion Failure";
	    	}
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

}
