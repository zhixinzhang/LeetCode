package Company.Ebay;

public class _80_RemoveDuplicatesfromSortedArray2 {
    public int removeDuplicates(int[] nums) {
 
        int index = 1;  // Index of the next unique element to add to the array
        int count = 1;  // Count of the current element
    
        // Loop through the array starting from the second element
        for(int i = 1; i < nums.length; i++){
        
            // If the current element is the same as the previous element, increment the count
            if(nums[i] == nums[i-1]){
                count++;
            } 
            // If the current element is different from the previous element, reset the count
            else {
                count = 1;
            }
        
            // If the count is less than or equal to 2, add the current element to the array
            if(count <= 2){
                nums[index] = nums[i];
                index++;
            }
        }
        // Return the index, which represents the number of unique elements in the array after removing duplicates
         return index;
    } 
}
