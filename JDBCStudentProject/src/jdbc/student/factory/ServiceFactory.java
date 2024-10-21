package jdbc.student.factory;

import jdbc.student.service.StudentService;
import jdbc.student.service.StudentServiceImpl;


public class ServiceFactory {
	
	private static StudentService ss;
	static
	{
		ss = (StudentService) new StudentServiceImpl();
	}
	public static StudentService getStudentService()
	{
		return ss;
	}

}
