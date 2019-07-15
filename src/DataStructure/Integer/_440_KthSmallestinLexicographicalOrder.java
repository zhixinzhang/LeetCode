package DataStructure.Integer;

/**
 * Created by zhang on 2018/5/4.
 * https://blog.csdn.net/sinat_17451213/article/details/53738327
 */
public class _440_KthSmallestinLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        int ans=1;
        for(k--;k>0;){
            int count=0;
            for(long first=ans,second=first+1;first<=n;first*=10,second*=10){
                count+=Math.min(n+1,second)-first;
            }
            if(count<=k){
                k-=count;
                ans++;
            }else{
                k--;//减掉的是当前为前缀的那个数
                ans*=10;
            }
        }
        return ans;
    }
}
