package consortium.psd.Attendance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import consortium.psd.UI.Attendance;
import consortium.psd.UI.Student;

public class AttendanceController {

	ClassController cc = new ClassController();
	StudentController sc = new StudentController();
	CourseController coc = new CourseController();
	ArrayList<Attendance> a = new ArrayList<Attendance>();
	Scanner scan = new Scanner(System.in);

	public AttendanceController() {
		initData();
	}
	
	public int getSize() {
		return a.size();
	}

	public void print() {
		for (Attendance k : a) {
			k.printAttendance();
			System.out.println();
		}

	}

	public void viewAtt() {
		for (Attendance temp : a) {
			System.out.println((temp.getid() + 1) + ".\t" + cc.getClas(temp.getName()) + "\t"
					+ coc.getCourse(temp.getCourse()).getName() + "\t" + temp.getdate());

		}
	}
	
	public void viewAtt(int id) {
		for (Attendance temp : a) {
			if (temp.getid() == (id-1)) {
				temp.printAttendance();
				break;
			}
		}
		
	}

	public void markAtt(int id) {
		Attendance k = a.get(id - 1);
		ArrayList<Student> keys = k.getKeys();
		for (Student all : keys) {
			boolean flag = false;
			while (!flag) {
				System.out.println("Is " + all.getFullname() + " here?");
				String ans = scan.nextLine();
				if (ans.equals("yes")) {
					flag = true;
					k.markPresent(all);
				} else if (ans.equals("no")) {
					flag = true;
					k.markAbsent(all);
				} else {
					System.out.println("Invalid input, please try again.");
				}
			}
		}
		save();

	}

	public void checkAbs() {
		for (Attendance k : a) {
			ArrayList<Student> temp = k.getKeys();
			int count = 0, nm = 0;
			Map<Student, String> tempMap = k.getMap();
			System.out.println("Class:\t" + cc.getClas(k.getName()));
			System.out.println("Course:\t" + coc.getCourse(k.getCourse()));
			for (Student s : temp) {
				String mark = tempMap.get(s);
				if (mark == null || mark.equals("null")) {

					nm++;
				} else if (mark.equals("N")) {
					System.out.println(s.getFullname());
					count++;
				}
			}
			if (count == 0 && nm == 0) {
				System.out.println("There is no absentee");
			} else if (nm > 0) {
				System.out.println("There are " + nm
						+ " student's attendance not marked.");
			}
			System.out.println();
		}
	}

	public boolean tabulate(int clas, int u, int c, String d, String mark) {

		if (cc.getClas(clas) == null) {
			System.err.println("Class not found!");
			return false;

		}

		if (sc.getStudent(u) == null) {
			System.err.println("Student not found!");
			return false;

		}

		if (coc.getCourse(c) == null) {
			System.err.println("Course not found!");
			return false;
		}

		if (a.size() == 0) {
			Attendance temp = new Attendance(a.size(), clas, c, d);
			temp.addAttendance(sc.getStudent(u), mark);

			a.add(temp);

		} else {
			for (Attendance p : a) {
				if (p.equals(clas, c)) {
					p.addAttendance(sc.getStudent(u), mark);
					return true;
				}
			}
			Attendance temp = new Attendance(a.size(), clas, c,d);
			temp.addAttendance(sc.getStudent(u), mark);

			a.add(temp);

		}
		return true;
	}
	
	public void save() {
		
		String url = "Database/attendance.csv";
		try {
			FileWriter writer = new FileWriter(url);

			for (Attendance p : a) {
				ArrayList<Student> keys = p.getKeys();
				Map<Student, String> mapKey = p.getMap();
				for (Student stu : keys) {
					writer.append(p.getName() + "," + stu.getUser_id() + "," + p.getCourse() + "," + p.getdate() + "," + mapKey.get(stu));
					System.out.println(p.getName() + "," + stu.getUser_id() + "," + p.getCourse() + "," + p.getdate() + "," + mapKey.get(stu));
					writer.append("\n");
				}
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
							"Database/attendance.csv"));
			while ((sCurrentLine = br.readLine()) != null) {
				String[] temp = sCurrentLine.split(",");

				// System.out.println(temp[0] + " " + temp[1] + " " + temp[2]);
				if (isInteger(temp[0]) && isInteger(temp[1])
						&& isInteger(temp[2])) {
					tabulate(Integer.parseInt(temp[0]),
							Integer.parseInt(temp[1]),
							Integer.parseInt(temp[2]), temp[3], temp[4]);
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
