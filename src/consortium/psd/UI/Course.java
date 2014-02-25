package consortium.psd.UI;


public class Course {
	
	String name;
	int id; 
	String type;

	public Course(int id, String name, String type) {
		this.name = name;
		this.id = id;
		this.type = type;
	} 
	

	public void setName(String name) {
		this.name = name;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public int getId() {
		return id;
	}


	public String getType() {
		return type;
	}


}
