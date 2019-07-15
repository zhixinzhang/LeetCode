package DataStructure.String;

/**
 * Created by zhang on 2018/1/14.
 */
public class findSubString {
    public static void main(String[] args){
    firstOccurrence("juliansamanthasamanth","ant*as");
    }
    public static int firstOccurrence(String s, String x) {
        int res = 0;
        for(int i= 0; i < s.length() ;i++){
            for(int j = 0; j<x.length(); j++){
                Character curS = s.charAt(i);
                Character curX = x.charAt(j);
                res = i;
                int curidx = i;
                while(curS == curX || curX == '*'){
                    curidx++;
                    j++;
                    if(j == x.length())
                        break;
                    curS = s.charAt(curidx);
                    curX = x.charAt(j);
                }
                break;
            }

        }

        return res;
    }

}
