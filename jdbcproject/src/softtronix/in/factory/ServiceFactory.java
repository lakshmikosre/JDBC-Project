package softtronix.in.factory;

import softtronix.in.service.EmployeeService;
import softtronix.in.service.EmployeeServiceImpl;

public class ServiceFactory {
         
	private static EmployeeService es;
	static
	{
		es = new EmployeeServiceImpl();
	}
	public static EmployeeService getEmployeeService()
	{
		return es;
	}
}
