package Company.ForUsAll;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/5/19
 * Time: 7:24 PM
 * Description:
 */


public class SuperStack {
    /**
     * Test function
     * @param args not applicable
     */
    public static void main(String[] args) {
        superStack(new String[]{"12", "push 4", "pop", "push 3", "push 5", "push 2", "inc 3 1",
                "pop", "push 1", "inc 2 2", "push 4", "pop", "pop"});
    }

    /**
     * function for process all the operations
     * @param ops all the operations
     */
    private static void superStack(String[] ops) {
        int[] stack = new int[Integer.parseInt(ops[0])];
        int p = -1;
        for (int i = 1; i < ops.length; i++) {
            p = process(stack, p, ops[i]);
        }
    }


    /**
     * process a single operations
     * @param stack array as stack
     * @param p the top pointer of the stack
     * @param op current operation
     * [url=home.php?mod=space&uid=160137]@return[/url] new top pointer
     */
    private static int process(int[] stack, int p, String op) {
        String[] tmp = op.split(" ");
        if (tmp.length == 1 && tmp[0].equals("pop")) {
            p--;
            if (p == -1) {
                System.out.println("EMPTY");
            } else {
                System.out.println(stack[p]);
            }
        } else if (tmp.length == 2 && tmp[0].equals("push")) {
            p++;
            stack[p] = Integer.parseInt(tmp[1]);
            System.out.println(stack[p]);
        } else if (tmp.length == 3 && tmp[0].equals("inc")){
            int num = Integer.parseInt(tmp[1]);
            int incr = Integer.parseInt(tmp[2]);
            for (int i = 0; i < Math.min(p + 1, num); i++) {
                stack[i] += incr;
            }
            System.out.println(stack[p]);
        }
        return p;
    }
}
