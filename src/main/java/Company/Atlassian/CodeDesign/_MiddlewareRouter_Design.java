package Company.Atlassian.CodeDesign;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/discuss/interview-question/object-oriented-design/2167390/atlassian-ood-design-a-middelware-router
Router.withRoute("/bar", "result")
Router.route("/bar") -> "result"

Router.withRoute("/bar/abc", "abc")
Router.route("/bar/abc") -> "abc"
Router.route("/bar/abc/dd") -> null	
 * 
*/

class Router {
    String name;
    boolean isEnd;
    Map<String, Router> childMap;
    
    public Router(String name){
        this.name = name;
        this.childMap = new HashMap<>();
        this.isEnd = false;
    }
}

public class _MiddlewareRouter_Design {

    public static void main(String[] args) {
        _MiddlewareRouter_Design middleRouter = new _MiddlewareRouter_Design();
        middleRouter.root = new Router("");

        // root = new Router("");
        middleRouter.buildRoute("/a/b/c/d/e", "e");
        middleRouter.buildRoute("/a/b/cc/dd/ee", "ee");
        middleRouter.buildRoute("/a/bb/cc/dd/h", "h");
        System.out.println(middleRouter.findRoute("/a/b/c/d/e"));
        System.out.println(middleRouter.findRoute("/a/bb/cc/dd/h"));
        System.out.println(middleRouter.findRoute("/a/cb"));

        middleRouter.buildRoute("/a/b/cc/dd/ee", "ee");

        System.out.println("Star***** ");
        
        // a = routeWithStar("/a/b/*/dd/ee".split("/"), root, 0);
        System.out.println(middleRouter.findRouteWithStar("/a/*/cc/*/ee".split("/"), middleRouter.root, 0));
        System.out.println(middleRouter.findRouteWithStar("/a/*/cc/x/ee".split("/"), middleRouter.root, 0));
    }

    Router root;
    public void buildRoute(String path, String destination){
        Router cur = root;
        String[] partPath = path.split("/");
        for (int i = 0; i < partPath.length; i++){
            String p = partPath[i];

            if (!cur.childMap.containsKey(p)){
                Router r = new Router(p);
                cur.childMap.put(p, r);
                cur = cur.childMap.get(p);
            } else {
                cur = cur.childMap.get(p);
            }
            
        }
        cur.isEnd = true;
    }

    public String findRoute(String destination){
        Router cur = root;
        String[] partPath = destination.split("/");
        for (int i = 0; i < partPath.length; i++){
            String p = partPath[i];
            if (!cur.childMap.containsKey(p)){
                System.out.println("we don't have this destionation");
                return "";
            } else {
                cur = cur.childMap.get(p);
            }
        }
        
        if (cur.isEnd) {
            System.out.println("we have this destionation  : " + cur.name);
            return cur.name;
        }

        return "";
    }

    public String findRouteWithStar(String[] partPath, Router cur, int index){
        
        for (int i = index; i < partPath.length; i++){
            String p = partPath[i];
            if ("*".equals(p)) {
                String val = "";
                i++;
                for (Map.Entry<String, Router> entry : cur.childMap.entrySet()){
                    val = findRouteWithStar(partPath, entry.getValue(), i);
                    if (val != "") {
                        return val;
                    }
                }
                return val;
            } else if (!cur.childMap.containsKey(p)){
                return "";
            } else {
                cur = cur.childMap.get(p);
            }
        }
        
        if (cur.isEnd) {
            System.out.println("we have this destionation : " + cur.name);
            return cur.name;
        }

        return "";
    }
}