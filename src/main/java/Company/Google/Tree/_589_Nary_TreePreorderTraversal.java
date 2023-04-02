package Company.Google.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhang on 2018/8/5.
 */
public class _589_Nary_TreePreorderTraversal {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(NaryNode root) {
        if (root == null)
            return list;

        list.add(root.val);
        for(NaryNode node: root.children)
            preorder(node);

        return list;
    }

    public List<Integer> preOrder_stack(NaryNode root){
        if (root == null)
            return list;
        Stack<NaryNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }
        return list;
    }

    public List<Integer> preOrder_mystack(NaryNode root){
        Stack<NaryNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            list.add(root.val);
            for (int i = root.children.size()-1; i>=0; i--){
                stack.push(root.children.get(i));
            }
        }
        return list;
    }
}
