package SystemDesign;

/**
 * Created by zhang on 2018/5/7.
 */
public class _IntervalTree_ {
    static class IntervalTree{
        int leftVal;
        int rightVal;
        IntervalTree left;
        IntervalTree right;
        public void stores (int leftVal, int rightVal){
            this.leftVal = leftVal;
            this.rightVal = rightVal;
        }
    }
    public static boolean search(double targert){
        IntervalTree iTree = new IntervalTree();
        iTree.stores(3,10);
        iTree.right = new IntervalTree();
        iTree.left = new IntervalTree();
        iTree.right.stores(5,8);
        iTree.left.stores(1,5);
        while (iTree != null){
            if (iTree.leftVal <= targert && iTree.rightVal >= targert)
                return true;
            if (iTree.leftVal > targert){
                iTree = iTree.left;
            }else{
                iTree = iTree.right;
            }
        }

        return false;
    }

    public static void main(String[] args){
        search(2.5);
    }
}
