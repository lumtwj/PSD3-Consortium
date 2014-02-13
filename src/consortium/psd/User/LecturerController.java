package consortium.psd.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LecturerController 
{
	public User getLecturer(int id)
	{
				
		User lecturer = new User();

		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("UserNew.csv"));		
			while ((sCurrentLine = br.readLine()) != null) {			
				String[] temp = sCurrentLine.split(",");
				if(Integer.parseInt(temp[0]) == id)
				{
					lecturer.setId(Integer.parseInt(temp[0]));
					lecturer.setUsername(temp[1]);
					lecturer.setPassword(temp[2]);
					lecturer.setName(temp[3]);
					lecturer.setEmail(temp[4]);
					lecturer.setRole(temp[5]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	

		
		return lecturer;
		
	}
	public List<User>getLecturerList()
	{
		
		List<User> lecturerList = new ArrayList<User>();
		User lecturer;
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("UserNew.csv"));		
			while ((sCurrentLine = br.readLine()) != null) {

				String[] temp = sCurrentLine.split(",");
				if(temp[5].equals("lecturer"))
				{
					lecturer = new User();
					lecturer.setId(Integer.parseInt(temp[0]));
					lecturer.setUsername(temp[1]);
					lecturer.setPassword(temp[2]);
					lecturer.setName(temp[3]);
					lecturer.setEmail(temp[4]);
					lecturer.setRole(temp[5]);

					lecturerList.add(lecturer);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	

		return lecturerList;
	}
	
	public List<User>getLecturerListBySession(int ssid)
	{
		
		List<User> lecturerList = new ArrayList<User>();
		
		return lecturerList;
	}
	
	public List<User>getLecturerListByCourse(int cid)
	{
		
		List<User> lecturerList = new ArrayList<User>();
		
		return lecturerList;
	}
	
	
}
