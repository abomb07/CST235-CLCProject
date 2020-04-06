/*Adam Bender
Tyler Wiggins
Milestone 4
April 5, 2020
Product Business Service*/

package business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
		else
		{
			Database db = new Database();
			ProductDataService pds = new ProductDataService(db);
			products.removeAll(products);
			products.addAll(pds.findAllProducts());
		}
	}
		
	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	/**
	 * Add product to database
	 * @param product
	 * @return
	 */
	public boolean addProduct(Products product)
	{
		Database db = new Database();
		ProductDataService pds = new ProductDataService(db);
		
		if(pds.createProduct(product))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Find all products from database
	 * @return
	 */
	private boolean findAllProducts()
	{
		Database db = new Database();
		ProductDataService pds = new ProductDataService(db);
		
		if(pds.findAllProducts() != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Find specific product from database
	 * @param id
	 * @return
	 */
	public Products findByID(int id)
	{
		Database db = new Database();
		ProductDataService pds = new ProductDataService(db);
		
		return pds.findByID(id);
	}
	
	/**
	 * Edit specific product from database
	 * @param product
	 * @return
	 */
	public boolean editProduct(Products product)
	{
		Database db = new Database();
		ProductDataService pds = new ProductDataService(db);
		
		if(pds.updateProduct(product))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Delete product from database
	 * @param id
	 * @return
	 */
	public boolean deleteProduct(int id)
	{
		Database db = new Database();
		ProductDataService pds = new ProductDataService(db);
		
		if(pds.deleteProduct(id))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Remove all products from arraylist and add updated list back to arraylist
	 */
	public void updateList()
	{
		Database db = new Database();
		ProductDataService pds = new ProductDataService(db);
		products.removeAll(products);
		products.addAll(pds.findAllProducts());
	}
}
