package DataStructure.String;
import java.util.Stack;

/**
 * Created by zhang on 2017/9/15.
 * path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 */
/**实用的一道题
 *想到各种情况  /..   /h///w/    /
 * 我用的stack
 * 首先用split（“/”） 然后循环数组
 * */
public class _71_Simplifypath {
    public static String simplifyPath(String path) {
        String[] step = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(int i = 0;i<step.length;i++){
            System.out.println(step[i]);
            if (!step[i].equals("..") && !step[i].equals( ".") && !step[i].equals("")){
                stack.push(step[i]);
            }else if (step[i].equals("..") && stack.size() != 0){
                stack.pop();
            }else if (step[i].equals(".")){
                continue;
            }
        }
        StringBuilder result = new StringBuilder();
        if (stack.isEmpty()){
            result.append('/');
        }else{
            for(String st : stack){
                if (!st.equals("/")){
                    result.append('/').append(st);
                }
            }
        }

        return result.toString();
    }

    public static  void main(String args[]){
//        String path ="/a/./b/../../c/f/g";
        String path ="/..";
        String simPath = simplifyPath(path);
    }
}
