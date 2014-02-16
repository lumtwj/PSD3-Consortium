package consortium.psd.Timetable;

import java.util.Scanner;


public class TimetableMenu {
	public TimetableMenu() {
		/*
		 * System.out.println("1.\tAdd Slot to Timetable");
		 * System.out.println("2.\tEdit Slot of Timetable");
		 * System.out.println("3.\tDelete Slot of Timetable");
		 * System.out.println("4.\tView Timetable");
		 * System.out.println("0.\tBack");
		 */
		System.out.println("Enter your selection: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		System.out.println(input);
	}
}
