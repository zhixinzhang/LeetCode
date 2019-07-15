package DataStructure.Array;

/**
 * Created by zhang on 2017/10/25.
 */
class MinNodeHeap implements Comparable<MinNodeHeap> {
    int x,val;
    public MinNodeHeap (int x,int val) {
        this.x = x;
        this.val = val;
    }
    @Override
    public int compareTo (MinNodeHeap that) {
//        return that.val - this.val;       maxHeap
        return this.val - that.val;         // minHeap
    }
}
