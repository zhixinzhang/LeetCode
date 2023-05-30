package Company.Wepay;

import java.util.LinkedList;

/**
 * Created by zhang on 2018/1/19.
 */
public class _71_SimplifyPath_Stack {
    public String simplifyPath(String path) {
        LinkedList<String> response = new LinkedList<>();    

        for (String dir : path.split("/+")) {
            if (dir.equals("") || dir.equals(".")) {
                continue;
            }
            else if (dir.equals("..")) {
                if (response.size() > 0) {
                    response.removeLast();
                }
            }
            else {
                response.addLast(dir);
            }
        }
    
        StringBuilder sb = new StringBuilder();
        for (String dir : response) {
            sb.append("/").append(dir);
        }
        return (response.size() == 0) ? "/" : sb.toString();
    }
}
