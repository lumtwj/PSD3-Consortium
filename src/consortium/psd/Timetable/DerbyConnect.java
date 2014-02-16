package consortium.psd.Timetable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DerbyConnect {

	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;

	public  void addModule(int module_ID, String moduleName, int session) throws SQLException{
		connection = DriverManager.getConnection("jdbc:derby:timetableDB");
		statement = connection.createStatement();
		statement.executeUpdate("insert into TIMETABLE(course_ID, course_name, session)"
				+"VALUES ("+module_ID+",\'"+moduleName+"\',"+session+")");

		statement.close();
		connection.close();
		shutdown();


	}

	public  void deleteModule(int session) throws SQLException{
		connection = DriverManager.getConnection("jdbc:derby:timetableDB");
		statement = connection.createStatement();
		statement.executeUpdate("delete from TIMETABLE where session="+session);
		statement.close();
		connection.close();
		shutdown();


	}

	public  void updateModule(int session, String moduleName, int moduleID) throws SQLException{
		connection = DriverManager.getConnection("jdbc:derby:timetableDB");
		statement = connection.createStatement();
		statement.executeUpdate("update TIMETABLE set course_ID="+moduleID+ ",course_name=\'"+moduleName+"\' where session="+session);
		statement.close();
		connection.close();
		shutdown();


	}


	public ArrayList<module> retriveTimetable() throws ClassNotFoundException, SQLException {
		ArrayList<module> moduleList = new ArrayList<module>();

		connection = DriverManager.getConnection("jdbc:derby:timetableDB");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * from timetable");
		module m = null;

		while (resultSet.next()) {

			int id = resultSet.getInt(1);
			String coursename = resultSet.getString(2);
			int session = resultSet.getInt(3);
			m = new module(id, coursename, session);
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
				DriverManager.getConnection("jdbc:derby:attendanceDB"
						+ ";shutdown=true");
				statement.close();
			}
		} catch (SQLException sqlExcept) {

		}

	}


}