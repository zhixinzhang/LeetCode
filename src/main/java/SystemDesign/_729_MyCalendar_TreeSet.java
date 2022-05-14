package SystemDesign;
import java.util.*;
/**
 * Created by zhang on 2018/5/5.
 * https://leetcode.com/problems/my-calendar-i/discuss/109475/JavaC++-Clean-Code-with-Explanation
 */
public class _729_MyCalendar_TreeSet {

//    Keep existing books sorted and only check 2 books start right before & after the new book starts
    public _729_MyCalendar_TreeSet() {

    }
    private TreeSet<int[]> books = new TreeSet<>((int[] a, int[] b) -> (a[0] - b[0]));        // maxTreeSet

    public boolean book(int s, int e) {
        int[] book = new int[] { s, e }, floor = books.floor(book), ceiling = books.ceiling(book);
        if (floor != null && s < floor[1]) return false; // (s, e) start within floor
        if (ceiling != null && ceiling[0] < e) return false; // ceiling start within (s, e)
        books.add(book);
        return true;
    }
}
