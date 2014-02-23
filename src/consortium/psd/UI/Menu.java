package consortium.psd.UI;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import consortium.psd.Attendance.Attendance;
import consortium.psd.User.Login;

public class Menu {
	private static final int ADMIN = 0;
	private static final int STUDENT = 1;
	private static final int LECTURER = 2;
	private static final int TUTOR = 3;

	Scanner s;

	String username;
	String password;

	public Menu() {
		s = new Scanner(System.in);

		login();
	}

	public void login() {
		System.out.println("Username: ");
		username = s.nextLine();
		System.out.println("Password: ");
		password = s.nextLine();

		retrieveMenu();
	}

	private void retrieveMenu() {
		//To-do retrieve user roles from database.
		Login lg = new Login();
		lg.doLogin(username, password);

		String status = lg.checkStatus();

		if (status == null) {
			System.out.println("The username or password is wrong, please try again!");
			login();
		}
		else {
			displayMenu(roleResolver(lg.checkStatus()));
		}
	}

	private void displayMenu(int role) {
		try {
			System.out.println("Welcome into the System.");
			switch(role) {
			case ADMIN:
				System.out.println("You are logged in as ADMIN.");
				System.out.println("1.\tManage Timetable");
				System.out.println("2.\tManage Student Group");
				System.out.println("3.\tManage Lecturer Group");
				System.out.println("4.\tManage Tutor Group");
				System.out.println("5.\tManage Facilities");
				System.out.println("0.\tLogout");
				displaySubMenu(getInputForMenu());

				break;
			case STUDENT:
				System.out.println("You are logged in as STUDENT.");
				System.out.println("1.\tView Timetable");
				System.out.println("2.\tApply for course avaliable");
				System.out.println("3.\tView semester compulsory course");
				System.out.println("4.\tApply for drop course!");
				System.out.println("0.\tLogout");
				student(getInputForMenu());

				break;
			case LECTURER:
				System.out.println("You are logged in as LECTURER.");
				System.out.println("1.\tView Timetable");
				System.out.println("2.\tSet up additional course");
				System.out.println("3.\tView semester compulsory course");
				System.out.println("4.\tView Attendance");
				System.out.println("0.\tLogout");
				lecturer(getInputForMenu());

				break;
			case TUTOR:
				System.out.println("You are logged in as TUTOR.");
				System.out.println("1.\tView Timetable");
				System.out.println("2.\tApply to switch timeslot");
				/*if (mailbox > 0) {
					System.out.println("3.\tView Requested Swap");
				}*/
				System.out.println("0.\tLogout");
				tutor(getInputForMenu());

				break;
			}
		}
		catch (InputMismatchException ex) {
			System.out.println("Invalid options!\n");
			displayMenu(role);
		}
	}

	private void student(int selection) {
		switch (selection) {
		case 0:
			//Logout
			break;
		case 1:
			//View timetable
			break;
		case 2:
			//Apply for course available
			break;
		case 3:
			//View semester compulsory course
			break;
		case 4:
			//Apply for drop course!
			break;
		default:
			System.out.println("Invalid options!\n");
			displayMenu(STUDENT);
			break;
		}
	}

	private void lecturer(int selection) {
		switch (selection) {
		case 0:
			//Logout
			System.out.println("You have logged out!");
			break;
		case 1:
			//View timetable
			displayMenu(LECTURER);
			break;
		case 2:
			//Set up additional course
			displayMenu(LECTURER);
			break;
		case 3:
			//View semester compulsory course
			displayMenu(LECTURER);
			break;
		case 4:
			//View Attendance
			System.out.println("===   View Attendance   ===");

			try {
				Attendance att = new Attendance();
				att.viewAttendance();
				System.out.println("\n");
			} 
			catch (ClassNotFoundException e) {e.printStackTrace();}
			catch (SQLException e) {e.printStackTrace();}

			displayMenu(LECTURER);
			break;
		default:
			System.out.println("Invalid options!\n");
			displayMenu(LECTURER);
			break;
		}
	}

	private void tutor(int selection) {
		switch (selection) {
		case 0:
			//Logout
			break;
		case 1:
			//View timetable
			break;
		case 2:
			//Apply to switch timeslot
			break;
		default:
			System.out.println("Invalid options!\n");
			displayMenu(TUTOR);
			break;
		}
	}

	private void displaySubMenu(int menu) {
		switch(menu) {
		case 1:
			System.out.println("===   Manage Timetable   ===");
			System.out.println("1.\tAdd Slot to Timetable");
			System.out.println("2.\tEdit Slot of Timetable");
			System.out.println("3.\tDelete Slot of Timetable");
			System.out.println("4.\tView Timetable");
			System.out.println("0.\tBack");
			break;
		case 2:
			System.out.println("===   Manage Student Group   ===");
			System.out.println("1.\tImport Students (csv file only)");
			System.out.println("2.\tManually Add Students");
			System.out.println("3.\tEdit Student Details");
			System.out.println("4.\tDelete Student");
			System.out.println("5.\tView All Students");
			System.out.println("0.\tBack");
			break;
		case 3:
			System.out.println("===   Manage Lecturer Group   ===");
			System.out.println("1.\tImport Lecturers (csv file only)");
			System.out.println("2.\tManually Add Lecturers");
			System.out.println("3.\tEdit Lecturers Details");
			System.out.println("4.\tDelete Lecturers");
			System.out.println("5.\tView All Lecturers");
			System.out.println("0.\tBack");
			break;
		case 4:
			System.out.println("===   Manage Tutor Group   ===");
			System.out.println("1.\tImport Tutors (csv file only)");
			System.out.println("2.\tManually Add Tutors");
			System.out.println("3.\tEdit Tutors Details");
			System.out.println("4.\tDelete Tutor");
			System.out.println("5.\tView All Tutors");
			System.out.println("0.\tBack");
			break;
		case 5:
			System.out.println("===   Manage Facilities   ===");
			System.out.println("1.\tImport Facilities (csv file only)");
			System.out.println("2.\tManually Add Facility");
			System.out.println("3.\tEdit Facility Details");
			System.out.println("4.\tDelete Facility");
			System.out.println("5.\tView All Facilities");
			System.out.println("0.\tBack");
			break;
		}
	}

	private int getInputForMenu() {
		s = new Scanner(System.in);
		System.out.println("Enter your selection:");
		return s.nextInt();
	}

	private int roleResolver(String role) {
		if (role.equalsIgnoreCase("admin")) {
			return ADMIN;
		}
		else if (role.equalsIgnoreCase("student")) {
			return STUDENT;
		}
		else if (role.equalsIgnoreCase("lecturer")) {
			return LECTURER;
		}
		else if (role.equals("tutor")) {
			return TUTOR;
		}

		return -1;
	}
}
