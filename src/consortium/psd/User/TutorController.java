package consortium.psd.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import consortium.psd.UI.Student;

public class TutorController {
	ArrayList<Student> t = new ArrayList<Student>();

	public TutorController() {
		initData();
	}

	public ArrayList<Student> toArray() {
		return t;
	}

	public int getSize() {
		return t.size();
	}
	public void viewTutor() {
		for (Student st : t) {
			System.out.println(st.getUser_id() + ".\t" + st.getFullname());
		}
	}
	public Student getTutor(int id) {
		for (Student st : t) {
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
							"/Users/Derrick/Documents/Programming/Java/CourseAllocation/Database/user.csv"));
			while ((sCurrentLine = br.readLine()) != null) {
				String[] temp = sCurrentLine.split(",");
				if (isInteger(temp[0]) && temp[5].equals("tutor")) {

					t.add(new Student(Integer.parseInt(temp[0]), temp[3], temp[4]));
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
