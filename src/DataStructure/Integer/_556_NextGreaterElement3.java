package DataStructure.Integer;
import java.util.*;
/**
如果从数字的第k位开始到数字尾部都是递减的并且第k位数字比第k-1位数字大，表明从第k位开始到尾部的这段数字是他们能组合出的最大数字，
在下一个数字中他们要整体倒序变为能组合出的最小数字，倒序后从这段数字序列中找出第一个大于第k-1位数字的位置和第k-1位交换即可。
举个栗子，如果n=13452，其中52是递减的，而且5>4，这样我们先把52倒序，n就变为13425，然后从25中找出第一个大于4的数字和4交换，
就得到了最终结果13524。需要注意的是下一个数字可能会超出INT_MAX范围
*/
public class _556_NextGreaterElement3{
		        // 123541  123145 -- 124135

        public int nextGreaterElement(int n) {
                char[] arr=(n+"").toCharArray();
                if(arr.length<=1)  return -1;
                int i=arr.length-2;
                //Find the rightmost element, which is not in a non-increasing sequence ending at arr[arr.length-1];
                //For example, for 679833,  7 is the rightmost element, which is not in the non-increasing sequence 9,8,3,3.
                while(i>=0&&arr[i]>=arr[i+1]){
                        i--;
                }
                if(i<0)   return -1;
                int j = arr.length - 1;
                //Find the smallest element larger than arr[i] in the non-increasing sequence.
                //Here, 8 is the smallest element larger than 7 in the sequence 9,8,3,3.
                while (arr[j] <= arr[i]) {
                        j--;
                }
                //Swap arr[i] with the element arr[j].
                //Here, swap 7 with 8.
                char tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
                //Sort this newly modified non-increasing sequence, which is equivalent to reversing the sequence.
                //Now, 9,7,3,3, becomes 3,3,7,9;
                Arrays.sort(arr,i+1,arr.length);

                //Use long to avoid overflow;
                //Here, res=683379
                // long res = Long.parseLong(new String(a));
                // long res = Long.valueOf(new String(a));
                long res = new Long(new String(arr));
                int c = Integer.valueOf(new String(arr));

                return res>Integer.MAX_VALUE?-1:(int)res;
        }
}