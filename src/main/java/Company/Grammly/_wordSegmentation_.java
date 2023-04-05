package Company.Grammly;
import java.util.*;

public class _wordSegmentation_ {
    private static List<String> sentences;
    public static void main(String[] args){
        segmentation("helloworld!", new String[]{"he", "hi", "hell", "low", "helloworld", "hello", "world", "!"});
    }

    private static void segmentation(String s, String[] dic){
        List<String> wordDict = new ArrayList<>(Arrays.asList(dic));
        Set<String> words = new HashSet<>(wordDict);
        sentences = new ArrayList<>();
        wordBreak(words, s, 0, "");

        for (String ss : sentences){
            System.out.println(ss);
        }
        return;
    }

    private static void wordBreak(Set<String> words, String s, int i, String sentence) {
        if (i == s.length()) {
            sentences.add(sentence);
            return;
        }

        for (int j = i; j < s.length(); j++) {
            String word = s.substring(i, j + 1);
            if (words.contains(word)) {
                if (sentence.length() == 0) {
                    wordBreak(words, s, j + 1, sentence + word);
                } else {
                    wordBreak(words, s, j + 1, sentence + " " + word);
                }
            }
        }
    }
}
