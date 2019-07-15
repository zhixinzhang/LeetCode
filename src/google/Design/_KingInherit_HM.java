package google.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhang on 2018/6/30.
 */
public class _KingInherit_HM {
    private HashMap<String, KingNode> map ;
    private KingNode root;
    class KingNode{
        String name;
        boolean isDead;
        List<KingNode> children;
        public KingNode(String name){
            this.name = name;
        }
        public List<KingNode> getChildren(){
            return children;
        }
    }
    public void buildKing(){
        map = new HashMap<>();
        root = new KingNode("king");
        root.isDead = true;
        map.putIfAbsent(root.name,root);
    }
    public void birth(String name, String child){
        KingNode p = map.get(name);
        p.children.add(new KingNode(child));
    }
    public void death(String name){
        map.get(name).isDead = true;
    }
    public List<String> getOrderSuccession(){
        List<String> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    public void dfs(KingNode root, List<String> res){
        if (!root.isDead)
            res.add(root.name);
        else
            return;
        List<KingNode> child = root.children;
        for (int i = 0; i<child.size(); i++){
            dfs(child.get(i),res);
        }
    }
}
