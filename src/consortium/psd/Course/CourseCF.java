package consortium.psd.Course;

public class CourseCF {
	private int courseID;
	private int course_Course_ID;
	private int class_Class_ID;
	private int user_Class_ID;
	private String courseName;
	private String type;
	
	public int getCourse_Course_ID() {
		return course_Course_ID;
	}

	public void setCourse_Course_ID(int course_Course_ID) {
		this.course_Course_ID = course_Course_ID;
	}

	public int getClass_Class_ID() {
		return class_Class_ID;
	}

	public void setClass_Class_ID(int class_Class_ID) {
		this.class_Class_ID = class_Class_ID;
	}

	public int getUser_Class_ID() {
		return user_Class_ID;
	}

	public void setUser_Class_ID(int user_Class_ID) {
		this.user_Class_ID = user_Class_ID;
	}
	
	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public CourseCF(int courseID, String courseName, String type){
	        this.courseID = courseID;
	        this.courseName = courseName;  
	        this.type = type;
	}
	public CourseCF(int userID, int courseID, int classID){
        this.user_Class_ID = userID;
        this.course_Course_ID = courseID;  
        this.class_Class_ID = classID;
	}
}
