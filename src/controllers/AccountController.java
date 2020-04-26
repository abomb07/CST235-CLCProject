/*Adam Bender
Tyler Wiggins
Milestone 6
April 26, 2020
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
	 * Invalidate user session bean and redirect to a protected page so the login module appears
	 * @return
	 */
	public String onLogoff() 
	{
		// Invalidate the Session to clear the security token
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			
		// Redirect to a protected page (so we get a full HTTP Request) to get Login Page
		return "HomePage.xhtml?faces-redirect=true";
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
