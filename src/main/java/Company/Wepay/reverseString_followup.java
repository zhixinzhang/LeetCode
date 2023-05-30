package Company.Wepay;

public class reverseString_followup {
    public static void main(String[] args){
        build("a  b   c    d");
        build("a--b---c----d");
    }

    private static void build(String s){
        String result = "";
        for (int i = s.length()-1;i>=0;i--){
            result = result + String.valueOf(s.charAt(i));
        }
        System.out.println(result);
    }

    public static char[] stringReverseInPlace(char[] string) {
        for(int i = 0, j = string.length - 1; i < string.length / 2; i++, j--) {
            char c = string[i];
            string[i] = string[j];
            string[j] = c;
        }
        return string;
    }
}
