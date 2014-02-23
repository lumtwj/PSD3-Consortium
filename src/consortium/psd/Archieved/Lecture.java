package consortium.psd.Archieved;

public class Lecture {
	
	private String name; 
	private String lectno;
	private String email;
	
	public Lecture (String name, String lectno, String email) {
		this.name = name; 
		this.lectno = lectno;
		this.email = email;
	}

	public String getLectno() {
		return lectno;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	
}
