package softtronix.in.dao;

import softtronix.in.bean.Employee;

public interface EmployeeDao {
            public String add(Employee emp);
            public Employee search(int eid);
            public  String update(Employee emp);
            public String delete(int eid);
            
}
