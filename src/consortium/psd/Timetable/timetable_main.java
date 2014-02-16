package consortium.psd.Timetable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class timetable_main {

	static Scanner sc = new Scanner(System.in);
	static String userInput = null;
	static ArrayList<module> moduleList;
	static String moduleName;
	static int session;
	static int moduleID;
	static DerbyConnect db = new DerbyConnect();
	static Timetable t;
	static boolean check=false;

	public static void studentView() {
		Timetable t = new Timetable();
		t.initTimetable();
		moduleList = new ArrayList<module>();
		db = new DerbyConnect();
		try {
			moduleList = db.retriveTimetable();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < moduleList.size(); i++) {
			t.addModule(moduleList.get(i).getSession(), moduleList.get(i)
					.getModuleName());
		}

		t.print = false;
		t.displayTimetable();

	}

	public static void AdminView() {
		t = new Timetable();
		t.initTimetable();
		moduleList = new ArrayList<module>();

		try {
			moduleList = db.retriveTimetable();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < moduleList.size(); i++) {
			t.addModule(moduleList.get(i).getSession(), moduleList.get(i)
					.getModuleName());
		}
		t.displayTimetable();
	}

	public static void Admin() {
		AdminView();
		System.out.println("1. Add Module\n2. Delete Module\n3. Edit Module");
		userInput = sc.nextLine();
		if (userInput.equalsIgnoreCase("1")) {

			System.out.println("Please enter the ModuleName: ");
			moduleName = sc.nextLine();
			System.out.println("Please enter the Module ID: ");
			moduleID = sc.nextInt();
			System.out.println("Please select which session?");
			session = sc.nextInt();
			sc.nextLine();

			for(int i=0; i<moduleList.size();i++){
				if(moduleList.get(i).getSession()==session){
					System.out.println("Selected session is not available");
					Admin();
					break;
				}
			}

			try {
				db.addModule(moduleID, moduleName, session);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (userInput.equalsIgnoreCase("2")) {
			System.out.println("Which session to delete?");
			session = sc.nextInt();
			sc.nextLine();

			for(int i=0; i<moduleList.size();i++){
				if(moduleList.get(i).getSession()==session){
					check=true;
				}
			}

			if(check==false){
				System.out.println("Selected session is not available");
				Admin();
			}

			try {
				db.deleteModule(session);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


			try {
				db.deleteModule(3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (userInput.equalsIgnoreCase("3")) {
			System.out.println("Please enter the ModuleName: ");
			moduleName = sc.nextLine();
			System.out.println("Please enter the Module ID: ");
			moduleID = sc.nextInt();
			System.out.println("Please select which session?");
			session = sc.nextInt();
			sc.nextLine();

			for(int i=0; i<moduleList.size();i++){
				if(moduleList.get(i).getSession()==session){
					check=true;
				}
			}

			if(check==false){
				System.out.println("Selected session is not available");
				Admin();
			}			
			try {
				db.updateModule(session, moduleName, moduleID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Wrong Input!");
			Admin();
		}

		Admin();
	}

	public static void start() {
		System.out.println("1. Student\n2. Admin");
		System.out.print("Select User: ");
		userInput = sc.nextLine();

		if (userInput.equalsIgnoreCase("1")) {
			studentView();
		} else if (userInput.equalsIgnoreCase("2")) {
			Admin();
		} else {
			System.out.println("Wrong Input!");
			start();
		}
	}

	public static void main(String args[]) {
		start();

	}
}
