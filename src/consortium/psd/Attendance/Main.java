package consortium.psd.Attendance;


import java.util.Scanner;

import consortium.psd.UI.Database;
import consortium.psd.UI.User;

public class Main {

	static NRController nc = new NRController();
	static Scanner sc = new Scanner(System.in);
	private static User u;
	private static boolean exit = false;
	private static Database db = new Database();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exit = false;
		if (doLogin()) {

			while (!exit) {
				showMenu(u.getType());
				System.out
						.println("Please choose the number of what you want to do?");
				String choice = sc.nextLine();

				if (isInteger(choice)) {
					int c = Integer.parseInt(choice);
					doMenu(u.getType(), c);

				} else {
					System.out
							.println("Wrong user input. Please only type in number");
				}
			}
		}
		
	}
	
	public static void doMenu(String type, int c) {
		if (type.equals("admin")) {

			switch (c) {
			case 1:
				boolean flag = true;
				while (flag) {
					nc.viewAtt();
					System.out
							.println("Which attendance do you want to view. Key 0 to exit");
					String course = sc.nextLine();
					if (isInteger(course)) {
						if (Integer.parseInt(course) <= nc.getSize()) {
							if (Integer.parseInt(course) == 0) {
								flag = false;
							} else {
								nc.viewAtt(Integer.parseInt(course));
							}
						} else {
							System.out.println("Value out of bound");
						}
					}
				}
				break;

			case 2:
				nc.checkAbs();
				break;
			
			case 0:
				exit = true;
				break;

			default:
				System.out
						.println("This is not a correct choice, please enter another choice.");
				showMenu(type);
				break;
			}

		} else if (type.equals("lecturer")) {
			switch (c) {
			case 1:
				boolean flag = true;
				while (flag) {
					nc.viewAtt();
					System.out
							.println("Which attendance do you want to mark. Key 0 to exit");
					String course = sc.nextLine();
					if (isInteger(course)) {
						if (Integer.parseInt(course) <= nc.getSize()) {
							if (Integer.parseInt(course) == 0) {
								flag = false;
							} else {
								nc.markAtt(Integer.parseInt(course));
							}
						} else {
							System.out.println("Value out of bound");
						}
					}
				}
				break;

			case 0:
				exit = true;
				break;

			default:
				System.out
						.println("This is not a correct choice, please enter another choice.");
				showMenu(type);
				break;
			}

		} else if (type.equals("tutor")) {
			switch (c) {

			case 0:
				exit = true;
				break;

			default:
				System.out
						.println("This is not a correct choice, please enter another choice.");
				showMenu(type);
				break;
			}

		} else if (type.equals("student")) {

			switch (c) {

			case 0:
				exit = true;
				break;

			default:
				System.out
						.println("This is not a correct choice, please enter another choice.");
				showMenu(type);
				break;
			}

		}
	}

	public static void showMenu(String type) {
		if (type.equals("admin")) {
			System.out.println("1.\t View Attendance");
			System.out.println("2.\t Check Attendance");
			System.out.println("0.\t Logout");

		} else if (type.equals("lecturer")) {
			System.out.println("1.\t Mark Attendance");
			System.out.println("0.\t Logout");

		} else if (type.equals("tutor")) {
			System.out.println("You are not supposed to be using this component, key 0 to log out.");

		} else if (type.equals("student")) {
			System.out.println("You are not supposed to be using this component, key 0 to log out.");

		}
	}

	public static boolean doLogin() {

		int count = 3;

		while (count > 0) {
			System.out.println("Username");
			String user = sc.nextLine();
			System.out.println("Password");
			String pwd = sc.nextLine();

			if ((u = db.checkLogin(user, pwd)) != null) {
				System.out.println("Welcome " + u.getName());
				return true;

			} else {
				count--;
				if (count == 0) {
					System.out
							.println("You have already exceed your try. Please try again later");

				} else {
					System.out
							.println("You have the wrong username and password combination, please try again");
				}
			}
		}
		return false;
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
