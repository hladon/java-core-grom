package lesson8.lesson82;

public class Demo {

	public static void main(String[] args) {
		
		Adder adder = new Adder();
		int[] arr = { 3, 45, 56, 98, 96 };
		adder.add(5, 6);
		adder.check(arr);
		System.out.println(adder.check(arr));
	}

}