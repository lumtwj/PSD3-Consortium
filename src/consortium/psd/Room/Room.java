package consortium.psd.Room;

public class Room {
	
	private int id;
	private String name; 
	private String location;
	private int capacity;

	public Room(int id, String name, String location, int capacity) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.capacity = capacity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getId() {
		return id;
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
