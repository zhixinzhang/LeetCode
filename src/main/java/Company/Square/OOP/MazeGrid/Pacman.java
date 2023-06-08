package Company.Square.OOP.MazeGrid;

import java.util.Random;

// 2023-3-9 https://www.1point3acres.com/bbs/thread-975089-1-1.html
/***
 * 1: 初始化游戏
2: 打印棋盘
3: 移动转向
4: 碰边传送
5: 生成随机敌人
6: 检测碰到敌人
 * 
 * 
 * @param args
 */
public class Pacman {
    static class Pac{
        int[] loc;
        String dir;
        String status;
        int ate;
        
        public Pac(int[] start, String dir){
            this.loc = start;
            this.dir = "right";
            this.status = "live";
            this.ate = 0;
        }
    }

    static class Board {
        int row;
        int col;
        char[][] board;

        public Board(int row, int col, char c){
            this.row = row;
            this.col = col;
            this.board = new char[row][col];
            for (int i = 0; i < row; i++){
                for (int j = 0; j < col; j++){
                    board[i][j] = c;
                }
            }
        }

        public void printBoard(Pac pac){
            for (int i = 0; i < row; i++){
                for (int j = 0; j < col; j++){
                    if (i == pac.loc[0] && j == pac.loc[1]) {
                        System.out.print("p" + " ");
                    } else {
                        System.out.print(board[i][j] + " ");
                    }
                   
                }
                System.out.println();
            }

            System.out.println("-----------split----------------");
        }

        public void printBoard(Pac pac, int[] enemy){
            for (int i = 0; i < row; i++){
                for (int j = 0; j < col; j++){
                    if (i == pac.loc[0] && j == pac.loc[1]) {
                        System.out.print("p" + " ");
                    } else if (enemy[0] == i && enemy[1] == j){
                        System.out.print("e" + " ");
                    }else {
                        System.out.print(board[i][j] + " ");
                    }
                   
                }
                System.out.println();
            }

            System.out.println("-----------split----------------");
        }

    }

    public static void main(String[] args) {

        Board board = new Board(5, 5, '*');
        Pac pac = new Pac(new int[]{0, 0}, "right");
        board.printBoard(pac);
        movePacCanPassBoundary(pac, board, "up", 5);
        movePacCanPassBoundary(pac, board, "down", 11);
        movePacCanPassBoundary(pac, board, "right", 10);
        movePacCanPassBoundary(pac, board, "left", 10);
        movePac(pac, board, "right", 3);   
        movePac(pac, board, "right", 1);
        movePac(pac, board, "right", 1);

        generateEnemy(pac, board);
    }

    private static void movePac(Pac pac, Board board, String dir, int move){
        if (dir != pac.dir) {
            pac.dir = dir;
        }
        int nextY = pac.loc[1];
        int nextX = pac.loc[0];
        if (dir == "right"){
            nextY += move;
        } else if (dir == "left") {
            nextY -= move;
        } else if (dir == "up") {
            nextX -= move;
        } else if (dir == "down"){
            nextX += move;
        } else {
            System.out.println("wrong dires");
        }

        if (nextX >= 0 && nextY >= 0 && nextX < board.row && nextY < board.col) {
            pac.loc = new int[]{nextX, nextY};
            board.printBoard(pac);
        } else {
            System.out.println("out of board");
        }
    }

    private static void movePacCanPassBoundary(Pac pac, Board board, String dir, int move){
        if (dir != pac.dir) {
            pac.dir = dir;
        }
        int nextY = pac.loc[1];
        int nextX = pac.loc[0];
        if (dir == "right"){
            nextY += move;
            if (nextY >= board.col) {
                int dis = nextY % board.col;
                if (dis == 0) {
                    nextY = pac.loc[1];
                } else {
                    nextY = dis;
                }
            }
        
        } else if (dir == "left") {
            nextY -= move;
            if (nextY < 0) {
                int dis = nextY % board.col;
                if (dis == 0) {
                    nextY = pac.loc[1];
                } else {
                    nextY = board.col + dis;
                }
            }
        } else if (dir == "up") {
            nextX -= move;          // 0   / 3
            if (nextX < 0) {
                int dis = nextX % board.row;
                if (dis == 0) {
                    nextX = pac.loc[0];
                } else {
                    nextX = board.row + dis;
                }
            }
        } else if (dir == "down"){
            nextX += move;
            if (nextX >= board.row) {
                int dis = nextX % board.row;
                if (dis == 0) {
                    nextX = pac.loc[0];
                } else {
                    nextX = dis;
                }
            }
        } else {
            System.out.println("wrong dires");
        }

        pac.loc = new int[]{nextX, nextY};
        board.printBoard(pac);

    }

    private static void generateEnemy(Pac pac, Board board){
        Random ran = new Random();
        int eX = ran.nextInt(board.row);
        int eY = ran.nextInt(board.col);
        if (eX != pac.loc[0] && eY != pac.loc[1]){
            System.out.println("Generated an enemy  " + eX + " , " + eY);
        }

        board.printBoard(pac, new int[]{eX, eY});
    }
}
