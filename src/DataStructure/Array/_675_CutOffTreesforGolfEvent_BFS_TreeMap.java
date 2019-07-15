package DataStructure.Array;
import java.util.*;

public class _675_CutOffTreesforGolfEvent_BFS_TreeMap{
	  int[][] direct = {{1,0},{-1,0},{0,1},{0,-1}};   // four direct
        int[][] dist;//保存当前出发点到所有点的最断距离  
    public int cutOffTree(List<List<Integer>> forest) {
        int result = 0;  
        int rows = forest.size();  
        int cols = forest.get(0).size();  
        int[][] matrix = new int[rows][cols]; 
        //TreeMap有自动键值排序的功能，用其存储<树高，与树所在矩阵的坐标>  
        TreeMap<Integer,int[]> map = new TreeMap<>();
        dist = new int[rows][cols];  
        for(int i=0;i<rows;i++)  
            for(int j=0;j<cols;j++){  
                matrix[i][j] = forest.get(i).get(j);  
                map.put(matrix[i][j],new int[]{i,j});  
            } 
        
        
                //这里拿到的键值均是从小到大有序的  
        Set<Integer> keys = map.keySet();  
        //初始坐标  
        int[] start = {0,0};  
        for(int key : keys){  
            if(key > 0){  
                int[] end = map.get(key);   //拿到当前最小高度的树的坐标  
                minDist(start,matrix);  //求出出发点到其它所有点的最短距离  
                int d = dist[end[0]][end[1]];   //拿到出发点到当前最小树高的距离  
                if(d == Integer.MAX_VALUE)  //若无法到达则返回-1  
                    return -1;  
                result += d;    //进行累加  
                start = end;    //将当前最小高度的树作为下一轮的出发点  
            }  
        }  
        return result;  
        
    }

        //求出给定的点到其它点之间的最短距离。  
    void minDist(int[] start,int[][] matrix){  
        int rows = matrix.length;  
        int cols = matrix[0].length;  
          
        //初始化dist数组，默认为MAX  
        for(int i=0;i<rows;i++)  
            for(int j=0;j<cols;j++)  
                dist[i][j] = Integer.MAX_VALUE;  
          
        //队列中存放点集合  
        Queue<int[]> q = new LinkedList<int[]>();  
        q.add(start);   //出发点入队  
        dist[start[0]][start[1]] = 0;   //到自己的距离为0  
          
        while(!q.isEmpty()){  
            int[] p = q.poll();  
            //可选的四个方向  
            for(int[] dir : direct ){  
                int x = p[0];  
                int y = p[1];  
                int nx = x + dir[0];  
                int ny = y + dir[1];  
                int[] np = {nx,ny};  
                //可入队的点要满足：1.格式  2.不是障碍物  3.出发点到它的距离小于其本身在dist数组里的距离  
                if(nx<rows && nx>=0 && ny<cols && ny>=0 && matrix[nx][ny]!=0  
                        && dist[nx][ny]>dist[x][y]+1){  
                    q.add(np);  
                    dist[nx][ny] = dist[x][y] + 1;  
                }  
            }  
              
        }  
}
}