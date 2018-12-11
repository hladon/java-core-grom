package lesson32;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static int readNumbers() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        int attempt = 3;
        int numbers = 10;
        int sum = 0;
        int number = 0;
        while (numbers != 0) {
            try {
                number = Integer.parseInt(bufferedReader.readLine());
                sum += number;
                numbers--;
            } catch (Exception e) {
                if (attempt == 0) {
                    System.out.println("Your numbers are wrong. Numbers of attempts exceeded");
                    break;
                }
                attempt--;
                System.out.println("Your numbers are wrong. You have " + attempt + " attempta to try again");
            }

        }

        return sum;
    }
}
