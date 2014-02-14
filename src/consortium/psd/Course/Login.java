package consortium.psd.Course;

import java.util.LinkedHashMap;
import java.util.Map;

public class Login {


	Map<String, String> userlist = new LinkedHashMap<String, String>();
	Map<String, String> userright = new LinkedHashMap<String, String>();
	Database db = new Database();

	public Login() {
		initUserList();
	}

	public boolean doLogin(String username, String pwd) {
		if (userlist.containsKey(username)) {
	
			if (userlist.get(username).equals(pwd)) {
				return true;
			} 
		} 
		return false;
	}
	
	
	public String checkStatus(String user) {
		userright = db.getUser();
		return userright.get(user);
		
	}

	public void initUserList() {
		userlist = db.getUserList();
	}

}
