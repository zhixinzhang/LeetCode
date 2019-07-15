package DataStructure.Integer;


/**
思路：果然不能直接DFS，会TLE
 * 就是要想办法凑出k个来
 * 注意到：1..n最多可以弄出n-1个不同的差，比如1..9就是
 * 1 9 2 8 3 7 4 6 5
 * diff: 8 7 6 5 4 3 2 1
 * 是大小交替的，这样的话，只要先凑出k-1个，后面按照顺序来产生1就好了
注意下标控制**/
public class _667_BeautifulArrangement2_Tricky{

	    public int[] constructArray(int n, int k) {
	      int[] res = new int[n];
		    int left = 1, right = k+1, idx = 0;
		    while(left<right){ res[idx++] = left++; res[idx++] = right--;}
		    if(left==right) res[idx++] = left;
		    for(int i = k+2; i<=n; ++i) res[idx++] = i;
		    return res;
	    }
}