package Company.Twitter;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/13/2021 10:59 PM
 * <p>
 * Source Link:
 * <p> https://www.1point3acres.com/bbs/thread-611777-1-1.html
 * Description:
 * <p>
 * <p> 2. sort数组[1,90,7,2,200,80]。但是只需要按照类别。分类规则：[INT_MIN, 50)是small， [50,100)
 * 是middle, [100, INT_MAX)是large，最后只要求 small都在最前，large都在最后。
 * 上面的例子sort之后就是：[1,7,2,90,80,200] 给了一个O(n) in place解法
 * Time and Space Complexity:
 * <p>
 * <p>
 * [1,90, 70, 7, 2, 8, 66, 3, 90,80,200]   -> [1, 7, 2, 8, 3, 90, 66, 90, 70, 80, 200]
 * [1,90, 70, 7, 2, 8, 120, 66, 3, 90,80,200]   -> [1, 90, 70, 7, 2, 8, 3, 66, 90,80,200] -> [1, 7, 2, 8, 3, 120, 70, 66, 90,80,200]  -> [1, 7, 2, 8, 3, 70, 66, 90,80, 120, 200]
 *
 *  i 6  2  1
 *  s 6  2
 *  m 7  6
 *  l 0
 *
 *  [90, 60, 65, 7, 2, 8, 66, 3, 90,80,200]
 *
 *  *  i 0
 *  *  s 0
 *  *  m 0
 *  *  l 0
 */

public class _MoveNumber_FollowUp_280 {
    public static void main(String[] args){
        int[] arr = new int[]{1,90, 70, 7, 2, 8, 120, 66, 3, 90,80,200};

        helper(arr);
    }

    private static int[] helper(int[] arr){

        int small = -1;
        for (int i = arr.length - 1; i >= 0; i--){
            if (arr[i] >= 50 && small == -1) {
                continue;
            } else if (arr[i] < 50 && small == -1){
                small = i;
            } else if (arr[i] >= 50) {
                int curIndex = i;
                while (curIndex < small){
                    int temp = arr[curIndex];
                    arr[curIndex] = arr[curIndex+1] ;
                    arr[curIndex+1] = temp;
                    curIndex++;
                }
            }
        }

        //  * [1,90, 70, 7, 2, 8, 66, 3, 90,80,200]  -> [1, 7, 2, 8, 3, 120, 110, 70, 66, 90,80,200]  -> [1, 7, 2, 8, 3, 70, 120, 110, 105, 66, 90,80,200]
        // [1, 7, 2, 8, 3, 70, 66, 90,80, 120, 110, 200]
        int large = -1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 50 && large == -1) {
                continue;
            } else if (arr[i] >= 100 && large == -1){
                large = i;
            } else if (arr[i] < 100){
                int lIndex = large;
                while (lIndex < i){
                    int temp = arr[i];
                    arr[i] = arr[lIndex];
                    arr[lIndex] = temp;
                    lIndex++;
                }
                large ++;
            }
        }

        for (int i : arr){
            System.out.println(i + ", ");
        }
        return arr;
    }
}
