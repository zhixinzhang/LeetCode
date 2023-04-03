package DataStructure.Array;
import java.util.*;

// https://leetcode.com/problems/largest-number/solutions/2766614/east-java-solution-with-comments/
public class _179_LargestNumber_sort {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];         
        for(int i=0; i<nums.length; i++)  
            s[i] = String.valueOf(nums[i]);
        Arrays.sort(s, (a,b) -> (b + a).compareTo(a + b));
        return s[0].equals("0") ? "0" : String.join("",s);
    }


    public String largestNumber_anotherSolution(int[] num) {
		if(num == null || num.length == 0)
		    return "";
		
		// Convert int array to String array, so we can sort later on
		String[] s_num = new String[num.length];
		for(int i = 0; i < num.length; i++)
		    s_num[i] = String.valueOf(num[i]);
			
		// Comparator to decide which string should come first in concatenation
		Comparator<String> comp = new Comparator<String>(){
		    @Override
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1); // reverse order here, so we can do append() later
		    }
	     };
		
		Arrays.sort(s_num, comp);
		// An extreme edge case by lc, say you have only a bunch of 0 in your int array
		if(s_num[0].charAt(0) == '0')
			return "0";
            
		StringBuilder sb = new StringBuilder();
		for(String s: s_num)
	        sb.append(s);
		
		return sb.toString();
		
	}
}
