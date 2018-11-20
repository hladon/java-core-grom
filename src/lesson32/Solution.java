package lesson32;


import java.util.Scanner;

public class Solution {
    public static int readNumbers() {
        Scanner scanner = new Scanner(System.in);
        int attempt = 3;
        int numbers = 10;
        int sum = 0;
        int number = 0;
        while (scanner.hasNext()) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                sum += number;
                numbers--;
            } catch (Exception e) {
                attempt--;
                System.out.println("Your numbers are wrong. You have " + attempt + " attempta to try again");
            }
            if (attempt == 0) {
                System.out.println("Your numbers are wrong. Numbers of attempts exceeded");
                return 0;
            }

            if (numbers == 0)
                break;

        }

        return sum;
    }
}
