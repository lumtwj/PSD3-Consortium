package consortium.psd.Timetable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import consortium.psd.UI.Menu;

public class timetable_main {
	static Scanner sc = new Scanner(System.in);
	static String u;
	static module m = new module();
	static int user_id;
	static ArrayList<module> mList = new ArrayList<module>();
	static timetable_entity e = new timetable_entity();
	static boolean val = false;
	static String role;

	public static void u_login() throws ClassNotFoundException, SQLException {
		System.out
		.println("1. Administrator\n2. Lecturer\n3. Tutor\n4. Student\n0. Exit");
		u = sc.nextLine();
		if (u.equalsIgnoreCase("1")) {
			role = "admin";
			timetable_select_admin();
		} else if (u.equalsIgnoreCase("2")) {
			role = "lecturer";
			timetable_select_other();
		} else if (u.equalsIgnoreCase("3")) {
			role = "tutor";
			timetable_select_other();
		} else if (u.equalsIgnoreCase("4")) {
			role = "student";
			timetable_select_other();
		} else if (u.equalsIgnoreCase("0")) {
			System.exit(0);
		} else {
			System.out.println("Wrong Input!");
			u_login();
		}

	}

	public static void timetable_select_other() throws ClassNotFoundException,
	SQLException {
		System.out.println("1. View timetable\n0. Back");
		u = sc.nextLine();
		if (u.equalsIgnoreCase("1")) {
			viewTimetable(Menu.STUDENT);
		} else if (u.equalsIgnoreCase("0")) {
			u_login();
		} else {
			System.out.println("Wrong Input!");
			timetable_select_other();
		}
	}

