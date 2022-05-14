package Company.PG;

/**
 * Created by zhang on 2018/1/28.
 */
public class _FindRepeatingELement {
    // O(n) space (1)
    // used the arr[] value
    //Traverse through the array and check the sign of array[abs(array[i])], if positive make it as negative and if it is negative then print it, as follows:
    static void printRepeating(int arr[], int size)
    {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++)
        {
            if (arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
            int c = 0;
        }
    }

    // Driver program
    public static void main(String[] args) {
//        FindDuplicate duplicate = new FindDuplicate();
        int arr[] = {4, 2, 4, 5, 2, 3, 1};
        int arr_size = arr.length;

        printRepeating(arr, arr_size);
    }

    // arrays.sort()   nlogn  O(1)
    // hashset O(n) O(n)
}
