package lesson31;



import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Map countSymbols(String text) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        char ch ;
        String stringCh ;
        while (i < text.length()) {
            ch = text.charAt(i);
            stringCh = Character.toString(ch);
            if (Character.isLetter(ch)) {
                map=adding(map,stringCh);
            }
            i++;
        }
        return map;
    }

    public Map words(String text) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = text.trim().split(" ");
        int count;
        for (String word : words) {
            if (!isWord(word))
                continue;
            map=adding(map,word);
        }
        return map;
    }

    private boolean isWord(String word) {
        if (word != null && word.length() > 1) {
            return word.replaceAll("[а-яА-Яa-zA-Z ]", "").length() == 0;
        }
        return false;
    }
    private Map adding (Map map, String text){
        int count;
        if (map.containsKey(text)) {
            count = (Integer) map.get(text);
            map.put(text, count + 1);
        } else {
            map.put(text, 1);
        }
        return map;
    }

}
