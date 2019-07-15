package DataStructure.LinkList;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time
 * Example:
 Given 1->2->3->4->5->NULL,
 return 1->3->5->2->4->NULL.
 * Created by zhang on 2017/1/8.
 */
public class OddEvenLinkedList328 {

    public  static  ListNode oddEvenList(ListNode head){
        //判断是否是奇数
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode odd = oddDummy;
        ListNode even = evenDummy;
        while(head != null){
            if (head.val %2 >0){
                odd.next = head;
                odd= odd.next ;
            }else{
                even.next = head;
                even = even.next;
            }
        }
        return null;
    }

//    public  static  ListNode oddEvenList(ListNode head){
//        //判断是否是奇数
//        ListNode oddDummy = new ListNode(0); //创建两个空链表
//        ListNode evenDummy = new ListNode(0);
//        ListNode odd = oddDummy;            //两个空链表的  当前link
//        ListNode even = evenDummy;
//        int index = 1;
//        while (head != null){
//            if(index % 2 != 0){  //奇数
//                odd.next = head;
//                odd = odd.next;
//            }else{
//                even.next = head;
//                even = even.next;
//            }
//            ListNode tmp = head.next;
//            head.next = null;
//            head = tmp;
//            ++ index;
//        }
//        odd.next = evenDummy.next;
//        return  oddDummy.next;
//    }



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

        oddEvenList(head);
        System.out.print("aaa");
    }


}
