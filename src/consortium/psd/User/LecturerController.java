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

public class LecturerController 
{
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	String DB = "ROOT";

	public List<User> retriveLecturers() throws ClassNotFoundException, SQLException {

		List<User> lecturerList = new ArrayList<User>();
		User lecturer;
		connection = DriverManager.getConnection("jdbc:derby:consortium");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * from "+ DB +".\"user\" where role='lecturer'");

		while (resultSet.next()) {
			lecturer = new User();
			lecturer.setId(resultSet.getInt(1));
			lecturer.setUsername(resultSet.getString(2));
			lecturer.setPassword(resultSet.getString(3));
			lecturer.setName(resultSet.getString(4));
			lecturer.setEmail(resultSet.getString(5));
			lecturer.setRole(resultSet.getString(6));

			lecturerList.add(lecturer);			


		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
		return lecturerList;
	}

	public User retriveLecturerById(int id) throws ClassNotFoundException, SQLException {


		User lecturer = new User();;
		connection = DriverManager.getConnection("jdbc:derby:consortium");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * from "+ DB +".\"user\" where user_id="+id);

		while (resultSet.next()) {
			lecturer.setId(resultSet.getInt(1));
			lecturer.setUsername(resultSet.getString(2));
			lecturer.setPassword(resultSet.getString(3));
			lecturer.setName(resultSet.getString(4));
			lecturer.setEmail(resultSet.getString(5));
			lecturer.setRole(resultSet.getString(6));

		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
		return lecturer;
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
