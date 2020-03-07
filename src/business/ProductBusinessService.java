package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import beans.Products;

@Local
@Stateless
public class ProductBusinessService {

	// array list of products
	List<Products> products = new ArrayList<>();

	// non default constructor
	public ProductBusinessService() {
		Products p1 = new Products(0, "Samsung TV", (float) 599.99, "image.jpg", "Television", "40' Samsung TV", "2xHDMI 1xCompnent OLed 4K TV", 100);
		products.add(p1);
	}
		
	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public void addProduct(Products product)
	{
		products.add(product);
	}
}
