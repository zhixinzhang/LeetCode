package google;

import java.util.*;

/**
 * Created by zhang on 2018/5/14.
 */
/**
 * In fact, this is a shortest path problem, which can be solved by BFS with record of level.

 We encapsulate Node class with pos and speed attritutes.Then the start node is (0, 1).
 To implement BFS, we need a set to check if we have visited the node before. So we add a method to serialize Node, serial(), which returns a string concatenating pos and speed values.
 For a node polled, it has two neighbour nodes. One is formed by 'A', the other one is formed by 'R'. neighbour.pos - target < target is a implicit restriction of the valid answer.
 *
 * */
public class _818_RaceCar_BFS {
    class Node {

        int pos;
        int speed;

        public Node(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }

        public String serial() {
            return pos + "," + speed;
        }

    }

    public int racecar(int target) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Node start = new Node(0, 1);
        queue.add(start);
        visited.add(start.serial());

        int level = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Node cur = queue.poll();
                if (cur.pos == target) {
                    return level;
                }
                Node neighbour1 = new Node(cur.pos + cur.speed, cur.speed * 2);
                if (!visited.contains(neighbour1.serial()) && Math.abs(neighbour1.pos - target) < target) {
                    visited.add(neighbour1.serial());
                    queue.add(neighbour1);
                }
                Node neighbour2 = new Node(cur.pos, cur.speed > 0 ? -1 : 1);
                if (!visited.contains(neighbour2.serial()) && Math.abs(neighbour2.pos - target) < target) {
                    visited.add(neighbour2.serial());
                    queue.add(neighbour2);
                }
            }
            level++;
        }
        return -1;
    }
    public static void main(String[] args){
//        racecar(330);
    }

    public int racecar_DP(int target) {
        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;

            int m = 1, j = 1;

            for (; j < i; j = (1 << ++m) - 1) {
                for (int q = 0, p = 0; p < j; p = (1 << ++q) - 1) {
                    dp[i] = Math.min(dp[i], m + 1 + q + 1 + dp[i - (j - p)]);
                }
            }

            dp[i] = Math.min(dp[i], m + (i == j ? 0 : 1 + dp[j - i]));
        }

        return dp[target];
    }
}
