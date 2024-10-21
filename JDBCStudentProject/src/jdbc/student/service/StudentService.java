package jdbc.student.service;

import jdbc.student.bean.Student;

public interface StudentService {
	
	public String addStudent(Student st) ;
	public Student searchStudent(int rollno);
	public String updateStudent( Student st);
	public Student deleteStudent(int rollno);
	
}
