package DataStructure.String;
import java.util.*;

public class _686_RepeatedStringMatch{
	    public int repeatedStringMatch(String A, String B) {
	    	if(B.length() < A.length()){
	    		return 0;
	    	}
	    	StringBuilder s = new StringBuilder();
	    	s.append(A);
	    	int count = 1;
	    	while(s.indexOf(B)<0){
	    		if(s.length() - A.length() > B.length()){
	    			return -1;
	    		}
	    		s.append(A);
	    		count++;
	    	}
	    	return count;

	    }
}