package Company.zillow.Array;

/**
 * Created by zhang on 2018/8/21.
 */
public class _66_PlusOne_iter_recur {
    public static void main(String[] args){
        plus(new int[]{9,9,9});
    }
    public static int[] plus(int[] arr){
        int[] res = new int[arr.length+1];
        boolean flag = false;
        for (int i = arr.length-1; i>= 0; i--){
            if (arr[i] == 9){
                arr[i] = 0;
                flag = true;
            }else if (arr[i] != 9){
                if (flag)
                    arr[i]++;
                else
                    return arr;
            }
        }
        res[0] = 1;
        return res;
    }

    public static int[] plus_recur(int[] arr){
        return recur(arr,arr.length-1);
    }
    public static int[] recur(int[] arr, int idx){
        if (arr[idx] == 9){
            arr[idx] = 0;
            idx--;
        }else {
            arr[idx] ++;
            return arr;
        }
        if (idx < 0){
            int[] res = new int[arr.length+1];
            res[0] = 1;
            return res;
        }
        return recur(arr,idx);
    }
}
