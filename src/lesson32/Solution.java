package lesson32;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static int readNumbers() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        int attempt = 3;
        int sum = 0;
        String line;
        while (attempt> 0) {
            try {
                line=bufferedReader.readLine();
                return lineToNumbers(line);
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

    private static int lineToNumbers  (String line) throws NumberFormatException{
        String[] stringsNumbers =line.trim().split(" ");
        int number = 0;
        int sum = 0;
        for (int i=0; i<10;i++){
            number =Integer.parseInt(stringsNumbers[i]);
            if (number>100){
                throw new   NumberFormatException();
            }
            sum +=number;
        }
        return sum;
    }
}
