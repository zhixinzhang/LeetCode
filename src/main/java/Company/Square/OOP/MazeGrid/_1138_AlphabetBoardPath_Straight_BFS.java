package Company.Square.OOP.MazeGrid;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

// currently return D2R1!U2R3!!D3!
// original DDR!UURRR!!DDD!
// followup是 如果有重复的字符在alphabet， 怎么走最少步（局部最优就好） 用 BFS or 用 map 存所有char 位置 然后遍历
public class _1138_AlphabetBoardPath_Straight_BFS {
    static String[] board = {"abcdef","fghij","klmno","pqrst","uvwxy","z"};
    static StringBuilder sbr = new StringBuilder("");
    static Map<Character, int[]> mapper = new HashMap<Character, int[]>();
    
    public static String alphabetBoardPath(String target) {
      target = target.strip();
      buildMap();
      char currentPostion = 'a';
      for(char cha : target.toCharArray()){
        sbr.append(getMoves(currentPostion, cha)+"!");
        currentPostion = cha;
      } 

      System.out.println(sbr.toString());
      return sbr.toString();
    }
  
    public static String getMoves(Character start, Character end){
      StringBuilder sb = new StringBuilder("");
      StringBuilder newSb = new StringBuilder("");
      int xdiff = mapper.get(start)[0] - mapper.get(end)[0];
      int ydiff = mapper.get(start)[1] - mapper.get(end)[1];
      if(xdiff< 0){
        String appendDown= "D";
        appendDown = appendDown.repeat(Math.abs(xdiff));
        sb.append(appendDown);
        newSb.append("D");
        newSb.append(String.valueOf(Math.abs(xdiff)));
      }
      if (xdiff>0){
        String appendUp= "U";
        appendUp = appendUp.repeat(Math.abs(xdiff));
        sb.append(appendUp);
        newSb.append("U");
        newSb.append(String.valueOf(Math.abs(xdiff)));
      }
      if (ydiff>0){
        String appendleft = "L";
        appendleft = appendleft.repeat(Math.abs(ydiff));
        sb.append(appendleft);
        newSb.append("L");
        newSb.append(String.valueOf(Math.abs(ydiff)));
      }
      if (ydiff<0){
        String appendRight= "R";
        appendRight = appendRight.repeat(Math.abs(ydiff));
        sb.append(appendRight);
        newSb.append("R");
        newSb.append(String.valueOf(Math.abs(ydiff)));
      }

      if (end == 'z' && start !='z'){
         // Z can only be D  as nothing is blew it, hence replace the last D with nothing and append it to the end
         sb.deleteCharAt(sb.lastIndexOf("D"));
         sb.append('D');
       }

       return newSb.toString(); 
    //   return sb.toString();      DDR!UURRR!!DDD!
    }
  
    public static void buildMap(){
      int x = 0;
      for(String str: board ){
        int y = 0;
        for(char ch: str.toCharArray()){
          mapper.put(ch, new int[]{x,y});
          y++;
        }
        x++;
      }
    }

    public static void main(String[] args) {
        // alphabetBoardPath("leet");
        alphabetBoardPath_BFS("leet");
    }


    // BFS with
    public static String alphabetBoardPath_BFS(String target) {
        String[][] board = {
                {"a", "b", "c", "d", "e"},
                {"f", "g", "h", "i", "j"},
                {"k", "l", "m", "n", "o"},
                {"p", "q", "r", "s", "t"},
                {"u", "v", "w", "x", "y"},
                {"z", "`", "`", "`", "`"}
        };
        // 记录走过的位置 队列
        Queue<String[]> queue = new ArrayDeque<>();

        queue.offer(new String[]{"0", "0", ""});
        int index = 0;
        String ans = "";
        while (!queue.isEmpty()) {
            String[] poll = queue.poll();
            String xx = poll[0];
            String yy = poll[1];
            int x = Integer.parseInt(xx);
            int y = Integer.parseInt(yy);
            String res = poll[2];
            // 补齐的位置直接跳过
            if ("`".equals(board[x][y])) {
                continue;
            }
            if (board[x][y].equals(String.valueOf(target.charAt(index)))) {
                res += "!";
                ans += board[x][y];
                index++;
                // 找到一个目标字符后 队列中其他的路径就没有用了
                queue.clear();
                // 从当前位置继续向下寻找目标字符
                queue.offer(new String[]{xx, yy, res});
                // 如果所有目标值都找到了 返回移动路径字符串
                if (ans.equals(target)) {
                    return res;
                }
            }
            // 如果当前x大于零 且上个动作 不是向下走 则表示当前可向上移动
            if (x > 0 && res.charAt(res.length() - 1) != 'D') {
                queue.offer(new String[]{String.valueOf(x - 1), yy, res + 'U'});
            }
            // 如果当前y大于零 且上个动作 不是向右走 则表示当前可向左移动
            if (y > 0 && res.charAt(res.length() - 1) != 'R') {
                queue.offer(new String[]{xx, String.valueOf(y - 1), res + 'L'});
            }
            // 如果当前y小于数组纵轴边界 且上个动作 不是向左走 则表示当前可向右移动
            // 如果当前是初始 0，0 位置 可向右移动
            if (y < 4 && (res.length() == 0 || res.charAt(res.length() - 1) != 'L')) {
                queue.offer(new String[]{xx, String.valueOf(y + 1), res + 'R'});
            }
            // 如果当前x小于数组纵轴边界 且上个动作 不是向上走 则表示当前可向下移动
            // 如果当前是初始 0，0 位置 可向下移动
            if (x < 5  && (res.length() == 0 || res.charAt(res.length() - 1) != 'U' )) {
                queue.offer(new String[]{String.valueOf(x + 1), yy, res + 'D'});
            }

            
        }
        
        return null;
    }
}
