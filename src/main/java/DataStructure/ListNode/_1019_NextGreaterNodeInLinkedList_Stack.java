package DataStructure.LinkedList;

import DataStructure.LinkList.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/5/19
 * Time: 1:32 PM
 * Description:
 */


public class _1019_NextGreaterNodeInLinkedList_Stack {
    public static void main(String[] args){

    }
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < list.size(); i++){
            while(!stack.isEmpty() && list.get(stack.peek()) < list.get(i))
                res[stack.pop()] = list.get(i);
            stack.push(i);
        }
        return res;
    }
}
