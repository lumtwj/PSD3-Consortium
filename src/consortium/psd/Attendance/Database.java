package consortium.psd.Attendance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

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
	
	public Map<String, String> getUserList() {
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
	}
	
}
