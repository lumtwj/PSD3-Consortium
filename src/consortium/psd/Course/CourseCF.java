package consortium.psd.Course;

public class CourseCF {
	//private String courseID;
	private String courseName;
	private String semester;
	private String compulsory;
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getCompulsory() {
		return compulsory;
	}

	public void setCompulsory(String compulsory) {
		this.compulsory = compulsory;
	}
	
	public CourseCF(String courseName, String semester, String compulsory){
	     
	        this.courseName = courseName;    
	        this.semester = semester;
	        this.compulsory = compulsory;
	}

}
