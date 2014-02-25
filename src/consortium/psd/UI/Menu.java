package consortium.psd.UI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import consortium.psd.Attendance.NRController;
import consortium.psd.Course.CourseController;
import consortium.psd.Room.RoomController;
import consortium.psd.Timetable.module;
import consortium.psd.Timetable.timetable_entity;
import consortium.psd.Timetable.timetable_main;
import consortium.psd.User.Login;

public class Menu {
	private static final int ADMIN = 0;
	private static final int STUDENT = 1;
	private static final int LECTURER = 2;
	private static final int TUTOR = 3;
	static CourseController cc = new CourseController();
	static NRController nc = new NRController();

	//Timetable
	static timetable_entity e = new timetable_entity();
	static ArrayList<module> mList = new ArrayList<module>();
	//

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
		Login lg = new Login();
		lg.doLogin(username, password);

		String status = lg.checkStatus();

		if (status == null) {
			System.out
			.println("The username or password is wrong, please try again!");
			login();
		} else {
			displayMenu(roleResolver(lg.checkStatus()));
		}
	}

	private void displayMenu(int role) {
		try {
			System.out.println("Welcome into the System.");
			switch (role) {
			case ADMIN:
				System.out.println("You are logged in as ADMIN.");
				System.out.println("1.\tManage Timetable");
				//System.out.println("2.\tManage Student Group");
				//System.out.println("3.\tManage Lecturer Group");
				//System.out.println("4.\tManage Tutor Group");
				System.out.println("5.\tManage Rooms");
				System.out.println("6.\tManage Attendance");
				// System.out.println("5.\tManage Facilities");
				System.out.println("0.\tLogout");
				displaySubMenu(getInputForMenu());

				break;
			case STUDENT:
				System.out.println("You are logged in as STUDENT.");
				System.out.println("1.\tView Timetable");
				//System.out.println("2.\tApply for course avaliable");
				//System.out.println("3.\tView semester compulsory course");
				//System.out.println("4.\tApply for drop course!");
				System.out.println("5.\tView Room");
				System.out.println("6.\tView Course");
				System.out.println("0.\tLogout");
				student(getInputForMenu());

				break;
			case LECTURER:
				System.out.println("You are logged in as LECTURER.");
				System.out.println("1.\tView Timetable");
				//System.out.println("2.\tSet up additional course");
				//System.out.println("3.\tView semester compulsory course");
				//System.out.println("4.\tView Attendance");
				System.out.println("5.\tView Room");
				System.out.println("6.\tView Course");
				System.out.println("7.\tAdd Course");
				System.out.println("8.\tMark Attendance");
				System.out.println("0.\tLogout");
				lecturer(getInputForMenu());

				break;
			case TUTOR:
				System.out.println("You are logged in as TUTOR.");
				System.out.println("1.\tView Timetable");
				//System.out.println("2.\tApply to switch timeslot");
				System.out.println("3.\tView Room");
				System.out.println("4.\tView Course");
				/*
				 * if (mailbox > 0) {
				 * System.out.println("3.\tView Requested Swap"); }
				 */
				System.out.println("0.\tLogout");
				tutor(getInputForMenu());

				break;
			}
		} catch (InputMismatchException ex) {
			System.out.println("Invalid options!\n");
			displayMenu(role);
		}
	}

	private void student(int selection) {
		switch (selection) {
		case 0:
			// Logout
			System.out.println("You have logged out!");
			break;
		case 1:
			// View timetable
			try {
				timetable_main.viewTimetable();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			displayMenu(STUDENT);
			break;
		case 2:
			// Apply for course available

			displayMenu(STUDENT);
			break;
		case 3:
			// View semester compulsory course

			displayMenu(STUDENT);
			break;
		case 4:
			// Apply for drop course!
			displayMenu(STUDENT);
			break;
		case 5:
			// View room
			try {
				boolean flag = true;

				while (flag) {
					RoomController rc = new RoomController();
					rc.viewRoom();
					System.out
					.println("Which room do you want to view. Key 0 to exit");
					int room = s.nextInt();

					if (room < rc.getsize()) {
						if (room == 0) {
							flag = false;
						} else {
							rc.viewRoom(room);
						}
					} else {
						System.out.println("Value out of bound");
					}
				}
			} catch (InputMismatchException ex) {
				System.out.println("Invalid options!\n");
			}

			displayMenu(STUDENT);

			break;
		case 6:
			// View course
			boolean flag = true;
			while (flag) {
				cc.viewCourse();
				System.out
				.println("Which course do you want to view. Key 0 to exit");
				int course = s.nextInt();
				if (course <= cc.getSize()) {
					if (course == 0) {
						flag = false;
					} else {
						cc.viewCourse(course);
					}
				} else {
					System.out.println("Value out of bound");
				}
			}

			displayMenu(STUDENT);

			break;
		default:
			System.out.println("Invalid options!\n");
			displayMenu(STUDENT);
			break;
		}
	}

	private void lecturer(int selection) {
		Scanner sc = new Scanner(System.in);

		switch (selection) {
		case 0:
			// Logout
			System.out.println("You have logged out!");
			break;
		case 1:
			// View timetable
			try {
				timetable_main.viewTimetable();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			displayMenu(LECTURER);
			break;
		case 2:
			// Set up additional course

			displayMenu(LECTURER);
			break;
		case 3:
			// View semester compulsory course
			displayMenu(LECTURER);
			break;
		case 4:
			// View Attendance

			displayMenu(LECTURER);
			break;
		case 5:
			// View room
			try {
				boolean flag = true;

				while (flag) {
					RoomController rc = new RoomController();
					rc.viewRoom();
					System.out
					.println("Which room do you want to view. Key 0 to exit");
					int room = s.nextInt();

					if (room < rc.getsize()) {
						if (room == 0) {
							flag = false;
						} else {
							rc.viewRoom(room);
						}
					} else {
						System.out.println("Value out of bound");
					}
				}
			} catch (InputMismatchException ex) {
				System.out.println("Invalid options!\n");
			}

			displayMenu(LECTURER);

			break;
		case 6:
			// View Course
			boolean flag = true;
			while (flag) {
				cc.viewCourse();
				System.out
				.println("Which course do you want to view. Key 0 to exit");
				int course = s.nextInt();
				if (course <= cc.getSize()) {
					if (course == 0) {
						flag = false;
					} else {
						cc.viewCourse(course);
					}
				} else {
					System.out.println("Value out of bound");
				}
			}

			displayMenu(LECTURER);

			break;
		case 7:
			// Add Course
			System.out.println("You have chosen to add a Course");
			System.out.println("Enter the name of the Course");
			String name = sc.nextLine();
			System.out.println("Enter the course type");
			String location = sc.nextLine();
			cc.addCourse(name, location);

			displayMenu(LECTURER);

			break;
		case 8:
			// Mark Attendance
			boolean flags = true;
			while (flags) {
				nc.viewAtt();
				System.out
				.println("Which attendance do you want to mark. Key 0 to exit");
				int course = sc.nextInt();
				if (course <= nc.getSize()) {
					if (course == 0) {
						flags = false;
					} else {
						nc.markAtt(course);
					}
				} else {
					System.out.println("Value out of bound");
				}
			}

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
			// Logout
			System.out.println("You have logged out!");
			break;
		case 1:
			// View timetable
			try {
				timetable_main.viewTimetable();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			displayMenu(TUTOR);
			break;
		case 2:
			// Apply to switch timeslot
			displayMenu(TUTOR);
			break;
		case 3:
			// View room
			try {
				boolean flag = true;

				while (flag) {
					RoomController rc = new RoomController();
					rc.viewRoom();
					System.out
					.println("Which room do you want to view. Key 0 to exit");
					int room = s.nextInt();

					if (room < rc.getsize()) {
						if (room == 0) {
							flag = false;
						} else {
							rc.viewRoom(room);
						}
					} else {
						System.out.println("Value out of bound");
					}
				}
			} catch (InputMismatchException ex) {
				System.out.println("Invalid options!\n");
			}

			displayMenu(TUTOR);
			break;
		case 4:
			// View course
			boolean flag = true;
			while (flag) {
				cc.viewCourse();
				System.out
				.println("Which course do you want to view. Key 0 to exit");
				int course = s.nextInt();
				if (course <= cc.getSize()) {
					if (course == 0) {
						flag = false;
					} else {
						cc.viewCourse(course);
					}
				} else {
					System.out.println("Value out of bound");
				}
			}

			displayMenu(TUTOR);
			break;
		default:
			System.out.println("Invalid options!\n");
			displayMenu(TUTOR);
			break;
		}
	}

	private void displaySubMenu(int menu) {
		switch (menu) {
		case 0:
			System.out.println("You have logged out!");
			break;
		case 1:
			System.out.println("===   Manage Timetable   ===");
			System.out.println("1.\tAdd Slot to Timetable");
			System.out.println("2.\tEdit Slot of Timetable");
			System.out.println("3.\tDelete Slot of Timetable");
			System.out.println("4.\tView Timetable");
			System.out.println("0.\tBack");

			menuTimetable(getInputForMenu());
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
			/*
			 * System.out.println("===   Manage Facilities   ===");
			 * System.out.println("1.\tImport Facilities (csv file only)");
			 * System.out.println("2.\tManually Add Facility");
			 * System.out.println("3.\tEdit Facility Details");
			 * System.out.println("4.\tDelete Facility");
			 * System.out.println("5.\tView All Facilities");
			 * System.out.println("0.\tBack");
			 */

			System.out.println("===   Manage Rooms   ===");
			System.out.println("1.\tView Room");
			System.out.println("2.\tAdd Room");
			System.out.println("3.\tEdit Room Detail");
			System.out.println("4.\tDelete Room");
			System.out.println("0.\tBack");

			menuRoom(getInputForMenu());

			break;
		case 6:
			System.out.println("===   Manage Attendance   ===");
			System.out.println("1.\tView Attendance");
			System.out.println("2.\tCheck Attendance");
			System.out.println("0.\tBack");

			menuAttendance(getInputForMenu());
		}
	}

	private int getInputForMenu() {
		s = new Scanner(System.in);
		System.out.println("Enter your selection:");
		return s.nextInt();
	}

	private void menuTimetable(int selection) {
		switch (selection) {
		case 0:
			//Back
			displayMenu(ADMIN);
			break;
		case 1:
			//Add Slot to Timetable
			try {
				timetable_main.addToTimetable();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			displaySubMenu(1);
			break;
		case 2:
			//Edit Slot of Timetable
			try {
				timetable_main.updateTimetable();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			displaySubMenu(1);
			break;
		case 3:
			//Delete Slot of Timetable
			try {
				timetable_main.deleteTimetable();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			displaySubMenu(1);
			break;
		case 4:
			//View Timetable
			try {
				timetable_main.viewTimetable();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			displaySubMenu(1);
			break;
		}
	}

	private void menuRoom(int selection) {
		RoomController rc = new RoomController();
		Scanner sc = new Scanner(System.in);

		switch (selection) {
		case 0:
			// Back
			displayMenu(ADMIN);
			break;
		case 1:
			// View Room
			boolean flag = true;
			while (flag) {
				rc.viewRoom();
				System.out
				.println("Which room do you want to view. Key 0 to exit");
				int room = s.nextInt();
				if (room <= rc.getsize()) {
					if (room == 0) {
						flag = false;
					} else {
						rc.viewRoom(room - 1);
					}
				} else {
					System.out.println("Value out of bound");
				}
			}

			displaySubMenu(5);
			break;
		case 2:
			// Add Room
			System.out.println("You have chosen to add a room");
			System.out.println("Enter the name of the room");
			String name = sc.nextLine();
			System.out.println("Enter the location of the room");
			String location = sc.nextLine();

			boolean notint = true;
			while (notint) {
				System.out.println("Enter the max capacity of the room");
				int cap = s.nextInt();
				// if (isInteger(cap)) {
				notint = false;
				rc.addRoom(name, location, cap);
				/*
				 * } else { System.out .println(
				 * "The number you keyed in is not numeric figures, please try again!"
				 * ); }
				 */
			}

			displaySubMenu(5);
			break;
		case 3:
			// Edit Room Detail
			notint = true;
			boolean notinta = true;
			while (notint) {
				rc.viewRoom();
				System.out
				.println("Please enter the id of the room you want to edit.");
				String cap = sc.nextLine();
				// if (isInteger(cap)) {
				notint = false;
				rc.viewRoom(Integer.parseInt(cap) - 1);
				while (notinta) {
					System.out
					.println("Is this the room you want to edit? (yes | no)");
					String ans = sc.nextLine();
					if (ans.equals("yes")) {
						System.out.println("The name of the classroom");
						String n = sc.nextLine();
						System.out.println("The location of the classroom");
						String l = sc.nextLine();
						boolean notintb = true;
						while (notintb) {
							System.out
							.println("The max occupancy of the room?");
							String capa = sc.nextLine();
							// if (isInteger(capa)) {
							rc.editRoom(Integer.parseInt(cap) - 1, n, l,
									Integer.parseInt(capa));
							System.out.println("The room have been edit!");
							notintb = false;
							/*
							 * } else { System.out.println("Invalid input"); }
							 */
						}

						notinta = false;
					} else if (ans.equals("no")) {
						System.out.println("Exiting to main menu.");
						notinta = false;
					} else {
						System.out.println("Invalid input");
					}
				}

				/*
				 * } else { System.out .println(
				 * "The number you keyed in is not numeric figures, please try again!"
				 * ); }
				 */
			}

			displaySubMenu(5);
			break;
		case 4:
			// Delete Room
			notint = true;
			notinta = true;
			while (notint) {
				rc.viewRoom();
				System.out
				.println("Please enter the id of the room you want to delete.");
				int cap = s.nextInt();
				// if (isInteger(cap)) {
				notint = false;
				rc.viewRoom(cap - 1);
				while (notinta) {
					System.out
					.println("Is this the room you want to delete? (yes | no)");
					String ans = s.nextLine();
					if (ans.equals("yes")) {
						rc.delRoom(cap - 1);
						System.out.println("The room have been deleted!");
						notinta = false;
					} else if (ans.equals("no")) {
						System.out.println("Item not deleted");
						notinta = false;
					} else {
						System.out.println("Invalid input");
					}
				}

				/*
				 * } else { System.out .println(
				 * "The number you keyed in is not numeric figures, please try again!"
				 * ); }
				 */
			}

			displaySubMenu(5);
			break;
		default:
			System.out.println("Invalid options!\n");
			displaySubMenu(5);
			break;
		}
	}

	private void menuAttendance(int selection) {
		switch (selection) {
		case 0:
			// Back
			displayMenu(ADMIN);
			break;
		case 1:
			// View Attendance
			boolean flag = true;
			while (flag) {
				nc.viewAtt();
				System.out
				.println("Which attendance do you want to view. Key 0 to exit");
				int course = s.nextInt();
				if (course <= nc.getSize()) {
					if (course == 0) {
						flag = false;
					} else {
						nc.viewAtt(course);
					}
				} else {
					System.out.println("Value out of bound");
				}
			}

			displaySubMenu(6);
			break;
		case 2:
			// Check Attendance
			nc.checkAbs();

			displaySubMenu(6);
			break;
		}
	}

	private int roleResolver(String role) {
		if (role.equalsIgnoreCase("admin")) {
			return ADMIN;
		} else if (role.equalsIgnoreCase("student")) {
			return STUDENT;
		} else if (role.equalsIgnoreCase("lecturer")) {
			return LECTURER;
		} else if (role.equals("tutor")) {
			return TUTOR;
		}

		return -1;
	}
}
