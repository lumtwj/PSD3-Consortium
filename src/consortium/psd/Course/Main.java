package consortium.psd.Course;


import java.util.Scanner;

import consortium.psd.UI.Database;
import consortium.psd.UI.User;

public class Main {

	static CourseController cc = new CourseController();
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
					cc.viewCourse();
					System.out
					.println("Which course do you want to view. Key 0 to exit");
					String course = sc.nextLine();
					if (isInteger(course)) {
						if (Integer.parseInt(course) <= cc.getSize()) {
							if (Integer.parseInt(course) == 0) {
								flag = false;
							} else {
								cc.viewCourse(Integer.parseInt(course));
							}
						} else {
							System.out.println("Value out of bound");
						}
					}
				}
				break;

			case 2:
				System.out.println("You have chosen to add a Course");
				System.out.println("Enter the name of the Course");
				String name = sc.nextLine();
				System.out.println("Enter the course type");
				String location = sc.nextLine();
				cc.addCourse(name, location);

				break;

			case 3:

				boolean notint = true;
				boolean notinta = true;
				while (notint) {
					cc.viewCourse();
					System.out
					.println("Please enter the id of the room you want to edit.");
					String cap = sc.nextLine();
					if (isInteger(cap)) {
						notint = false;
						cc.viewCourse(Integer.parseInt(cap));
						while (notinta) {
							System.out
							.println("Is this the Course you want to edit? (yes | no)");
							String ans = sc.nextLine();
							if (ans.equals("yes")) {
								System.out.println("The name of the Course");
								String n = sc.nextLine();
								System.out.println("The type of the course");
								String l = sc.nextLine();
								cc.editCourse(Integer.parseInt(cap), n, l);
								System.out
								.println("The course have been edit!");

								notinta = false;
							} else if (ans.equals("no")) {
								System.out.println("Exiting to main menu.");
								notinta = false;
							} else {
								System.out.println("Invalid input");
							}
						}

					} else {
						System.out
						.println("The number you keyed in is not numeric figures, please try again!");
					}
				}
				break;

			case 4:

				notint = true;
				notinta = true;
				while (notint) {
					cc.viewCourse();
					System.out
					.println("Please enter the id of the course you want to delete.");
					String cap = sc.nextLine();
					if (isInteger(cap)) {
						notint = false;
						cc.viewCourse(Integer.parseInt(cap));
						while (notinta) {
							System.out
							.println("Is this the room you want to delete? (yes | no)");
							String ans = sc.nextLine();
							if (ans.equals("yes")) {

								cc.delCourse(Integer.parseInt(cap));
								System.out
								.println("The room have been deleted!");
								notinta = false;
							} else if (ans.equals("no")) {
								System.out.println("Item not deleted");
								notinta = false;
							} else {
								System.out.println("Invalid input");
							}
						}

					} else {
						System.out
						.println("The number you keyed in is not numeric figures, please try again!");
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

		} else if (type.equals("lecturer")) {
			switch (c) {
			case 1:
				boolean flag = true;
				while (flag) {
					cc.viewCourse();
					System.out
					.println("Which course do you want to view. Key 0 to exit");
					String course = sc.nextLine();
					if (isInteger(course)) {
						if (Integer.parseInt(course) <= cc.getSize()) {
							if (Integer.parseInt(course) == 0) {
								flag = false;
							} else {
								cc.viewCourse(Integer.parseInt(course));
							}
						} else {
							System.out.println("Value out of bound");
						}
					}
				}
				break;

			case 2:
				System.out.println("You have chosen to add a Course");
				System.out.println("Enter the name of the Course");
				String name = sc.nextLine();
				System.out.println("Enter the course type");
				String location = sc.nextLine();
				cc.addCourse(name, location);
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

			case 1:
				boolean flag = true;
				while (flag) {
					cc.viewCourse();
					System.out
					.println("Which course do you want to view. Key 0 to exit");
					String course = sc.nextLine();
					if (isInteger(course)) {
						if (Integer.parseInt(course) <= cc.getSize()) {
							if (Integer.parseInt(course) == 0) {
								flag = false;
							} else {
								cc.viewCourse(Integer.parseInt(course));
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

		} else if (type.equals("student")) {

			switch (c) {
			case 1:
				boolean flag = true;
				while (flag) {
					cc.viewCourse();
					System.out
					.println("Which course do you want to view. Key 0 to exit");
					String course = sc.nextLine();
					if (isInteger(course)) {
						if (Integer.parseInt(course) <= cc.getSize()) {
							if (Integer.parseInt(course) == 0) {
								flag = false;
							} else {
								cc.viewCourse(Integer.parseInt(course));
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

		}
	}

	public static void showMenu(String type) {
		if (type.equals("admin")) {
			System.out.println("1.\t View Course");
			System.out.println("2.\t Add Course");
			System.out.println("3.\t Edit Course Detail");
			System.out.println("4.\t Delete Course");
			System.out.println("0.\t Logout");

		} else if (type.equals("lecturer")) {
			System.out.println("1.\t View Course");
			System.out.println("2.\t Add Course");
			System.out.println("0.\t Logout");

		} else if (type.equals("tutor")) {
			System.out.println("1.\t View Course");
			System.out.println("0.\t Logout");

		} else if (type.equals("student")) {
			System.out.println("1.\t View Course");
			System.out.println("0.\t Logout");

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
