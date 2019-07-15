package company.PG;
import java.util.*;
/**
 * Created by zhang on 2018/1/29.
 */
public class _444_SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs.size() == 0 || org.length == 0) {
            return false;
        }
        int n = org.length;
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i ++) {
            pos[org[i]] = i;
        }
        boolean[] valid = new boolean[n + 1];
        int totalMatch = n - 1;
        boolean notEmpty = false;
        for (List<Integer> seq: seqs) {
            int size = seq.size();
            if (size > 0) notEmpty = true;
            for (int i = 0; i < size; i ++) {
                if (seq.get(i) < 1 || seq.get(i) > n) return false;
                if (i == 0) continue;
                int x = seq.get(i - 1), y = seq.get(i);
                if (pos[x] >= pos[y]) return false;
                if (valid[x] == false && pos[x] + 1 == pos[y]) {
                    valid[x] = true;
                    totalMatch --;
                }
            }
        }
        return totalMatch == 0 && notEmpty;
    }
}
