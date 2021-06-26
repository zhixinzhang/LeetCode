package Company.Karat;

/**
 * @author Luke Zhang
 * @Date 2021-06-20 22:45
 *
 * https://www.1point3acres.com/bbs/interview/roblox-software-engineer-678987.html
 * 第一题 encodeMessage
 * 给你一个String message 和 int row, int col
 * 把这个message 转成一个 row * col 的grid line by line
 * 然后按照col by col 输出 encodeMessage
 */
public class EncodeMessage {

    public static void main(String[] args){
        String message = "thisIsATestforEcodeMessage";
        char[][] outPut = solution(message, 4, 5);
        for (int i = 0; i < outPut.length; i++){
            for (int j = 0; j < outPut[0].length; j++){
                System.out.print(outPut[i][j]);
            }

            System.out.println("     ");

        }
    }


    public static char[][] solution(String message, int row, int col){
        char[][] ans = new char[row][col];
        if (message == null || message.length() == 0) {
            return ans;
        }
        char[] chars = message.toCharArray(); // [t] [h] [i] [s] [I]
                                              // [s] [A] [T] [e] [s]
                                              // [t] [f] [o] [r] [E]
        int len = row * col;
        int i = 0;
        while (i < len && i < message.length()){

            int curRow = i / col;   // i = 11 / 4  1
            int curCol = i % col;   // 7 % 5 = 2   11 % 5 = 3

            ans[curRow][curCol] = chars[i];
            i++;
        }

        return  ans;
    }
}
