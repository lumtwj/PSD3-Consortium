package consortium.psd.UI;

public class Student {
	private int user_id;
	private String fullname;
	private String email;

	public Student(int user_id, String fullname,
			String email) {

		this.user_id = user_id;
		this.fullname = fullname;
		this.email = email;
	}

	public int getUser_id() {
		return user_id;
	}

	public String getFullname() {
		return fullname;
	}


	public String getEmail() {
		return email;
	}


}
