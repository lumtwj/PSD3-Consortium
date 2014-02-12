package psd.sprint.consortium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class Database {
	boolean connected = false;
	URL url;

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

		try {

			URL url = new URL("http://psd3.ksynnet.com/consortium/user.csv");
			if (url.openConnection() != null) {
				System.out.println("Got Connection");

				BufferedReader br = null;
				try {
					String sCurrentLine;

					br = new BufferedReader(new InputStreamReader(
							url.openStream()));

					while ((sCurrentLine = br.readLine()) != null) {
						String[] temp = sCurrentLine.split(",");
						
						System.out.println(temp[0] + " " + temp[1]);
						//userlist.put(temp[0], temp[1]);
						user.put(temp[0], temp[1]);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (br != null)
							br.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			} else {
				System.out.println("Fail");
			}

		} catch (IOException e) {
			System.err.println("Connection Error");
		}

		return user;
	}

	public Map<String, String> getUserList() {
		Map<String, String> userlist = new LinkedHashMap<String, String>();

		try {

			URL url = new URL("http://psd3.ksynnet.com/consortium/user.csv");
			if (url.openConnection() != null) {
				System.out.println("Got Connection");

				BufferedReader br = null;
				try {
					String sCurrentLine;

					br = new BufferedReader(new InputStreamReader(
							url.openStream()));

					while ((sCurrentLine = br.readLine()) != null) {
						String[] temp = sCurrentLine.split(",");
						
						System.out.println(temp[0] + " " + temp[1]);
						userlist.put(temp[0], temp[1]);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (br != null)
							br.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			} else {
				System.out.println("Fail");
			}

		} catch (IOException e) {
			System.err.println("Connection Error");
		}
		return userlist;
	}
}
