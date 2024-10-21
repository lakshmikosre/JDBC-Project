package jdbc.student.dao;

import jdbc.student.bean.Student;


public interface StudentDao {
	  public String add( Student s);
      public Student search(int rollno);
      public  String update(Student s);
      public Student delete(int rollno);
}
