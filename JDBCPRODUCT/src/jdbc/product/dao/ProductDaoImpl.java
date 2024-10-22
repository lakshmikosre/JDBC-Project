package jdbc.product.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.product.bean.Product;
import jdbc.product.factory.ConnectionFactory;


public class ProductDaoImpl  implements ProductDao{

	Connection con = ConnectionFactory.getConnectionFactory();
	String status;
	Statement st = null;

	@Override
	public String add(Product p) {
		  try {
	        	 
				 st = con.createStatement();
				 int rowCount = st.executeUpdate("INSERT INTO product_info VALUES (" +   p.getProID() + ", '" + p.getProName() + "', '" + p.getCategory() + "', '" + p.getPrice() + " ')");

			
		         if(rowCount ==1 )
		         {
		        	 status = "Product Data Insert Successfully";
		         }
		         else 
		         {
		        	 status = "Product Data Insertion Failure";   
			     }
		         
			} 
		         catch(Exception e)
			{
		        	 e.printStackTrace();
			}
				
				return status;
			}
	

	@Override
	public Product search(int ProID) {
		
		Product p = new Product();
		try {

			st=con.createStatement();
			ResultSet rs = st.executeQuery("select * from product_info where ProID="+ProID+" ");
			
			boolean b = rs.next();
			if(b==true)
			{

			p.setProID(rs.getInt("ProID"));
		    p.setProName(rs.getString("ProName"));
			p.setCategory(rs.getString("Category"));
			p.setPrice(rs.getInt("Price"));
		
			}
			else
			{
				return null;
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			 return p;
			
		}

	@Override
	public String update(Product p) {
		
		try {
	    	
	    	int rowCount = st.executeUpdate("UPDATE product_info SET ProName = '" + p.getProName() + 
                 "',category = '" + p.getCategory() + 
                 "', price = '" + p.getPrice() + 
                 "' WHERE ProId = " + p.getProID());
	    	
	    	if(rowCount==1) {
	    		status = "Product Data Update Successfully";
	    	}
	    	else
	    	{
	    		status = "Product Data Updation Failure";
	    	}
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	return status;
}


	@Override
	public Product delete(int ProID) {
	
		try {
        	st= con.createStatement();
        	
			int rowCount=st.executeUpdate("delete from product_info where ProID="+ProID+" ");
        	
        	if(rowCount==1) {
	    		status = "Product Data Delete Successfully";
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
