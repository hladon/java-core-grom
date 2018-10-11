package lesson83;

public class SpecialStudent extends CollegeStudent {
	long secretKey;
	String email;

	public SpecialStudent(String firstName, String lastName, int group, Course[] courseTaken, long secretKey,
			String email) {
		super(firstName, lastName, group, courseTaken);
		this.secretKey = secretKey;
		this.email = email;
	}

}
