package DataStructure.Array;
import java.util.*;

public class _324_WiggleSort2_Sort_Dive {
       // the idea is to sort the input array and divide into two equal parts; 0 to mid & mid+ 1 to end
    // and then arrange the elements (using auxillary array) using reverse order for both parts (mid to 0 and end to mid + 1).
    // an example : Input array [1, 5, 1, 1, 6, 4] , after sorting it becomes [1,1,1,4,5,6]
    // the two parts of the array are [1,1,1] & [4,5,6]
    // now take last values of these two arrays i.e. index 2(o-based) from both ; which gives us 1 & 6 respectively
    // now [1,6,...] becomes the first two values in the final/input array
    // now again take previous chosen index - 1, which are index 1 from both ; which gives us 1 & 5 
    // now [1,6,1,5] becomes our array
    // now again take index - 1 , which is index 0 from both now; this gives us 1 & 4
    // now [1,6,1,5,1,4] becomes our answer
    public void wiggleSort(int[] nums) {
        
        //sort the array
        Arrays.sort(nums);
        
        // find mid point of array
        int mid = (nums.length - 1 ) / 2;
        int right = nums.length - 1;
        
        //aux array to temp store the values
        int[] result = new int[right + 1];
        int counter = 0;
        
        // select values from two parts of the array and arrange them in aux array
        while(mid >= 0 || right > (nums.length - 1 ) / 2 ){
            
            if(counter % 2 == 0){
                result[counter] = nums[mid];
                mid--;
            } else {
                result[counter] = nums[right];
                right--;
            }
            
            counter++;
        }
        
        //now store back these values in input/original array
        for(int i = 0; i < nums.length; i++){
            nums[i] = result[i];
        }
    }
}