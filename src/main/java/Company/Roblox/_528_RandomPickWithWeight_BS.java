package Company.Roblox;

import java.util.Random;


// prefix sum + binay search

public class _528_RandomPickWithWeight_BS {
      
   private int[] nums;
   private int total;
   private Random rand;

   public  _528_RandomPickWithWeight_BS(int[] w) {
       this.rand = new Random();
       
       for (int i = 1; i < w.length; i++) {
           w[i] += w[i - 1];
       }
       
       this.nums = w;
       this.total = w[w.length - 1];
   }
   
   public int pickIndex() {
       // no numbers to pick!
       if (this.total == 0)
           return -1;
       
       int n = this.rand.nextInt(this.total) + 1; // the value pulled for {2, 5, 7} could be 0, 1, 2 all the way up to 7; we want a pulled value of 2 to actually coordinate with the second index (5), because three numbers do not fall into the range!
        
       //I actually used random.nextInt( wSums[len-1] + 1), and I know why it failed. For wsum[] = {2,7,10,14}, it generates a random value in range [0, 14], totally 15 numbers. If the random number is 0, 1, 2, our code will return index 0, so the probability for selecting the first one is 3/15.
       
       // this is the implementation of a left searching binary search
       int lo = 0, hi = this.nums.length - 1;
       while (lo < hi) {
           int mid = lo + (hi - lo) / 2;
           
           // pulled the exact value of an index
           if (this.nums[mid] == n)
               return mid;
           else if (this.nums[mid] < n)
               lo = mid + 1;
           else
               hi = mid; // find the leftmost value incase two of the indexes are the same and one is zero
       }
       return lo;
   }
}
