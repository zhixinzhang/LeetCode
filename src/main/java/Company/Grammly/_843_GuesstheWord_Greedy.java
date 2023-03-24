package Company.Grammly;

import java.util.HashSet;
import java.util.Iterator;
import java.util.*;

/**
 * Created by zhang on 2023/3/24.
 * 
 * The approach is, for each guess, take a word from the word list and use it to guess. 
 * If we get 6 matches, we are done. If not, we iterate the rest of the words in the word list 
 * and remove words that don't have a similar number of matches. For example, if the guess word is 
 * ccbazz and the secret word is acckzz, master.guess("ccbazz") will return 3, then I iterate the array
 *  to find words that compared to the guess word (ccbazz) have a match of 3, removing the rest.

To make the removal easy, we first convert the array to a hash set, and make use of an Iterator to 
remove while iterating (remember that there will be a concurrent exception if you try to remove an item 
from a collection while iterating on it). Why not a list? It could also work, but there is no use for the 
indexes. Besides, removal of a hash set is O(1), which may differ on a list depending on the implementation.

For choosing the guess word, it doesn't really matter, as there is no additional information that we can use 
to make a "smart" choice, so either a random pick or, in the case of this solution, the first word from the iterator.
 */
public class _843_GuesstheWord_Greedy {
    public interface Master{
        public int guess(String a);
    }
    public void findSecretWord(String[] wordlist, Master master) {
        Set<String> wordset = new HashSet<>(Arrays.asList(wordlist));
        int guesses = 0;
        while (!wordset.isEmpty() && guesses < 10) {
            Iterator<String> iterator = wordset.iterator();
            String guessWord = iterator.next();
            int matches = master.guess(guessWord);
            if (matches == 6) {
                return;
            }
            iterator.remove();
            while (iterator.hasNext()) {
                String word = iterator.next();
                if (!this.hasPartialMatch(guessWord, word, matches)) {
                    iterator.remove();
                }
            }
            guesses++;
        }
    }
    
    private boolean hasPartialMatch(String word1, String word2, int matches) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                count++;
            }
        }
        return count == matches;
    }
}
