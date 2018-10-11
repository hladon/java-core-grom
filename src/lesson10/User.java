package lesson10;

public class User extends Human {

	public User(String name) {
		super(name);
	}

	void run() {
		System.out.println("User class is called...");
		super.run();
	}

}
