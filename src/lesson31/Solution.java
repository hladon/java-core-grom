package lesson31;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Map countSymbols(String text) {
        Map<Character, Integer> symbols = new HashMap<>();
        char[] characters = text.toCharArray();
        int count = 1;
        int i = 0;
        while (i < characters.length) {
            if (Character.isLetter(characters[i])) {
                for (int k = i + 1; k < characters.length; k++) {
                    if (characters[i] == characters[k]) {
                        characters[k] = ' ';
                        count++;
                    }
                }
                symbols.put(characters[i], count);
            }
            i++;
            count = 1;
        }
        return symbols;
    }

    public Map words(String text) {
        Map<String, Integer> symbols = new HashMap<>();
        String[] words = text.trim().split(" ");
        int count = 1;
        int i = 0;
        while (i < words.length) {
            if (isWord(text) ) {
                for (int k = i + 1; k < words.length; k++) {
                    if (words[i] != null && words[i].equals(words[k])) {
                        words[k] = null;
                        count++;
                    }
                }
                symbols.put(words[i], count);
            }
            i++;
            count = 1;
        }
        return symbols;
    }
    private boolean isWord(String word){
        if (word!=null&& word.length()>1){
            return word.replaceAll("[а-яА-Яa-zA-Z ]","").length()==0;
        }
        return false;
    }

}
