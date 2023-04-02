package Company.Google.Array.Interval_Meeting;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by zhang on 2018/7/27.
 * https://bbs.csdn.net/topics/380266575
 *
 * **** hashset 是无序的 treeset 可以排序
 * treeset 可以直接remove int【】  hashset 不可以
 */
class Rain {
    double left;
    double right;
    public Rain(double left, double right){
        this.left = left;
        this.right = right;
    }
//    @Override
//    public int compare(Rain r, Rain r2){
//        if (r.left != r2.left)
//            return -1;
//        else
//            return 1;
//    }
//    @Override
//    public int compareTo(Rain o) {
//        System.out.println(left + " compareTo " + o.left);
//        if (o.left == left && o.right == right)
//            return 0;
//        else
//            return -1;
//    }
}
public class RainDrop {
//   static TreeSet<Rain> treeSet = new TreeSet<Rain>();
    static TreeSet<Rain> treeSet = new TreeSet<>(new Comparator<Rain>() {
        @Override
        public int compare(Rain o1, Rain o2) {
            if (o1.left > o2.left)
                return -1;
            else
                return 1;
        }
    });
    public static boolean isWet(double drop){
        Rain rain = new Rain(drop - 0.5, drop + 0.5);
        Rain l = treeSet.ceiling(rain);
        Rain right = treeSet.floor(rain);
        if (l == null && right == null){
            if (rain.right > 0 || rain.left < 100)
                treeSet.add(rain);
        }else {
            if (l != null)
                handle(l,rain);
            if (right != null)
                handle(right,rain);
        }
        if (treeSet.size() == 1){
            for (Rain r : treeSet){
                if (r.left <= 0 && r.right >= 100)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }
    public static void handle(Rain l, Rain rain){
        if (rain.left >= l.left && rain.left <= l.right){
            Iterator it = treeSet.iterator();
            while (it.hasNext()){
                Rain r = (Rain) it.next();
                if (r.left == l.left && r.right == l.right)
                    it.remove();
            }
            rain = new Rain(l.left, rain.right);
            treeSet.add(rain);
        }else if (rain.right >= l.left && rain.right <= l.right){
            Iterator it = treeSet.iterator();
            while (it.hasNext()){
                Rain r = (Rain) it.next();
                if (r.left == l.left && r.right == l.right)
                    it.remove();
            }
            Rain newRain = new Rain(rain.left, l.right);
            treeSet.add(newRain);
        }else {
            treeSet.add(rain);
        }
    }
    public static void main(String[] args){
        // 0.8-1.8  1-2 1.8-2.8 2.8-3.8
        // 0.8-2.8
        TreeSet<int[]> ss = new TreeSet<>((a,b)->(a[0]-b[0]));

        ss.add(new int[]{1,2});
        ss.add(new int[]{4,5});
        ss.add(new int[]{2,3});
        ss.remove(new int[]{1,2});
        isWet(1.3);
        isWet(3.3);
        isWet(1.5);
        isWet(2.3);
        Iterator it = treeSet.iterator();
        while (it.hasNext()){
            Rain r = (Rain)it.next();
            System.out.println(r.left + " ..... " + r.right);
        }
        int a = 0;

    }
}
