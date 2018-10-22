package lesson16hw;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        String test =" This   is is is my my     testing strin:g 3 f7rom from herson city ! ";
        String test2="https://www.gromcode.com";

        System.out.println(Arrays.toString(test2.trim().split("//")));
        System.out.println(test2.replace("rr",""));


        Solution tester=new Solution();

        System.out.println(tester.validate(test2));

    }
}
