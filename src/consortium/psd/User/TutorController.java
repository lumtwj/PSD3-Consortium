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

	public List<Tutor> retriveAllTutors() throws ClassNotFoundException, SQLException {

		List<Tutor> tutorList = new ArrayList<Tutor>();
		Tutor tutor;
		connection = DriverManager.getConnection("jdbc:derby:consortium");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * from "+ DB +".\"user\" where role='tutor'");

		while (resultSet.next()) {
			tutor = new Tutor();
			tutor.setId(resultSet.getInt("user_id"));
			tutor.setUsername(resultSet.getString("username"));
			tutor.setPassword(resultSet.getString("password"));
			tutor.setName(resultSet.getString("fullname"));
			tutor.setEmail(resultSet.getString("email"));
			tutor.setRole(resultSet.getString("role"));
			tutorList.add(tutor);			


		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
		return tutorList;
	}

	public Tutor retriveTutorByUserId(int id) throws ClassNotFoundException, SQLException {


		Tutor tutor = new Tutor();;
		connection = DriverManager.getConnection("jdbc:derby:consortium");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * from "+ DB +".\"user\" where user_id="+id);

		while (resultSet.next()) {
			tutor.setId(resultSet.getInt("user_id"));
			tutor.setUsername(resultSet.getString("username"));
			tutor.setPassword(resultSet.getString("password"));
			tutor.setName(resultSet.getString("fullname"));
			tutor.setEmail(resultSet.getString("email"));
			tutor.setRole(resultSet.getString("role"));

		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
		return tutor;
	}
	
	public List<Tutor> retriveTutorsListByCourseId(int id) throws ClassNotFoundException, SQLException {

		List<Tutor> tutorList = new ArrayList<Tutor>();
		Tutor tutor;
		connection = DriverManager.getConnection("jdbc:derby:consortium");
		statement = connection.createStatement();
		
		//to edit
		resultSet = statement.executeQuery("SELECT * from "+ DB +".\"user\" where role='tutor'");

		while (resultSet.next()) {
			tutor = new Tutor();
			tutor.setId(resultSet.getInt("user_id"));
			tutor.setUsername(resultSet.getString("username"));
			tutor.setPassword(resultSet.getString("password"));
			tutor.setName(resultSet.getString("fullname"));
			tutor.setEmail(resultSet.getString("email"));
			tutor.setRole(resultSet.getString("role"));
			
			tutorList.add(tutor);			


		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
		return tutorList;
	}
	
	public List<Tutor> retriveTutorsListByTimetableId(int id) throws ClassNotFoundException, SQLException {

		List<Tutor> tutorList = new ArrayList<Tutor>();
		Tutor tutor;
		connection = DriverManager.getConnection("jdbc:derby:consortium");
		statement = connection.createStatement();
		
		//to edit
		resultSet = statement.executeQuery("SELECT * from "+ DB +".\"user\" where role='tutor'");

		while (resultSet.next()) {
			tutor = new Tutor();
			tutor.setId(resultSet.getInt("user_id"));
			tutor.setUsername(resultSet.getString("username"));
			tutor.setPassword(resultSet.getString("password"));
			tutor.setName(resultSet.getString("fullname"));
			tutor.setEmail(resultSet.getString("email"));
			tutor.setRole(resultSet.getString("role"));

			tutorList.add(tutor);


		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
		return tutorList;
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
