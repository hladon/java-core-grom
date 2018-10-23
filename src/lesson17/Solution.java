package lesson17;

public class Solution {

    public int[] findNumbers(String text) {
        String[] words = text.split(" ");
        int[] numbers = new int[words.length];
        for (int i = 0; i < words.length; i++) {

            if (test(words[i])) {
                numbers[i] = Integer.parseInt(words[i]);
            } else {
                System.out.println("not a number");
            }

        }
        return numbers;
    }

    private static boolean test(String word) {
        if (word == null) {
            return false;
        }
        char[] chars = word.toCharArray();
        for (Character sym : chars) {
            if (!sym.isDigit(sym)) {
                return false;
            }
        }
        return true;
    }
}
