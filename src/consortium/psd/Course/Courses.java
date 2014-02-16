package consortium.psd.Course;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Courses {
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	
	public void retriveCourse() throws SQLException {
		/** Course table Information start **/ 
		//course_id int primary key, name varchar(50), type varchar(50)
		/** Course table Information start **/ 
		
		/** user_has_class table Information start **/ 
		//user_user_id int not null, class_class_id int not null, PRIMARY KEY (user_user_id, class_class_id)
		/** user_has_class table Information start **/ 
		
		/** course_has_class table Information start **/ 
		//course_course_id int not null, class_class_id int not null, PRIMARY KEY (course_course_id, class_class_id)
		/** course_has_class table Information start **/
		
		/** timetable table Information start **/ 
		//TIMETABLE_ID int primary key, ROOM_ID int, class_ID int, ATTENDANCE_ID int, DATE VARCHAR(10), START_TIME VARCHAR(10), END_TIME VARCHAR(10), IS_COMPULSORY VARCHAR(3), REQUIRE_TUTOR VARCHAR(3), MAX_STUDENT int, REMARKS VARCHAR(1000)
		/** timetable table Information start **/
		
		connection = DriverManager.getConnection("jdbc:derby:consortiumDB");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * from course");
		System.out.println("id" + "  " + "coursename" + "  " + "type");
		while (resultSet.next()) {

			int id = resultSet.getInt(1);
			String coursename = resultSet.getString(2);
			String type = resultSet.getString(3);
			
			System.out.println(id + "  " + coursename + "  " + type);
		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
	}
	public void retriveCompulsoryCourse() throws SQLException {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter your userid.");
		int userID = Integer.parseInt(scanner.nextLine()); 
		connection = DriverManager.getConnection("jdbc:derby:consortiumDB");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT course.name, course.type, timetable.IS_COMPULSORY from user_has_class, course_has_class, Course, timetable where user_has_class.class_class_id=course_has_class.class_class_id and course_has_class.class_class_id = timetable.CLASS_ID and course_has_class.course_course_id = Course.course_id and user_has_class.user_user_id="+ userID);
		System.out.println("coursename" + "  " + "type" + "  " + "Compulsory");
		while (resultSet.next()) {

			String coursename = resultSet.getString(1);
			String type = resultSet.getString(2);
			String compulsory = resultSet.getString(3);
			
			System.out.println(coursename + "  " + type + "  " + compulsory);
			System.out.println(" ");
		}
		resultSet.close();
		statement.close();
		connection.close();
		shutdown();
	}

	public void setupCourses() throws SQLException {
		retriveCourse();
					
		ArrayList<CourseCF> Course = new ArrayList<CourseCF>();
		Scanner scanner = new Scanner (System.in);
		System.out.println("===   Setup Additional Course   ===");
		System.out.println("Enter the course ID.");
		int courseID = Integer.parseInt(scanner.nextLine()); 
		System.out.println("Enter the name of the new courses.");
		String courseName = scanner.nextLine(); 
		System.out.println("Enter the type of the new courses.");
		String type = scanner.nextLine(); 
		CourseCF newCourse = new CourseCF(courseID, courseName, type);
		Course.add(newCourse);
		connection = DriverManager.getConnection("jdbc:derby:consortiumDB");
		statement = connection.createStatement();
				
	    for (CourseCF c : Course) {
	        String insert = "INSERT INTO course values" + 
	        "("+ c.getCourseID() + ",'"+ c.getCourseName() + "','"+ c.getType() + "')"; 
	        statement.executeUpdate(insert);
	    }
	    statement.close();
	    connection.close();
	    shutdown();
	    System.out.println("The course has been successfully setup");
	}
	
	public void applyCourse() throws SQLException {
		
		ArrayList<CourseCF> applyCourse = new ArrayList<CourseCF>();
	 	Scanner scanner = new Scanner (System.in);
	 	System.out.println("===   Apply for Course   ===");
	    System.out.println("Enter your user ID.");
		int userID = Integer.parseInt(scanner.nextLine()); 
		System.out.println("Enter the course ID that you wish to apply.");
		int courseID = Integer.parseInt(scanner.nextLine()); 
		System.out.println("Enter your class ID");
		int classID = Integer.parseInt(scanner.nextLine()); 
		CourseCF newApplyCourse = new CourseCF(userID, courseID, classID);
		applyCourse.add(newApplyCourse);
		connection = DriverManager.getConnection("jdbc:derby:consortiumDB");
		statement = connection.createStatement();
		
        for (CourseCF c : applyCourse) {
        	 String insert = "INSERT INTO user_has_class values" + 
        	 "("+ c.getUser_Class_ID() + ","+ c.getClass_Class_ID() + ")"; 
        	 statement.executeUpdate(insert);
        	 insert = "INSERT INTO course_has_class values" + 
             "("+ c.getCourse_Course_ID() + ","+ c.getUser_Class_ID() + ")"; 
             statement.executeUpdate(insert);
        }
		statement.close();
		connection.close();
		shutdown();
        System.out.println("The course has been successfully apply");
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
