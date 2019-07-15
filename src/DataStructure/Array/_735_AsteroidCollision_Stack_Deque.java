package DataStructure.Array;
import java.util.*;


public class _735_AsteroidCollision_Stack_Deque{
	 public int[] asteroidCollision(int[] asteroids) {
//	     Character c = '2';
//	     DataStructure.Integer.valueOf(c);
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<asteroids.length;i++){
            int ele = asteroids[i];
            if(deque.size()==0){
                deque.offer(ele);
            }else{
                int popEle = deque.peekLast();
                if((popEle<0&&ele<0) || (popEle>0&&ele>0) || (popEle<0&&ele>0)){
                    deque.offer(ele);
                }else if(Math.abs(popEle)>Math.abs(ele)){
                    continue;
                }else if(Math.abs(popEle)<Math.abs(ele)){
                     i--;
                    deque.pollLast();
                }else{
                    deque.pollLast();
                }
            }
        }
        
        int[] res = new int[deque.size()];
        int p = 0;
        
        while(deque.size()!=0){
            res[p++] = deque.pollFirst();
        }
        
        return res;
        
    }
}