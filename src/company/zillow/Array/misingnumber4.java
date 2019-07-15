package company.zillow.Array;

import java.util.Arrays;

/**
 * Created by zhang on 2018/8/20.
 */
public class misingnumber4 {

    // Driver code
    public static void main(String[] args) {
        int[] arr = {4,6,2,1};
//        missing4(arr);
        missing4(arr);
//        missing4_3(arr);
    }
    //t O(n) space O(1)
    public static void missing4(int[] arr){
        int[] helper = new int[2];
        for (int i = 0; i<arr.length; i++){
            int temp = Math.abs(arr[i]);
            if (temp <= arr.length)
                arr[temp-1] *= -1;
            else if (temp > arr.length){
                if (temp % arr.length != 0){
                    helper[temp % arr.length-1] = -1;
                }else {
                    helper[temp % arr.length + arr.length - 1] = -1;
                }
            }
        }
        // Print all those elements whose presence
        // is not marked.
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > 0)
                System.out.print(i + 1 + " ");
        for (int i = 0; i < helper.length; i++)
            if (helper[i] >= 0)
                System.out.print(arr.length + i + 1 + " ");

        return;
    }

    // t O(n) space O(n)
    public static void missing4_2(int[] arr){
        int[] helper = new int[arr.length+4];
        for (int i = 0; i<arr.length; i++){
            int cur = arr[i]-1;
            helper[cur] = 1;
        }
        int[] res = new int[4];
        int k = 0;
        for (int i = 0; i<helper.length;i++){
            if (helper[i] != 1){
                res[k] = i+1;
                k++;
            }
        }
        return;
    }
    public static void missing4_3(int[] arr){
        int[] res = new int[4];
        int k = 0;
        Arrays.sort(arr);
        for (int i = 1; i<arr.length; i++){
            if (arr[i-1] != i){
                res[k] = i;
                k++;
            }
        }
        int a = 0;
    }
}
