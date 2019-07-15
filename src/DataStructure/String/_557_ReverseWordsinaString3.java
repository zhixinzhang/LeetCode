package DataStructure.String;
import java.util.*;

public class _557_ReverseWordsinaString3{
	    public String reverseWords_reverse(String s) {
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) str[i] = new StringBuilder(str[i]).reverse().toString();
        StringBuilder result = new StringBuilder();
        for (String st : str) result.append(st + " ");
        return result.toString().trim();
    }
	public String reverseWords(String s) {
        if(s == null || s.length() <= 1) return s;
        StringBuilder sb  = new StringBuilder();
        String[] sArray = s.split(" ");
        for(int i = 0; i< sArray.length; i++){
        	//leetcode  left = 0  right = 7  07/16/25/34  
        	int left = 0, right = sArray[i].length()-1;
        	while(left < right){
        		Character temp = sArray[i].charAt(right);
//        		sArray[i].charAt(right) = sArray[i].charAt(left);
//        		sArray[i].charAt(left) = temp;
        		left++;
        		right--;
        	}
        	sb.append(sArray[i]+" ");
        }
       return sb.toString().trim();
    }
    /**
	public void reverse(char[] s, int l, int r)
{
	while(l < r)
	{
		char temp = s[l];
		s[l] = s[r];
		s[r] = temp;
		l++; r--;
	}
}
    */


}