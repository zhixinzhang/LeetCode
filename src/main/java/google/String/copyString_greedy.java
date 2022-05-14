package google.String;


/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/30/19
 * Time: 12:37 AM
 * Description:
 * https://www.1point3acres.com/bbs/thread-519652-1-1.html
 * https://www.1point3acres.com/bbs/thread-507548-2-1.html
 */

// source  aabd  target aaabbbdd
public class copyString_greedy {
    public static void main(){

    }
    public static int solve(String source, String target){
//        HashMap<Character, DataStructure.Integer> freq = new HashMap<>();
        int indexT = 0, indexS = 0;
        int lenT = target.length(), lenS = source.length();

        while (indexT < lenT){
            char c = source.charAt(indexS % lenS);
            if (c == target.charAt(indexT)){
                indexT++;
                indexS++;
            }else{
                indexS++;
            }
        }
        if (indexS % lenS == 0) return indexS / lenS;
        else return indexS / lenS + 1;
    }
}
