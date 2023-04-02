package Company.Google.Array;


import java.util.HashSet;

/**
 * Created by zhang on 2018/7/31.
 */
public class WordSearch_followUp {
    public static void main(String[] args){
        solu(new String[][]{{"G","O","O"},{"G","L","E"},{"A","B","C"}},"ABG");
    }
    static int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    public static String solu(String[][] words,String s){
        String res = "";
        for (int i = 0; i < words.length; i++){
            for (int j = 0; j<words[0].length; j++){
                String a = String.valueOf(s.charAt(0));
                if (words[i][j].equals(a)){
                    HashSet<String> visited = new HashSet<>();
                    visited.add(i + "." + j);
                    String curS = backt(i,j,words,s,1,visited,words[i][j]);
                    if (res == "")  res = curS;
                    if (curS != "")
                        res = res.length()>curS.length()? curS:res;
                }
            }
        }
        return res;
    }
    public static String backt(int x, int y, String[][] words,String s, int index,HashSet<String> visited,String preS ){
        if (index > s.length()-1)
            return preS;
        String res = "";
        for (int[] d : dirs){
            int nx = x + d[0];
            int ny = y + d[1];
            if(nx < 0 || ny < 0 || nx >= words.length || ny >= words[0].length || visited.contains(nx + "." + ny))
                continue;
            String nextS = preS + words[nx][ny];
            String reS = "";
            visited.add(nx + "." + ny);
            if (words[nx][ny].equals(String.valueOf(s.charAt(index)))){
                reS = backt(nx,ny,words,s,index+1,visited,nextS);
                if(res == "") res = reS;
                if (reS != "")
                    res = res.length()>reS.length()? reS:res;
                index--;
            } else{
                reS = backt(nx,ny,words,s,index,visited,nextS);
                if(res == "") res = reS;
                if (reS != "")
                    res = res.length()>reS.length()? reS:res;
            }
            visited.remove(nx+"."+ny);
        }
        return res;
    }
}
