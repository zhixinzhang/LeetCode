package Company.Square.OOP.MazeGrid;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectFourModified {
    class Node {
        char color;
        int count;
    
        int[] loc;
    
        Node (char color, int count, int[] loc) {
            this.color = color;
            this.count = count;
            this.loc = loc;
        }
    }

    int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

    public void playConnect4() {
        char[][] grid = new char[3][6];
        for (int i=0; i<3; i++) {
            for (int j=0; j<6; j++) {
                grid[i][j] = '-';
            }
        }

        grid[0][0] = 'Y';
        grid[1][0] = 'Y';
        grid[1][1] = 'Y';
        grid[0][1] = 'R';
        grid[0][2] = 'R';
        grid[1][2] = 'R';
        grid[2][0] = 'R';
        grid[2][1] = 'R';
        grid[2][2] = 'R';

        BFS(grid, 5, new Node('R', 1, new int[]{2,0}));
        BFS(grid, 3, new Node('Y', 1, new int[]{0,0}));
    }

    private void BFS(char[][] grid, int toWin, Node start) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<Node> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int count = curr.count;
            char color = curr.color;
            int[] loc = curr.loc;

            if (count == toWin) {
                System.out.println("The winner is: " + color);
                return;
            }

            int i = loc[0];
            int j = loc[1];
            visited[i][j] = true;

            for (int[] dir: dirs) {
                int x = i + dir[0];
                int y = j + dir[1];

                if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || grid[x][y]!=color || grid[x][y]=='-') {
                    continue;
                }

                q.add(new Node(grid[x][y], count+1, new int[]{x,y}));
            }
        }

        System.out.println("No winner");
    }

    public static void main(String[] args) {
        new ConnectFourModified().playConnect4();
    }
}
