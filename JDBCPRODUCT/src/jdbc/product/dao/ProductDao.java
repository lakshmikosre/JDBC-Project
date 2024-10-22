package jdbc.product.dao;

import jdbc.product.bean.Product;

public interface ProductDao {
	
	  public String add( Product p);
      public Product search(int ProID);
      public  String update(Product p);
      public Product delete(int ProID);

}
