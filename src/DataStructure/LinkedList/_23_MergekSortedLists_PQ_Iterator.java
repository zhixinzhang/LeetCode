package DataStructure.LinkedList;

import DataStructure.LinkList.ListNode;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=679722
 *
 * lc 尔散的变形，输入变成了iterator，有next 和hasnext 两个method，next会返回当前值，且advance iterator到下个element。
 * 这样priorityqueue做comparison的时候就不能直接比较iterator next的值，需要自己建一个class来记录当前值，和iterator next，在写pq的时候和面试官主动提了下，不能用next直接比较，
 * 但是我说我暂时也没想好这要怎么处理，先写下面的merge部分，回头再改。后来我说可以用integer比较，但是需要somehow记录下当前iterator的next，他提示我说你可以自己建一个class存这两个值。
 * Key Point:
 */

public class _23_MergekSortedLists_PQ_Iterator {
    class NewListNode {
        int val;
        ListNode listNode;

        public NewListNode(ListNode listNode, int val){
            this.listNode = listNode;
            this.val = val;
        }
    }

    public ListNode mergeKLists(LinkedList<Iterator<ListNode>> iterators) {
        ListNode dum = new ListNode(-1);
        if (iterators == null || iterators.size() == 0) {
            return dum;
        }

        int k = iterators.size();
        ListNode ans = dum;
        PriorityQueue<NewListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));

        while (!iterators.isEmpty()) {

            Iterator<ListNode> iterator = iterators.poll();
            ListNode listNode = iterator.next();
            minHeap.add(new NewListNode(listNode, listNode.val));

            if (minHeap.size() >= k){
                NewListNode newListNode = minHeap.poll();
                ans.next = newListNode.listNode;
                ans = ans.next;

            }
            if (iterator.hasNext()) {
                iterators.add(iterator);
            }
        }

        while (!minHeap.isEmpty()){
            NewListNode newListNode = minHeap.poll();
            ans.next = newListNode.listNode;
        }

        return ans.next;
    }


}
