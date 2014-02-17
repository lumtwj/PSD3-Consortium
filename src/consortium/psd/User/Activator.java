package consortium.psd.User;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	public void start(BundleContext context) throws Exception {
		System.out.println("Hello, from User Component!");
		StudentController sController = new StudentController();
		LecturerController lController = new LecturerController();
		TutorController tController = new TutorController();

		System.out.println("\nSTUDENT:getStudent(11)");
		User s1 = sController.retriveStudentById(11);
		System.out.format("id:%s\tname:%s\trole:%s\n", s1.id,s1.name,s1.role);
		
		System.out.println("\nSTUDENT:getStudentList()");
//		for (User s : sController.getStudentList()) 
		for (User s : sController.retriveStudents())
		{
			System.out.format("id:%s\tname:%s\trole:%s\n", s.id,s.name,s.role);
		}
		
		System.out.println("\nLECTURER:getLecturer(3)");
		User ll = lController.retriveLecturerById(3);
		System.out.format("id:%s\tname:%s\trole:%s\n", ll.id,ll.name,ll.role);
		
		System.out.println("\nLECTURER:getLecturerList()");		
		for (User l :lController.retriveLecturers()) 
		{
			System.out.format("id:%s\tname:%s\trole:%s\n", l.id,l.name,l.role);
		}
		
		System.out.println("\nTUTOR:retriveTutorById(7)");
		User tt = tController.retriveTutorById(7);
		System.out.format("id:%s\tname:%s\trole:%s\n", tt.id,tt.name,tt.role);
		
		System.out.println("\nTUTOR:retriveTutors()");		
		for (User t :tController.retriveTutors()) 
		{
			System.out.format("id:%s\tname:%s\trole:%s\n", t.id,t.name,t.role);
		}
		
		System.out.println("\nLogin:loginTest()");	
		loginTest();
	}
	
	private void loginTest()
	{
		String username;
		String status;
		Scanner sc = new Scanner(System.in);
		
		int flag = 0, securityCheck = 3;

		Login lg = new Login();
		while (securityCheck > 0) {
			System.out.println("Username ");
			username = sc.nextLine();
			System.out.println("Password ");
			String password = sc.nextLine();
			if (lg.doLogin(username, password)) {
				status = lg.checkStatus();
				System.out.println("Welcome "+ lg.getUser().getName() + " ("+ status.toUpperCase() + ")!");
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
		
		
	}
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World, from User Component!");
	}
}
