package jdbc.product.service;

import jdbc.product.bean.Product;


public interface ProductService {

	public String addProduct(Product p) ;
	public Product searchProduct(int ProID);
	public String updateProduct(Product p);
	public Product deleteProduct(int ProID);

}
