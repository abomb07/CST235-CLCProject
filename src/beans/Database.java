/*Adam Bender
Tyler Wiggins
Milestone 6
April 26, 2020
Database Model*/

package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Database 
{
	String url = "jdbc:postgresql://localhost:5432/postgres";
	String user = "postgres";
	String pass = "root";
	
	public Database() 
	{

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
