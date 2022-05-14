package DataStructure.Array;

public class _473_MatchstickstoSquare_DFS{
	 public boolean makesquare(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int total = 0;
        for(int num : nums){
            total += num;
        }
        if(total % 4 != 0){
          return false;  
        } else{
           return dfs(nums,new int[4],0, total/4);
        }        
    }
    private boolean dfs(int nums[], int sums[], int index, int average){
        //edge case
        if(nums.length<=3 || index>nums.length) return false;
        //满足条件 搜索到了最后位置 并且sums的4个数字 每个数字都等于average
        if(index==nums.length ){
            if(sums[0]==average && sums[1]==average && sums[2]==average&& sums[3]==average)
               return true;
            else
               return false;
        }
        
               //搜索
            for(int i=0;i<4;i++){
                if(nums[index]+sums[i]<=average){
                    if( i>0 && sums[i]==sums[i-1] ) continue; //边相同则跳过
                    //加上此根火柴
                    sums[i]+=nums[index];
                    //继续往下搜索 
                    if(dfs(nums,sums,index+1,average)) return true;
                    //还原
                    sums[i]-=nums[index];
                }
             }
        return false;
    }
}