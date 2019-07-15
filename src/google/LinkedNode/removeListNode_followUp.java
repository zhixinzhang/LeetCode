package google.LinkedNode;

import DataStructure.LinkList.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/27/19
 * Time: 10:05 PM
 * Description:
 */


public class removeListNode_followUp {
    // 1 2 3 4 5 6 1 ->  1 3 5 1  去除能被k整出的数
    public static void main(){}
    public ListNode remove(ListNode head, int k){
        if (head == null) return head;
        int headVal = head.val;
        int count = 1;
        ListNode temp = head;
        while (temp.next != null){
            if (temp.next.val == headVal)
                break;
            if (count % 2 != 0){
                temp.next = temp.next.next;
                count++;
            }
            temp = temp.next;
            count++;
        }
        return head;
    }
}
