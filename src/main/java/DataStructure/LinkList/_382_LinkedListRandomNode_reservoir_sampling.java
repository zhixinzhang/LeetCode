package DataStructure.LinkList;
import  java.util.*;

/**
 * Created by zhang on 2018/4/18.
 * 蓄水池采样
 * https://leetcode.com/problems/linked-list-random-node/discuss/85659/Brief-explanation-for-Reservoir-Sampling
 */
public class _382_LinkedListRandomNode_reservoir_sampling {
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    private Random rm;
    private ListNode head;
    public _382_LinkedListRandomNode_reservoir_sampling(ListNode head) {
        this.head = head;
        rm = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode temp = head;
        int res = temp.val;
        int prob = 1;
        while(temp.next != null){
            temp = temp.next;
            if(rm.nextInt(++prob) == 0){
                res = temp.val;
            }
        }
        return res;
    }
}
