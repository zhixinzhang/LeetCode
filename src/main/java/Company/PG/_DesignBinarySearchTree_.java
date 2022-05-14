package Company.PG;

/**
 * Created by zhang on 2018/1/29.
 */
public class _DesignBinarySearchTree_ {
    public class BinaryTree {

        private int data;
        private BinaryTree left;
        private BinaryTree right;

        public BinaryTree(int num) {
            this.data = num;
            this.left = null;
            this.right = null;
        }
        // As a convention, if the key to be inserted is less than the key of root node, then key is inserted in
// left sub-tree; If key is greater, it is inserted in right sub-tree. If it is equal, as a convention, it
// is inserted in right sub-tree
        public void addNode(int num) {
            if (num < this.data) {
                if (this.left != null) {
                    this.left.addNode(num);
                } else {
                    this.left = new BinaryTree(num);
                }
            } else {
                if (this.right != null) {
                    this.right.addNode(num);
                } else {
                    this.right = new BinaryTree(num);
                }
            }
        }
        // Visit the node first, then left and right sub-trees
        public void traversePreOrder() {
            System.out.println( this.data );
            if( this.left != null ) {
                this.left.traversePreOrder();
            }
            if( this.right != null ) {
                this.right.traversePreOrder();
            }
        }
        // Visit left sub-tree, then node and then, right sub-tree
        public void traverseInOrder() {
            if( this.left != null ) {
                this.left.traverseInOrder();
            }
            System.out.println( this.data );
            if( this.right != null ) {
                this.right.traverseInOrder();
            }
        }
        // Visit left sub-tree, then right sub-tree and then the node
        public void traversePostOrder() {
            if( this.left != null ) {
                this.left.traversePostOrder();
            }
            if( this.right != null ) {
                this.right.traversePostOrder();
            }
            System.out.println( this.data );
        }

    }
}
