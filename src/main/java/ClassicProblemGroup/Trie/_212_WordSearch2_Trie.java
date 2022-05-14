package ClassicProblemGroup.Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/27/19
 * Time: 1:48 PM
 * Description:
 *
 * 牛逼一遍过， 可以不用hashset 用*代表之前的
 *
 */


public class _212_WordSearch2_Trie {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
//    class Trie{
//        public TrieNode root;
//        public Trie(){
//            root = new TrieNode();
//        }
//        void insert(String word){
//            TrieNode temp = root;
//            for(char c : word.toCharArray()){
//                if(temp.children[c - 'a'] == null){
//                    temp.children[c - 'a'] = new TrieNode();
//                    temp.children[c - 'a'].val = c;
//                }
//                temp = temp.children[c - 'a'];
//            }
//        }
//    }
//
//    class TrieNode{
//        public char val;
//        public boolean isWord;
//        public TrieNode[] children;
//        public TrieNode(){
//            isWord = false;
//            children = new TrieNode[26];
//        }
//    }
//
//    List<String> ans = new ArrayList<>();
//    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
//    public List<String> findWords(char[][] board, String[] words) {
//        if(board == null || board.length == 0 || board[0].length == 0)
//            return ans;
//        Trie trie = new Trie();
//        int m = board.length, n = board[0].length;
//        for(String w : words) trie.insert(w);
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                HashSet<String> visited = new HashSet<>();
//                visited.add(String.valueOf(board[i][j]));
//                dfs(visited, i, j, String.valueOf(board[i][j]), trie.root,board);
//            }
//        }
//        return ans;
//    }
//    public void dfs(HashSet<String> visited, int i, int j, String path, TrieNode root, char[][] board){
//        char c = board[i][j];
//        if(root.children[c - 'a'] == null)  return;
//        if(root.children[c - 'a'].isWord) ans.add(path);
//        for(int[] d : dir){
//            int nx = d[0] + i, ny = d[1] + j;
//            if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length)
//                continue;
//            if(!visited.add(nx + "," + ny)) continue;
//            dfs(visited, nx, ny, path + c, root.children[c - 'a'], board);
//        }
//    }
}
