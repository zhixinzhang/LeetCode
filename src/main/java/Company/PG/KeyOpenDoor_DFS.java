package Company.PG;
import java.util.*;
/**
 * Created by zhang on 2018/1/27.
 * 然后就在doc里面粘贴了题目，就是一个matrix，里面0表示水，1表示陆地，2表示起点，3表示终点。然后还有钥匙和门，小写字母代表钥匙，走到钥匙这里就可以捡起钥匙；大写字母代表门，只有对应字母的钥匙可以打开对应的门。比如有a 和 A，
 * 你要先走到a这里把这把钥匙捡起来，才能通过A这个门。 问题是写个算法返回最短的路径，能够从起点走到终点
 ***dfs
 * for loop the board to find start point
 * when we find start point we used dfs  define hashset to store the door(we can through) and boolean[][] visited to rem node
 *
 *
 * */
public class KeyOpenDoor_DFS {
    public static void main (String[] args) {
        char[][] board =
                        {{'0', '2', '1', '1', '1'},
                        {'0', '1', '0', '0', '1'},
                        {'0', '0', '0', '0', '1'},
                        {'0', '0', 'A', '0', '1'},
                        {'1', '1', 'a', '1', '1'},
                        {'1', 'b', '0', '0', 'B'},
                        {'1', '1', '0', '0', '1'},
                        {'0', '1', '0', '0', '3'}};
        List<Node> res = find(board);
        System.out.println(parsePath(res));
    }
    public static List<Node> find(char[][] board) {
        List<Node> res = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '2') {
                    List<Node> path = new ArrayList<>();
                    dfs(board, visited, path, res, i, j, new HashSet<>());
                }
            }
        }
        return res;
    }
    public static void dfs(char[][] board, boolean[][] visited, List<Node> path, List<Node> res, int x, int y,
                           HashSet<Character> keys) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == '0' || visited[x][y]) return;
        char c = board[x][y];
        if (c == '3') {
            if (res.isEmpty() || path.size() < res.size()) {
                res.clear();
                path.add(new Node(x, y));
                res.addAll(path);
                path.remove(path.size() - 1);
            }
            return;
        }
        // if current is door and in hashset not exist door its mean we not found the key so we can not through the door
        //we return
        if (c >= 'A' && c <= 'Z') {
            if (!keys.contains(c)) {
                return;
            }
        }
        //if current is key we put the door into hashset
        if (c >= 'a' &&  c <= 'z') {
            if (!keys.contains(Character.toUpperCase(c))) {
                keys.add(Character.toUpperCase(c));
                visited = new boolean[board.length][board[0].length];
            }
        }
        visited[x][y] = true;
        path.add(new Node(x, y));
        dfs(board, visited, path, res, x, y + 1, keys);
        dfs(board, visited, path, res, x + 1, y, keys);
        dfs(board, visited, path, res, x, y - 1, keys);
        dfs(board, visited, path, res, x - 1, y, keys);
        visited[x][y] = false;
        path.remove(path.size() - 1);
    }
    public static String parsePath(List<Node> res) {
        StringBuilder sb = new StringBuilder();
        for (Node node : res) {
            sb.append("(").append(node.x).append(",").append(node.y).append(")");
            sb.append("->");
        }
        return sb.toString();
    }
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    }
