package google;
public class AddStringPalindrome{

    public static void main(String[] args ){
        System.out.println("result + ............ +" + min("cbca"));
    }
    //ex   cbca ----  acbca
//my solution: recursion
    public static int  min(String s){
        if(s == null ||s.length() == 0)
            return 0;
        int right = s.length()-1;
        return dfsPa(s, 0, s.length() - 1);

    }
    public static int dfsPa(String s,int left, int right){
        //break
        if (left >= right){
            return 0;
        }
        if (s.charAt(left) == s.charAt(right)){
            left ++;
            right --;
            int a = dfsPa(s,left,right);
            return a;
        }else {
            int a = Math.min(dfsPa(s,left+1,right)+1,dfsPa(s,left,right-1)+1);
            return a;
        }
    }

    public static int findMinDP(String s){
        //dp[i][j]  substing(i,j)  to min character to palindrome
        int[][] dp = new int[s.length()][s.length()];
        //dp初始化
        for (int i = 0; i<s.length();i++){
            dp[i][i] = 0;
            if (i < s.length()-1){
                dp[i][i+1] = s.charAt(i) == s.charAt(i+1)?0:1;
            }
        }
        return 0;
    }
}