	public static void timetable_select_admin() throws ClassNotFoundException,
	SQLException {
		System.out
		.println("1. Add to timetable\n2. Delete from timetable\n3. Update timetable\n4. View timetable\n0. Back");
		u = sc.nextLine();
		if (u.equalsIgnoreCase("1")) {
			addToTimetable();
		} else if (u.equalsIgnoreCase("2")) {
			deleteTimetable();
		} else if (u.equalsIgnoreCase("3")) {
			updateTimetable();
		} else if (u.equalsIgnoreCase("4")) {
			viewTimetable(Menu.STUDENT);
		} else if (u.equalsIgnoreCase("0")) {
			u_login();
		} else {
			System.out.println("Wrong Input!");
			timetable_select_admin();
		}
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static void addToTimetable() throws SQLException,
	ClassNotFoundException {
		do {
			System.out.println("Class ID: ");
			u = sc.nextLine();
			if (!isInteger(u)) {
				System.out.println("Please input number only!");
			} else {
				val = true;
			}

		} while (val == false);
		m.setClass_id(Integer.parseInt(u));
		val = false;

		do {
			System.out.println("Course ID: ");
			u = sc.nextLine();
			if (!isInteger(u)) {
				System.out.println("Please input number only!");
			} else {
				val = true;
			}

		} while (val == false);
		m.setCourse_id(Integer.parseInt(u));
		val = false;

		do {
			System.out.println("Room ID: ");
			u = sc.nextLine();
			if (!isInteger(u)) {
				System.out.println("Please input number only!");
			} else {
				val = true;
			}

		} while (val == false);
		m.setRoom_id(Integer.parseInt(u));
		val = false;

		do {
			System.out.println("Date(DD/MM/YYYY): ");
			u = sc.nextLine();
			if (u.length() != 10 || !u.contains("/")) {
				System.out.println("Invalid Format");
			} else {
				val = true;
			}

		} while (val == false);
		u = u.replaceAll("/", "");
		m.setDate(u);
		val = false;

		System.out.println("Start Time: ");
		m.setStart_time(sc.nextLine());
		System.out.println("End Time: ");
		m.setEnd_time(sc.nextLine());
		System.out.println("Is Compulsory:(Y/N)");
		m.setIs_compulsory(sc.nextLine());

		do {
			System.out
			.println("Require Tutor:(Insert tutor ID if available, NA if not available)");
			u = sc.nextLine();

			if (u.equalsIgnoreCase("NA")) {
				val = true;
			} else if (!isInteger(u)) {
				System.out.println("Please input number only!");
			}

			else {
				m.setRequire_tutor(Integer.parseInt(u));
				val = true;
			}

		} while (val == false);
		val = false;

		do {
			System.out.println("Lecturer ID: ");
			u = sc.nextLine();
			if (!isInteger(u)) {
				System.out.println("Please input number only!");
			} else {
				val = true;
			}

		} while (val == false);
		m.setLecturer_id(Integer.parseInt(u));
		val = false;

		System.out.println("Remarks: ");
		m.setRemarks(sc.nextLine());

		e.addToTimetable(m.getClass_id(), m.getCourse_id(), m.getRoom_id(),
				m.getDate(), m.getStart_time(), m.getEnd_time(),
				m.getIs_compulsory(), m.getRequire_tutor(), m.getLecturer_id(),
				m.getRemarks());
		System.out.println("Added Successful!");
		//timetable_select_admin();
	}

	public static void deleteTimetable() throws SQLException,
	ClassNotFoundException {
		do {
			System.out.println("Timetable ID: ");
			u = sc.nextLine();
			if (!isInteger(u)) {
				System.out.println("Please input number only!");
			} else {
				val = true;
			}

		} while (val == false);
		m.setTimetable_id(Integer.parseInt(u));
		val = false;
		e.deleteFromTimetable(m.getTimetable_id());
		System.out.println("Deleted Successful!");
		//timetable_select_admin();

	}

	public static void updateTimetable() throws SQLException,
	ClassNotFoundException {
		do {
			System.out.println("Timetable ID: ");
			u = sc.nextLine();
			if (!isInteger(u)) {
				System.out.println("Please input number only!");
			} else {
				val = true;
			}

		} while (val == false);
		m.setTimetable_id(Integer.parseInt(u));
		val = false;

		do {
			System.out.println("Class ID: ");
			u = sc.nextLine();
			if (!isInteger(u)) {
				System.out.println("Please input number only!");
			} else {
				val = true;
			}

		} while (val == false);
		m.setClass_id(Integer.parseInt(u));
		val = false;

		do {
			System.out.println("Course ID: ");
			u = sc.nextLine();
			if (!isInteger(u)) {
				System.out.println("Please input number only!");
			} else {
				val = true;
			}

		} while (val == false);
		m.setCourse_id(Integer.parseInt(u));
		val = false;

		do {
			System.out.println("Room ID: ");
			u = sc.nextLine();
			if (!isInteger(u)) {
				System.out.println("Please input number only!");
			} else {
				val = true;
			}

		} while (val == false);
		m.setRoom_id(Integer.parseInt(u));
		val = false;

		do {
			System.out.println("Date(DD/MM/YYYY): ");
			u = sc.nextLine();
			if (u.length() != 10 || !u.contains("/")) {
				System.out.println("Invalid Format");
			} else {
				val = true;
			}

		} while (val == false);
		u = u.replaceAll("/", "");
		m.setDate(u);
		val = false;

		System.out.println("Start Time: ");
		m.setStart_time(sc.nextLine());
		System.out.println("End Time: ");
		m.setEnd_time(sc.nextLine());
		System.out.println("Is Compulsory:(Y/N)");
		m.setIs_compulsory(sc.nextLine());

		do {
			System.out
			.println("Require Tutor:(Insert tutor ID if available, NA if not available)");
			u = sc.nextLine();

			if (u.equalsIgnoreCase("NA")) {
				val = true;
			} else if (!isInteger(u)) {
				System.out.println("Please input number only!");
			}

			else {
				m.setRequire_tutor(Integer.parseInt(u));
				val = true;
			}

		} while (val == false);
		val = false;

		do {
			System.out.println("Lecturer ID: ");
			u = sc.nextLine();
			if (!isInteger(u)) {
				System.out.println("Please input number only!");
			} else {
				val = true;
			}

		} while (val == false);
		m.setLecturer_id(Integer.parseInt(u));
		val = false;

		System.out.println("Remarks: ");
		m.setRemarks(sc.nextLine());

		e.updateTimetable(m.getClass_id(), m.getCourse_id(), m.getRoom_id(),
				m.getDate(), m.getStart_time(), m.getEnd_time(),
				m.getIs_compulsory(), m.getRequire_tutor(), m.getLecturer_id(),
				m.getRemarks(), m.getTimetable_id());

		System.out.println("Update successful!");
		//timetable_select_admin();
	}

	public static void viewTimetable(int role) throws ClassNotFoundException,
	SQLException {
		user_id = 3;
		if(role == Menu.ADMIN){
			mList=e.retriveTimetable_admin();
		}
		else{
			mList = e.retriveTimetable(user_id);
		}
		System.out
		.println("\n==========================================================\n");
		for (int i = 0; i < mList.size(); i++) {

			System.out.println("Timetable ID: "
					+ mList.get(i).getTimetable_id());
			System.out.println("Module Name: " + mList.get(i).getModule_name());
			System.out.println("Lecturer Name: "
					+ mList.get(i).getLecturer_name());
			System.out.println("Start Time: " + mList.get(i).getStart_time());
			System.out.println("End Time: " + mList.get(i).getEnd_time());
			String d = mList.get(i).getDate().substring(0, 2) + "/"
					+ mList.get(i).getDate().substring(2, 4) + "/"
					+ mList.get(i).getDate().substring(4);

			System.out.println(d);
			System.out.println();
		}

		System.out
		.println("\n==========================================================\n");
		System.out.println();
		/*if (role.equalsIgnoreCase("admin")) {
			timetable_select_admin();
		} else {
			timetable_select_other();
		}*/
	}

	public static void main(String args[]) throws ClassNotFoundException,
	SQLException {
		u_login();
	}

}
