package Company.Google.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/8/9.
 */
public class _428_SerializeandDeserializeNaryTree_Recur {
    static class NaryNode{
        char val;
        List<NaryNode> children;
        NaryNode(char c){
            this.val = c;
            children = new ArrayList<>();
        }
    }
    public static String seri(NaryNode root){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        serialize(root, sb);
        sb.append(']');
        return sb.toString();
    }
    public static void serialize(NaryNode root,StringBuilder sb){
        if(root == null)
            return;
        sb.append(root.val);
        sb.append('#');
        if(root.children != null && root.children.size() > 0)
        {
            sb.append('[');
            for(NaryNode child : root.children)
            {
                serialize(child, sb);
            }
            sb.append(']');
        }
        return;
    }

    // Decodes your encoded data to tree.
    public static NaryNode deserialize(String data) {
        char[] str = data.toCharArray();
        // serialized string for null == "[]"
        if(str.length <= 2)
            return null;
        List<NaryNode> rst = new ArrayList<>();
        deserialize(str, 1, rst);
        return rst.get(0);
    }

    // each recursion takes care of one level, which starts with '[' and ends with ']'.
    // idx is assumed to be just after a '[' when invoked.
    // list is parentNode.children, where newly created nodes are added to.
    // function returns the ending position of pointer just after a ']'
    private static int deserialize(char[] str, int idx, List<NaryNode> list)
    {
        while(idx < str.length && str[idx] != ']')
        {
            int val = 0;
            while(str[idx] != '#')
            {
                val = (val * 10) + (str[idx] - '0');
                idx++;
            }
            idx++;
            NaryNode node = new NaryNode('0');
            list.add(node);
            if(str[idx] == '[')
                idx = deserialize(str, idx+1, node.children);
        }
        return idx+1;
    }

    public static void main(String[] args){
        NaryNode root = new NaryNode('1');
        root.children.add(new NaryNode('2'));
        root.children.add(new NaryNode('3'));
        root.children.add(new NaryNode('4'));

        root.children.get(0).children.add(new NaryNode('5'));
        root.children.get(0).children.add(new NaryNode('6'));
        root.children.get(1).children.add(new NaryNode('5'));
        String s = seri(root);
        char[] c = s.toCharArray();
        NaryNode resRoot;
//        unSeri(resRoot,c,0,s.length());
    }
}
