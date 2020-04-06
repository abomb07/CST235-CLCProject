/*Adam Bender
Tyler Wiggins
Milestone 4
April 5, 2020
Account Controller*/

package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.UserBusinessService;

@ManagedBean
@ViewScoped
public class AccountController 
{
	@Inject
	UserBusinessService ubs;
	
	/**
	 * Call authenticate in the UserBusinessService
	 * @param user
	 * @return
	 */
	public String authenticate(User user) 
	{
		// if user is authenticated go home else display error
		if (ubs.authenticate(user)) 
		{
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
			return "LoginSuccessPage.xhtml";
		} else {
			return "FailPage.xhtml";
		}
	}

	/**
	 * Calls register in the UserBusinessService
	 * @param user
	 * @return
	 */
	public String register(User user) 
	{
		// if user is found go home else display error
		if (ubs.register(user)) {
			return "RegisterSuccessPage.xhtml";
		} else {
			return "FailPage.xhtml";
		}
	}
}
