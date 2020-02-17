/*Adam Bender
Tyler Wiggins
Milestone 2
February 16, 2020
Products Model*/

package beans;

public class Products {
	// product properties
	int id = -1;
	String name = "";
	float price = 0;

	// non default constructor
	public Products(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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
}
