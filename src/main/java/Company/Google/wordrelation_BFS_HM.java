package Company.Google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/24/19
 * Time: 11:06 PM
 * Description:
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=518813&page=1&authorid=312838
 * 一个三哥哥，好像说话有些不利落，根本听不大清他说啥，我还以为信号差呢
 * 还好他人比较nice， 有些重要的地方给打字打出来了
 *
 * 题目比较简单，一些corner case想到了就可以了
 * ABCDE
 * FGHIJ
 * KLMNO
 * PQRST
 * UVWXY
 * Z
 *
 * 26个字母的keyboard，input是string，输出string
 * 找到上下左右的关系
 * 比如CARS， A -> C go right twice ->RR, C->A, go left twice LL, A->R, go right then go down, RRDDD
 * 最后每到一个字母加个感叹号
 * cars最后就是RR!LL!RRDDD!R!
 *
 * 大概说一下思路，写完code，讲几个case， 然后run time
 *
 * 时间还有多余就给了第二个题目，isIsomorphic leetcode上的
 * 没让写，就讲一下思路，我说用mapping，他说不用mapping呢，一下没想起来晕，时间也差不多了，就再见了
 */


public class wordrelation_BFS_HM {
    public static void main(String[] args){
        findRelation(new String[]{"ABCDE","FGHIJ","KLMNO","PQRST","UVWXY"}, "CARS");
    }
    static int[] start = new int[]{0,0};
    static int[][] directs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    static String[] directS = new String[]{"R","L","D","U"};
    public static String findRelation(String[] strings, String s){
        if(strings == null || strings.length == 0 || strings[0].length() == 0 || s == null || s.length() == 0)
            return "";
        String ans = "";
        for (int i = 0; i < s.length(); i++){
            ans += bfsPath(strings, s, i) + "!";
        }
        return ans;
    }
    public static String bfsPath(String[] strings, String s, int i){
        char target = s.charAt(i);
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[strings.length][strings[0].length()];
        q.add(start);
        Deque<String> path = new ArrayDeque<>();
        path.add("");
        a : while (!q.isEmpty()){
            int size = q.size();
            for (int j = 0; j < size; j++){
                int[] curP = q.poll();
                String curPath = path.poll();
                int k = 0;
                for (int[] dir : directs){
                    int nextX = curP[0] + dir[0];
                    int nextY = curP[1] + dir[1];
                    if (nextX < 0 || nextX >= strings.length || nextY < 0 || nextY >= strings[0].length() || visited[nextX][nextY]){
                        k++;
                        continue;
                    }
                    q.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    path.add(curPath + directS[k]);
                    System.out.println(curPath + directS[k]);
                    k++;
                    if (strings[nextX].charAt(nextY) == target){
                        start = new int[]{nextX, nextY};
                        break a;
                    }
                }
            }
        }
        return path.pollLast();
    }
}
