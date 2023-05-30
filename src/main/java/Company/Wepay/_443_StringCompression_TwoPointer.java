package Company.Wepay;

public class _443_StringCompression_TwoPointer {
    public static void main(String[] args){
    //    compress(new char[]{'a', 'b','b','b','b','b','b','b','b','b','b','b','b','b','b'});
        compressWithOne(new char[]{'a','a','b'});
    }

    public static int compressWithOne(char[] chars) {
        int i = 0, res = 0;
        while (i < chars.length) {
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }
        return res;
    }

    public static int compress(char[] chars) {
        String ans = "";
        int count = 1;
        int i;
        for (i = 0;i < chars.length-1;i++){
            if(chars[i] == chars[i+1]){
                  count++;
            }else{
                if(count > 1)
                    ans += chars[i]+ "" + count;
                else 
                    ans += chars[i];
                count = 1;
            }
        }

        if(count > 1)
            ans += chars[i]+""+count;
        else 
            ans += chars[i];

        int k=0;
        for(char c1: ans.toCharArray()){
            chars[k++]=c1;
        }

        return ans.length();
    }
}
