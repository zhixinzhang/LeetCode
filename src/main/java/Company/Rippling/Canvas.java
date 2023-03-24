package Company.Rippling;
import java.util.*;

/**
 * 
Part 1
create a MxN blank canvas

display the canvas to the user
 * 
*/

class Square {
    public final char c;
    public final int id;  // id is how many times we operate this canvas
    
    public Square(char c, int id) {
       this.c = c;
       this.id = id;
    }
}


public class Canvas {
    public static void main(String[] args){
        Canvas c = new Canvas(10, 25);
        c.draw('a', 4, 6, 0, 0);
        c.draw('b', 6, 4, 4, 21);
        c.draw('c', 5, 5, 2, 5);
        c.draw('d', 5, 5, 2, 5);
        c.display();
        System.out.println("=============================================================");
        c.move(2,5, 2,7);
        c.display();
    }


    private int id;
    private final int length;
    private final int width;
    private final Stack<Square>[][] board;
    
    public Canvas(int width, int length) {
        this.id = 0;
        this.length = length;
        this.width = width;
        this.board = new Stack[width][length];
        this.draw('0', width, length, 0, 0);
    }
    
    public void display() {
        for(int i=0; i<width; i++) {
            for (int j=0; j<length; j++) {
                System.out.print(board[i][j].peek().c);
                if (j != length-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    public void draw(char c,int sizeX, int sizeY, int posX, int posY) {
        for (int i=0; i<sizeX; i++) {
            if (i+posX<0 || i+posX >= width) {
                break;
            }
            for (int j=0; j<sizeY; j++) {
                if (j+posY<0 || j+posY >= length) {
                    break;
                }
                int newI = posX + i;
                int newJ = posY + j;
                if (board[newI][newJ] == null) {
                    board[newI][newJ] = new Stack<>();
                }
                board[newI][newJ].push(new Square(c, id));
            }
        }
    
        id++;
    }
    
    
    public void move(int fromX, int fromY, int toX, int toY) {
        int currId = board[fromX][fromY].peek().id;
        char c = board[fromX][fromY].peek().c;
        int sizeX = 0;
        int sizeY = 0;
    
        while(board[fromX+sizeX][fromY].peek().id == currId) {
            sizeX++;
        }
    
        while(board[fromX][fromY+sizeY].peek().id == currId) {
            sizeY++;
        }
    
        for (int i=fromX; i<fromX+sizeX; i++) {
            for (int j=fromY; j<fromY+sizeY; j++) {
                board[i][j].pop();
            }
        }
    
        this.draw(c, sizeX, sizeY, toX, toY);
    }
}
