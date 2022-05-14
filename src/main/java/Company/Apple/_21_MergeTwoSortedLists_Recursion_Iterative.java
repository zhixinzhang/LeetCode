package Company.Apple;

/**
 * Created by zhang on 2018/2/9.
 */
public class _21_MergeTwoSortedLists_Recursion_Iterative {
    // 1 2 4   1 3  5     1 1 2 3 4 5
        public ListNode mergeTwoLists_recursion(ListNode l1, ListNode l2) {
            if(l1 == null)
                return l2;
            if (l2 == null)
                return l1;
            ListNode curNode;
            if (l1.val < l2.val){
                curNode = l1;
                curNode.next = mergeTwoLists_recursion(l1.next,l2);
            }else{
                curNode = l2;
                curNode.next = mergeTwoLists_recursion(l1,l2.next);
            }
            return curNode;
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2){
            ListNode dum = new ListNode(0);
            ListNode curNode = dum;
            while (l1 != null && l2 != null){
                if (l1.val < l2.val){
                    curNode.next = l1;
                    l1 = l1.next;
                }else{
                    curNode.next = l2;
                    l2 = l2.next;
                }
                curNode = curNode.next;
            }
            if (l1 != null && l2 == null)
                curNode.next = l1;
            if (l1 == null && l2 != null)
                curNode.next = l2;

            return dum.next;
        }
    }
