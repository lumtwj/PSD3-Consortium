package consortium.psd.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TutorController 
{
	public User getTutor(int id)
	{
		User tutor = new User();

		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("UserNew.csv"));		
			while ((sCurrentLine = br.readLine()) != null) {			
				String[] temp = sCurrentLine.split(",");
				if(Integer.parseInt(temp[0]) == id)
				{
					tutor.setId(Integer.parseInt(temp[0]));
					tutor.setUsername(temp[1]);
					tutor.setPassword(temp[2]);
					tutor.setName(temp[3]);
					tutor.setEmail(temp[4]);
					tutor.setRole(temp[5]);
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

		
		return tutor;
		
	}
	public List<User>getTutorList()
	{
		
		List<User> tutorList = new ArrayList<User>();
		User tutor;
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("UserNew.csv"));		
			while ((sCurrentLine = br.readLine()) != null) {

				String[] temp = sCurrentLine.split(",");
				if(temp[5].equals("tutor"))
				{
					tutor = new User();
					tutor.setId(Integer.parseInt(temp[0]));
					tutor.setUsername(temp[1]);
					tutor.setPassword(temp[2]);
					tutor.setName(temp[3]);
					tutor.setEmail(temp[4]);
					tutor.setRole(temp[5]);

					tutorList.add(tutor);
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

		return tutorList;
	}
	
	public List<User>getTutorListBySession(int ssid)
	{
		
		List<User> tutorList = new ArrayList<User>();
		
		return tutorList;
	}
	
	public List<User>getTutorListByCourse(int cid)
	{
		
		List<User> tutorList = new ArrayList<User>();
		
		return tutorList;
	}
	
	
}
