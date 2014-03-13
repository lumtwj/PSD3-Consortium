package consortium.psd.Timetable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import consortium.psd.Attendance.ClassController;
import consortium.psd.Attendance.StudentController;
import consortium.psd.Course.CourseController;
import consortium.psd.Room.Room;
import consortium.psd.Room.RoomController;
import consortium.psd.User.LecturerController;
import consortium.psd.User.TutorController;

public class TimetableController {

	ArrayList<Timetable> tt = new ArrayList<Timetable>();
	ClassController cc = new ClassController();
	CourseController coc = new CourseController();
	RoomController rc = new RoomController();
	LecturerController lc = new LecturerController();
	TutorController tc = new TutorController();
	StudentController sc = new StudentController();
	Scanner scan = new Scanner(System.in);

	public TimetableController() {
		initData();
	}

	public void viewTt(int id) {
		for (Timetable t : tt) {
			if (t.getTimetable_id() == id) {
				System.out.println("Timetable ID: \t" + t.getTimetable_id());
				System.out.println("Date: \t\t" + t.getDate());
				System.out.println("Start Time: \t" + t.getStart_time());
				System.out.println("End Time: \t" + t.getEnd_time());
				System.out.println("Class: \t\t" + cc.getClas(t.getClass_id()));
				if (lc.getTutor(t.getLecturer_id()) != null) {
					System.out.println("Lecturer:\t"
							+ lc.getTutor(t.getLecturer_id()).getFullname());
				} else {
					System.out.println(t.getLecturer_id());
				}
				if (tc.getTutor(t.getRequire_tutor()) != null) {
					System.out.println("Tutor:\t\t"
							+ tc.getTutor(t.getRequire_tutor()).getFullname());
				} else {

					System.out.println("Tutor:\t\t Not required");
				}

				System.out.println("Remarks:\t" + t.getRemarks());

			}
		}
	}

	public void checkClash() {
		boolean clash = false;
		for (int i = 0; i < tt.size(); i++) {
			for (int j = 0; j < tt.size(); j++) {
				if (i != j) {
					if (tt.get(i).getDate().equals(tt.get(j).getDate())) {
						if (tt.get(i).getStart_time()
								.equals(tt.get(j).getStart_time())) {
							System.out.println("Time Clash between "
									+ coc.getCourse(tt.get(i).getCourse_id())
									+ " at " + tt.get(i).getStart_time()
									+ " and "
									+ coc.getCourse(tt.get(j).getCourse_id())
									+ " at " + tt.get(j).getStart_time());
							clash = true;
						}
					}
				}
			}
		}
		if (clash) 
			System.out.println("Please edit the clashed timetable. Thank you!");
		else 
			System.out.println("There is no clash in the course.");
	}

	public void viewTt() {
		for (Timetable t : tt) {
			System.out.println(t.getTimetable_id() + ".\t"
					+ coc.getCourse(t.getCourse_id()).getName() + "\t"
					+ cc.getClas(t.getClass_id()) + "\t" + t.getDate());
		}
	}

