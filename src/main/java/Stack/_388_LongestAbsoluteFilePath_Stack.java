package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by zhang on 2018/4/24.
 */
public class _388_LongestAbsoluteFilePath_Stack {

    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int maxLen = 0;
        for (String s : input.split("\n")){
            int lev = s.lastIndexOf("\t")+1;        // number of \t
            while(lev + 1 < stack.size()){ // find parent
                stack.pop();
            }
            int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
            stack.push(len);
            if(s.contains(".")) maxLen = Math.max(maxLen, len-1);
        }
        return maxLen;
    }
}
