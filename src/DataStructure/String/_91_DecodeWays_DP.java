package DataStructure.String;
import java.util.*;

//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//dp[n] = dp[n-1]+1 
public class _91_DecodeWays_DP{
	public int numDecodings(String s) {
      if(s.length()==0 || s.charAt(0)== '0') return 0;
        int path[]=new int[s.length()];
        for(int i=0;i<s.length();i++)
            path[i] = s.charAt(i)-'0';
        int dp[]=new int[s.length()+1];
        dp[1]=1;
        dp[0]=1;
        for(int i=2;i<=path.length;i++){
            if(path[i-1]==0){
                if(path[i-2]*10+path[i-1]<10 || path[i-2]*10+path[i-1]>26 ) return 0;
                dp[i]=dp[i-2];
                continue;
            }
            dp[i]=dp[i-1];
            if(path[i-2]>0 && path[i-2]*10+path[i-1]<27 && path[i-2]*10+path[i-1]>9 )
                dp[i]+=dp[i-2];
        }
        return dp[path.length];
    }

}