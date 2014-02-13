package consortium.psd.Attendance;

public class Facility {
	private String name;
	private String location;
	private int capacity;
	
	public Facility(String name, String location, int capacity) {
		this.name = name;
		this.location = location;
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public int getCapacity() {
		return capacity;
	}
	
	
	

}
