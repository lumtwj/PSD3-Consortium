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

public class TutorController 
{
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	String DB = "ROOT";

	public List<User> retriveTutors() throws ClassNotFoundException, SQLException {

		List<User> tutorList = new ArrayList<User>();
		User tutor;
		connection = DriverManager.getConnection("jdbc:derby:consortium");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * from "+ DB +".\"user\" where role='tutor'");

		while (resultSet.next()) {
			tutor = new User();
			tutor.setId(resultSet.getInt(1));
			tutor.setUsername(resultSet.getString(2));
			tutor.setPassword(resultSet.getString(3));
			tutor.setName(resultSet.getString(4));
			tutor.setEmail(resultSet.getString(5));
			tutor.setRole(resultSet.getString(6));

			tutorList.add(tutor);			


		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
		return tutorList;
	}

	public User retriveTutorById(int id) throws ClassNotFoundException, SQLException {


		User tutor = new User();;
		connection = DriverManager.getConnection("jdbc:derby:consortium");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * from "+ DB +".\"user\" where user_id="+id);

		while (resultSet.next()) {
			tutor.setId(resultSet.getInt(1));
			tutor.setUsername(resultSet.getString(2));
			tutor.setPassword(resultSet.getString(3));
			tutor.setName(resultSet.getString(4));
			tutor.setEmail(resultSet.getString(5));
			tutor.setRole(resultSet.getString(6));

		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
		return tutor;
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
