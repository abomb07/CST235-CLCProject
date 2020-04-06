/*Adam Bender
Tyler Wiggins
Milestone 4
April 5, 2020
User Model*/

package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
public class User {

	// data validation for all fields
	@NotNull(message = "Please, enter your username!")
	@Size(min = 4, max = 15)
	String username = "";

	@NotNull(message = "Please, enter your password!")
	@Size(min = 4, max = 15)
	String password = "";

	@NotNull(message = "Please, enter your first name!")
	@Size(min = 1, max = 20)
	String firstName = "";

	@NotNull(message = "Please, enter your last name!")
	@Size(min = 1, max = 20)
	String lastName = "";

	@NotNull(message = "Please, enter your email!")
	@Size(min = 4, max = 50)
	String email = "";

	@NotNull(message = "Please, enter your phone number!")
	@Size(min = 7, max = 11)
	String phoneNumber = "";

	// default consturctor
	public User() {
		username = "";
		password = "";
		firstName = "";
		lastName = "";
		email = "";
		phoneNumber = "";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
