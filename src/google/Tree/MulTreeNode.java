package google.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/6/24.
 */
public class MulTreeNode {
    public int val;
    List<MulTreeNode> nodes;

    public MulTreeNode(int val){
        this.val = val;
        nodes = new ArrayList<>();
    }
}
