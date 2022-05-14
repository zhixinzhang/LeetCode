package DataStructure.ArrayList;
import java.util.*;


public class _422_ValidWordSquare{
     public boolean validWordSquare(List<String> words) {  
          
         for(int i=0;i<words.size();i++){  
             String s = words.get(i);  
             if(!s.equals(getVertical(i,words))){  
                 return false;  
             }  
         }  
         return true;  
    }  
      
    private String getVertical(int col,List<String> words){  
        StringBuilder sb = new StringBuilder();  
        for(int i=0;i<words.size();i++){  
            String word = words.get(i);  
            if(col<word.length()){  
                sb.append(word.charAt(col));  
            }  
        }  
        return sb.toString();  
    }  
}