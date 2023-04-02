package Company.Google;
import java.util.*;
/**
 * Created by zhang on 2018/5/30.
 */
public class _726_NumberofAtoms_Stack {
        public String countOfAtoms(String formula) {
            // H2O(Fe2(Mg2H2)3O2)3
            // basic idea from right to calculate
            Stack<Map<String,Integer>> stack= new Stack<>();
            Map<String,Integer> map= new HashMap<>();
            int i=0,n=formula.length();
            while (i < n){
                char c=formula.charAt(i);i++;
                if(c=='('){
                    stack.push(map);
                    map=new HashMap<>();
                }else if(c==')'){
                    int val=0;
                    while(i<n && Character.isDigit(formula.charAt(i)))
                        val=val*10+formula.charAt(i++)-'0';
                    if(val==0) val=1;
                    if(!stack.isEmpty()){
                        Map<String,Integer> temp= map;
                        map=stack.pop();
                        for(String key: temp.keySet())
                            map.put(key,map.getOrDefault(key,0)+temp.get(key)*val);
                    }
                }else{
                    int start=i-1;
                    while(i<n && Character.isLowerCase(formula.charAt(i))){
                        i++;
                    }
                    String s= formula.substring(start,i);
                    int val=0;
                    while(i<n && Character.isDigit(formula.charAt(i))) val=val*10+ formula.charAt(i++)-'0';
                    if(val==0) val=1;
                    map.put(s,map.getOrDefault(s,0)+val);
                }

            }
            StringBuilder sb= new StringBuilder();
            List<String> list= new ArrayList<>(map.keySet());
//            List<String> l = new DataStructure.ArrayList<>();
//            l.addAll(map.keySet());
            Collections.sort(list);
            for(String key: list){
                sb.append(key);
                if(map.get(key)>1) sb.append(map.get(key));
            }
            return sb.toString();
        }
    }
