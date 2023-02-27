package DataStructure.Integer;
import java.util.*;
/**
 * Let N be the number of digits for a valid combination, and K be the difference between digits.
 * Time Complexity: O(2^N), Space Complexity: O(2^N), 
 * In the worst case, the total number of nodes in a binary tree of depth N−1N-1N−1 is 2N2^N2 
N
 . Hence, the overall time complexity of the algorithm is O(2^N)
 * */ 
public class _967_NumbersWithSameConsecutiveDifferences_DFS_BFS {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1)
            return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> results = new ArrayList<Integer>();
        for (int num = 1; num < 10; ++num)
            this.DFS(N - 1, num, K, results);

        // convert the ArrayList to int[]
        return results.stream().mapToInt(i->i).toArray();
    }

    protected void DFS(int N, int num, int K, List<Integer> results) {
        if (N == 0) {
            results.add(num);
            return;
        }
        List<Integer> nextDigits = new ArrayList<>();

        Integer tailDigit = num % 10;
        nextDigits.add(tailDigit + K);
        if (K != 0)
            nextDigits.add(tailDigit - K);
        for (Integer nextDigit : nextDigits) {
            if (0 <= nextDigit && nextDigit < 10) {
                Integer newNum = num * 10 + nextDigit;
                this.DFS(N - 1, newNum, K, results);
            }
        }
    }


    public int[] numsSameConsecDiff_BFS(int N, int K) {

        if (N == 1)
            return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> queue = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for(int level = 1; level < N; ++ level) {
            ArrayList<Integer> nextQueue = new ArrayList<>();
            // iterate through each number within the level
            for (Integer num : queue) {
                Integer tailDigit = num % 10;

                ArrayList<Integer> nextDigits = new ArrayList<>();
                nextDigits.add(tailDigit + K);
                if (K != 0)
                    nextDigits.add(tailDigit - K);
                for (Integer nextDigit : nextDigits) {
                    if (0 <= nextDigit && nextDigit < 10) {
                        Integer newNum = num * 10 + nextDigit;
                        nextQueue.add(newNum);
                    }
                }
            }
            // prepare for the next level
            queue = nextQueue;
        }

        return queue.stream().mapToInt(i->i).toArray();
    }
}
