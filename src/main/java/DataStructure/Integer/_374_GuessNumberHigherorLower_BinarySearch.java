package DataStructure.Integer;

/**
 * Created by zhang on 2018/5/1.
 */
public class _374_GuessNumberHigherorLower_BinarySearch {
        public int guessNumber(int n) {
            int i = 0, j = n;
            while (i < j){
                int mid = i + (j - 1) / 2;
                if (guessNumber(mid) == 0)
                    return mid;
                if (guessNumber(mid) == 1)
                    i = mid+1;
                if (guessNumber(mid) == -1)
                    j = mid - 1;
            }
            return i;
        }
    }
