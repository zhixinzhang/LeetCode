package google;



/**[2, 6, 1, 8, 9, 2, 7, 3, 10]， 那么[1, 8, 9, 2]就是最长山脉*/
/**http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=268861&extra=page%3D3%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311*/
public class LongestMountain{

	public int findMountain(int[] nums){
		if(nums.length == 0) return 0;
		int res= 0;
		for(int i = 0; i<nums.length;i++){
			//go up
			int curLen = 1;
			while(i<nums.length-1 && nums[i+1]>nums[i]){
			i++;
			curLen++;
		}
		if(curLen>1){
			int tmpLen = curLen;
			while(i<nums.length-1 && nums[i+1] < nums[i]){
			i++;
			curLen++;
		}
}
     // 后降了 保存结果 并且退后一位 因为后降里面的最后一位可能是下一个山脉的起点
//           if (tmpLen < curLen) {
//               res = Math.max(res, curLen);
//               i--;
//           }


		}
		return res;
		}
}
