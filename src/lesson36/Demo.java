package lesson36;

import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("\\d+,\\w+");
        System.out.println(Repository.checkDataFromRepository(pattern,"111"));

    }
}
