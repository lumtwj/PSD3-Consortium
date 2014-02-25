package consortium.psd.Timetable;

public class module {

	private int class_id;
	private int course_id;
	private int room_id;
	private String date;
	private String start_time;
	private String end_time;
	private String is_compulsory;
	private int require_tutor;
	private int lecturer_id;
	private String remarks;
	private int timetable_id;
	private String module_name;

	public String getModule_name() {
		return module_name;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	public String getLecturer_name() {
		return lecturer_name;
	}

	public void setLecturer_name(String lecturer_name) {
		this.lecturer_name = lecturer_name;
	}

	private String lecturer_name;

	public module() {

	}

	public module(int timetable_id, String module_name, String lecturer_name,
			String start_time, String end_time, String date) {
		this.timetable_id = timetable_id;
		this.module_name = module_name;
		this.lecturer_name = lecturer_name;
		this.start_time = start_time;
		this.end_time = end_time;
		this.date = date;
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

	public String getIs_compulsory() {
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
