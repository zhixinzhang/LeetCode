package google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang on 2018/5/9.
 * 首先根据complete binary search tree 特性 bot leaf as far as left
 * 计算出多少层次，然后还有
 * 填充
 */
public class _108_ConvertSortedArraytoBinarySearchTree_followup {
    public static TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if(len==0){
            return null;
        }

        TreeNode root = new TreeNode(0);
        len--;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int layer = 1;
        while(len>0){
            layer *= 2;
            for(int i=0;i<layer&&len>0;i++,len-=2){
                TreeNode cur = q.poll();
                cur.left = new TreeNode(0);
                if(len>1){
                    cur.right = new TreeNode(0);
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
        }

        int i=0;
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
                cur.val = nums[i++];
                cur = cur.right;
            }else {
                TreeNode pre = cur.left;
                while(pre.right!=null && pre.right!=cur){
                    pre = pre.right;
                }

                if(pre.right==null){
                    pre.right = cur;
                    cur = cur.left;
                }else {
                    pre.right = null;

                    // pre must has a value now
                    cur.val = nums[i++];
                    cur = cur.right;
                }
            }
        }

        return root;
    }
    public static void main(String[] args){
        sortedArrayToBST(new int[]{-10,-5,-3,0,1,2,3,4,5,6});
    }
}
