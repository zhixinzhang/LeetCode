package XianQiao.CCI;


import DataStructure.LinkList.ListNode;

/**
 * @Author: Xianqiao
 * @Date: 6/15/20 19:49
 */

/** Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node,
 * not necessarily the exact middle) of a singly linked list, given only access to that node. */
public class CCI2_3DeleteMiddleNode {
    private boolean deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
        return true;
    }

}
