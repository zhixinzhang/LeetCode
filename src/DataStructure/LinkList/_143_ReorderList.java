package DataStructure.LinkList;

/**
 * Created by zhang on 2017/1/7.
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 for example  1 2 3 4 5 6    to  162534
 */
/**datastructure   LinkedList
 * step  find middle and reverse second link  and merge
 *
 * */
//find mid node  after revese and merge
public class _143_ReorderList {

    public static ListNode reorder(ListNode head){
    ListNode midNode =  findMid(head);
    ListNode secondHead = midNode.next;
    midNode.next = null;
    secondHead = reverse(secondHead);
    head = merge(head, secondHead);
        System.out.print("aaa");
        return  head;
    }

    private  static  ListNode merge(ListNode head,ListNode secondHead){
        ListNode cur = head;
        while (secondHead != null) {
            ListNode tmp = secondHead.next;
            secondHead.next = cur.next;
            cur.next =secondHead;
            cur = cur.next.next;
            secondHead = tmp;
        }
        return head;
    }
    private static  ListNode findMid(ListNode head){
        ListNode slowNode = head;
        ListNode fastNode = head.next;

        while(fastNode.next != null && fastNode != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return  slowNode;
    }

    private static ListNode reverse(ListNode midNode){
        if(midNode == null || midNode.next == null){
            return  midNode;
        }
        ListNode newHead = null;
        while (midNode != null){
            ListNode tmp = midNode.next;
            midNode.next = newHead;
            newHead = midNode;
            midNode = tmp;
        }
        return newHead;
    }

    private static ListNode backInitNode(ListNode head,int[] test,int a){
        if(a<test.length && head.next == null){
            head.next = new ListNode(test[a]);
            a++;
            backInitNode(head.next,test,a);
        }
        return head;
    }

    public  static void main(String args[]){
        int[] test = {2,3,4,5,6};
        ListNode head = new ListNode(1);
        for(int i=0;i<test.length;i++){
            backInitNode(head,test,i);
        }

        int x = 3;
        reorder(head);
        System.out.print("aaa");
    }

}
