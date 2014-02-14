package consortium.psd.Attendance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import consortium.psd.UI.Student;

public class Attendance {
	String name;
	ArrayList<Student> nameList = new ArrayList<Student>();
	ArrayList<AttendanceList> att = new ArrayList<AttendanceList>();
	String directory;
	String getFileInfo;

	public Attendance(String name) {
		this.name = name;
	}

	public Attendance() {
	}

	public void importNameList() {
		String file = "student.csv";
		BufferedReader br = null;
		
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(file));
			while ((sCurrentLine = br.readLine()) != null) {
				String[] temp = sCurrentLine.split(",");
				nameList.add(new Student(temp[0], temp[1], temp[2]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void importAttendList(String file) {

		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("attendance/" + file));
			while ((sCurrentLine = br.readLine()) != null) {
				String[] temp = sCurrentLine.split(",");
				att.add(new AttendanceList(temp[0], temp[1], temp[2]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public String getName() {
		return name;
	}

	public void createAttendance() throws IOException {
		getFolder();
		System.out.println("Enter Date:");
		Scanner a = new Scanner(System.in);
		String b = a.nextLine();
		System.out.println(b);
		FileWriter writer = new FileWriter("attendance/" + directory + "/" + b
				+ ".csv");
		importNameList();
		int i;
		for (i = 0; i < nameList.size(); i++) {
			writer.append(nameList.get(i).getMatricno());
			writer.append(",");
			writer.append(b);
			writer.append(",");
			writer.append("N");
			writer.append('\n');

		}
		writer.flush();
		writer.close();
		System.out.println("Attendance had been created");
	}

	public String viewAttendance() {
		String info = null;
		importNameList();
		getFolder();
		getFiles(directory);
		int i = 0;
		for (i = 0; i < nameList.size(); i++) {
			System.out.print(nameList.get(i).getMatricno() + "\t\t");
			System.out.print(nameList.get(i).getName() + "\t\t");
			System.out.print(att.get(i).getDate() + "\t\t");
			System.out.println(att.get(i).getStatus());

		}
		return info;
	}

	public void getFolder() {
		File folder = new File("attendance");
		File[] getFile = folder.listFiles();
		System.out.println("Select Module");
		for (int i = 0; i < getFile.length; i++) {
			if (getFile[i].isDirectory()) {

				System.out.println(i + "\t" + getFile[i].getName());
			}
		}
		Scanner a = new Scanner(System.in);
		String b = a.nextLine();
		directory = getFile[Integer.parseInt(b)].getName();

	}

	public void getFiles(String directory) {
		File folder = new File("attendance/" + directory);
		File[] getFile = folder.listFiles();
		System.out.println("Please Selection Option");
		for (int i = 0; i < getFile.length; i++) {
			if (getFile[i].isFile()) {

				System.out.print(i + "\t");
				System.out.println("Attendance of " + getFile[i].getName());
			}
		}
		Scanner a = new Scanner(System.in);
		String b = a.nextLine();

		importAttendList(directory + "/"
				+ getFile[Integer.parseInt(b)].getName());
		getFileInfo = getFile[Integer.parseInt(b)].getName();
	}

	public void markAttendance() throws IOException {
		String n = "0";

		while (!n.equals("exit")) {
			viewAttendance();
			System.out.println("Select Student:");
			Scanner a = new Scanner(System.in);
			String b = a.nextLine();

			int getStudent = Integer.parseInt(b.replaceFirst("^0+(?!$)", ""));
			System.out.println(getStudent);
			FileWriter writer = new FileWriter("attendance/" + directory + "/"
					+ getFileInfo);
			System.out.println("attendance/" + directory + "/" + getFileInfo);
			int i;

			for (i = 0; i < nameList.size(); i++) {
				writer.write(nameList.get(i).getMatricno());
				writer.write(",");
				writer.write(getFileInfo.substring(0, getFileInfo.length() - 4));
				writer.write(",");
				if (i == getStudent - 1) {

					if (att.get(i).getStatus().equals("Y")) {

						writer.write("N");
					} else if (att.get(i).getStatus().equals("N")) {

						writer.write("Y");
					}

				} else if (i != getStudent - 1) {

					writer.write(att.get(i).getStatus());
				}
				writer.write('\n');

			}

			writer.flush();
			writer.close();
			nameList.clear();
			att.clear();
			System.out.println("Type x to quit or type c to continue");
			Scanner c = new Scanner(System.in);
			String d = c.nextLine();
			if (d.equals("c")) {
				markAttendance();
			} else {
				n = "exit";
				System.out.println("Press 0 to go back.");
			}

		}

	}

}
