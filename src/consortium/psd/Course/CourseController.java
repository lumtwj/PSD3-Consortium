package consortium.psd.Course;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import consortium.psd.UI.Course;

public class CourseController {

	ArrayList<Course> c = new ArrayList<Course>();

	public CourseController() {
		initData();
	}

	public void addCourse(String name, String type) {
		Course temp = new Course(c.size() + 1, name, type);
		c.add(temp);
		save();
	}

	public void editCourse(int id, String name, String type) {
		for (Course p : c) {
			if (p.getId() == id) {
				p.setName(name);
				p.setType(type);

			}
		}
		save();
	}

	public void delCourse(int id) {
		for (Course p : c) {
			if (p.getId() == id) {
				c.remove(p);
				break;
			}
		}
		save();
	}

	public void save() {
		String url = "Database/course.csv";
		try {
			FileWriter writer = new FileWriter(url);

			for (Course p : c) {
				writer.append(p.getId() + "," + p.getName() +","+ p.getType());
				writer.append("\n");
			}

			writer.flush();
			writer.close();

		} catch (IOException e) {
			System.err.println("Unable to save");
		}
	}

	public void viewCourse() {

		for (Course p : c) {
			System.out.println(p.getId() + ".\t" + p.getName());
		}
	}

	public int getSize() {
		return c.size();
	}

	public Course getCourse(int id) {
		for (Course p : c) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	public void viewCourse(int id) {
		for (Course p : c) {
			if (p.getId() == id) {
				System.out.println("======================================");
				System.out.println("Course ID:\t" + p.getId());
				System.out.println("Course name:\t" + p.getName());
				System.out.println("Course type:\t" + p.getType());
				System.out.println("======================================");
			}
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
							"Database/course.csv"));
			while ((sCurrentLine = br.readLine()) != null) {
				String[] temp = sCurrentLine.split(",");
				if (isInteger(temp[0])) {
					c.add(new Course(Integer.parseInt(temp[0]), temp[1],
							temp[2]));
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
