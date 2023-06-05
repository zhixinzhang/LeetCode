package Company.Square.OOP.MazeGrid;


import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * Dijkstra algorithm,
create a int[][] distance to store shortest distances from ball to every poisition in the maze.
create a String[][] prev to store the shortest path from ball to every position in the maze.
PriorityQueue queue used to sort by distances and always pop the next shortest distance position.

Using Dijkstra algorithm, during the iteration each time we pop out the next shortest position in the maze starting from ball.
Until the next shortest position is the hole, we stop our loop. Or if the queue pops all element, and we still dont see hole, means impossible to find a path from ball to hole.
 * 
 * 
*/
public class _499_TheMaze_FindShorestDirections_BFS {
    class Point{
        int x;
        int y;
        int dist; 
        
        Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] distance = new int[maze.length][maze[0].length];
        String[][] prev = new String[maze.length][maze[0].length];
        
        Point start = new Point(ball[0], ball[1], 0);
        prev[ball[0]][ball[1]] = "";
        
        for(int[] row: distance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[ball[0]][ball[1]] = 0;
        PriorityQueue<Point> queue = new PriorityQueue<>((x,y) -> (x.dist - y.dist));
        queue.add(start);
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        String[] sdirections = {"u", "d", "l","r"};
        String result = "";
        
        while(!queue.isEmpty()){
            Point shortest = queue.poll();
            
			// if next shortest position is hole, we stop the loop and return answer.
            if(shortest.x == hole[0] && shortest.y == hole[1]){
                break;
            }
			//we ignore this poped position  if previously there is a shorter path already saved in prev[][]
            if(shortest.dist > distance[shortest.x][shortest.y]) continue;
            for(int i = 0;i < 4; ++i){
                int x = shortest.x;
                int y = shortest.y;
                int count = 0;
				// keep walking until hits the wall or fall in the hole
                while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0 && (x != hole[0] || y != hole[1])){
                    x += directions[i][0];
                    y += directions[i][1];
                    count++;
                }
				// if it hits the wall, roll back the position
                if(x != hole[0] || y != hole[1]){
                    x -= directions[i][0];
                    y -= directions[i][1];
                    count--;   
                }
                
                if(distance[x][y] >= shortest.dist + count){
                    String newPath = prev[shortest.x][shortest.y] + sdirections[i];
					// if we have two path with same distance, we saved the path with samller lexicographic order
                    if(distance[x][y] == shortest.dist + count){
                        if(prev[x][y].compareTo(newPath) > 0) { prev[x][y] = newPath;}
                    } else {
					// if we find a shorter path, just save the shorter path, no need comparsion
                        distance[x][y] = shortest.dist + count;
                        prev[x][y] = newPath;
                        Point next = new Point(x,y,distance[x][y]); 
                        queue.add(next);
                    }
                }
            } 
        }
        return prev[hole[0]][hole[1]] == null ? "impossible" : prev[hole[0]][hole[1]];
    }
}
