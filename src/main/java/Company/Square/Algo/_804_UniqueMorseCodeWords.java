package Company.Square.Algo;

import java.util.*;


public class _804_UniqueMorseCodeWords {
    public static int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> dic = new HashSet<>();

        for (String word : words){
            String morseWord = "";
            for (char c : word.toCharArray()){
                int index = c - 'a';
                morseWord += morse[index];
            }

            System.out.println(morseWord);
            dic.add(morseWord);
        }

        return dic.size();
    }



    public static void main(String[] args){
        String[] words = new String[]{"gin","zen","gig","msg"};
        int res = uniqueMorseRepresentations(words);
        System.out.println(res);
    }
}