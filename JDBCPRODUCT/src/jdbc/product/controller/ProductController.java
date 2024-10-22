package jdbc.product.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import jdbc.product.bean.Product;
import jdbc.product.factory.ServiceFactory;
import jdbc.product.service.ProductService;

public class ProductController {

	public static void main(String[] args) {
		
try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true)
			{
				System.out.println("-----------------------Select operation to perform----------------------");
				System.out.println("Select 1 for ADD Product");
				System.out.println("Select 2 for Search Product");
				System.out.println("Select 3 for Update Product");
				System.out.println("Select 4 for Delete Product");
				System.out.println("Select 5 for Exit");
				System.out.println("");
				
				System.out.println("Select options from [1,2,3,4,5] : ");
				int option = Integer.parseInt(br.readLine());
				 int ProID ;
				 String ProName;
				 String Category;
				 int Price;
				 ProductService ps =  ServiceFactory.getProductService();
				String status = " ";
					
				 Product p = new Product();
				switch(option)
				{
				case 1 :
					System.out.println("***********Add Product Details***********");
					 System.out.println("Enter the Product ID : ");
					 ProID = Integer.parseInt(br.readLine());
					 
					 System.out.println("Enter the Product Name : ");
					  ProName = br.readLine();
					 
					 System.out.println("Enter the Product Category : ");
					  Category = br.readLine();
					 
					 System.out.println("Enter the Product Price : ");
					  Price= Integer.parseInt(br.readLine());
					 
					 System.out.println();
					 
					 
					 p.setProID(ProID);
					 p.setProName(ProName);
					 p.setCategory(Category);
					 p.setPrice(Price);
					 
					
					 status = ps.addProduct(p);
					
					System.out.println(status);
					 
					 break;
					 
				case 2:
					System.out.println("********Search the Product***********");
					System.out.println("Enter the Product ID  : ");
					ProID = Integer.parseInt(br.readLine());
					
					p=ps.searchProduct(ProID);
					if(p!=null)
					{
					
					System.out.println("***********Add Product Details***********");
					System.out.println("________________________________________");
					System.out.println("Product Id    : " + p.getProID());
					System.out.println("Product Name    : " + p.getProName());
					System.out.println("Product Category    : " + p.getCategory());
					System.out.println("Product Price   : " + p.getPrice());
					
					}
					else
					{
						System.out.println("No such Product");
					}
					break;
				case 3:
					System.out.println("********Update the Product*******");
					System.out.println("Product ID :  ");
					ProID= Integer.parseInt(br.readLine());
					p=ps.searchProduct(ProID);
					if(p!=null)
					{
						System.out.println("Old Product name :  "+ p.getProName()+"  : Enter new name : ");
						String new_ProName = br.readLine();
						if(new_ProName == null || new_ProName.equals(""))
						{
							new_ProName=p.getProName();
						}
						System.out.println("Old Product Category: "+ p.getCategory()+" /Enter new Category :  ");
						String new_Category = br.readLine();
						if(new_Category == null || new_Category.equals(""))
						{
							new_Category=p.getCategory();
						}
						System.out.println("Old Price :" + p.getPrice()+ "  : Enter new Price: ");
						int new_City = Integer.parseInt(br.readLine());
						
						p.setProID(ProID);
						p.setProName(new_ProName);
						p.setCategory(new_Category);
						p.setPrice(new_City);
						
						status = ps.updateProduct(p);
						System.out.println(status);
					}
						else
						{
							System.out.println("No such product found");
						}
				
					break;
				case 4: 
					System.out.println("********Delete the Product*******");
					System.out.println("Product ID :  ");
					ProID= Integer.parseInt(br.readLine());
					p=ps.searchProduct(ProID);
					if(p!=null)
					{
					p = ps.deleteProduct(ProID);
					System.out.println(status);
					}
					else
					{
						System.out.println("Product not Exit");
					}
					break;
				case 5:
					System.out.println("===============Please Visit Again==============");
					System.exit(0);
					break;
					
					default:
						System.out.println("!!**Please provide a choice from[1,2,3,4,5] !!");
						
						break;
				}	
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
        finally
        {
        	
        }
	}

}