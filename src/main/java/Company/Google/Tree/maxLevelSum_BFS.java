package google.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhang on 2018/6/24.
 * 输出一颗树的 max level sum，不是二叉树。先让我定义 TreeNode 该怎么定义，顺带问问成员变量的访问权限。
 * 然后就用层序遍历秒了。然后接着问了问我会用什么样的 test case 来测试
 */
public class maxLevelSum_BFS {
    public int solution(MulTreeNode root){
        int res = 0;
        MulTreeNode m = new MulTreeNode(0);
        if (root == null)
            return 0;
        Queue<MulTreeNode> q = new LinkedList<>();
        q.add(root);
        res = root.val;
        while (!q.isEmpty()){
            int cur = 0;
            int size = q.size();
            for (int i = 0; i<size; i++){
                MulTreeNode r = q.poll();
                List<MulTreeNode> list = r.nodes;
                cur += r.val;
                for (int j = 0; j<list.size(); j++){
                    q.offer(list.get(i));
                }
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
