/*Adam Bender
Tyler Wiggins
Milestone 3
March 13, 2020
Product Business Service*/

package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import beans.Database;
import beans.Products;
import data.ProductDataService;

@Local
@Stateless
public class ProductBusinessService {

	// array list of products
	List<Products> products = new ArrayList<>();

	// non default constructor
	public ProductBusinessService() 
	{
		if(!findAllProducts())
		{
			Products p1 = new Products(0, "Samsung TV", (float) 599.99, "image.jpg", "Television", "40' Samsung TV", "2xHDMI 1xCompnent OLed 4K TV", 100);
			products.add(p1);
		}
	}
		
	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	/**
	 * Add product to database and arraylist
	 * @param product
	 * @return
	 */
	public boolean addProduct(Products product)
	{
		Database db = new Database();
		ProductDataService pds = new ProductDataService(db);
		
		if(pds.createProduct(product))
		{
			products.add(product);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private boolean findAllProducts()
	{
		Database db = new Database();
		ProductDataService pds = new ProductDataService(db);
		
		if(pds.findAllProducts() != null)
		{
			products.addAll(pds.findAllProducts());
			return true;
		}
		else
		{
			return false;
		}
	}
}
