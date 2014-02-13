package consortium.psd.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentController 
{
	public User getStudent(int id)
	{
		User student = new User();

		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("UserNew.csv"));		
			while ((sCurrentLine = br.readLine()) != null) {			
				String[] temp = sCurrentLine.split(",");
				if(Integer.parseInt(temp[0]) == id)
				{
					student.setId(Integer.parseInt(temp[0]));
					student.setUsername(temp[1]);
					student.setPassword(temp[2]);
					student.setName(temp[3]);
					student.setEmail(temp[4]);
					student.setRole(temp[5]);
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

		return student;

	}
	public List<User>getStudentList()
	{

		List<User> studentList = new ArrayList<User>();
		User student;
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("UserNew.csv"));		
			while ((sCurrentLine = br.readLine()) != null) {

				String[] temp = sCurrentLine.split(",");
				if(temp[5].equals("student"))
				{
					student = new User();
					student.setId(Integer.parseInt(temp[0]));
					student.setUsername(temp[1]);
					student.setPassword(temp[2]);
					student.setName(temp[3]);
					student.setEmail(temp[4]);
					student.setRole(temp[5]);

					studentList.add(student);
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

		return studentList;
	}

	public List<User>getStudentListBySession(int ssid)
	{

		List<User> studentList = new ArrayList<User>();

		return studentList;
	}

	public List<User>getStudentListByCourse(int cid)
	{

		List<User> studentList = new ArrayList<User>();

		return studentList;
	}

	public List<User>getStudentListByClass(int classid)
	{

		List<User> studentList = new ArrayList<User>();

		return studentList;
	}
}
