package DataStructure.Array;
import java.util.*;
//先排序 后根据k来定位置
//LinkedList类是双向列表,列表中的每个节点都包含了对前一个和后一个元素的引用。他的获取速度不及ArrayList，但是随机位置插入和删除速度比ArrayList要快。
//add（插入的位置，插入的元素）
public class _406_QueueReconstructionbyHeight{
    public static int[][] reconstructQueue(int[][] people) {
        //brute  force to search every element  [7,0]  O(n^2)
        //70,71,61,50,52,44
        //70,61,71....
        //50,70,61,71.....
        //50,70,52,61,71...
        //50,70,52,61,44,71
//        Arrays.sort(people, new Comparator<int[]>() {
//        @Override
//                public int compare(int[] o1, int[] o2) {
//                return o1[0] != o2[0] ? -o1[0] + o2[0] : o1[1] - o2[1];
//            }
//        });

        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if (a[0] == b[0])
                    return a[1] - b[1];
                else
                    return b[0] - a[0];
            }
        });

        List<int[]> res = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        for (int[] cur : people){
            list.add(cur[1],cur);
        }
        for (int[] cur : people) {  
            res.add(cur[1], cur);  
        }
        int[][] ans = new int[people.length][2];
        for (int i = 0; i<res.size(); i++){
            ans[i] = res.get(i);
        }
        return res.toArray(new int[people.length][]);  
    }
    public static void main(String[] args){
        //[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        int[][] a = new int[6][2];
        a[0] = new int[]{7,0};
        a[1] = new int[]{4,4};
        a[2] = new int[]{7,1};
        a[3] = new int[]{5,0};
        a[4] = new int[]{6,1};
        a[5] = new int[]{5,2};
        reconstructQueue(a);
    }

}