package Search;

import java.util.ArrayList;
import java.util.List;
/**
Find all possible combinations of k numbers that add up to a number n, given that only numbers
 from 1 to 9 can be used and each combination should be a unique set of numbers.
 Input: k = 3, n = 7
 OutPut [[1,2,4]]
 eg2:
Input: k = 3, n = 9
Output:
[[1,2,6], [1,3,5], [2,3,4]]
*/
//这是一个多阶段问题，目标是求所有解，显然用深搜+剪枝，即回溯法
public class CombinationSum216{
	
  public static List<List<Integer>> combinationSum3(int k, int n) {
  	List<List<Integer>>  result = new ArrayList<>();
  	List<Integer> path = new ArrayList<>();
  	dfs(k,n,path,result);
     return result; 
    }

   private static void  dfs (int step,int gap,List<Integer> path, List<List<Integer>>  result){
	   	if(step ==0){
			if (gap ==0){
				result.add(new ArrayList<>(path));
			}
			return;
		}
   		if (gap < 1) {
   			return;
   		}
	   int start = path.isEmpty()?1:path.get(path.size()-1);

		for(int i = start; i<10; ++i){
			if (!path.contains(i)){
				path.add(i);
				dfs(step-1,gap-i,path,result);
				path.remove(path.size()-1);
			}
        }
   }


	public  static void main (String[] args){
		int k = 3;
		int n = 7;
		combinationSum3(k,n);
	}
}