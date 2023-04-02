package Company.Google.Tree;

/**
 * Created by zhang on 2018/6/30.
 */
public class _307_RangeSumQueryMutable_SegmentTreeNode {
    class SegmentTreeNode{
        int start, end;
        SegmentTreeNode left, right;
        int sum;
        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
    SegmentTreeNode root = null;
    public void NumArray(int[] nums){
        root = buildTree(nums,0, nums.length -1);
    }
    public SegmentTreeNode buildTree(int[] nums, int start, int end){
        if (start > end)
            return null;
        SegmentTreeNode res = new SegmentTreeNode(start,end);
        if (start == end)
            res.sum = nums[start];
        else {
            int mid = start + (end - start) / 2;
            res.left = buildTree(nums,start, mid);
            res.right = buildTree(nums,mid+1, end);
            res.sum = res.left.sum + res.right.sum;
        }
        return res;
    }

    void update(int i, int val){
        updateTree(root, i, val);
    }
    void updateTree(SegmentTreeNode root, int pos, int val){
        if (root.start == root.end)
            root.sum = val;
        else{
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid){
                updateTree(root.left, pos, val);
            }else {
                updateTree(root.right, pos,val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }
    public int sumRange(int i, int j){
        return sumRange(root,i,j);
    }
    public int sumRange(SegmentTreeNode root, int start, int end){
        if (root.end == end && root.start == start){
            return root.sum;
        }else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid){
                return sumRange(root.left,start,end);
            }else if (start >= mid + 1)
                return sumRange(root.right, start, end);
            else
                return sumRange(root.right, mid + 1,end) + sumRange(root.left, start, mid);
        }
    }
}
