package consortium.psd.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoginController {
	boolean connected = false; 
	
	public LoginController() {
		connected = true; 
	}
	
	public void close() { 
		connected = false; 
	}
	
	public boolean ifconnected() {
		return connected; 
	}
	
	
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	String DB = "ROOT";

	/*public Map<String, String> getUserList() throws ClassNotFoundException, SQLException {

		Map<String, String> userlist = new LinkedHashMap<String, String>();
		connection = DriverManager.getConnection("jdbc:derby:consortium");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * from "+ DB +".\"user\"");

		while (resultSet.next()) {
			userlist.put(resultSet.getString("USERNAME"), resultSet.getString("PASSWORD"));
		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
		return userlist;
	}*/
	public User getUser(String username, String password) throws ClassNotFoundException, SQLException {

		User user = new User();
		connection = DriverManager.getConnection("jdbc:derby:consortium");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * from "+ DB +".\"user\" where username='" +username + "' and password='"+password+"'");

		while (resultSet.next()) {
			user.setId(resultSet.getInt(1));
			user.setUsername(resultSet.getString(2));
			user.setPassword(resultSet.getString(3));
			user.setName(resultSet.getString(4));
			user.setEmail(resultSet.getString(5));
			user.setRole(resultSet.getString(6));

		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
		return user;
	}
	
	
	
	public Map<String, String> getUser() { 
		Map<String, String> user = new LinkedHashMap<String, String>();
		
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("userrights.csv"));		
			while ((sCurrentLine = br.readLine()) != null) {			
				String[] temp = sCurrentLine.split(",");

				user.put(temp[0], temp[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		return user;
	}
	
	private void shutdown() 
	{
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				DriverManager.getConnection("jdbc:derby:consortium"
						+ ";shutdown=true");
				statement.close();
			}
		} catch (SQLException sqlExcept) {

		}

	}
	
	/*public Map<String, String> getUserList() {
		Map<String, String> userlist = new LinkedHashMap<String, String>();
		
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("user.csv"));		
			while ((sCurrentLine = br.readLine()) != null) {			
				String[] temp = sCurrentLine.split(",");
				//System.out.println(temp[0] + " " + temp[1]);
				userlist.put(temp[0], temp[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		return userlist;
	}*/
	
	
	
	
}
