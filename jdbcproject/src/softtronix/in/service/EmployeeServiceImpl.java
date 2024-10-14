package softtronix.in.service;

import softtronix.in.bean.Employee;
import softtronix.in.dao.EmployeeDao;
import softtronix.in.factory.DaoFactory;

public class EmployeeServiceImpl implements EmployeeService {
    
	
	EmployeeDao ed = DaoFactory.getEmployeeDao();
	Employee emp = new Employee();
	String status ="";
	@Override
	public String addEmployee(Employee emp) {
		   status = ed.add(emp);
		return status;
	}

	@Override
	public Employee searchEmployee(int eid) {
		emp=ed.search(eid);
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		status = ed.update(emp);
		return status;
	}

	@Override
	public String deleteEmployee(int eid) {
		status = ed.delete(eid);
		return status;
	}

}
