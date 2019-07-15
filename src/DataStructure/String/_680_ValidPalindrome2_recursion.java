package DataStructure.String;
import java.util.*;

public class _680_ValidPalindrome2_recursion{

	public boolean validPalindrome(String s) {
	return valid(s, 0, s.length() - 1, 1);
	}

	public boolean valid(String s, int i, int j, int d){
	    while(i<j){
	         if (s.charAt(i) != s.charAt(j)) {
	            if(d == 0) return false;
	             return valid(s, i+1, j, d-1) ||  valid(s, i, j-1, d-1);
	         }
	        i++;
	        j--;
	    }
	    return true;
	    

	}
}