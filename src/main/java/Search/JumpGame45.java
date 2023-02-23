package Search;

/*
https://leetcode.com/problems/jump-game-ii/solutions/1677863/java-solution-4-approaches-from-recursive-to-top-down-to-botton-up-and-finally-greedy/?languageTags=java&topicTags=dynamic-programming
 * Greedy Approach ->
we can make use of greedy idea + sliding window concept also and can reduce the complexity from o(n^2) to o(n)
for that keep maintaing left and right pointers to hold the window size on which we can go from each step.
jump will store total jump needed to reach from first window till last window.
initially set l=r=jump=0
now loop till right< n-1
check for item starting from left till right what is max value i.e.
max=Math.max(max,i+nums[i]);
once inner loop finsihes we have max hops that we can go. now, increment jump, and left and right boundary also.
once outer loop finishes jump has the desired answer.
 * 
*/
public class JumpGame45 {


    public int greedy(int[] nums) {
		int jump = 0;
		int left = 0;
		int right = 0;
		//till we reach end of the array
		while (right < nums.length - 1) {
			int max = 0;
			//find max reach (in range of indexes left and right)
			for (int i = left; i <= right; i++) {
				max = Math.max(nums[i] + i, max);
			}
			//update new boundaries
			left = right + 1;
			right = max;
			jump++;
		}
		return jump;
	}
}

