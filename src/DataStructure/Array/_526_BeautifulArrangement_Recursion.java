package DataStructure.Array;

/**
 * Created by zhang on 2017/12/25.
 */
/**
 * 乍一想有很多种可能不知道怎么统计，而这恰恰就可以通过递归回溯来实现。

 我们的思路是，从第一位到第N位，我们都要找到对应的没有放置过的数字来放，每一位都会有很多个数字可以放，而放了之后以后就不能放了，这样一直放到最后一位，如果都能放到数字，那就是一种漂亮的安排，总结果就要加一。

 这种思路就可以通过递归来实现。每一次递归我们都判断当前位置有哪些没放过的数字可以放，对于数字有没有放过我们需要一个数字来记录。对于每个放在这一位的数字，都是一种可能性，我们要继续往后递归看能不能全部放完才能知道要不要算作一种。如果所有都放完了那就算作一种了，总结过可以加一。

 要注意这里的位置并不是从0开始算的，而是1
 * */
//  两种回溯法
public class _526_BeautifulArrangement_Recursion {
    public int countArrangement(int N) {
        int[] num = new int[N];
        int res = findWay(num, 1);
        return res;
    }

    public int findWay(int[] num, int index) {
        if (index == num.length + 1) return 1;
        int total = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 1) {
                if ((i + 1) % index == 0 || index % (i + 1) == 0) {
                    int[] newNum = num.clone();
                    newNum[i] = 1;
                    total += findWay(newNum, index + 1);
                }
            }
        }
        return total;
    }


    int count = 0;

    public int countArrangement_2(int N) {
        if (N == 0) return 0;
        helper(N, 1, new int[N + 1]);
        return count;
    }

    private void helper(int N, int pos, int[] used) {
        if (pos > N) {
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1;
                helper(N, pos + 1, used);
                used[i] = 0;
            }
        }
    }
}
