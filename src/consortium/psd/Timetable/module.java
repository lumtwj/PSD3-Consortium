package consortium.psd.Timetable;

public class module {

	private int moduleID;
	private int roomID;
	private int courseID;
	private int attendanceID;
	private int session;
	private boolean isCompulsory;
	private boolean requireTutor;
	private String remark;
	private int capacity;
	private String moduleName;

	public module(int moduleID, String moduleName, int session){
		isCompulsory=true;
		this.moduleID=moduleID;
		this.moduleName=moduleName;
		this.session=session;
	}

	public module(String moduleName){
		this.moduleName=moduleName;
	}

	public module(){
		isCompulsory=true;
	}

	public String getModuleName() {
		if(moduleName==null)
			return "   ";
		else
			return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public int getModuleID() {
		return moduleID;
	}

	public void setModuleID(int moduleID) {
		this.moduleID = moduleID;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public int getAttendanceID() {
		return attendanceID;
	}

	public void setAttendanceID(int attendanceID) {
		this.attendanceID = attendanceID;
	}

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}

	public boolean isCompulsory() {
		return isCompulsory;
	}

	public void setCompulsory(boolean isCompulsory) {
		this.isCompulsory = isCompulsory;
	}

	public boolean isRequireTutor() {
		return requireTutor;
	}

	public void setRequireTutor(boolean requireTutor) {
		this.requireTutor = requireTutor;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getCompulsory(){
		if(moduleName==null){
			return "";
		}
		else{
			if(isCompulsory==false)
				return "(NC)";
			else
				return "(C)";
		}

	}

}
