/*Adam Bender
Tyler Wiggins
Milestone 2
February 16, 2020
Product List Model*/

package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ProductList {
	// array list of products
	List<Products> products = new ArrayList<>();

	// default constructor
	public ProductList() {
		products.add(new Products(0, "Razer Headset", (float) 299.99));
		products.add(new Products(1, "Logitech Mouse", (float) 19.99));
		products.add(new Products(2, "HP Laptop", (float) 699.99));
		products.add(new Products(3, "Logitech Keyboard", (float) 19.99));
		products.add(new Products(4, "Acer Moniter 36'", (float) 99.99));
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}
}
