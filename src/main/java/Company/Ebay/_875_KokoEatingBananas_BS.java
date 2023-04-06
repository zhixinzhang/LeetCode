package Company.Ebay;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/7/19
 * Time: 2:18 PM
 * Description:
 * Initialize the two boundaries of the binary search as left=1left = 1left=1,
 *  right=max(piles)right = max(piles)right=max(piles).
Get the middle value from leftleftleft and rightrightright, that is, 
middle=(left+right)/2middle = (left + right) / 2middle=(left+right)/2, this is Koko's eating speed during this iteration.
Iterate over the piles and check if Koko can eat all the piles within hhh hours 
given this eating speed of middlemiddlemiddle.
If Koko can finish all the piles within hhh hours, set rightrightright equal to 
middlemiddlemiddle signifying that all speeds greater than middlemiddlemiddle are workable 
but less desirable by Koko. Otherwise, set leftleftleft equal to 
middle+1middle + 1middle+1 signifying that all speeds less than or equal to middlemiddlemiddle are not workable.
Repeat the steps 2, 3, and 4 until the two boundaries overlap, i.e., 
left=rightleft = rightleft=right, which means that we have found the minimum speed by which Koko could finish eating all the piles within hhh hours. We can return either leftleftleft or rightrightright as the answer. 
 */


public class _875_KokoEatingBananas_BS {
    public int minEatingSpeed(int[] piles, int h) {
     // Initalize the left and right boundaries 
     int left = 1, right = 1;
     for (int pile : piles) {
         right = Math.max(right, pile);
     }

     while (left < right) {
         // Get the middle index between left and right boundary indexes.
         // hourSpent stands for the total hour Koko spends.
         int middle = (left + right) / 2;
         int hourSpent = 0;

         // Iterate over the piles and calculate hourSpent.
         // We increase the hourSpent by ceil(pile / middle)
         for (int pile : piles) {
             hourSpent += Math.ceil((double) pile / middle);
         }

         // Check if middle is a workable speed, and cut the search space by half.
         if (hourSpent <= h) {
             right = middle;
         } else {
             left = middle + 1;
         }
     }

     // Once the left and right boundaries coincide, we find the target value,
     // that is, the minimum workable eating speed.
     return right;
    }
}
