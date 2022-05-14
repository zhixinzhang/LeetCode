package Company.Amazon.String;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/10/19
 * Time: 3:25 PM
 * Description:
 */


public class _942_DIStringMatch {
    public int[] diStringMatch(String S) {
        int n = S.length(), left = 0, right = n;
        int[] res = new int[n + 1];
        for (int i = 0; i < n; ++i)
            res[i] = S.charAt(i) == 'I' ? left++ : right--;
        res[n] = left;
        return res;
    }
}
