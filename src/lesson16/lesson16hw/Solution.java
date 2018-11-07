package lesson16.lesson16hw;

public class Solution {
    public int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] words = input.split(" ");
        int count = 0;
        for (String word : words) {

            if (isWord(word)) {
                count++;

            }
        }
        return count;

    }

    public String maxWord(String input) {
        if (input == null) {
            return null;
        }
        String[] words = input.split(" ");

        String res = null;
        for (int i = 0; i < words.length; i++) {
            if (isWord(words[i])) {
                res = (res == null) ? words[i] : res;
                res = (res.trim().length() < words[i].trim().length()) ? words[i] : res;

            }
        }
        return res;
    }

    public String minWord(String input) {
        if (input == null) {
            return null;
        }
        String[] words = input.split(" ");
        String res = null;
        for (int i = 0; i < words.length; i++) {
            if (isWord(words[i])) {
                res = (res == null) ? words[i] : res;
                res = (res.trim().length() > words[i].trim().length()) ? words[i] : res;

            }
        }
        return res;
    }

    public String mostCountedWord(String input) {
        if (input == null) {
            return null;
        }
        String[] words = input.split(" ");
        String res = null;
        int bigger = 0;
        for (int i = 0; i < words.length; i++) {
            int count = 0;

            if (isWord(words[i])) {
                for (int j = i; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        count++;
                    }
                }
                if (count > bigger) {
                    res = words[i];
                    bigger = count;
                }

            }
        }
        return res;
    }

    public boolean validate(String adress) {
        if (adress == null||adress.isEmpty()||adress.length()<12) {
            return false;
        }
        adress = adress.trim();

        boolean check1 = adress.substring(0,7).equals("http://")||adress.substring(0,8).equals("https://");
        boolean check2 = adress.substring(adress.length()-4).equals(".com")||adress.substring(adress.length()-4).equals(".org")||
                adress.substring(adress.length()-4).equals(".net");
        adress=adress.replace("www.","");
        if (adress.substring(7,12).contains("www.")){

        }

        return check2 ;
    }

    private boolean isWord(String word) {
        if (word.isEmpty()) {
            return false;
        }
        char[] chekWord = word.trim().toCharArray();

        for (Character ch : chekWord) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }
        return true;
    }
}
