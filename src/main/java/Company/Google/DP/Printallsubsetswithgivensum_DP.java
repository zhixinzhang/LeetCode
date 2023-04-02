package google.DP;

import java.util.ArrayList;

/**
 * Created by zhang on 2018/7/6.
 * https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/
 */
public class Printallsubsetswithgivensum_DP {
    static boolean[][] dp;
    public static void display(ArrayList<Integer> v){
        System.out.println(v);
    }
    //Driver Program to test above functions
    public static void main(String args[])
    {
        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;
        int sum = 10;
        printAllSubsets(arr, n, sum);
    }
    static void printAllSubsets(int arr[], int n, int sum){
        if (n == 0 || sum < 0)
            return;

        // Sum 0 can always be achieved with 0 elements
        dp = new boolean[n][sum + 1];
        for (int i = 0; i<n; i++){
            dp[i][0] = true;
        }
        if (arr[0] <= sum){
            dp[0][arr[0]] = true;
        }
        // Fill rest of the entries in dp[][]
        for (int i = 1; i < n; ++i)
            for (int j = 0; j < sum + 1; ++j)
                dp[i][j] = (arr[i] <= j) ? (dp[i-1][j] ||
                        dp[i-1][j-arr[i]])
                        : dp[i - 1][j];

        if (dp[n-1][sum] == false) {
            System.out.println("There are no subsets with" +
                    " sum "+ sum);
            return;
        }
        // Now recursively traverse dp[][] to find all
        // paths from dp[n-1][sum]
        ArrayList<Integer> p = new ArrayList<>();
        printSubsetsRec(arr, n-1, sum, p);
    }
    static void printSubsetsRec(int arr[], int i, int sum,
                                ArrayList<Integer> p){
        if (i == 0 && sum != 0 && dp[0][sum]){
            p.add(arr[i]);
            display(p);
            p.clear();
            return;
        }
        if(i == 0 && sum == 0){
            display(p);
            p.clear();
            return;
        }
        // If given sum can be achieved after ignoring
        // current element.
        if (dp[i-1][sum]) {
            // Create a new vector to store path
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(p);
            printSubsetsRec(arr, i-1, sum, b);
        }

        // If given sum can be achieved after considering
        // current element.
        if (sum >= arr[i] && dp[i-1][sum-arr[i]])
        {
            p.add(arr[i]);
            printSubsetsRec(arr, i-1, sum-arr[i], p);
        }

    }

}
