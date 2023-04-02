package google;

//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=306857&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
//2 pointer
// time complexity  O(n) and in place;
public  class LeftPosRightNega{

	public int[] sort(int[] arr){
		if (arr == null || arr.length == 0) {
			return arr;
		}
		int right = arr.length-1;
		for(int i = 0;i<arr.length;i++){
			// make sure right == negative
			while(arr[right]>0){
				right--;
			}
			if (i<right) {
				if (arr[i] < 0) {
					int tmp = arr[right];
					arr[right] = arr[i];
					arr[i] = tmp;
				}else{
					i++;
				}	
			}
			
		}
		return arr;
	}

}