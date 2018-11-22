package lesson31;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Map countSymbols(String text) {
        Map<Character, Integer> symbols = new HashMap<>();

        int count = 0;
        int i = 0;
        char ch ;
        String stringCh ;
        while (i < text.length()) {
            ch = text.charAt(i);
            stringCh = Character.toString(ch);
            if (Character.isLetter(ch)) {
                count = text.length() - text.replace(stringCh, "").length();
                symbols.put(ch, count);
            }
            i++;
        }
        return symbols;
    }

    public Map words(String text) {
        Map<String, Integer> symbols = new HashMap<>();
        String[] words = text.trim().split(" ");
        int count = 1;
        int i = 0;
        while (i < text.length()) {

            if (isWord(words[i])) {

            }
            i++;
        }
        return symbols;
    }

    private boolean isWord(String word) {
        if (word != null && word.length() > 1) {
            return word.replaceAll("[а-яА-Яa-zA-Z ]", "").length() == 0;
        }
        return false;
    }

}
