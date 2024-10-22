package jdbc.product.service;

import jdbc.product.bean.Product;
import jdbc.product.dao.ProductDao;
import jdbc.product.factory.DaoFactory;


public class ProductServiceImpl implements ProductService {
	
	ProductDao pd = DaoFactory.getProductDao();
	Product p = new Product();
	String status ="";

	@Override
	public String addProduct(Product p) {
		status = pd.add(p);
		return status;
	}
		
	@Override
	public Product searchProduct(int ProID) {
		p=pd.search(ProID);
		return p;
	}

	@Override
	public String updateProduct(Product p) {
		status = pd.update(p);
		return status;
	}

	@Override
	public Product deleteProduct(int ProID) {
		p=pd.delete(ProID);
		return p;
	}

}
