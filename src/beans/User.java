/*Adam Bender
Tyler Wiggins
Milestone 2
February 16, 2020
User Model*/

package beans;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
	@Size(min = 4, max = 15)
	String firstName = "";

	@NotNull(message = "Please, enter your last name!")
	@Size(min = 4, max = 15)
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

	public String authenticate() {
		boolean found = false;
		String tempUsername = "";
		String tempPassword = "";

		try {
			Scanner s1 = new Scanner(new File("C:\\Users\\Adam\\workspace\\CST235-CLCProject\\src\\beans\\users.txt"));
			s1.useDelimiter("[,\n]");

			while (s1.hasNext() && !found) {
				tempUsername = s1.next();
				tempPassword = s1.next();

				if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
					found = true;
				}
			}
			s1.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR");
		}

		// if user is found go home else display error
		if (found) {
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", this);
			return "LoginSuccessPage.xhtml";
		} else {
			return "FailPage.xhtml";
		}
	}

	public String register() {
		boolean success = false;
		String newUser = username + "," + password;

		try {
			BufferedWriter writer = new BufferedWriter(
					new FileWriter("C:\\Users\\Adam\\workspace\\CST235-CLCProject\\src\\beans\\users.txt", true));

			writer.newLine();
			writer.write(newUser);
			writer.close();
			success = true;

		} catch (IOException e) {
			System.out.println("ERROR");
		}

		// if user is found go home else display error
		if (success) {
			return "RegisterSuccessPage.xhtml";
		} else {
			return "FailPage.xhtml";
		}
	}
}
