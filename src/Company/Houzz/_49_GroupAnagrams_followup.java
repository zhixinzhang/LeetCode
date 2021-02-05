package Company.Houzz;
import java.util.*;

//要按顺序输出
public class _49_GroupAnagrams_followup{
	//O(n*m)
	 public static List<List<String>> groupAnagrams_encode(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length ==0) return res;
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String str : strs){
            char[] ch = new char[26];
            String s = "";
            for(int i = 0;i<str.length();i++){      //eat   
                ch[str.charAt(i) - 'a']++;
            }
            for(int i = 0; i<ch.length; i++){       //1a1e1t
                s += String.valueOf(ch[i]) + String.valueOf((char)(i+'a'));
            }
            if(!hm.containsKey(s)){
                List<String> l = new ArrayList<>();
                l.add(str);
                hm.put(s,l);
            }else{
                List<String> l = hm.get(s);
                l.add(str);
                hm.put(s,l);
            }
            
        }
        for(String s : hm.keySet()){
            res.add(hm.get(s));
        }
        return res;
        
    }



	//O(m*n*logn)
	public static List<List<String>> groupAnagrams_sort(String[] strs) {

	        List<List<String>> res = new ArrayList<>();
	        if(strs == null || strs.length ==0) return res;
	        HashMap<String, List<String>> hm = new HashMap<>();
	        List<String> sort = new ArrayList<>();
	        for(String str : strs){
	            char[] ch = str.toCharArray();              // eat   [e,a,t]
	            Arrays.sort(ch);        // aet
	            String key = new String(ch);
	            if(!hm.containsKey(key)){
                    sort.add(key);
	                List<String> l = new ArrayList<>();
	                l.add(str);
	                hm.put(key,l);
	            }else{
	                List<String> l = hm.get(key);
	                l.add(str);
	                hm.put(key,l);
	            }
	        }
//	        for(String s : hm.keySet()){
//	            res.add(hm.get(s));
//	        }
	        for(String sor : sort){
	            res.add(hm.get(sor));
            }
	        return res;
	        
    }

    public static void main(String[] args){
        groupAnagrams_sort(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}