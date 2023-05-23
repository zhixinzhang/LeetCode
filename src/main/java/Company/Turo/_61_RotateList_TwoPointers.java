package Company.Turo;


import DataStructure.LinkList.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/19/19
 * Time: 11:33 PM
 * Description:
 */


public class _61_RotateList_TwoPointers {
    public static ListNode BuildUpListNode_Recursion (ListNode head, int i, int[] arr){
        if (i < arr.length){
            head = new ListNode(arr[i]);
            head.next = BuildUpListNode_Recursion(new ListNode(0), ++i, arr);
        }
        return head;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int[] arr = new int[]{1,2,3,4,5,6,7};
        ListNode re = BuildUpListNode_Recursion(head, 0, arr);
        int i = 0;
        while (i < arr.length){
            temp.next = new ListNode(arr[i]);
            i++;
            temp = temp.next;
        }
        rotateRight(head.next, 3);
    }

    /**
     * Since n may be a large number compared to the length of list. So we need to know the length of linked list.After that, move the list after the (l-n%l )th node to the front to finish the rotation.
     *
     * Ex: {1,2,3} k=2 Move the list after the 1st node to the front
     *
     * Ex: {1,2,3} k=5, In this case Move the list after (3-5%3=1)st node to the front.
     *
     * So the code has three parts.
     *
     * Get the length
     *
     * Move to the (l-n%l)th node
     *
     * 3)Do the rotation
     * */

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head;
        int n;
        for(n = 1; temp.next != null; n++){
            temp = temp.next;
        }
        temp.next = head;

        ListNode new_tail = head;
        int newLen = n - k % n - 1;
        for(int i = 0; i < newLen; i++){
            new_tail = new_tail.next;
        }

        ListNode new_head = new_tail.next;
        new_tail.next = null;
        return new_head;
    }
}
