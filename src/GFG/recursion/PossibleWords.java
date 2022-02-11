package GFG.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PossibleWords {

    private static Map<Integer, String> wordMap = new HashMap<>();
    {
        wordMap.put(0, "");
        wordMap.put(1, "");
        wordMap.put(2, "abc");
        wordMap.put(3, "def");
        wordMap.put(4, "ghi");
        wordMap.put(5, "jkl");
        wordMap.put(6, "mno");
        wordMap.put(7, "pqrs");
        wordMap.put(8, "tuv");
        wordMap.put(9, "wxyz");
    }
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList<String> possibleWords(int a[], int N)
    {
        // your code here
        ArrayList<String> words = new ArrayList<>();
        possibleWords(a, 0, "", words);
        Collections.sort(words);
        return words;
    }

    private static void possibleWords(int a[], int index, String word, ArrayList<String> words) {
        if(a.length == index) {
            words.add(word);
            return;
        }
        String cur = wordMap.get(a[index]);
        for(int i = 0; i < cur.length(); i++) {
            possibleWords(a, index+1, word+cur.charAt(i), words);
        }
    }

}
