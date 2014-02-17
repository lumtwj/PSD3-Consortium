package consortium.psd.Room;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	private static User u;
	private static Database db = new Database();
	private static Scanner sc = new Scanner(System.in);
	private static BundleContext context;
	private static boolean exit = false;
	private static RoomController rc;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		exit = false;
		if (doLogin()) {
			rc = new RoomController();
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

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

	public static void doMenu(String type, int c) {
		if (type.equals("admin")) {

			switch (c) {
			case 1:
				boolean flag = true;
				while (flag) {
					rc.viewRoom();
					System.out
							.println("Which room do you want to view. Key 0 to exit");
					String room = sc.nextLine();
					if (isInteger(room)) {
						if (Integer.parseInt(room) <= rc.getsize()) {
							if (Integer.parseInt(room) == 0) {
								flag = false;
							} else {
								rc.viewRoom(Integer.parseInt(room) - 1);
							}
						} else {
							System.out.println("Value out of bound");
						}
					}
				}
				break;

			case 2:
				System.out.println("You have chosen to add a room");
				System.out.println("Enter the name of the room");
				String name = sc.nextLine();
				System.out.println("Enter the location of the room");
				String location = sc.nextLine();

				boolean notint = true;
				while (notint) {
					System.out.println("Enter the max capacity of the room");
					String cap = sc.nextLine();
					if (isInteger(cap)) {
						notint = false;
						rc.addRoom(name, location, Integer.parseInt(cap));
					} else {
						System.out
								.println("The number you keyed in is not numeric figures, please try again!");
					}
				}
				break;

			case 3:

				notint = true;
				boolean notinta = true;
				while (notint) {
					rc.viewRoom();
					System.out
							.println("Please enter the id of the room you want to edit.");
					String cap = sc.nextLine();
					if (isInteger(cap)) {
						notint = false;
						rc.viewRoom(Integer.parseInt(cap) - 1);
						while (notinta) {
							System.out
									.println("Is this the room you want to edit? (yes | no)");
							String ans = sc.nextLine();
							if (ans.equals("yes")) {
								System.out.println("The name of the classroom");
								String n = sc.nextLine();
								System.out
										.println("The location of the classroom");
								String l = sc.nextLine();
								boolean notintb = true;
								while (notintb) {
									System.out
											.println("The max occupancy of the room?");
									String capa = sc.nextLine();
									if (isInteger(capa)) {
										rc.editRoom(Integer.parseInt(cap) - 1,
												n, l, Integer.parseInt(capa));
										System.out
												.println("The room have been edit!");
										notintb = false;
									} else {
										System.out.println("Invalid input");
									}
								}

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
					rc.viewRoom();
					System.out
							.println("Please enter the id of the room you want to delete.");
					String cap = sc.nextLine();
					if (isInteger(cap)) {
						notint = false;
						rc.viewRoom(Integer.parseInt(cap) - 1);
						while (notinta) {
							System.out
									.println("Is this the room you want to delete? (yes | no)");
							String ans = sc.nextLine();
							if (ans.equals("yes")) {
								rc.delRoom(Integer.parseInt(cap) - 1);
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
					rc.viewRoom();
					System.out
							.println("Which room do you want to view. Key 0 to exit");
					String room = sc.nextLine();
					if (isInteger(room)) {
						if (Integer.parseInt(room) < rc.getsize()) {
							if (Integer.parseInt(room) == 0) {
								flag = false;
							} else {
								rc.viewRoom(Integer.parseInt(room));
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
			case 1:
				boolean flag = true;
				while (flag) {
					rc.viewRoom();
					System.out
							.println("Which room do you want to view. Key 0 to exit");
					String room = sc.nextLine();
					if (isInteger(room)) {
						if (Integer.parseInt(room) < rc.getsize()) {
							if (Integer.parseInt(room) == 0) {
								flag = false;
							} else {
								rc.viewRoom(Integer.parseInt(room));
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
					rc.viewRoom();
					System.out
							.println("Which room do you want to view. Key 0 to exit");
					String room = sc.nextLine();
					if (isInteger(room)) {
						if (Integer.parseInt(room) < rc.getsize()) {
							if (Integer.parseInt(room) == 0) {
								flag = false;
							} else {
								rc.viewRoom(Integer.parseInt(room));
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
			System.out.println("1.\t View Room");
			System.out.println("2.\t Add Room");
			System.out.println("3.\t Edit Room Detail");
			System.out.println("4.\t Delete Room");
			System.out.println("0.\t Logout");

		} else if (type.equals("lecturer")) {
			System.out.println("1.\t View Room");
			System.out.println("0.\t Logout");

		} else if (type.equals("tutor")) {
			System.out.println("1.\t View Room");
			System.out.println("0.\t Logout");

		} else if (type.equals("student")) {
			System.out.println("1.\t View Room");
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