package jdbc.student.service;

import jdbc.student.bean.Student;
import jdbc.student.dao.StudentDao;
import jdbc.student.factory.DaoFactory;


public class StudentServiceImpl implements StudentService {
	
	StudentDao sd = DaoFactory.getStudentDao();
	Student s = new Student();
	String status ="";

	@Override
	public String addStudent(Student s) {
		status = sd.add(s);
		return status;
	}

	@Override
	public Student searchStudent(int rollno) {
		s=sd.search(rollno);
		return s;
	}

	@Override
	public String updateStudent(Student s) {
	   status = sd.update(s);
		return status;
	}

	@Override
	public Student deleteStudent(int rollno) {
	   s = sd.delete(rollno);
	    return s;
	}


}
