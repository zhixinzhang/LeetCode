package DataStructure.LinkList;

/**
 * Created by zhang on 2017/3/13.
 */
public class IntialListNode {
    public ListNode iniListNode(int[]test ,int i,ListNode head){
        while (i<test.length && head.next == null){

            head.next = new ListNode(test[i]);
            i++;
            iniListNode(test,i,head.next);
        }
        return head;
    }
}
