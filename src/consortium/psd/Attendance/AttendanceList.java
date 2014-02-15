package consortium.psd.Attendance;

public class AttendanceList {
	
	private int id; 
	private String date;
	private String status;
	
	
	public AttendanceList(int id, String date, String status) {

		this.date = date;
		this.id = id;
		this.status = status;
	}


	public int getID() {
		return id;
	}


	public String getDate() {
		return date;
	}
	
	public String getStatus() {
		return status;
	}
	
	
	
	
}
