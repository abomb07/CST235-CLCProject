/*Adam Bender
Tyler Wiggins
Milestone 4
April 5, 2020
User Business Service*/

package business;

import javax.ejb.Local;
import javax.ejb.Stateless;

import beans.Database;
import beans.User;
import data.UserDataService;

@Local
@Stateless
public class UserBusinessService {

	/**
	 * Check login form username and password in the userdataservice
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
