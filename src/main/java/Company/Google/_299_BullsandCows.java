package google;

/**
 * Created by zhang on 2018/5/9.
 */
public class _299_BullsandCows {
    public static String getHint(String secret, String guess) {
        int[] count = new int[10];
        // 1123   [0,2,1,1,0.....]
        int right = 0, wrong = 0;
        for(int i = 0; i<guess.length();  i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            int idxG = g - '0';
            int idxS = s - '0';
            if(s == g) {
                right++;
            }else{      // 1 1 2 2
                        // 1 2 2 2
                if (count[idxS] < 0 ) wrong++;
                if (count[idxG] > 0) wrong++;
                count[idxG]--;
                count[idxS]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(right)).append('A').append(String.valueOf(wrong)).append('B');
        return sb.toString();
    }
    public static void main(String[] args){
        getHint("1122","1222");
    }
}
