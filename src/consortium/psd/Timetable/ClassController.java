package consortium.psd.Timetable;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import consortium.psd.UI.Classes;

public class ClassController {

	ArrayList <Classes> c = new ArrayList<Classes>();

	public ClassController() {
		initData();
	}


	public void viewClasses() {
		for (Classes a : c) {
			System.out.println(c.indexOf(a) + " " +a.getName());
		}
	}


	public void addClass(String name) {
		c.add(new Classes(c.size() + 1, name));
		save();
	}

	public String getClas(int id) {
		for (Classes p : c) {
			if (p.getId() == id) {
				return p.getName();
			}
		}
		return null;
	}

	public ArrayList<Classes> toArray() {
		return c;
	}

	public void save() {

		String url = "Database/class.csv";
		try {
			FileWriter writer = new FileWriter(url);

			for (Classes p : c) {
				writer.append(p.getId() + "," + p.getName());
				writer.append("\n");
			}

			writer.flush();
			writer.close();

		} catch (IOException e) {
			System.err.println("Unable to save");
		}

	}

	public void initData() {
		BufferedReader br = null;
		try {

			/*
			 * Reading all the classes
			 */
			String sCurrentLine;
			br = new BufferedReader(
					new FileReader(
							"Database/class.csv"));
			while ((sCurrentLine = br.readLine()) != null) {
				String[] temp = sCurrentLine.split(",");
				if (isInteger(temp[0])) {
					c.add(new Classes (Integer.parseInt(temp[0]), temp[1]));
				}

			}

		} catch (IOException e) {
			System.err
			.println("Unable to establish connection with the database. Please exit the the system and try again later.");
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				System.err.println("Unable to do process");
			}
		}
	}

	public static boolean isInteger(String str) {
		int size = str.length();

		for (int i = 0; i < size; i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}

		return size > 0;
	}
}
