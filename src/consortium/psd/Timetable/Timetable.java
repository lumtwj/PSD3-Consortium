package consortium.psd.Timetable;

import java.util.ArrayList;

public class Timetable {
	String userID;
	String userType;
	String userCourse;
	static boolean print=true;

	//module datatype
	module module;
	ArrayList<module> moduleList = new ArrayList<module>();


	//display all of the module
	public void displayTimetable(){
		System.out.print("            "+"\t"+"0900-1000"+"\t"+"1000-1100"+"\t"+"1100-1200"+"\t"+"1200-1300"+"\t"+"1300-1400"+"\t"+"1400-1500"+"\t"+"1500-1600"+"\t"+"1600-1700"+"\t"+"1700-1800"+"\n");

		checkPrint("            "+"\t"+"   1"+"\t\t"+"   2"+"\t\t"+"   3"+"\t\t"+"   4"+"\t\t"+"   5"+"\t\t"+"   6"+"\t\t"+"   7"+"\t\t"+"   8"+"\t\t"+"   9"+"\n");
		System.out.print("  Monday    "+"\t"+moduleList.get(0).getModuleName()+moduleList.get(0).getCompulsory()+"\t\t"+
				moduleList.get(1).getModuleName()+moduleList.get(1).getCompulsory()+"\t\t"+
				moduleList.get(2).getModuleName()+moduleList.get(2).getCompulsory()+"\t\t"+
				moduleList.get(3).getModuleName()+moduleList.get(3).getCompulsory()+"\t\t"+
				moduleList.get(4).getModuleName()+moduleList.get(4).getCompulsory()+"\t\t"+
				moduleList.get(5).getModuleName()+moduleList.get(5).getCompulsory()+"\t\t"+
				moduleList.get(6).getModuleName()+moduleList.get(6).getCompulsory()+"\t\t"+
				moduleList.get(7).getModuleName()+moduleList.get(7).getCompulsory()+"\t\t"+
				moduleList.get(8).getModuleName()+moduleList.get(8).getCompulsory()+"\n\n");

		checkPrint("            "+"\t"+"  10"+"\t\t"+"  11"+"\t\t"+"  12"+"\t\t"+"  13"+"\t\t"+"  14"+"\t\t"+"  15"+"\t\t"+"  16"+"\t\t"+"  17"+"\t\t"+"  18"+"\n");
		System.out.print("  Tuesday   "+"\t"+moduleList.get(9).getModuleName()+moduleList.get(9).getCompulsory()+"\t\t"+				
				moduleList.get(10).getModuleName()+moduleList.get(10).getCompulsory()+"\t\t"+
				moduleList.get(11).getModuleName()+moduleList.get(11).getCompulsory()+"\t\t"+
				moduleList.get(12).getModuleName()+moduleList.get(12).getCompulsory()+"\t\t"+
				moduleList.get(13).getModuleName()+moduleList.get(13).getCompulsory()+"\t\t"+
				moduleList.get(14).getModuleName()+moduleList.get(14).getCompulsory()+"\t\t"+
				moduleList.get(15).getModuleName()+moduleList.get(15).getCompulsory()+"\t\t"+
				moduleList.get(16).getModuleName()+moduleList.get(16).getCompulsory()+"\t\t"+
				moduleList.get(17).getModuleName()+moduleList.get(17).getCompulsory()+"\n\n");

		checkPrint("            "+"\t"+"  19"+"\t\t"+"  20"+"\t\t"+"  21"+"\t\t"+"  22"+"\t\t"+"  23"+"\t\t"+"  24"+"\t\t"+"  25"+"\t\t"+"  26"+"\t\t"+"  27"+"\n");
		System.out.print("  Wednesday "+"\t"+moduleList.get(18).getModuleName()+moduleList.get(18).getCompulsory()+"\t\t"+
				moduleList.get(19).getModuleName()+moduleList.get(19).getCompulsory()+"\t\t"+
				moduleList.get(20).getModuleName()+moduleList.get(20).getCompulsory()+"\t\t"+
				moduleList.get(21).getModuleName()+moduleList.get(21).getCompulsory()+"\t\t"+
				moduleList.get(22).getModuleName()+moduleList.get(22).getCompulsory()+"\t\t"+
				moduleList.get(23).getModuleName()+moduleList.get(23).getCompulsory()+"\t\t"+
				moduleList.get(24).getModuleName()+moduleList.get(24).getCompulsory()+"\t\t"+
				moduleList.get(25).getModuleName()+moduleList.get(25).getCompulsory()+"\t\t"+
				moduleList.get(26).getModuleName()+moduleList.get(26).getCompulsory()+"\n\n");

		checkPrint("            "+"\t"+"  28"+"\t\t"+"  29"+"\t\t"+"  30"+"\t\t"+"  31"+"\t\t"+"  32"+"\t\t"+"  33"+"\t\t"+"  34"+"\t\t"+"  35"+"\t\t"+"  36"+"\n");
		System.out.print("  Thursday "+"\t"+ moduleList.get(27).getModuleName()+moduleList.get(27).getCompulsory()+"\t\t"+
				moduleList.get(28).getModuleName()+moduleList.get(28).getCompulsory()+"\t\t"+
				moduleList.get(29).getModuleName()+moduleList.get(29).getCompulsory()+"\t\t"+
				moduleList.get(30).getModuleName()+moduleList.get(30).getCompulsory()+"\t\t"+
				moduleList.get(31).getModuleName()+moduleList.get(31).getCompulsory()+"\t\t"+
				moduleList.get(32).getModuleName()+moduleList.get(32).getCompulsory()+"\t\t"+
				moduleList.get(33).getModuleName()+moduleList.get(33).getCompulsory()+"\t\t"+
				moduleList.get(34).getModuleName()+moduleList.get(34).getCompulsory()+"\t\t"+
				moduleList.get(35).getModuleName()+moduleList.get(35).getCompulsory()+"\n\n");

		checkPrint("            "+"\t"+"  37"+"\t\t"+"  38"+"\t\t"+"  39"+"\t\t"+"  40"+"\t\t"+"  41"+"\t\t"+"  42"+"\t\t"+"  43"+"\t\t"+"  44"+"\t\t"+"  45"+"\n");
		System.out.print("  Friday    "+"\t"+moduleList.get(36).getModuleName()+moduleList.get(36).getCompulsory()+"\t\t"+
				moduleList.get(37).getModuleName()+moduleList.get(37).getCompulsory()+"\t\t"+
				moduleList.get(38).getModuleName()+moduleList.get(38).getCompulsory()+"\t\t"+
				moduleList.get(39).getModuleName()+moduleList.get(39).getCompulsory()+"\t\t"+
				moduleList.get(40).getModuleName()+moduleList.get(40).getCompulsory()+"\t\t"+
				moduleList.get(41).getModuleName()+moduleList.get(41).getCompulsory()+"\t\t"+
				moduleList.get(42).getModuleName()+moduleList.get(42).getCompulsory()+"\t\t"+
				moduleList.get(43).getModuleName()+moduleList.get(43).getCompulsory()+"\t\t"+
				moduleList.get(44).getModuleName()+moduleList.get(44).getCompulsory()+"\n\n");

	}

	//print the number in the timetable for "Admin" to make changes as well as for "Lecturer" or "Tutor" to put in attendance
	public static void checkPrint(String toPrint){
		if(print==true)
			System.out.print(toPrint);
		else
			System.out.print("\n");
	}

	//for adding new module or editing existing module can use this method
	public void addModule(int index, String newModule){
		moduleList.get(index-1).setModuleName(newModule);
	}


	//delete module
	public void delModule(int index){
		moduleList.get(index-1).setModuleName(null);
	}

	public void initTimetable(){
		for(int i=0;i<50;i++){
			moduleList.add(new module());		
		}
	}


}
