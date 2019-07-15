package DataStructure.Integer;

//使用 buckets 来记录数字 0 ~ 9 的最后出现位置。

//从左到右遍历num的数字，对于每个位置，我们查找是否在之后的位置中存在一个比它更大的数（从 9 一直找到当前位置的数字大小）。我们也需要确保 这个更大的数字的位置 是 位于当前位置 之后的。如果找到了，我们就可以交换这两个数字的位置，返回结果。
public class _670_MaximumSwap_bucket{

	   public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int[] buckets = new int[10];
       for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;           // the last digit appear
        }
        //98368  [0,0,0,2,,,,]
        
        for(int i = 0; i<digits.length; i++){
            for(int k = 9; k>digits[i] - '0';k--){
                if(buckets[k] > i){
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}