package google.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhang on 2018/7/9.
 * 题目：
 一维棋盘，有白子（white）和黑子（black），白子只能向右移动，黑子只能向左移动,只能在空白格子移动，如果遇到棋子不能跨越。给出起始状态（String start）和终止状态（String end），问能否由起始状态通过移动白子和黑子达到终止状态，返回boolean。
 .1point3acres网
 举例：
 start: _ W _ _ B _
 end:   _ _ _ W B _  true. 1point3acres
 _ _ B W _ _  false
 _ W B _ _ _  true
 W _ B _ _ _  false

 follow up: 如果黑子和白子轮流走，一次只能走一步，判断能否达到终止状态。

 举例：
 start: _ W _ _ B _. 围观我们@1point 3 acres
 end:   _ _ _ W B _  false. 一亩-三分-地，独家发布
 . From 1point 3acres bbs
 最后问了一下如果要设计test case，应该考虑哪些case
 */
public class WhiteBlackChess {
    public static void main(String[] args){
        char[] board = new char[]{'_','W','_','_','_','B','_','_','B'};
        char[] target = new char[]{'_','_','W','B','_','_','W','_','_'};
        solution(board,target);
    }
    public static boolean solution(char[] board, char[] target){
        if (board.length != target.length)  return false;
        int al = 0, ar = 0, bl = 0, br = 0;
        int L = board.length;
        while (al < L && ar < L && bl < L && br < L){
            al = findIndex(board, al, 'W');
            ar = findIndex(board, ar, 'B');
            bl = findIndex(target, bl, 'W');
            br = findIndex(target, br, 'B');
            if (al == -1 && bl != -1 || ar == -1 && br != -1)   return false;
            if (al > bl || ar < br) return false;
            if (al - ar < 0 && bl - br > 0 || al - ar > 0 && bl - br < 0)
                return false;
            al++;ar++;bl++;br++;
        }
        return true;
    }
    public static int findIndex(char[] board, int i, char c){
        while (i < board.length && board[i] != c){
            i++;
        }
        if (i == board.length)
            i = -1;
        return i;
    }

}
