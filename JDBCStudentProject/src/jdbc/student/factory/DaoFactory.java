package jdbc.student.factory;

import jdbc.student.dao.StudentDao;
import jdbc.student.dao.StudentDaoImpl;

public class DaoFactory {
	
	private static StudentDao sd;
    
    static 
    {
    	sd = new StudentDaoImpl();
    }
    
    public static StudentDao getStudentDao()
    {
    	return sd;
    }

}
