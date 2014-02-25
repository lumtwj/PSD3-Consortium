package consortium.psd.UI;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Database {
	
	boolean connected = false; 
	
	public Database() {
		connected = true; 
	}
	
	public void close() { 
		connected = false; 
	}
	
	public boolean ifconnected() {
		return connected; 
	}
	
	public User checkLogin(String user, String pwd) {
		BufferedReader br = null;
		User u = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("Database/user.csv"));
			while ((sCurrentLine = br.readLine()) != null) {			
				String[] temp = sCurrentLine.split(",");
				if (user.equals(temp[1]) && pwd.equals(temp[2])) {
					return new User(temp[1], temp[5]);
					
				} 
			}
			
		} catch (IOException e) {
			System.err.println("Unable to establish connection with the database. Please exit the the system and try again later.");
			
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				System.err.println("Unable to do process");
			}
		}

		return u;
	}
	
}
