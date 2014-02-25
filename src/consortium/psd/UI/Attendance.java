package consortium.psd.UI;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import consortium.psd.Attendance.ClassController;
import consortium.psd.Attendance.CourseController;

public class Attendance {
	int id;
	int classs;
	int course;
	String date;
	ClassController cc = new ClassController();
	CourseController coc = new CourseController();
	ArrayList<Student> student = new ArrayList<Student>();
	Map<Student, String> attendance = new LinkedHashMap<Student, String>();

	public Attendance(int id, int classs, int course, String date) {
		this.classs = classs;
		this.course = course;
		this.id = id;
		this.date = date;

	}

	public ArrayList<Student> getKeys() {
		return student;
	}

	public Map<Student, String> getMap() {
		return attendance;
	}

	public boolean equals(int nq, int cq) {
		return (classs == nq && course == cq);
	}

	public String getdate() {
		return date;
	}

	public int getName() {
		return classs;
	}

	public int getid() {
		return id;
	}

	public int getCourse() {
		return course;
	}

	private void addStudent(Student name) {
		student.add(name);
	}

	public void addAttendance(Student name, String mark) {
		addStudent(name);
		attendance.put(name, mark);
	}

	public void markPresent(Student name) {
		attendance.remove(name);
		attendance.put(name, "Y");
	}

	public void markAbsent(Student name) {
		attendance.remove(name);
		attendance.put(name, "N");
	}

	public void printAttendance() {
		System.out.println("Class:\t" + cc.getClas(classs));
		System.out.println("Course:\t" + coc.getCourse(course).getName());
		for (Student s : student) {
			String marked = attendance.get(s);
			if (marked.equals("null")) {
				System.out
						.println(s.getFullname() + ".\tAttendance Not Marked");
			} else if (marked.equals("N")) {
				System.out.println(s.getFullname() + ".\tAbsent");
			} else if (marked.equals("Y")) {
				System.out.println(s.getFullname() + ".\tPresent");
			} else {

				System.out
						.println(s.getFullname() + ".\tAttendance Not Marked");

			}
		}
		System.out.println("");
	}
}
