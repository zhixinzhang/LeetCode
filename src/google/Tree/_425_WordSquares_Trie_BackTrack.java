package google.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/8/3.
 *
 * 重点是每层都有n重选项！！！
 */
public class _425_WordSquares_Trie_BackTrack {
    public static void main(String[] args){
        wordSquares(new String[]{"abc","bbe","cef"});
    }
   static class Node{
       String word;
       Node[] nodes;
       Node(){
           this.nodes = new Node[26];
           this.word = null;
       }
   }
    public static List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if(words == null || words.length == 0)  return res;
        Node root = new Node();
        int len = words[0].length();
        for (String s : words){
            buildTrie(s,root);
        }
        Node[] rows = new Node[len];
        for (int i = 0; i < len; i++){
            rows[i] = root;
        }
        backTr(0, 0, len, rows, res);
        return res;
    }
    public static void buildTrie(String s, Node root){
       Node cur  = root;
       for (char c : s.toCharArray()){
           int idx = c - 'a';
           if (cur.nodes[idx] == null)
               cur.nodes[idx] = new Node();
           cur = cur.nodes[idx];
       }
       cur.word = s;
    }

    public static void backTr(int row, int col, int len, Node[] rows, List<List<String>> res){
        if ((row == col) && (row == len)){
            List<String> s = new ArrayList<>();
            for (int i = 0; i<len; i++){
                s.add(new String(rows[i].word));
            }
            res.add(s);
        }else{
            if ( col < len  ) { // left to right first
                Node pre_row = rows[row];
                Node pre_col = rows[col];
                for (int i = 0; i < 26; i++) { // find all the possible next char
                    if ( (rows[row].nodes[i] != null) && (rows[col].nodes[i] != null) ) {
                        rows[row] = rows[row].nodes[i];
                        if (col != row)
                            rows[col] = rows[col].nodes[i];
                        backTr(row, col+1, len, rows, res);
                        rows[row] = pre_row;
                        if (col != row) rows[col] = pre_col;
                    }
                }
            } else { // reach the end of column, go to the next row
                backTr(row+1, row+1, len, rows, res);
            }
        }
    }
}
