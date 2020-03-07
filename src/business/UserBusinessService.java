package business;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.ejb.Local;
import javax.ejb.Stateless;

import beans.User;

@Local
@Stateless
public class UserBusinessService {

	/**
	 * Check login form username and password in the text file
	 * @param user
	 * @return boolean
	 */
	public boolean authenticate(User user) 
	{
		boolean found = false;
		String username = user.getUsername();
		String password = user.getPassword();
		
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
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Register user to text file
	 * @param user
	 * @return boolean
	 */
	public boolean register(User user) 
	{
		boolean success = false;
		String newUser = user.getUsername() + "," + user.getPassword();

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

		// if user is successfully written to text file, return true, else false
		if (success) {
			return true;
		} else {
			return false;
		}
	}
}
