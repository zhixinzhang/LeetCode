package Company.Google.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/8/5.
 */
public class NaryNode {
    int val;
    List<NaryNode> children;

    NaryNode(int val){
        this.val = val;
        children = new ArrayList<>();
    }
}
