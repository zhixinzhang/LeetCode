package DataStructure.String;
import java.util.*;

public class _676_ImplementMagicDictionary_Implement{
	  private List<String> dictionary;
    /** Initialize your data structure here. */
    public void MagicDictionary() {
        dictionary = new ArrayList();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String word: dict){
            dictionary.add(word);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(word == null) return false;
        for(String s : dictionary){
            if(s.length() != word.length()){
                continue;
            }else{
                int count = 0;
                for(int i = 0; i<s.length();i++){
                    if(s.charAt(i) != word.charAt(i)) count++;
                    if(count>1) break;
                }
                if(count == 1)
                    return true;
            }
        }
        return false;
    }
}