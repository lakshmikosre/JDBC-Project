package softtronix.in.factory;

import softtronix.in.dao.EmployeeDao;
import softtronix.in.dao.EmployeeDaoImpl;

public class DaoFactory {
	
	    private static EmployeeDao ed;
	    
	    static 
	    {
	    	ed = new EmployeeDaoImpl();
	    }
	    
	    public static EmployeeDao getEmployeeDao()
	    {
	    	return ed;
	    }

}
