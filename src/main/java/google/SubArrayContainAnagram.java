package google;

import java.util.HashMap;
/***
 * Given 2 words, return true if second word has a substring that is also an anagram of word 1.
 LGE , GOOGLE- True
 GEO, GOOGLE - False*/

public class SubArrayContainAnagram{
	public static void main(String[] sargs){
//		boolean a = checkAnagram("OGE","GOOGLE");
		boolean a = checkAnagram("LGE","GOOGLE");
		System.out.println(a);
	}

	// Min Window sub string 
	// LGE  ---  GOOGLE 
	public static boolean checkAnagram(String left, String right){
		if(left == null || left.length() == 0){
			return true;
		}
		if (left.length() > right.length()) {
			return false;
		}
		// Map
		HashMap<Character,Integer> hm = new HashMap<>();
		for (int i = 0; i<left.length();i++){
			if (hm.containsKey(left.charAt(i))){
				int val = hm.get(left.charAt(i));
				hm.put(left.charAt(i),val+1);
			}else{
				hm.put(left.charAt(i),1);
			}
		}
		HashMap<Character, Integer> hm2  = (HashMap)hm.clone();

		for(int i = 0; i<right.length();i++){
			char curRight = right.charAt(i);
			if (hm.containsKey(curRight)){
				int val = hm.get(curRight);
				if (val == 1){
					hm.remove(curRight);
				}else{
					hm.put(curRight,val-1);
				}
			}else{
				int lastSt = right.length() - i +1;
				if (lastSt < left.length()){
					return false;
				}else{
					hm = hm2;
				}
			}
		}

		return true;
	}

}


