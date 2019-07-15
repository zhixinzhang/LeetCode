package company.PG;

/**
 * Created by zhang on 2018/1/26.
 */
/**
 * 我们可以使用类似桶排序的思想，对所有的数进行计数。

 1. 从左扫描到右边，遇到一个数字，先找到对应的bucket.比如

 3 2 2 1 4

 第一个3对应的bucket是index = 2 (bucket从0开始计算）

 2. Bucket 如果有数字，则把这个数字移动到i的position(就是存放起来），然后把bucket记为-1(表示该位置是一个计数器，计1）。

 3. Bucket 存的是负数，表示这个bucket已经是计数器，直接减1. 并把color[i] 设置为0 （表示此处已经计算过）

 4. Bucket 存的是0，与3一样处理，将bucket设置为-1， 并把color[i] 设置为0 （表示此处已经计算过）

 5. 回到position i，再判断此处是否为0（只要不是为0，就一直重复2-4的步骤）。

 6.完成1-5的步骤后，从尾部到头部将数组置结果。（从尾至头是为了避免开头的计数器被覆盖）

 例子(按以上步骤运算)：

 3 2 2 1 4

 2 2 -1 1 4

 2 -1 -1 1 4

 0 -2 -1 1 4

 -1 -2 -1 0 4

 -1 -2 -1 -1 0
 * **/
public class SortKColor_bucket {
    // Solution 1:counting sort
    /**
     * Method I: O(k) space, O(n) time; two-pass algorithm, counting sort
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2TwoPass(int[] colors, int k) {
        int[] count = new int[k];
        for (int color : colors) {
            count[color-1]++;
        }
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (count[i]>0) {
                colors[index++] = i+1;
                count[i]--;
            }
        }
    }


    // Solution 2: inplace, O(n)
    public static void main(String[] args){
        int[] arr = new int[]{3,2,2,1,4,1,1,4,3,3,2,2,1};
        sortKColors_bucket(arr,4);
        sortKColors_2pointer(arr,4);
        System.out.println(arr);
    }
    public static void sortKColors_bucket(int[] colors, int k) {
        // write your code here
        if (colors == null) {
            return;
        }
        int len = colors.length;
        for (int i = 0; i < len; i++) {
            // Means need to deal with A[i]
            while (colors[i] > 0) {
                int num = colors[i];
                if (colors[num - 1] > 0) {
                    // 1. There is a number in the bucket,
                    // Store the number in the bucket in position i;
                    colors[i] = colors[num - 1];
                    colors[num - 1] = -1;
                } else if (colors[num - 1] <= 0) {
                    // 2. Bucket is using or the bucket is empty.
                    colors[num - 1]--;
                    // delete the A[i];
                    colors[i] = 0;
                }
            }
        }

        int index = len - 1;
        for (int i = k - 1; i >= 0; i--) {
            int cnt = -colors[i];
            // Empty number.
            if (cnt == 0) {
                continue;
            }
            while (cnt > 0) {
                colors[index--] = i + 1;
                cnt--;
            }
        }
    }

    // Solution 3 inplace O(n)
    /**
     * Method II:
     *  Each time sort the array into three parts:
     *  [all min] [all unsorted others] [all max],
     *  then update min and max and sort the [all unsorted others]
     *  with the same method.
     *
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public static void sortKColors_2pointer(int[] colors, int k) {
        int pl = 0;
        int pr = colors.length - 1;
        int i = 0;
        int min = 1, max = k;
        while (min < max) {
            while (i <= pr) {
                if (colors[i] == min) {
                    swap(colors, pl, i);
                    i++;
                    pl++;
                } else if (colors[i] == max) {
                    swap(colors, pr, i);
                    pr--;
                } else {
                    i++;
                }
                // printArray(colors);
            }
            i = pl;
            min++;
            max--;
        }
    }

    private static void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}
