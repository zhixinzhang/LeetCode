package google.Array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang on 2018/6/6.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=426676&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26searchoption%5B3109%5D%5Bvalue%5D%3D1%26searchoption%5B3109%5D%5Btype%5D%3Dradio%26sortid%3D311
 * 2. 给定k，和一个二进制序列，判断该是否包含全部可能长度为k的序列。
 例如，11001包含了所有k=2的可能的二进制序列（00，01，10，11）。
 followup，不是判断，而是生成序列（里口原题）
 */
public class CrackingTheSafe_PreFollowUp {
    public static boolean allTheSafe(int[] arr, int k){
        if (arr == null || arr.length < k || k < 0) return false;
        int level = k;
        Queue<String> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        q.add("0");
        q.add("1");
        while (--level > 0){
            int size = q.size();
            for (int i = 0; i<size; i++){
                String curS = q.poll();
                q.add(curS + "0");
                q.add(curS + "1");
                if (level == 1){
                    hs.add(curS+"0");
                    hs.add(curS+"1");
                }
            }
        }
        int right = k-1;String curS = "";
        for (;right<arr.length;right++){
            if (curS == ""){
                for (int i = 0; i<k; i++){
                    curS += String.valueOf(arr[i]);
                }
            }else {
                curS = curS.substring(1,curS.length());
                curS += String.valueOf(arr[right]);
            }
            if (hs.contains(curS)) hs.remove(curS);
            continue;
        }
        if (hs.isEmpty())   return true;
        return false;
    }
    public static void main(String[] args){
        allTheSafe(new int[]{1,1,0,0,1}, 2);
    }

}
