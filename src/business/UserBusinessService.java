package business;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.ejb.Local;
import javax.ejb.Stateless;

import beans.Database;
import beans.User;
import data.UserDataService;

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
		Database db = new Database();
		UserDataService uds = new UserDataService(db);
		
		if(uds.findUser(user))
		{
			return true;
		}
		else
		{
			return false;
		}
		
//		boolean found = false;
//		String username = user.getUsername();
//		String password = user.getPassword();
//		
//		String tempUsername = "";
//		String tempPassword = "";
//
//		try {
//			Scanner s1 = new Scanner(new File("C:\\Users\\Adam\\workspace\\CST235-CLCProject\\src\\beans\\users.txt"));
//			s1.useDelimiter("[,\n]");
//
//			while (s1.hasNext() && !found) {
//				tempUsername = s1.next();
//				tempPassword = s1.next();
//
//				if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
//					found = true;
//				}
//			}
//			s1.close();
//		} catch (FileNotFoundException e) {
//			System.out.println("ERROR");
//		}
//
//		// if user is found go home else display error
//		if (found) {
//			return true;
//		} else {
//			return false;
//		}
	}
	
	/**
	 * Register user to the database
	 * @param user
	 * @return boolean
	 */
	public boolean register(User user) 
	{
		Database db = new Database();
		UserDataService uds = new UserDataService(db);
		
		if(uds.createUser(user))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
