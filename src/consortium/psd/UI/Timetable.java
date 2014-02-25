package consortium.psd.UI;


public class Timetable {
	int timetable_id;
	int class_id;
	int course_id;
	int room_id;
	String date;
	String start_time;
	String end_time;
	String is_compulsory;
	int require_tutor;
	int lecturer_id;
	int max_student;
	String remarks;



	public void showTt() {

	}

	public int getTimetable_id() {
		return timetable_id;
	}

	public void setTimetable_id(int timetable_id) {
		this.timetable_id = timetable_id;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String isIs_compulsory() {
		return is_compulsory;
	}

	public void setIs_compulsory(String is_compulsory) {
		this.is_compulsory = is_compulsory;
	}

	public int getRequire_tutor() {
		return require_tutor;
	}

	public void setRequire_tutor(int require_tutor) {
		this.require_tutor = require_tutor;
	}

	public int getLecturer_id() {
		return lecturer_id;
	}

	public void setLecturer_id(int lecturer_id) {
		this.lecturer_id = lecturer_id;
	}

	public int getMax_student() {
		return max_student;
	}

	public void setMax_student(int max_student) {
		this.max_student = max_student;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
