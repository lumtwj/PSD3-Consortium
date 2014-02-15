package consortium.psd.Attendance;

public class Course {
	
	private String courseName; 
	private int courseID;
	
	
	
	public Course(int courseID,String courseName) {

		this.courseName=courseName;
		this.courseID=courseID;
		
	}



	public String getCourseName() {
		return courseName;
	}



	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public int getCourseID() {
		return courseID;
	}



	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}



	
	
	
	
}
