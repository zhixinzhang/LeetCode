package DataStructure.Integer;


public class _633_SumofSquareNumbers_TwoPointer{
    public boolean judgeSquareSum(int c) {
        if(c == 1) return true;  // 0 , 1
        int left = 0, right = (int)Math.sqrt(c);
        while(left <= right){
            int cur = left*left + right*right;
            if(cur < c){
                left++;
            }else if(cur > c){
                right--;
            }else{
                return true;
            }
        }
        return false;
    }
}