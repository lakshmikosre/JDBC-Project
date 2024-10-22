package jdbc.product.factory;

import jdbc.product.service.ProductService;
import jdbc.product.service.ProductServiceImpl;

public class ServiceFactory {
	
	private static ProductService ps;
	static {
		
		ps= new ProductServiceImpl();
	}

	public static ProductService getProductService() {
		
		return ps;
	}

}
