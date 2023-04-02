package Company.Google;

/**
 * Created by zhang on 2018/6/9.
 */
public class _408_ValidWordAbbreviation_forLoop {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word == null || abbr == null || abbr.length()>word.length()) return false;
        int num = 0, idx = 0;
        for (char c : abbr.toCharArray()){
            if (c == '0' && num == 0)    return false;
            if (c >= '0'){
                num = num*10 + c-'0';
            }else {
                idx += num;
                if(idx >= word.length() || c != word.charAt(idx)) return false;
                num = 0;
                idx++;
            }
        }
        return idx+num == word.length() ? true : false;
    }
}
