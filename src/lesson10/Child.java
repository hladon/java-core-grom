package lesson10;

public class Child extends Human {

	public Child(String name) {
		super(name);
	}

	void run() {
		System.out.println("Child class is called...");
		super.run();

	}
}
