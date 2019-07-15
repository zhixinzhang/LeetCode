package google;
import java.util.*;
import company.Apple.ListNode;

/**
 * Created by zhang on 2018/5/17.s
 */
public class _817_LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        if(G == null || G.length == 0 || head == null)  return 0;
        Set<Integer> setG = new HashSet<>();
        for (int i: G) setG.add(i);
        int res = 0;
        while (head != null) {
//            if (setG.contains(head.val) && (head.next == null || !setG.contains(head.next.val))) res++;
//            head = head.next;
        }
        return res;
    }
}
