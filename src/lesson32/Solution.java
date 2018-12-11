package lesson32;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static int readNumbers() throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        int attempt = 3;
        int sum = 0;
        int number = 0;
        String[] numbers = bufferedReader.readLine().trim().split(" ");
        for (int i=0;i<10;i++){
            try {
                sum += Integer.valueOf(numbers[i]);
            } catch (Exception e) {
                if (attempt == 0) {
                    System.out.println("Your numbers are wrong. Numbers of attempts exceeded");
                    break;
                }
                attempt--;
                System.out.println("Your numbers are wrong. You have " + attempt + " attempt to try again");
            }
        }
        return sum;
    }
}

