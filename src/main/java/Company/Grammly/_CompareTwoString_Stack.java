package Company.Grammly;

public class _CompareTwoString_Stack {
    public static void main(String[] args){
        compareStrings("abb**", "a");
    }

    private static void compareStrings(String s1, String s2){
        if (s1.equals(s2)) {
            System.out.println("yes");
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s1.toCharArray()){
            if (c != '*') {
                sb.append(c);
            } else if (sb.length() != 0){
                sb.deleteCharAt(sb.length() - 1);
            } 
        }

        String ans = sb.toString();
        System.out.println(ans.compareTo(s2));
    }
}
