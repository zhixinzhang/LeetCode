package Company.Attentive;

import java.util.Stack;

public class ExpressionPolish {
    public static void main(String[] args){
        // doCal("( ADD 3 ( MULT 5 6 ) )");
        doCal("( ADD ( ADD 5 6 ) 3 )");   // 14
    }

    private static void doCal(String s){
        String newS = s.replaceAll("\\(", "");
        newS = newS.replaceAll("\\)", "");

        String[] sArray = newS.split(" ");   // ADD 3 MULT 5 6

        Stack<Integer> values = new Stack<>();
        Stack<String> operations = new Stack<>();
        int ans = 0;

        for (int i = 0; i < sArray.length; i++){
            String sign = sArray[i].trim();
            if (sign.equals("ADD") || sign.equals("MULT")) {
                operations.add(sign);
            } else if (sign.equals(" ") || sign.equals("")){
                continue;
            } else {
                Integer val = Integer.valueOf(sign);
                String op = operations.peek();
                if (values.isEmpty()) {
                    values.add(val);
                } else {
                    if (i != sArray.length - 1 && (sArray[i + 1] == "")) {
                        i++;
                    }
                    if (i != sArray.length - 1 && (sArray[i + 1] != "ADD" || sArray[i + 1] != "MULT")) {
                        i++;
                        Integer val2 = Integer.valueOf(sArray[i].trim());
                        
                        if (op.equals("ADD")) {
                            val += val2;
                        } else {
                            val *= val2;
                        }
                        ans = val;
                        values.add(val);
                        operations.pop();
                    } else {
                        values.add(val);
                    }
                }
            }
        }


        String preOp = operations.pop();
        int val2 = values.pop();
        int val = values.pop();
        if (preOp.equals("ADD")) {
            val += val2;
        } else {
            val *= val2;
        }
        ans = val;
        System.out.println(ans);
        
    }
}
