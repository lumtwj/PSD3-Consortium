package consortium.psd.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RoomController {

	
	private ArrayList<Room> room = new ArrayList<Room>();

	public RoomController() {
		initData();

	}

	
	public void addRoom(String name, String location, int capacity) {
		int id = room.size();
		room.add(new Room(id, name, location, capacity));
		save();
	}

	
	public Room getRoom(int id) {
		for (Room rm : room) {
			if (rm.getId() == id){
				return rm;
			}
		}
			return null;
	}

	public int getsize() {
		return room.size();
	}

	public void viewRoom() {
		for (Room r : room) {
			System.out.println(r.getId() + ":\t" + r.getName());
		}
	}

	public void viewRoom(int id) {
		for (Room r : room) {
			if (r.getId() == id) {
				System.out.println("Name:\t\t" + r.getName());
				System.out.println("Location:\t\t" + r.getLocation());
				System.out.println("Max Capacity:\t" + r.getCapacity());
				System.out.println();
				break;
			}
		}
	}

	public void editRoom(int id, String name, String location, int capacity) {
		for (Room r : room) {
			if (r.getId() == id) {
				r.setName(name);
				r.setLocation(location);
				r.setCapacity(capacity);
				break;
			}
		}
		save();
	}

	public void delRoom(int id) {
		for (Room r : room) {
			if (r.getId() == id) {
				room.remove(r);
				break;
			}
		}
		save();
	}

	public void save() {
		
		String url = "Database/room.csv";
		try {

			FileWriter writer = new FileWriter(url);

			for (Room r : room) {
				writer.append(r.getId() + "," + r.getName() + ","
						+ r.getLocation() + "," + r.getCapacity());
				writer.append("\n");
			}

			writer.flush();
			writer.close();

		} catch (IOException e) {
			System.err.println("Unable to save");
		}
	}

	
	public void initData() {
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(
					new FileReader(
							"Database/room.csv"));
			while ((sCurrentLine = br.readLine()) != null) {
				String[] temp = sCurrentLine.split(",");
				if (isInteger(temp[3]) && isInteger(temp[0])) {
					int cap = Integer.parseInt(temp[3]);
					int id = Integer.parseInt(temp[0]);
					room.add(new Room(id, temp[1], temp[2], cap));
				}
			}

		} catch (IOException e) {
			System.err
					.println("Unable to establish connection with the database. Please exit the the system and try again later.");
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				System.err.println("Unable to do process");
			}
		}
	}

	public static boolean isInteger(String str) {
		int size = str.length();

		for (int i = 0; i < size; i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}

		return size > 0;
	}
}
