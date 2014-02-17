package consortium.psd.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentController 
{
	
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	String DB = "ROOT";

	public List<User> retriveStudents() throws ClassNotFoundException, SQLException {

		List<User> studentList = new ArrayList<User>();
		User student;
		connection = DriverManager.getConnection("jdbc:derby:consortium");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * from "+ DB +".\"user\" where role='student'");

		while (resultSet.next()) {
			student = new User();
			student.setId(resultSet.getInt(1));
			student.setUsername(resultSet.getString(2));
			student.setPassword(resultSet.getString(3));
			student.setName(resultSet.getString(4));
			student.setEmail(resultSet.getString(5));
			student.setRole(resultSet.getString(6));

			studentList.add(student);			


		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
		return studentList;
	}
	
	public User retriveStudentById(int id) throws ClassNotFoundException, SQLException {
		
		
		User student = new User();;
		connection = DriverManager.getConnection("jdbc:derby:consortium");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * from "+ DB +".\"user\" where user_id="+id);

		while (resultSet.next()) {
			student.setId(resultSet.getInt(1));
			student.setUsername(resultSet.getString(2));
			student.setPassword(resultSet.getString(3));
			student.setName(resultSet.getString(4));
			student.setEmail(resultSet.getString(5));
			student.setRole(resultSet.getString(6));

		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
		return student;
	}
	
	private void shutdown() 
	{
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				DriverManager.getConnection("jdbc:derby:consortium"
						+ ";shutdown=true");
				statement.close();
			}
		} catch (SQLException sqlExcept) {

		}

	}




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
