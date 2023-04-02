package Company.Google.Tree;

import DataStructure.LinkList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luke Zhang
 * @date $(DATE) $(TIME)
 */
public class _109_ConvertSortedListtoBinarySearchTree_Recursion {
//两种解法
// 第一种 找到ListNode的中点 然后中点作为 TreeNode root
//然后左右分割 继续recursion
//第二种 把ListNode转成 数组Array 之后recursion

    //O(N * logN)
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return helper(head, null);
    }
    public TreeNode helper(ListNode left, ListNode right){
        ListNode slow = left;
        ListNode fast = left;
        if(left == right) return null;

        while(fast != right && fast.next != right){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(left,slow);
        root.right = helper(slow.next,right);
        return root;
    }

    public TreeNode sortedListToBST_Array(ListNode head) {
        if(head == null) return null;
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        return helper2(list, 0, list.size()-1);
    }
    public TreeNode helper2( List<Integer> list, int l, int r){
        int mid = (r + l)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper2(list, l, mid-1);
        root.right = helper2(list, mid+1, r);
        return root;
    }
}
