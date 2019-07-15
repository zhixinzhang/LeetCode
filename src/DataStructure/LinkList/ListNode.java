package DataStructure.LinkList;

/**
 * Created by zhang on 2017/1/4.
 */
public class  ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public void push(int i){
        ListNode  listNode =  new ListNode(i);
    }
}