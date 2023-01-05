package sortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class $06_GroupAnagrams {
    public static void main(String[] args) {
        String res = solution(new String[]{"cat", "dog", "tac", "god", "act",  "tom marvolo riddle ","abc", "def",
                "cab", "fed", "clint eastwood ", "i am lord voldemort", "elvis", "old west action",  "lives" });

        System.out.println(res);
    }

    /**
     * Given an array of strings that contain anagrams,
     * write a function to print anagrams in groups.
     */
    public static String solution(String[] arr) {
        HashMap<String, List<String>> map = new HashMap<>();

        // traverse all words
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            char[] letters = word.toCharArray(); // convert word to character array
            Arrays.sort(letters); // sort the letters
            String newWord = new String(letters); // convert the sorted letters to a new word

            // if map contains the new word, add the original word to the list
            if (map.containsKey(newWord)) {
                map.get(newWord).add(word);
            } else { // if map doesn't contain new word, add new word to map and add original word to list
                map.put(newWord, new ArrayList<>(Arrays.asList(word)));
            }
        }

        String result = "";
        for (String s: map.keySet()) {
            List<String> anagrams = map.get(s);
            // if there are more than one anagrams, print them
            if (anagrams.size() > 1) {
                result += anagrams;
            }
        }

        return result;
    }
}
