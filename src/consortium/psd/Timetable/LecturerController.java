package consortium.psd.Timetable;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import consortium.psd.UI.Student;

public class LecturerController {
	ArrayList<Student> l = new ArrayList<Student>();

	public LecturerController() {
		initData();
	}

	public int getSize() {
		return l.size();
	}

	public void viewLect() {
		for (Student st : l) {
			System.out.println(st.getUser_id() + " " + st.getFullname());
		}
	}

	public ArrayList<Student> toArray() {
		return l;
	}

	public Student getTutor(int id) {
		for (Student st : l) {
			if (st.getUser_id() == id) {
				return st;
			}
		}
		return null;
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
							"Database/user.csv"));
			while ((sCurrentLine = br.readLine()) != null) {
				String[] temp = sCurrentLine.split(",");
				if (isInteger(temp[0]) && temp[5].equals("lecturer")) {

					l.add(new Student(Integer.parseInt(temp[0]), temp[3], temp[4]));

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
