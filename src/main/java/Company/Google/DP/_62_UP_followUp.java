package google.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/7/30.
 * http://www.1point3acres.com/bbs/thread-435743-1-1.html
 * 4. 無限長寬的棋盤 給定座標x, y
 求從原點出發的西洋棋騎士到達goal的路徑
 */
public class _62_UP_followUp {
    public static void main(String[] args){
        solu_1D(3,3);
    }
    static class Path{
        List<String> path;
        public Path(List<String> path){
            this.path = path;
        }
    }
    public static List<String> solu_2D(int x, int y){
        if ( x == 0 || y == 0) return new ArrayList<>();
        Path[][] dp = new Path[x][y];
//        List<String> res =
        List<String> s = new ArrayList<>();
        s.add("0.0 ->");
        dp[0][0] = new Path(s);
        for (int i = 1; i < y; i++){
            List<String> curPath = new ArrayList<>();
            s = dp[0][i-1].path;
            String path = "0." + i + "->";
            String prePath = s.get(0) + path;
            curPath.add(prePath);
            dp[0][i] = new Path(curPath);
        }

        for (int i = 1; i < x; i++){
            for (int j = 0; j < y; j++){
                List<String> prePaths = new ArrayList<>();
                prePaths.addAll(dp[i-1][j].path);
                if (j>0)
                    prePaths.addAll(dp[i][j-1].path);
                List<String> nextPath = new ArrayList<>();
                for (String path : prePaths){
                    path += i + "." + j + " -> ";
                    nextPath.add(path);
                }
                dp[i][j] = new Path(nextPath);
            }
        }
        System.out.println(dp[x-1][y-1].path);
        return dp[x-1][y-1].path;
    }

    public static List<String> solu_1D(int x, int y){
        List<String> p = new ArrayList<>();
        p.add("0.0 ->");
        Path[] dp = new Path[y];
        dp[0] = new Path(p);
        for (int i = 1; i < y; i++){
            String s = dp[i-1].path.get(0);
            s += "0." + i + " -> ";
            List<String> path = new ArrayList<>();
            path.add(s);
            dp[i] = new Path(path);
        }
        for (int i = 1; i<x; i++){
//            Path[] pre = dp.clone();
            for (int j = 0; j<y;j++){
                List<String> curPath = new ArrayList<>();
                List<String> nextPath = new ArrayList<>();
                curPath.addAll(dp[j].path);
                if (j > 0)
                    curPath.addAll(dp[j-1].path);
                String curS = i + "." + j +" -> ";
                for (String s : curPath){
                    s += curS;
                    nextPath.add(s);
                }
                dp[i] = new Path(nextPath);
            }
//            System.out.println(dp[].path);
//            dp = pre;
        }
        System.out.println(dp[y-1].path);
        return dp[y-1].path;
    }
}
