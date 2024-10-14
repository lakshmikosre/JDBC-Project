package softtronix.in.service;

import softtronix.in.bean.Employee;
public interface EmployeeService {
		 
		public String addEmployee(Employee emp) ;
		public Employee searchEmployee(int eid);
		public String updateEmployee(Employee emp);
		public String deleteEmployee(int eid);
		

	}

