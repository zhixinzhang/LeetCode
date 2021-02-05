package Company.zillow;

/**
 * Created by zhang on 2018/9/23.
 */
// 有多个重复的character 找第一个
// 所以在int[] 里存index 然后找到最小的index
public class _387_findFirstUniqueCharacter_ {

    public static void main(String[] args){
        System.out.println(find("loveleetcode"));
    }

    public static char find(String s){
        if (s == null || s.length() == 0)
            return ' ';
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++){
            if (arr[s.charAt(i) - 'a'] == 0){
                arr[s.charAt(i) - 'a'] = i;
            }else {
                arr[s.charAt(i) - 'a'] = -1;        // duplicate
            }

        }
        int idx = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++){
            if (arr[i] != 0 && arr[i] != -1){
                idx = Math.min(arr[i],idx);
            }
        }
        return s.charAt(idx);
    }
}
