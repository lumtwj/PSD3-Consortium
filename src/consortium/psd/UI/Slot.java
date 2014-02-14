package consortium.psd.UI;

import java.util.ArrayList;


public class Slot {

	private String date;
	private String location; 
	private ArrayList<Student> attendance;
	private Lecture lect;
	
	public Slot(String date, String location, ArrayList<Student> attendance,
			Lecture lect) {

		this.date = date;
		this.location = location;
		this.attendance = attendance;
		this.lect = lect;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<Student> getAttendance() {
		return attendance;
	}

	public void setAttendance(ArrayList<Student> attendance) {
		this.attendance = attendance;
	}

	public Lecture getLect() {
		return lect;
	}

	public void setLect(Lecture lect) {
		this.lect = lect;
	} 
	
}
