package google;


import java.util.LinkedHashMap;
import java.util.Map;

public class FindNoRepeatCharString{
	public static void main(String[] args){
			String c = find("google");
	}

	public static String find(String s){
		String ans = null;
		Map<Character, Integer> sMap = new LinkedHashMap<>();
		for(char c: s.toCharArray()){
			if(!sMap.containsKey(c)){
				sMap.put(c, 1);
			}else{
				sMap.put(c, sMap.get(c)+1);
			}
		}
		for(Map.Entry<Character, Integer> en: sMap.entrySet()){
			if(en.getValue()==1) return en.getKey().toString();
		}
		return ans;

	}

}