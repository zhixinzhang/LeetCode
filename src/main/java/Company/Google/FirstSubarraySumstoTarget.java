package Company.Google;

public class FirstSubarraySumstoTarget{
			/**Given a non-empty array nums contains positive integers and a positive integer target.
Find the first subarray in nums that sums up to target and return the begin and end index of this subarray. If there is no such subarray, return [-1, -1].*/
		public static void main(String[] args){
			int[] a = findMinIndex(new int[]{4, 7, 5, 7, 8}, 12);
			int c = 0;
		}
		public static int[] findMinIndex(int[] arr, int target){

			int[] res = new int[2];
			int left = 0;
			int right = 0;
			int curSum = 0;
			//nums=[4, 7, 5, 7, 8] target = 12
			for (int i = 0 ; i < arr.length; i++) {
//				 curSum = curSum + arr[right];
				if (curSum == target) {
					res[0] = left;
					res[1] = right-1;
					return res;
				}else  if(curSum < target){
					right ++;
					curSum = curSum + arr[i];
				}else if(curSum > target){
					curSum = curSum - arr[left];
					left ++;
				}
			}
			return new int[]{-1,-1};
		}

}