package Company.Attentive;

// https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=961847
// ”let x 5；let y 10； add x  y”
public class OperateSolution {
     public static void main (String[] args) throws Exception {
        doCalculate("le");

        // doCalculate("let x 5;    let y 10; add x y");
     }

     private static void doCalculate (String input) throws Exception {
        if (input == null || input.length() <= 3) {
            throw new IllegalArgumentException(input);
        }

        String[] vals = input.split(";");
        if (vals.length != 3)
            System.out.println("0");
        
        double x = Double.valueOf(vals[0].trim().split(" ")[2]);
        double y = Double.valueOf(vals[1].trim().split(" ")[2]);

        if (vals[2].split(" ")[1].equals("add")) {
            double ans = x + y;
            System.out.println(ans);
        }

     }
}
