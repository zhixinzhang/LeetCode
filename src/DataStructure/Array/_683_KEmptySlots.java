package DataStructure.Array;

import java.util.TreeSet;

/**
 * Created by zhang on 2017/11/17.
 */
//［1，4，2，5，3］，2     x - - x -
//1 3 2   k = 1
//[5,1,4,3,2]  3    - - - - x      x - - - x
    //brute force  each flower blooming, check cur flower left or right k empty slot and K+1 is flower
    //。不过有一点小不一样，就是Google的OA没有要求靠近两边的连续未开花花圃不算数。
public class _683_KEmptySlots {
    //flowers[i] = x means that the unique flower that blooms at day i will be at position x
//    public static int kEmptySlots(int[] flowers, int k) {
//        int dayLength = flowers.length;
//        boolean[] garden = new boolean[dayLength];  //blooming or not
////        HashSet<DataStructure.Integer> d = new HashSet<DataStructure.Integer>();
//        // iterate through day
//        int curPosition = 0;
//        for(int i=0;i < dayLength;i++){
//            curPosition = flowers[i]-1;           //flower i position x
//            garden[curPosition] = true;           // x position blooming
//            int left = 1, right = 1;
//            //check left
//            while(curPosition - left >= 0){
//                if(garden[curPosition-left]) {
//                    if (left - 1 == k)
//                        return i+1;
////                    d.add(left-1);
////                    break;
//                }
//                left++;
//            }
//            //check right
//            while(curPosition + right < dayLength){
//                if(garden[curPosition + right]) {
//                    if (right - 1 == k)
//                        return i+1;
////                    d.add(right-1);
////                    break;
//                }
//                right++;
//            }
////            if(d.contains(k)) {
////                return i+1;
////            }
//        }
//        return -1;
//    }
    public static int kEmptySlots(int[] flowers, int k) {
        if(flowers.length == 0 && k != 0){
            return -1;
        }
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < flowers.length;i++){
            int cur = flowers[i];
            Integer next = treeSet.higher(cur);
            if (next != null && next - cur == k+1){
                return i+1;
            }
            Integer pre = treeSet.lower(cur);
            if (pre != null && cur-pre ==k+1){
                return i+1;
            }
            treeSet.add(cur);
        }
        return -1;
    }

        public static void main(String[] args){
        int[] a = new int[5];
        a[0] = 5;
        a[1] = 6;
        a[2] = 2;
        a[3] = 3;
        a[4] = 1;
        //- - - - x -    - - - - x x   - x - - x x
        int c = kEmptySlots(a,2);
        int b = 0;
    }
}
