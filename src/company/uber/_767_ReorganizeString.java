package company.uber;

/**
 * Created by zhang on 2018/9/18.
 * 首先计算最多的character 先放最多的character
 * 然后按照idx放其余的
 */
public class _767_ReorganizeString {
    public static void main(String[] args){
        reorganizeString("aabcccdef");
        // abacdc
    }

    public static String reorganizeString(String S) {
        char ch[] = new char[26];
        int max = 0;
        for(char c: S.toCharArray()) {
            ch[c - 'a'] ++;
            if(ch[c-'a'] > ch[max])
                max = c - 'a';
        }
        int len = S.length();
        if(len < 2 * ch[max] - 1) return "";
        int index = 0;
        char []res = new char[len];
        for(int i = 0 ; i < ch[max]; i++) {
            res[index] = (char)(max + 'a');
            index += 2;
        }
        ch[max] = 0;
        for(int i = 0 ; i < 26; i++) {
            int count = ch[i];
            while(count > 0 ) {
                if(index >= len ) index = 1;
                res[index] = (char)(i + 'a');
                index += 2;
                count --;
            }
        }

        return new String(res);
    }
}
