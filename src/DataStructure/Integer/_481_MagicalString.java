package DataStructure.Integer;

public class _481_MagicalString{
	    public int magicalString(int n) {
         if(n == 0)  return 0;
        if(n <= 3)  return 1;
        
        int[] nums = new int[n];
        nums[0] = 1; nums[1] = nums[2] = 2;
        
        int i = 2, j = 3;
        int count = 1;
        while(j < n) {
            // current number: 1->2, 2->1
            int cur = 3 ^ nums[j-1];
            for(int k = 0; k < nums[i] && j < n; k++) {
                nums[j] = cur;
                // count 1
                if(nums[j] == 1) count++;
                j++;
            }
            i++;
        }
        
        return count;
    
    }
}