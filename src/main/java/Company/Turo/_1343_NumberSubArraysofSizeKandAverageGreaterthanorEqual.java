package Company.Turo;

/**
 * We need to create windows of size k and move ahead with that window size keeping in mind.
    Approach
    Create the window and calculate the sum.
    Check the window size.
    If window Size is achieved then calulate the average and match it with threshold.

    Complexity
    Time complexity: O(n)
    Space complexity: O(1)
 * 
*/
public class _1343_NumberSubArraysofSizeKandAverageGreaterthanorEqual {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int currSum = 0; // For storing the sum value of window size
        int countK = 0; // To check if the size is achieved then start adding the values
        int countRes = 0; // To store the result count
        int len = arr.length;
        int avg;
        for(int i=0 ; i<len ; i++){
            currSum += arr[i];
            countK++;
            if(countK >= k){
                avg = (currSum/k);
                if(avg >= threshold){
                    countRes++;
                }
                /**
                    This will subtract the first element in the window and 
                    in the next iteration, the new window will be added.
                    For e.g:
                    arr=[1,2,3,4,5] and k = 3
                    i=2
                    currSum = (1+2+3) = 6
                    currSum = currSum - arr[(i+1)-k];
                    window is (1,2,3) - Subtract 1 from the window
                    then shift the window.
                    currSum = 6 - arr[0]; 
                **/
                currSum = currSum - arr[(i+1)-k]; 
            }
        }
        return countRes;
    }
}
