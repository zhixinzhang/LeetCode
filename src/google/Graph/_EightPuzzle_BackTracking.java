package google.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhang on 2018/7/4.
 */
public class _EightPuzzle_BackTracking {
    static int count = 0;
    static List<List<String>> result = new ArrayList<>();
    public static void puzzle(){
        int level = 8;
        int m = 8, n = 8;
        boolean[] dia1 = new boolean[2 * n - 1];
        boolean[] dia2 = new boolean[2 * n - 1];
        boolean[] visited = new boolean[n];
        //2*n-1个斜对角线
        isPuzzle(level,0,visited,dia1,dia2, new ArrayList<String>());
        System.out.println("数目     " + count);
    }
    public static void isPuzzle(int n,int rowIndex,boolean[] visited,boolean[] dia1,boolean[] dia2, List<String> list){
        if (n == rowIndex){
            result.add(new ArrayList<String>(list));
            count++;
            return;
        }
        for (int i = 0; i < n; i++){
            //这一行、正对角线、反对角线都不能再放了，如果发现是true，停止本次循环
            if(visited[i] ||  dia1[rowIndex+i] || dia2[rowIndex-i+n-1])
                continue;

            //init一个长度为n的一维数组，里面初始化为'.'
            char[] charArray = new char[n];
            Arrays.fill(charArray,'.');
            charArray[i] = 'Q';
            String stringArray = new String(charArray);
            list.add(stringArray);

            visited[i] = true;
            dia1[rowIndex+i] = true;
            dia2[rowIndex-i+n-1] = true;
            isPuzzle(n,rowIndex+1,visited,dia1,dia2, list);

            //reset 不影响回溯的下个目标
            list.remove(list.size()-1);
            charArray[i] = '.';
            visited[i] = false;
            dia1[rowIndex+i] = false;
            dia2[rowIndex-i+n-1] = false;
        }
    }
    public static void main(String[] args){
        puzzle();
    }
}
