package lesson8.lesson82;

import java.util.*;

public class Arithmetic {
	boolean check(int[] array) {
		Arrays.sort(array);
		return array[0] + array[array.length - 1] > 100;
	}
}
