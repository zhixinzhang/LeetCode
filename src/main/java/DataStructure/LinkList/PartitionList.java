package DataStructure.LinkList;

/**
 * Created by zhang on 2017/1/4.
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
//my solution 两个单链表  按大小每个排序 然后合并
public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return  head;
        }
        //判断每个lin当前的值
        ListNode slowDummy = new ListNode(0);
        ListNode fastDummy = new ListNode(0);
        ListNode slow = slowDummy;
        ListNode fast = fastDummy;
        while (head != null){
          if (head.val <x){
              slow.next = head;
              slow = slow.next;

          } else {
              fast.next = head;
              fast = fast.next;
          }
         head = head.next;
        }
        fast.next = null;
        slow.next = fastDummy.next;
        return slowDummy.next;
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
        int[] test = {4,3,2,5,2};
        ListNode head = new ListNode(1);
        for(int i=0;i<test.length;i++){
            backInitNode(head,test,i);
        }

        int x = 3;
        partition(head,x);
        System.out.print("aaa");
    }
}
