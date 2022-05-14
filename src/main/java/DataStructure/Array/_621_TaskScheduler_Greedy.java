package DataStructure.Array;
import java.util.*;

//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
//https://www.youtube.com/watch?v=YCD_iYxyXoo
//给定一个char数组，代表CPU需要做的任务，包含A-Z，不用考虑顺序，每个任务能在1个单位完成。
//但是有规定一个非负整数n代表两个相同任务之间需要至少n个时间单位。球最少数量的时间单位完成所有任务。
public class _621_TaskScheduler_Greedy{
	    public int leastInterval(char[] tasks, int n) {
                int[] c = new int[26];  
        for(char t : tasks){  
            c[t - 'A']++;  
        }  
        Arrays.sort(c);  
        int i = 25;  
        while(i >= 0 && c[i] == c[25]) i--;  
  
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);  
    }

}