package DataStructure.Stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/25/19
 * Time: 5:41 PM
 * Description:
 *
 * https://www.1point3acres.com/bbs/thread-520388-2-1.html
 */


public class _735_AsteroidCollision_Stack {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int ast: asteroids) {
            collision: {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }
}
