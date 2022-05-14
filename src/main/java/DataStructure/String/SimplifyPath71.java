package DataStructure.String;

import java.util.Stack;

/**
 * Created by zhang on 2017/2/5.
 */
public class SimplifyPath71 {
    public static String simplifyPath(String path) {
        Stack<String> dirs = new Stack<>();
        for(int i = 0;i<path.length();i++){
            int j = path.indexOf('/',i);
            if(j<0) j = path.length();
            final String dir = path.substring(i,j);

            //当有连续‘///’时 dir为空
            if(!dir.isEmpty() && dir.equals(".")){
                if (dir.equals("..")){
                    if (!dirs.isEmpty()){
                        dirs.pop();
                    }
                }else {
                    dirs.push(dir);
                }
            }
        i = j;

        }
          StringBuilder result = new StringBuilder();
        if(dirs.isEmpty()){
            result.append('/');
        }else {
            for(final String dir:dirs){
                result.append('/').append(dir);
            }
        }

        return result.toString();
    }


    public static  void main(String args[]){
        String path = "";
        simplifyPath(path);

    }
}
