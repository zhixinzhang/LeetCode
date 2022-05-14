package DataStructure.String;
import java.util.*;

//https://www.cnblogs.com/grandyang/p/6915355.html
public class _564_FindtheClosestPalindrome{
        // 1234 --- 1221   15431  --- 15451  15351 find mid point  4 copy front string and reverse
		public String nearestPalindromic(String n) {
		long num = Long.valueOf(n);
		if (num == 0) return "1";
		if (num == 11) return "9";
		if (num <= 10 || Math.log10(num)%1==0) return num - 1 + "";
		
		long exp = n.length() - (n.length() - 1) / 2 - 1;
		long offset = (long) Math.pow(10, exp);
		
		return min(num, palindry(n), palindry(num + offset + ""), palindry(num - offset + ""));
	}

		//choose the closest number away from target
		private String min(long target, long s1, long s2, long s3) {
			long[] array = { s1, s2, s3 };
			long[] distance = new long[3];
			for (int i = 0; i < array.length; i++) {
				distance[i] = Math.abs(target - array[i]);
		                //exclude itself
				if (distance[i] == 0) distance[i] = Long.MAX_VALUE;
			}

			int minIndex = distance[0] > distance[1] ? 1 : 0;
			return array[distance[2] > distance[minIndex] ? minIndex : 2] + "";
		}

		//get a normal palindrome number
		private long palindry(String n) {
			char[] c = n.toCharArray();
			for (int i = 0; i < c.length / 2; i++) {
				c[c.length - i - 1] = c[i];
			}
			return new Long(new String(c));
		}
}