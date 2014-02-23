package consortium.psd.User;

import java.sql.SQLException;



public class Login {

	LoginController lController = new LoginController();
	private User user = new User();
	int getRole;
	public Login() {
	}

	public boolean doLogin(String username, String pwd) {

		try {
			setUser(lController.getUser(username, pwd));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (getUser() != null) {

			return true;
		}  else {

			return false;
		}
	}
	
	public String checkStatus() {
		return getUser().getRole();
	}

	User getUser() {
		return user;
	}

	void setUser(User user) {
		this.user = user;
	}
}