	public void addTt() {
		boolean isint = false;
		Timetable t = new Timetable();
		Room rm = null;
		int clas;
		String ans;

		while (!isint) {
			cc.viewClasses();
			System.out.println("Please choose a class?");
			ans = scan.nextLine();
			if (isInteger(ans)) {
				t.setClass_id(Integer.parseInt(ans));
				clas = Integer.parseInt(ans);
				isint = true;
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		isint = false;

		while (!isint) {
			coc.viewCourse();
			System.out.println("Please choose a course?");
			ans = scan.nextLine();
			if (isInteger(ans)) {
				t.setCourse_id(Integer.parseInt(ans));
				isint = true;
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		isint = false;

		while (!isint) {
			rc.viewRoom();
			System.out.println("Please choose a room?");
			ans = scan.nextLine();
			if (isInteger(ans)) {
				t.setClass_id(Integer.parseInt(ans));
				rm = rc.getRoom(Integer.parseInt(ans));
				isint = true;

				boolean isinta = false;

				while (isinta) {
					System.out
							.println("Please enter the maximum number of student for this course?");
					ans = scan.nextLine();
					if (isInteger(ans)
							&& Integer.parseInt(ans) <= rm.getCapacity()) {
						t.setLecturer_id(Integer.parseInt(ans));
						isinta = true;
					} else {
						System.out.println("Invalid input. Please try again");
					}

				}

			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		isint = false;

		while (!isint) {
			System.out.println("Please enter the start time?");
			ans = scan.nextLine();
			if (isInteger(ans)) {
				if (ans.length() == 4) {
					t.setStart_time(ans);
					isint = true;
				} else {
					System.out.println("Invalid input. Please try again");
				}
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}
		isint = false;

		while (!isint) {
			System.out.println("Please enter the end time?");
			ans = scan.nextLine();
			if (isInteger(ans)) {
				if (ans.length() == 4) {
					t.setEnd_time(ans);
					isint = true;
				} else {
					System.out.println("Invalid input. Please try again");
				}
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		isint = false;

		while (!isint) {
			System.out.println("Please enter the date? (DDMMYY)");
			ans = scan.nextLine();
			if (isInteger(ans)) {
				if (ans.length() == 6) {
					t.setDate(ans);
					isint = true;
				} else {
					System.out.println("Invalid input. Please try again");
				}
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		isint = false;

		while (!isint) {
			System.out.println("Is this complusory? (Y | N)");
			ans = scan.nextLine();
			if (ans.equals("Y") || ans.equals("N")) {
				t.setIs_compulsory(ans);
				isint = true;
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		isint = false;

		while (!isint) {
			System.out.println("Do you require a tutor? (yes | no)");
			ans = scan.nextLine();
			if (ans.equals("yes")) {
				isint = true;
				boolean isinta = false;
				while (!isinta) {
					tc.viewTutor();
					System.out.println("Enter the number of the tutor");
					ans = scan.nextLine();
					if (isInteger(ans)) {
						t.setRequire_tutor(Integer.parseInt(ans));
						isinta = true;
					} else {
						System.out.println("Invalid input. Please try again");
					}

				}
			} else if (ans.equals("no")) {
				isint = true;
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		isint = false;

		while (!isint) {
			lc.viewLect();
			System.out.println("Please choose a lecturer?");
			ans = scan.nextLine();
			if (isInteger(ans)) {
				t.setLecturer_id(Integer.parseInt(ans));
				isint = true;
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		System.out.println("Do you have any remarks?");
		ans = scan.nextLine();
		t.setRemarks(ans);
		t.setTimetable_id(tt.size() + 1);
		tt.add(t);
		System.out.println("Time Slot added");
		save();

	}

	public boolean editTt(int id) {
		boolean isint = false;

		Timetable t = new Timetable();
		boolean found = false;
		for (Timetable ti : tt) {
			if (ti.getTimetable_id() == id) {
				t = ti;
				tt.remove(ti);
				found = true;
			}
		}
		if (!found) {
			return false;
		}

		Room rm = null;
		String ans;

		while (!isint) {
			cc.viewClasses();
			System.out.println("Please choose a class?");
			ans = scan.nextLine();
			if (isInteger(ans)) {
				t.setClass_id(Integer.parseInt(ans));
				isint = true;
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		isint = false;

		while (!isint) {
			coc.viewCourse();
			System.out.println("Please choose a course?");
			ans = scan.nextLine();
			if (isInteger(ans)) {
				t.setCourse_id(Integer.parseInt(ans));
				isint = true;
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		isint = false;

		while (!isint) {
			rc.viewRoom();
			System.out.println("Please choose a room?");
			ans = scan.nextLine();
			if (isInteger(ans)) {
				t.setClass_id(Integer.parseInt(ans));
				rm = rc.getRoom(Integer.parseInt(ans));
				isint = true;

				boolean isinta = false;

				while (isinta) {
					System.out
							.println("Please enter the maximum number of student for this course?");
					ans = scan.nextLine();
					if (isInteger(ans)
							&& Integer.parseInt(ans) <= rm.getCapacity()) {
						t.setLecturer_id(Integer.parseInt(ans));
						isinta = true;
					} else {
						System.out.println("Invalid input. Please try again");
					}

				}

			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		isint = false;

		while (!isint) {
			System.out.println("Please enter the start time?");
			ans = scan.nextLine();
			if (isInteger(ans)) {
				if (ans.length() == 4) {
					t.setStart_time(ans);
					isint = true;
				} else {
					System.out.println("Invalid input. Please try again");
				}
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}
		isint = false;

		while (!isint) {
			System.out.println("Please enter the end time?");
			ans = scan.nextLine();
			if (isInteger(ans)) {
				if (ans.length() == 4) {
					t.setEnd_time(ans);
					isint = true;
				} else {
					System.out.println("Invalid input. Please try again");
				}
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		isint = false;

		while (!isint) {
			System.out.println("Please enter the date? (DDMMYY)");
			ans = scan.nextLine();
			if (isInteger(ans)) {
				if (ans.length() == 6) {
					t.setDate(ans);
					isint = true;
				} else {
					System.out.println("Invalid input. Please try again");
				}
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		isint = false;

		while (!isint) {
			System.out.println("Is this complusory? (Y | N)");
			ans = scan.nextLine();
			if (ans.equals("Y") || ans.equals("N")) {
				t.setIs_compulsory(ans);
				isint = true;
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		isint = false;

		while (!isint) {
			System.out.println("Do you require a tutor? (yes | no)");
			ans = scan.nextLine();
			if (ans.equals("yes")) {
				isint = true;
				boolean isinta = false;
				while (!isinta) {
					tc.viewTutor();
					System.out.println("Enter the number of the tutor");
					ans = scan.nextLine();
					if (isInteger(ans)) {
						t.setRequire_tutor(Integer.parseInt(ans));
						isinta = true;
					} else {
						System.out.println("Invalid input. Please try again");
					}

				}
			} else if (ans.equals("no")) {
				isint = true;
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		isint = false;

		while (!isint) {
			lc.viewLect();
			System.out.println("Please choose a lecturer?");
			ans = scan.nextLine();
			if (isInteger(ans)) {
				t.setLecturer_id(Integer.parseInt(ans));
				isint = true;
			} else {
				System.out.println("Invalid input. Please try again");
			}

		}

		System.out.println("Do you have any remarks?");
		ans = scan.nextLine();
		t.setRemarks(ans);
		t.setTimetable_id(id);
		tt.add(t);
		System.out.println("Time Slot added");
		save();

		return true;

	}

	public boolean contain(int id) {
		for (Timetable t : tt) {
			if (t.getTimetable_id() == id) {
				return true;
			}
		}
		return false;
	}

	public void removeTt(int id) {
		for (Timetable t : tt) {
			if (t.getTimetable_id() == id) {
				tt.remove(t);
				break;
			}
		}
		save();
	}

	public void save() {
		String url = "Database/timetable.csv";
		try {
			FileWriter writer = new FileWriter(url);

			for (Timetable t : tt) {
				writer.append(t.getTimetable_id() + "," + t.getClass_id() + ","
						+ t.getCourse_id() + "," + t.getRoom_id() + ","
						+ t.getStart_time() + "," + t.getEnd_time() + ","
						+ t.isIs_compulsory() + "," + t.getRequire_tutor()
						+ "," + t.getLecturer_id() + "," + t.getMax_student()
						+ "," + t.getRemarks());
				writer.append("\n");

			}

			writer.flush();
			writer.close();

		} catch (IOException e) {
			System.err.println("Unable to save");
		}
	}

	private void initData() {
		BufferedReader br = null;
		try {

			/*
			 * Reading all the classes
			 */
			String sCurrentLine;
			br = new BufferedReader(
					new FileReader(
							"Database/timetable.csv"));
			while ((sCurrentLine = br.readLine()) != null) {

				String[] temp = sCurrentLine.split(",");

				if (isInteger(temp[0]) && isInteger(temp[1])
						&& isInteger(temp[2]) && isInteger(temp[3])
						&& isInteger(temp[9]) && isInteger(temp[10])) {

					Timetable tem = new Timetable();
					tem.setTimetable_id(Integer.parseInt(temp[0]));
					tem.setClass_id(Integer.parseInt(temp[1]));
					tem.setCourse_id(Integer.parseInt(temp[2]));
					tem.setRoom_id(Integer.parseInt(temp[3]));
					tem.setDate(temp[4]);
					tem.setStart_time(temp[5]);
					tem.setEnd_time(temp[6]);
					tem.setIs_compulsory(temp[7]);
					if (isInteger(temp[8]))
						tem.setRequire_tutor(Integer.parseInt(temp[8]));
					tem.setLecturer_id(Integer.parseInt(temp[9]));
					tem.setMax_student(Integer.parseInt(temp[10]));
					tem.setRemarks(temp[11]);

					tt.add(tem);

				}

			}

		} catch (IOException e) {
			System.err
					.println("Unable to establish connection with the database. Please exit the the system and try again later.");
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				System.err.println("Unable to do process");
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
}
