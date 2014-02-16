package consortium.psd.UI;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	static String username;
	static String status;
	static Scanner sc = new Scanner(System.in);
	static Menu menu;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		int flag = 0, securityCheck = 3;

		Login lg = new Login();
		while (securityCheck > 0) {
			System.out.println("Username ");
			username = sc.nextLine();
			System.out.println("Password ");
			String password = sc.nextLine();
			if (lg.doLogin(username, password)) {
				status = lg.checkStatus(username);
				System.out.println("Welcome " + status.toUpperCase() + "!");
				securityCheck = 0;
			} else {
				if (securityCheck > 1)
					System.out
							.println("The username or password is wrong, please try again!");
				else
					System.out
							.println("You have exceeded the maximum number of tries");
				securityCheck--;
				flag = -1;
			}

		}
		while (flag == 0) {
			menu = new Menu(status);
			String choice = sc.nextLine();
			if (isInteger(choice)) {
				
				if (Integer.parseInt(choice) != 0) {
					flag++;
					
					while (flag == 1) {
						if (Integer.parseInt(choice) != 0) {
							menu.layerTwo(Integer.parseInt(choice));
							choice = sc.nextLine();
							
							if (isInteger(choice)) {
								if (Integer.parseInt(choice) == 0) {
									flag--;
								} else {
									flag++;
								}
									
								
							}
						} else {
							flag--;
						}
					}
				} else {
					flag--;
				}
			} else {
				System.out
						.println("What you've keyed is not a number, please try again!");
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

	

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
