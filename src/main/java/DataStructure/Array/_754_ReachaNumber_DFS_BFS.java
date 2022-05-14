package DataStructure.Array;
import java.util.*;


public class _754_ReachaNumber_DFS_BFS{
    public static void main(String[] args){
        _754_ReachaNumber_DFS_BFS(-6);
    }
	public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0;
        int n   = 0;
        while (sum < target){
            n ++;
            sum += n;
        }
        if (sum == target) return n;
        int res = sum - target;
        if ((res & 1) == 0) {
            return n;
        }
        else {
            return n + ((n & 1) == 0 ? 1 : 2);
        }
    }
	 public static int  _754_ReachaNumber_DFS_BFS(int target) {
        if(target == 0) return 0;
        target = Math.abs(target);
        // target tree
        /**             0
                    -1      1
                -3     1  -1   3
             -6   0  -2 4-4 2 0  6
         -10    2
        */
        // bfs find min step
        
        int step = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()){
            int size = q.size();
            step++;
            for(int i = 0; i< size;i++){
                int curVal = q.poll();
                if(Math.abs(curVal - step) == target || Math.abs(curVal + step) == target )
                    return step;
                q.offer(curVal - step);
                q.offer(curVal + step);
            }
            
        }
        return -1;
    }
}