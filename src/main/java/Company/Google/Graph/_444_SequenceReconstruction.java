package Company.Google.Graph;
import java.util.*;
/**
 * Created by zhang on 2018/6/1.
 * 规律
 * https://www.cnblogs.com/grandyang/p/6032498.html
 *
 * 拓扑
 * https://leetcode.com/problems/sequence-reconstruction/discuss/135166/JAVA-solution-guarantee-you-understand-it-immediately.
 */
public class _444_SequenceReconstruction {
    public static boolean sequenceReconstruction(int[] org, int[][] seqs) {
        int len = org.length;
        int[] map = new int[len + 1];//map number to its index
        Arrays.fill(map, -1);
        int[] memo = new int[org.length];//count how many numbers are smaller(on the right)
        for (int i = 0; i < len; i++) {
            map[org[i]] = i;
        }
        for (int[] seq : seqs) {
            if (seq.length == 0) continue;
            int prev = seq[0];
            if (prev <= 0 || prev > len || map[prev] == -1) return false;
            for (int i = 1; i < seq.length; i++) {
                int curr = seq[i];
                if (curr <= 0 || curr > len || map[curr] == -1) return false;
                memo[map[prev]] = Math.max(memo[map[prev]], len - map[curr] + 1);
                prev = curr;
            }
            memo[map[prev]] = Math.max(memo[map[prev]], 1);
        }
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] != len - i) return false;
        }
        return true;
    }
    public static void main(String[] args){
//        sequenceReconstruction(new int[]{4,1,5,2,6,3},new int[][]{{5,2,6,3},{4,1,5,2}});
        List<List<Integer>> seqs = new ArrayList<>();
        List<Integer> seq1= new ArrayList<Integer>();
        seq1.add(5);seq1.add(2);seq1.add(6);seq1.add(3);
        List<Integer> seq2= new ArrayList<Integer>();
        seq2.add(4);seq2.add(1);seq2.add(5);seq2.add(2);
        seqs.add(seq1);seqs.add(seq2);
        sequenceReconstruction_TP(new int[]{4,1,5,2,6,3},seqs);
    }

    public static boolean sequenceReconstruction_TP(int[] org, List<List<Integer>> seqs) {
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        HashMap<Integer, Integer> indegree = new HashMap<Integer, Integer>();
        for(int i = 0;i < seqs.size();++i) {
            List<Integer> seq = seqs.get(i);
            if(seq.size() == 1) {
                int from = seq.get(0);
                if(!graph.containsKey(from)) {
                    graph.put(from, new ArrayList<Integer>());
                    indegree.put(from, 0);
                }
            } else {
                for(int j = 0;j < seq.size() - 1;++j) {
                    int from = seq.get(j);
                    int to = seq.get(j + 1);
                    if(!graph.containsKey(from)) {
                        graph.put(from, new ArrayList<Integer>());
                        indegree.put(from, 0);
                    }
                    if(!graph.containsKey(to)) {
                        graph.put(to, new ArrayList<Integer>());
                        indegree.put(to, 0);
                    }
                    if(!graph.get(from).contains(to)) {
                        graph.get(from).add(to);
                        indegree.put(to, indegree.get(to) + 1);
                    }
                }
            }
        }
        if(graph.size() != org.length) return false; // Strictly checking
        Queue<Integer> queue = new LinkedList<Integer>();
        for(HashMap.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if(entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        int index = 0;
        while(!queue.isEmpty()) {
            if(queue.size() != 1) return false; // Strictly checking
            int from = queue.poll();
            if(from != org[index++]) return false; // Strictly checking
            List<Integer> list = graph.get(from);
            for(int i = 0;i < list.size();++i) {
                int to = list.get(i);
                indegree.put(to, indegree.get(to) - 1);
                if(indegree.get(to) == 0) {
                    queue.offer(to);
                }
            }
        }
        return index == org.length; // Strictly checking
    }

}
