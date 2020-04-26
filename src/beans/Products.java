/*Adam Bender
Tyler Wiggins
Milestone 6
April 26, 2020
Products Model*/

package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean
@SessionScoped
@XmlRootElement(name="Product")
public class Products {
	// product properties
	// data validation for all fields except id
	int id = 0;
	
	@NotNull(message = "Please, enter product name!")
	@Size(min = 4, max = 15)
	String name = "";
	
	@NotNull(message = "Please, enter product price!")
	@Max(100000)
	float price = 0;
	
	@NotNull(message = "Please, enter product image!")
	@Size(min = 4, max = 256)
	String image = "";
	
	@NotNull(message = "Please, enter product category!")
	@Size(min = 4, max = 128)
	String category = "";
	
	@NotNull(message = "Please, enter product short description!")
	@Size(min = 4, max = 256)
	String short_description = "";
	
	@NotNull(message = "Please, enter product long description!")
	@Size(min = 4, max = 1024)
	String long_description = "";
	
	@NotNull(message = "Please, enter product quantity!")
	@Max(10000)
	int quantity = 0;

	/**
	 * Non default constructor
	 */
	public Products(int id, String name, float price, String image, String category, String short_description, String long_description, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.category = category;
		this.short_description = short_description;
		this.long_description = long_description;
		this.quantity = quantity;
	}
	
	//default constructor
	public Products()
	{
		name = "";
		price = 0;
		image = "";
		category = "";
		short_description = "";
		long_description = "";
		quantity = 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getLong_description() {
		return long_description;
	}

	public void setLong_description(String long_description) {
		this.long_description = long_description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
