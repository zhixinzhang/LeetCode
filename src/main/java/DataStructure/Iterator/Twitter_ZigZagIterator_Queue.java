//package DataStructure.Iterator;
//
//import com.sun.istack.internal.Nullable;
//
//import java.util.*;
//
//
///**
// * @author Luke(New Man) Zhang
// * @Date 6/13/2021 1:17 AM
// * <p>
// * Source Link:
// * <p> https://www.1point3acres.com/bbs/thread-695478-1-1.html
// * Description:
// * <p>举个栗子
// * {1, 2, 3, 4}
// * {5, 6}
// * {7}
// *
// * 输出应该是 1， 5， 7， 2， 6， 3， 4.
// * 他给了一个interface
// * <p>
// * Time and Space Complexity:
// * <p>
// * <p>
// * Data structure
// *
// * _281_ZigzagIterator_LinkedList
// */
//
//interface Playlist {
//     @Nullable
//     int getNextTrack();
//     boolean hasNextTrack();
//}
//
//public class Twitter_ZigZagIterator_Queue implements Playlist {
//    static Queue<Iterator> queue;
//    public Twitter_ZigZagIterator_Queue(List<List<Integer>> lists) {
//        queue = new LinkedList<>();
//        for (List<Integer> list : lists){
//            queue.add(list.iterator());
//        }
//    }
//
//    @Override
//    public boolean hasNextTrack() {
//        if (queue.isEmpty())
//            return false;
//        else
//            return true;
//    }
//
//    @Override
//    public int getNextTrack() {
//        if (hasNextTrack()) {
//            Iterator iterator = queue.poll();
//            int res = (int)iterator.next();
//            if (iterator.hasNext())
//                queue.add(iterator);
//
//            return res;
//        } else
//            return -1;
//    }
//
//    public static void main(String[] args){
//        List<List<Integer>> input = new ArrayList<>();
//        List<Integer> l1 = new ArrayList<>();
//        l1.add(1);
//        l1.add(2);
//        l1.add(3);
//        l1.add(4);
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(5);
//        l2.add(6);
//        List<Integer> l3 = new ArrayList<>();
//        l3.add(7);
//
//        input.add(l1);
//        input.add(l2);
//        input.add(l3);
//        Twitter_ZigZagIterator_Queue zig = new Twitter_ZigZagIterator_Queue(input);
//
//        while (zig.hasNextTrack()){
//            System.out.println(zig.getNextTrack());
//        }
//    }
//}
