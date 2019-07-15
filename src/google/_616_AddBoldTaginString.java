package google;

/**
 * Created by zhang on 2018/5/15.
 */
public class _616_AddBoldTaginString {
    public static String addBoldTag(String s, String[] dict) {
        StringBuilder sb = new StringBuilder();
        if(s == null || s.length() == 0)    return sb.toString();
        int right = 0;
        for(String curS : dict){        // O(m)
            int i = s.indexOf(curS);
            int ii = i + curS.length()-1;       // a a a   // aab 1
            if ( right + 1 == i){
                sb.append(curS);  //<b>aaa
                right = right + curS.length();
                continue;
            }
            if (i >= right) {
                if (sb.length() == 0)
                    sb.append("<b>").append(curS);  //<b>aaa
                else{
                    sb.append("</b>");
                    String cc = s.substring(right+1,i);
                    sb.append(cc);
                }
                right = ii;                         // right = 2  i = 1
            }else if (i < right && ii > right){   //aaa aab   overloop
                int over = right - i + 1;
                String cc = curS.substring(over,curS.length());
                sb.append(cc);
                right = ii;
            }
        }
        if (right  < s.length()-1){
            sb.append("</b>");
        }
        String cc = s.substring(right+1, s.length());
        return sb.append(cc).toString();
    }
    public static void main(String[] args){
        addBoldTag_best("aaabbcc",new String[]{"aaa","aab","bc"});
//        addBoldTag_best("abcxyz123",new String[]{"abc","123"});
    }
    public static String addBoldTag_best(String S, String[] dict) {
        StringBuilder sb = new StringBuilder();
        int[] s = new int[S.length()+1];        // [00000010] 1 mean we should bold the character
        for (String word : dict){
            int left = S.indexOf(word);
            int right = left + word.length()-1;
            while (left <= right){
                s[left] = 1;
                left++;
            }
        }
        int flag = 0;
        if (s[0] == 1) {
            sb.append("<b>");
            flag = 1;
        }
        for (int i = 0; i<s.length; i++){
            if (i < S.length()){
                if (s[i] == 0 && flag == 0){
                    sb.append(S.charAt(i));
                    continue;
                }else if(s[i] == 0 && flag == 1){
                    sb.append("</b>");
                    flag = 0;
                }else if(s[i] == 1 && flag == 0){
                    sb.append("<b>");
                    flag = 1;
                }
                    sb.append(S.charAt(i));
            }

        }
        return sb.toString();
    }
    }
