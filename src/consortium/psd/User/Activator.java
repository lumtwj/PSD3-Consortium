package consortium.psd.User;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	public void start(BundleContext context) throws Exception {
		System.out.println("Hello, from User Component!");
		StudentController sController = new StudentController();
		LecturerController lController = new LecturerController();
		TutorController tController = new TutorController();

		System.out.println("\nSTUDENT:getStudent(5)");
		User s1 = sController.getStudent(5);
		System.out.format("id:%s\tname:%s\trole:%s\n", s1.id,s1.name,s1.role);
		
		System.out.println("\nSTUDENT:getStudentList()");
		for (User s : sController.getStudentList()) 
		{
			System.out.format("id:%s\tname:%s\trole:%s\n", s.id,s.name,s.role);
		}
		
		System.out.println("\nLECTURER:getLecturer(3)");
		User ll = lController.getLecturer(3);
		System.out.format("id:%s\tname:%s\trole:%s\n", ll.id,ll.name,ll.role);
		
		System.out.println("\nLECTURER:getLecturerList()");		
		for (User l :lController.getLecturerList()) 
		{
			System.out.format("id:%s\tname:%s\trole:%s\n", l.id,l.name,l.role);
		}
		
		System.out.println("\nTUTOR:getTutor(7)");
		User tt = tController.getTutor(7);
		System.out.format("id:%s\tname:%s\trole:%s\n", tt.id,tt.name,tt.role);
		
		System.out.println("\nTUTOR:getTutorList()");		
		for (User t :tController.getTutorList()) 
		{
			System.out.format("id:%s\tname:%s\trole:%s\n", t.id,t.name,t.role);
		}
	}
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World, from User Component!");
	}
}
