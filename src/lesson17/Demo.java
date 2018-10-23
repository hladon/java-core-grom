package lesson17;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Solution test=new Solution();
        int[] res=test.findNumbers("111 is not 112 even not 113");
        System.out.println(Arrays.toString(res));
    }
}
