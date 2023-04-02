package google.Integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zhang on 2018/7/30.
 * 先问了点Java基础知识
 Magic Square: given an integer n, build a magic square with size n x n, filled numbers from 1 to n * n, each number can only be used once. And the sum of each row, each column diagonal and anti-diagonal line are same.
 e.g., n is 3. Each row, column, and both diagonals all have the same sum 15.
 4 3 8
 9 5 1
 2 7 6


 Follow up1: Optimization.

 Follow up2: build all possible magic squares for a certain integer n.

 http://www.1point3acres.com/bbs/thread-435726-1-1.html

 https://www.geeksforgeeks.org/magic-square/
 Magic Square of size 5
 ----------------------
 9   3  22  16  15
 2  21  20  14   8
 25  19  13   7   1
 18  12   6   5  24
 11  10   4  23  17
 Sum in each row & each column = 5*(5^2+1)/2 = 65


 Magic Square of size 7
 ----------------------
 20  12   4  45  37  29  28
 11   3  44  36  35  27  19
 2  43  42  34  26  18  10
 49  41  33  25  17   9   1
 40  32  24  16   8   7  48
 31  23  15  14   6  47  39
 22  21  13   5  46  38  30
 Sum in each row & each column = 7*(7^2+1)/2 = 175
 */
public class MagicSquare_Backtracking {
    public static void main(String[] args){
        solution(3);
    }
    //跟据 特点
    public static int[][] generate(int n){
        int[][] magic = new int[n][n];
        int i = n/2;
        int j = n-1;
        for (int num = 1; num <= n*n; num++){
            if (i == -1 && j == n){
                j = n-2;
                i = 0;
            }else{
                if (j == n)
                    j = 0;
                if (i < 0)
                    i = n-1;
            }
            if (magic[i][j] != 0){
                j -= 2;
                i++;
                continue;
            }else {
                magic[i][j] = num++;
            }
            j++; i--;
        }
        return magic;
    }
    static List<int[][]> res = new ArrayList<>();
    static int sum = 0;
    public static List<int[][]> findAll(int n){
        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        int anti = 0, deanti = 0;
        for (int i = 1; i<= n*n;i++)
            sum +=i;
        sum /= 3;
        backT(0,0,rowSum,colSum,anti,deanti,new HashSet<Integer>(),new int[n][n]);
        return res;
    }
    public static void backT(int i, int j, int[] rowSum,int[] colSum, int anti, int deanti,
                             HashSet<Integer> vis, int[][] magic){
        int n = rowSum.length;
        if (j > n){
            i++;
            j = 0;
        }
        if (vis.size() == n*n){
            res.add(magic); return;
        }
        for (int num = 1; num <= n*n; num++){
            if (!vis.contains(num)){
                rowSum[i] += num;
                colSum[j] += num;
                if (i == j) anti += num;
                if (i == n - j) deanti += num;
                if (rowSum[i] < sum && colSum[j] < sum && anti < sum && deanti > sum){
                    magic[i][j] = num;
                    backT(i,j++,rowSum,colSum,anti,deanti,vis,magic);
                }
                rowSum[i] -= num;
                colSum[j] -= num;
                if (i == j) anti -= num;
                if (i == n - j) deanti -= num;
            }
        }
    }

    public static int[][] solution(int n){
        int[][] res = new int[n][n];
        if (n == 0) return res;
        int sum = 0;
        for (int i = 1; i <= n*n; i++) sum += i;
        if(sum%3 != 0)  return res;
        sum /= 3;
        int[] row = new int[n];
        int[] col = new int[n];
        Arrays.fill(row,0);
        Arrays.fill(col,0);
        int anti = 0;
        int diaAnti = 0;
        backTracking(n,0,0,row,col,anti,diaAnti,sum,new HashSet<Integer>());
        return res;
    }
    public static boolean backTracking(int n, int x, int y,int[] row, int[] col, int anti, int diaAnti, int sum, HashSet<Integer> visited){
        if (visited.size() == n * n)  return true;
        for (int i = 1; i <= n*n; i++){
            if (!visited.contains(i)){
                int r = row[x];
                int c = col[y];
                row[x] += i;
                col[y] += i;
                if (x == y)
                    anti += i;
                if (x == (y-x)+1)
                    diaAnti += i;
                if ((r += i) > sum || (c += i) >sum || anti > sum || diaAnti > sum)
                    continue;
                visited.add(i);
                backTracking(n,x,y+1,row,col,anti,diaAnti,sum,visited);
                visited.remove(i);
                row[x] -= i;
                col[y] -= i;
                anti -= i;
                diaAnti -= i;
            }
        }
        return false;
    }
}
