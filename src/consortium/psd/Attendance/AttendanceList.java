package consortium.psd.Attendance;

public class AttendanceList {
	
	private String matri; 
	private String date;
	private String status;
	
	
	public AttendanceList(String matri, String date, String status) {

		this.date = date;
		this.matri = matri;
		this.status = status;
	}


	public String getMatri() {
		return matri;
	}


	public String getDate() {
		return date;
	}
	
	public String getStatus() {
		return status;
	}
	
	
	
	
}
