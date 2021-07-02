package Y2021.ds.LinkedList.cci;

import Y2021.ds.LinkedList.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveMiddleElement {

    public static void main(String[] args) {
        /*LinkedList<Integer> list = LinkedList.getMeASample();

        printAll(list);
        list.removeMiddle();
        printAll(list);
        list.removeMiddle();
        printAll(list);

        IntStream.range(0,10).forEach(i-> {
            list.removeMiddle();
            printAll(list);
        });*/
        String[] ar = findWords(new String[]{"Hello","Alaska","Dad","Peace"});

        System.out.println(Arrays.toString(ar));
    }

    private static void printAll(LinkedList<Integer> list) {
        list.forEach(integer -> System.out.print(integer + " "));
        System.out.println();


    }
    public static String[] findWords(String[] words) {
        List<HashSet<String>> keyboard = new ArrayList<>();
        keyboard.add(buildKeyboard("qwertyuiopQWERTYUIOP"));
        keyboard.add(buildKeyboard("asdfghjklASDFGHJKL"));
        keyboard.add(buildKeyboard("zxcvbnmZXCVBNM"));

        List<String> result = new ArrayList<>();
        for(String word : words) {
            for(HashSet<String> keys : keyboard) {
                if(keys.containsAll(Arrays.asList(word.split("")))){
                    result.add(word);
                }
            }
        }

        return result.toArray(String[]::new);
    }
    private static HashSet<String> buildKeyboard(String s) {
        HashSet<String> set = new HashSet<>(s.length());
        for(String c : s.split("")) {
            set.add(c);
        }
        return set;
    }

}
