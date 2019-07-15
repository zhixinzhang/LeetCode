package DataStructure.LinkedList;


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

    //if k 小于 ListNode的长度 一次遍历就可以
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode l = head, r = head;
        // 1 2 3 4 5 6 7       5 6 7 1 2 3 4  k = 3
        int n = k;
        while(--n >= 0){
            r = r.next;
        }
        while(r.next != null){
            r = r.next;
            l = l.next;
        }
        ListNode prefix = reverse(head, l, r);
        ListNode temp = prefix;
        while (temp.next != null)
            temp = temp.next;
        temp.next = head;
        return prefix;
    }

    public static ListNode reverse(ListNode head,ListNode l,ListNode r){
        ListNode newHead = l.next;
        l.next = null;
        ListNode temp = newHead;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }

    // if k 不知道多大 可能大于listnode 的size ，那就链接 listnode首位 然后断开
    public ListNode rotateRight_Best(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int size = 0;
        ListNode temp = head;
        // 1 2 3 null
        for (;temp.next!=null;size++){
            temp = temp.next;
        }
        temp.next = head;       // 1 2 3 -> 1
        // k  从右面数
//        k %= size;
        k = size - k%size -1;
        ListNode res = head;
        for (int i = 0; i < k; i++){
            res = res.next;
        }
        ListNode new_head = res.next;
        res.next = null;
        return new_head;
    }
}
