package Company.Atlassian.CodeDesign;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

// _353_SnakeDesign
public class SnakeDesign {
    public static void main(String[] args){
        SnakeDesign snake = new SnakeDesign(5, 5, new int[][]{
            {1, 1},
            {1, 2},
            {3, 1},
            {3, 2}}
        );

        snake.generateSnake(new int[]{0, 0});

        snake.move("R");
        snake.move("D");
        snake.move("R");
        snake.move("D");
        snake.move("D");
        snake.move("L");
        snake.move("D");

        snake.getSnakeInfo();
        snake.move("L");
        snake.move("U");
        snake.getSnakeInfo();
    }

    int width;
    int height;
    Deque<int[]> path;  // maintain snake body
    Set<String> cache;  // quick check snake 
    Set<String> food;   // check food
    int score;

    public SnakeDesign(int width, int height, int[][] snacks){
        this.width = width;
        this.height = height;
        this.path = new LinkedList<>();
        this.cache = new HashSet<>();
        this.score = 0;
        this.food = new HashSet<>();
        for (int[] fo : snacks){
            food.add(String.valueOf(fo[0]) + "," + String.valueOf(fo[1]));
        }
    }

    public boolean move(String direction){
        if (score < 0) {
            return false;
        }

        int headX = path.getFirst()[0];
        int headY = path.getFirst()[1];
        int[] tail = path.getLast();
        if ("U".equals(direction)){
            headX --;
        } else if ("D".equals(direction)){
            headX ++;
        } else if ("L".equals(direction)){
            headY --;
        } else if ("R".equals(direction)){
            headY ++;
        } else {
            score = -1;
            return false;
        }

        String nextHead = headX + "," + headY;
        System.out.println("Current head is : " + headX + "," + headY +  "  direction is : " + direction);
        if (headX < 0 || headX >= height || headY < 0 || headY >= width || cache.contains(nextHead)) {
            score = -1;
            System.out.println("Snake dead");
            return false;
        }
        
        path.addFirst(new int[]{headX, headY});
        cache.add(nextHead);
        if (food.contains(nextHead)){
            food.remove(nextHead);
            score ++;
        } else {
            path.removeLast();
            String tailPos = tail[0] + "," + tail[1];
            cache.remove(tailPos);
        }

        printSnakeShape();
        return true;
    }

    public void generateSnake(int[] head){
        path.addFirst(head);
        cache.add(head[0] + "," + head[1]);
    }

    public void getSnakeInfo(){
        System.out.println("snake lengh is " + path.size());
        Iterator<int[]> iterator = path.iterator();
        while (iterator.hasNext()){
            int[] pos = iterator.next();
            System.out.println("snake body is " + pos[0] + ", " + pos[1]);
        }
    }

    public void printSnakeShape(){
        System.out.println("--------------------");
        for (int i = 0; i < width; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < height; j++){
                String curPos = String.valueOf(i) + "," + String.valueOf(j);
                if (food.contains(curPos)) {
                    sb.append("f");
                } else if (cache.contains(curPos)){
                    sb.append("s");
                } else {
                    sb.append("*");
                }
            }

            System.out.println(sb.toString());
        }
    }
}
