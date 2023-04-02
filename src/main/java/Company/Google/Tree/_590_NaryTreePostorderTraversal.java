package Company.Google.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhang on 2018/8/5.
 */
public class _590_NaryTreePostorderTraversal {
    public List<Integer> postorder(NaryNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<NaryNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for(NaryNode node: root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;
    }
}
