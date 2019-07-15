package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _734_SentenceSimilarity_MAP {
	public static void main(String[] args){
		String[] words= {"great","acting","skills"};
		String[] words2 = {"fine","drama","talent"};
		String[][] pairs = {{"great","fine"},{"drama","acting"},{"skills","talent"}};
		boolean a = areSentencesSimilar(words,words2,pairs);
		int c = 0;
	}

	public boolean areSentencesSimilar_Single(String[] words1, String[] words2, String[][] pairs) {
		if(words1 == null && words2 == null)    return true;
		if(words1.length != words2.length)  return false;
		HashMap<String, String> hm = new HashMap<>();
		for(int i = 0; i < words1.length; i++){
			hm.putIfAbsent(words1[i],words2[i]);
			hm.putIfAbsent(words2[i],words1[i]);
		}
		for(String[] pair : pairs){
			if(pair[0].equals(pair[1]))
				continue;
			if(!hm.containsKey(pair[0]) || !hm.containsKey(pair[1]))
				return false;
			if(!hm.get(pair[0]).equals(pair[1]))
				return false;

		}
		return true;
	}



	public static boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
		Map<String,Set<String>> map= new HashMap<>();
		int m= words1.length,n=words2.length;
		if(m!=n) return false;
		for(String[] pair : pairs){
			if(!map.containsKey(pair[0])) map.put(pair[0],new HashSet<>());
			if(!map.containsKey(pair[1])) map.put(pair[1],new HashSet<>());
			map.get(pair[0]).add(pair[1]);
			map.get(pair[1]).add(pair[0]);
		}

		for(int i=0;i<m;i++){
			if(words1[i].equals(words2[i])) continue;
			if(!map.containsKey(words1[i]) || !map.get(words1[i]).contains(words2[i])) return false;
		}
		return true;
	}
}