package consortium.psd.Attendance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Attendance {

	// jdbc Connection

	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;

	ArrayList<AttendanceList> att = new ArrayList<AttendanceList>();
	ArrayList<Course> course = new ArrayList<Course>();
	ArrayList<String> getdate = new ArrayList<String>();
	ArrayList<String> getname = new ArrayList<String>();
	public void retriveCourse() throws ClassNotFoundException, SQLException {
		 
		connection = DriverManager.getConnection("jdbc:derby:attendanceDB");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * from course");

		while (resultSet.next()) {

			int id = resultSet.getInt(1);
			String coursename = resultSet.getString(2);
			course.add(new Course(id, coursename));

		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
	}

	public void retriveDate(int d) throws ClassNotFoundException, SQLException {
		
		connection = DriverManager.getConnection("jdbc:derby:attendanceDB");
		statement = connection.createStatement();
		resultSet = statement
				.executeQuery("SELECT DISTINCT attendance.date  from course,attendance where course.id=attendance.id and attendance.id ="
						+ d);

		while (resultSet.next()) {

			
			String date = resultSet.getString(1);
			getdate.add(date);
			//att.add(new AttendanceList(id, date,status));

		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
	}
	public void getAttendance(String d) throws ClassNotFoundException, SQLException {

	
		connection = DriverManager.getConnection("jdbc:derby:attendanceDB");
		statement = connection.createStatement();
		resultSet = statement
				.executeQuery("select s.name,a.SID,a.date,a.STATUS from ATTENDANCE a,COURSE c ,COURSE_HAS_STUDENT chs ,STUDENT s where s.sid=chs.sid and c.id=chs.id and chs.sid=a.sid and a.date='" + d + "'"
						);

		while (resultSet.next()) {

			
			String name = resultSet.getString(1);
			int id = resultSet.getInt(2);
			String date = resultSet.getString(3);
			String status = resultSet.getString(4);
			att.add(new AttendanceList(id,date,status));
			getname.add(name);
			//att.add(new AttendanceList(id, date,status));

		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
	}

	public void viewAttendance() throws SQLException, ClassNotFoundException {
		retriveCourse();
	
		int i;
		for (i = 0; i < course.size(); i++) {
			System.out.println(course.get(i).getCourseID()+"\t"
					+ course.get(i).getCourseName());
		}
		Scanner c = new Scanner(System.in);
		int d = Integer.parseInt(c.nextLine());
		
		

		System.out.println("Select id to view course");
		retriveDate(d);
		
		for (i = 0; i < getdate.size(); i++) {
			System.out.println(i+"\t"+getdate.get(i));
					
		}
		
		System.out.println("Select id to view Attendance");
		Scanner e = new Scanner(System.in);
		int f = Integer.parseInt(e.nextLine());
		getAttendance(getdate.get(f));
		System.out.print("Name \t");
		System.out.print("Date \t");	
		System.out.println("Status");	
		for (i = 0; i < getname.size(); i++) {
			System.out.print(getname.get(i)+"\t");
			System.out.print(att.get(i).getDate()+"\t");	
			System.out.println(att.get(i).getStatus());		
		}
	}

	private void shutdown() {
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
