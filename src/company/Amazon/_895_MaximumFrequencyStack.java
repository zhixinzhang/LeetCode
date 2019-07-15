package company.Amazon;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/19/19
 * Time: 4:10 PM
 * Description:
 * https://leetcode.com/problems/maximum-frequency-stack/discuss/163410/C%2B%2BJavaPython-O(1)
 *
 * freq的问题不一定要用 pq 典型的stack分开 启发思路
 * 根据不同的 freq 分成不一样的 stack
 */


public class _895_MaximumFrequencyStack {
    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> group;
    int maxfreq;

    public _895_MaximumFrequencyStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxfreq = 0;
    }

    public void push(int x) {
        int fr = freq.getOrDefault(x, 0) + 1;
        freq.put(x,fr);
        maxfreq = Math.max(maxfreq, fr);
        group.computeIfAbsent(fr, a->new Stack<>()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0)
            maxfreq--;
        return x;
    }
}
