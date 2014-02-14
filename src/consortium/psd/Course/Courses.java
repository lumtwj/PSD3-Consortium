package consortium.psd.Course;
import java.io.*;
import java.util.*;

public class Courses {
	public static void setupCourses() {
		 try {
			 	ArrayList<CourseCF> Course = new ArrayList<CourseCF>();
			 	Scanner scanner = new Scanner (System.in);
			 	String word = "";
			 	String path = "C:\\Users\\Supersiao\\workspace\\PSD3-Consortium\\src\\consortium\\psd\\Course\\Courses.csv";
			 	System.out.println("===   Setup Additional Course   ===");
			 	BufferedReader br = null;
			    br = new BufferedReader(new FileReader(path));
			    
			    while ((word = br.readLine()) != null) {
			    	String[] tempWordArr= word.split(",");
			    	
			    	if(tempWordArr.length == 3) {
				    	System.out.println(tempWordArr[0]);
				    	System.out.println(tempWordArr[1]);
				    	System.out.println(tempWordArr[2]);
				    	CourseCF newCourse = new CourseCF(tempWordArr[0],tempWordArr[1], tempWordArr[2]);
				    	Course.add(newCourse);
			    	}
		
			    }
			    System.out.println("hehe");
				System.out.println("Enter the name of the new courses.");
				String courseName = scanner.nextLine(); 
				System.out.println("Enter this course semester.");
				String semester = scanner.nextLine(); 
				System.out.println("Is this course compulsory.");
				String compulsory = scanner.nextLine(); 
				CourseCF newCourse = new CourseCF(courseName,semester,compulsory);
				Course.add(newCourse);
				FileWriter writer = new FileWriter(path);
	            for (CourseCF c : Course) {
	            	writer.append(c.getCourseName() + "," + c.getSemester() + "," + c.getCompulsory() + "\n");
	            	//writer.append("\n");
	            }
				
	            writer.flush();
	            writer.close();
	            System.out.println("The course has been successfully setup");
		 }
		 catch (IOException e) 
	     {
	            System.out.println("Read File Fail..");
	     }
	}
}
