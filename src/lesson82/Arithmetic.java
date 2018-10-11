package lesson82;

import java.util.*;

public class Arithmetic {
	boolean check(int[] array) {
		Arrays.sort(array);
		if (array[0] + array[array.length - 1] > 100) {
			return true;
		}
		return false;
	}
}
