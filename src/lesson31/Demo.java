package lesson31;

public class Demo {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.countSymbols("kkmmmcv"));
        System.out.println(solution.countSymbols("First test text for my solution"));
        System.out.println(solution.countSymbols(" 2 test text with numbers and spaces "));
        System.out.println(solution.countSymbols(" werjolregnb;lv;fdj;"));
        System.out.println(solution.countSymbols(" 3u09438tujg0w 0utgw gw09utg "));

        System.out.println(solution.words("my my next next next is  word"));
        System.out.println(solution.words(" vv zz kk mm mm ll th th th ht "));
    }
}
