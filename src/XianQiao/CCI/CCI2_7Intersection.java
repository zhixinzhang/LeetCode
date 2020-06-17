package XianQiao.CCI;

/**
 * @Author: Xianqiao
 * @Date: 6/16/20 16:42
 */

import DataStructure.LinkList.ListNode;

/** Given two (singly) linked lists, determine if the two lists intersect.
 * Return the intersecting node. Note that the intersection is defined based
 * on reference, not value. That is, if the kth node of the first linked list
 * is the exact same node (by reference) as the jth node of the second linked
 * list, then they are intersecting. */

public class CCI2_7Intersection {
    private ListNode findIntersection_TwoPointer(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        // Get tail and sizes.
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        // If different tail nodes, then there's no intersection.
        if (result1.tail != result2.tail) {
            return null;
        }

        // Set pointer to the start of each linked list.
        ListNode shorter = result1.size < result2.size ? list1 : list2;
        ListNode longer = result2.size < result2.size ? list2 : list1;

        //Advance the pointer for the longer linked list by difference in length.
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        // Move both pointer for the longer linked list by difference in lengths.
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        //Return either one
        return longer;
    }


    class Result {
        public ListNode tail;
        public int size;
        public Result(ListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    Result getTailAndSize(ListNode list) {
        if (list == null) return null;
        int size = 1;
        ListNode current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    ListNode getKthNode(ListNode head, int k) {
        ListNode current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }


}
