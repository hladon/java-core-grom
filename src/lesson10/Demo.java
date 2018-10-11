package lesson10;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human human = new Human("Test");
		run(human);
		System.out.println();

		User user = new User("Jack");

	}

	private static void run(Human human) {
		human.run();
	}
}
