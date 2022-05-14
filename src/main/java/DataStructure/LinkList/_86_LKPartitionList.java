package DataStructure.LinkList;

/**
 * Created by zhang on 2017/9/24.
 */
public class _86_LKPartitionList {
    public static ListNode partition(ListNode head, int x) {
        // time complexity O(n)  space complexity O(1)  two pointer
        if (head  == null || head.next == null)
            return head;
        ListNode leftPre = new ListNode(0);
        ListNode rightPre = new ListNode(0);
        ListNode rightDummy = rightPre;
        ListNode leftDummy = leftPre;
        while (head != null){
            if (head.val < x){
                leftPre.next = head;
                leftPre = leftPre.next;
            }else{
                rightPre.next = head;
                rightPre = rightPre.next;
            }
            head = head.next;
        }
        leftPre.next = rightDummy.next;
        rightPre.next = null;

        return leftDummy.next;
    }


    public static  void main(String args[]){
        ListNode listNode = new ListNode(1);
        ListNode ls = listNode;
        int[] array = {1,4,3,2,5,2};
        int i = 1;
        while(i<array.length){
            listNode.next = new ListNode(array[i]);
            listNode = listNode.next;
            i++;
        }
        ListNode re = partition(ls,3);
    }
}
