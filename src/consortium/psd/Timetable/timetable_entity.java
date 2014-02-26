package consortium.psd.Timetable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class timetable_entity {

	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;

	public  void addToTimetable(int class_id, int course_id, int room_id, String date, String start_time, String end_time,
			String is_compulsory, int require_tutor, int lecturer_id, String remark) throws SQLException{
		connection = DriverManager.getConnection("jdbc:derby:consortiumDB");
		statement = connection.createStatement();

		statement.executeUpdate("INSERT INTO APP.\"timetable\" (class_id, course_id, room_id, date, start_time, end_time, is_compulsory, require_tutor, lecturer_id, remarks) "
				+ " VALUES ("+class_id+","+course_id+","+room_id+",\'"+date+"\',\'"+start_time+"\',\'"+end_time
				+"\',\'"+is_compulsory+"\',"+require_tutor+","+lecturer_id+",\'"+remark+"\')");


		statement.close();
		connection.close();
		shutdown();


	}

	public  void deleteFromTimetable(int timetable_id) throws SQLException{
		connection = DriverManager.getConnection("jdbc:derby:consortiumDB");
		statement = connection.createStatement();
		statement.executeUpdate("DELETE FROM APP.\"timetable\" WHERE \"timetable\".TIMETABLE_ID = "+timetable_id+"");
		statement.close();
		connection.close();
		shutdown();


	}

	public  void updateTimetable(int class_id, int course_id, int room_id, String date, String start_time, String end_time,
			String is_compulsory, int require_tutor, int lecturer_id, String remark, int timetable_id) throws SQLException{
		connection = DriverManager.getConnection("jdbc:derby:consortiumDB");
		statement = connection.createStatement();
		statement.executeUpdate("UPDATE APP.\"timetable\" set class_id="+class_id+", course_id="+course_id+", room_id="+room_id+", date=\'"+date+"\',start_time=\'"+start_time+"\', end_time=\'"+end_time+"\', is_compulsory=\'"+is_compulsory+"\', require_tutor="+require_tutor+", lecturer_id="+lecturer_id+", remarks=\'"+remark+"\' where timetable_id="+timetable_id);
		statement.close();
		connection.close();
		shutdown();


	}

	public ArrayList<module> retriveTimetable(int user_id) throws ClassNotFoundException, SQLException {
		ArrayList<module> moduleList = new ArrayList<module>();

		connection = DriverManager.getConnection("jdbc:derby:consortiumDB");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT \"timetable\".TIMETABLE_ID,\"course\".NAME, \"user\".FULLNAME, \"timetable\".START_TIME, \"timetable\".END_TIME, \"timetable\".DATE FROM \"user\", \"timetable\", \"course\" WHERE \"user\".USER_ID = \"timetable\".LECTURER_ID AND \"timetable\".COURSE_ID = \"course\".COURSE_ID AND \"user\".USER_ID="+user_id);
		module m = null;

		while (resultSet.next()) {

			int timetable_id=resultSet.getInt(1);
			String module_name = resultSet.getString(2);
			String lecturer_name = resultSet.getString(3);
			String start_time = resultSet.getString(4);
			String end_time = resultSet.getString(5);
			String date = resultSet.getString(6);

			m = new module(timetable_id, module_name, lecturer_name, start_time, end_time, date);
			moduleList.add(m);

		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();

		return moduleList;
	}

	public ArrayList<module> retriveTimetable_admin() throws ClassNotFoundException, SQLException {
		ArrayList<module> moduleList = new ArrayList<module>();

		connection = DriverManager.getConnection("jdbc:derby:consortiumDB");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT \"timetable\".TIMETABLE_ID,\"course\".NAME, \"user\".FULLNAME, \"timetable\".START_TIME, \"timetable\".END_TIME, \"timetable\".DATE FROM \"user\", \"timetable\", \"course\" WHERE \"user\".USER_ID = \"timetable\".LECTURER_ID AND \"timetable\".COURSE_ID = \"course\".COURSE_ID");
		module m = null;

		while (resultSet.next()) {

			int timetable_id=resultSet.getInt(1);
			String module_name = resultSet.getString(2);
			String lecturer_name = resultSet.getString(3);
			String start_time = resultSet.getString(4);
			String end_time = resultSet.getString(5);
			String date = resultSet.getString(6);

			m = new module(timetable_id, module_name, lecturer_name, start_time, end_time, date);
			moduleList.add(m);

		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();

		return moduleList;
	}


	private  void shutdown() {
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				DriverManager.getConnection("jdbc:derby:consortiumDB"
						+ ";shutdown=true");
				statement.close();
			}
		} catch (SQLException sqlExcept) {

		}

	}




}