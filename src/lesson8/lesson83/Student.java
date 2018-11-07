package lesson8.lesson83;

public class Student {
	String firstName;
	String lastName;
	int group;
	Course[] coursesTaken;
	int age;

	public Student(String firstName, String lastName, int group, Course[] courseTaken) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.group = group;
		this.coursesTaken = courseTaken;
	}

}
