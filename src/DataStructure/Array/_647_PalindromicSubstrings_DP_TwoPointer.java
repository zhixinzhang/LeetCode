package DataStructure.Array;


//http://m.blog.csdn.net/ChiBaoNeLiuLiuNi/article/details/78015078
public class _647_PalindromicSubstrings_DP_TwoPointer{
	public int countSubstrings(String s) {
		if(s == null || s.length() == 0)return 0;
		int len = s.length();
        int res = 0;
		boolean dp[][] = new boolean[len][len];
		for(int i = len-1; i>=0;i--){
			for(int j = i; j<len;j++){
				if(s.charAt(i) == s.charAt(j) && (j-i <=2 || dp[i+1][j-1])){
					dp[i][j] = true;
					res++;
				}
			}
		}
        return res;   
	}

	    public int countSubstrings_twoPointer(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res += count(s, i, i);
            res += count(s, i, i + 1);
        }
        return res;
    }
    
    private int count(String s, int l, int r){
        int res = 0;
        while(l >= 0 && r < s.length() && s.charAt(l--) == s.charAt(r++)){
            res++;
        }
        return res;
    }
	
}