package consortium.psd.User;

import java.util.ArrayList;

import consortium.psd.Course.CourseCF;
import consortium.psd.Timetable.Timetable;

public class Student extends User
{
	ArrayList<Timetable> timetables;
	ArrayList<CourseCF> courses;
	
	/**
	 * @return the timetables
	 */
	public ArrayList<Timetable> getTimetables() {
		return timetables;
	}
	/**
	 * @param timetables the timetables to set
	 */
	public void setTimetables(ArrayList<Timetable> timetables) {
		this.timetables = timetables;
	}
	/**
	 * @return the courses
	 */
	public ArrayList<CourseCF> getCourses() {
		return courses;
	}
	/**
	 * @param courses the courses to set
	 */
	public void setCourses(ArrayList<CourseCF> courses) {
		this.courses = courses;
	}
}
