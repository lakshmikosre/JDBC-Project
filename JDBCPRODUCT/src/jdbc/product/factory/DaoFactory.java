package jdbc.product.factory;

import jdbc.product.dao.ProductDao;
import jdbc.product.dao.ProductDaoImpl;


public class DaoFactory {

	private static ProductDao pd;
    
    static 
    {
    	pd = new ProductDaoImpl();
    }
    
    public static ProductDao getProductDao()
    {
    	return pd;
    }

}