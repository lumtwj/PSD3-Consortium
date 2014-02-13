package consortium.psd.Attendance;

import java.io.IOException;

public class Menu {

	String user;
	int mailbox = 0;
	Attendance attendance = new Attendance();

	public Menu(String user) {
		this.user = user;
		if (user.equals("admin")) {
			showMenu(1);
		} else if (user.equals("student")) {
			showMenu(2);
		} else if (user.equals("lecturer")) {
			showMenu(3);
		} else if (user.equals("tutor")) {
			showMenu(4);
		}
	}

	public void showMenu(int u) {
		System.out.println("Welcome into the System.");
		switch (u) {
		case 1:
			System.out.println("1.\tManage Timetable");
			System.out.println("2.\tManage Student Group");
			System.out.println("3.\tManage Lecturer Group");
			System.out.println("4.\tManage Tutor Group");
			System.out.println("5.\tManage Facilities");
			System.out.println("0.\tLogout");
			break;

		case 2:
			System.out.println("1.\tView Timetable");
			System.out.println("2.\tApply for course avaliable");
			System.out.println("3.\tView semester complusory course");
			System.out.println("4.\tApply for drop course!");
			System.out.println("0.\tLogout");
			break;

		case 3:
			System.out.println("1.\tCreate Attendance");
			System.out.println("2.\tView Attendance");
			System.out.println("3.\tMark Attendance");
			System.out.println("0.\tLogout");
			break;

		case 4:
			System.out.println("1.\tView Timetable");
			System.out.println("2.\tApply to switch timeslot");
			if (mailbox > 0) {
				System.out.println("3.\tView Requested Swap");
			}
			System.out.println("0.\tLogout");
			break;
		}
	}

	public boolean layerTwo(int choice) {

		if (user.equals("admin")) {
			switch (choice) {
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
		} else if (user.equals("student")) {
			switch (choice) {
			case 1:
				System.out.println("===   Timetable   ===");
				// displayTimetable();
				System.out
						.println("Enter the number indicated to the event to view the detail or enter 0 to go back.");
				break;

			case 2:
				System.out.println("===   Course Available   ===");
				System.out
						.println("zz.\t Enter the number indicated to the course to apply or enter 0 to go back.");
				break;

			case 3:
				System.out.println("===   Semester Compulsory Course   ===");
				System.out.println("Please Enter 0 to go back.");
				break;

			case 4:
				System.out.println("===   Apply to Drop Course   ===");
				System.out
						.println("Enter the number indicated to the course you wish to drop or enter 0 to go back.");
				break;
			}

		} else if (user.equals("lecturer")) {
			switch (choice) {
			case 1:
				System.out.println("===   Create Attendance   ===");
				System.out
						.println("Enter the number indicated to the course you wish to view or enter 0 to go back.");

				try {
					attendance.createAttendance();
					System.out.println("Press 0 to go back.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 2:
				System.out.println("===   View Attendance   ===");

				attendance.viewAttendance();
				System.out.println("Press 0 to go back.");
				break;

			case 3:
				System.out.println("===  Mark Attendance   ===");
				System.out
						.println("Enter the number indicated to the course you wish to view or enter 0 to go back.");

				try {
					attendance.markAttendance();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;				

			}
		} else if (user.equals("tutor")) {
			switch (choice) {
			case 1:
				System.out.println("===   Timetable   ===");
				// displayTimetable();
				System.out
						.println("Enter the number indicated to the event to view the detail or enter 0 to go back.");
				break;

			case 2:
				System.out.println("===   Apply to Switch   ===");
				System.out
						.println("Enter the number indicating the person you wish to swap with.");
				break;

			}
		}

		return false;
	}

}
