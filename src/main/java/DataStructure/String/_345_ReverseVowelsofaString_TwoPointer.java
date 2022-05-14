package DataStructure.String;

/**
 * Created by zhang on 2018/5/1.
 */
public class _345_ReverseVowelsofaString_TwoPointer {
        public static String reverseVowels(String s) {
            if (s == null || s.length() == 1)   return s;
            char[] arr = s.toCharArray();
            String vowls = "AEIOUaeiou";
            for (int i = 0, j = arr.length-1; i<j;){
                while (vowls.indexOf(arr[i]) == -1 && i<j){
                    i++;
                }
                while (vowls.indexOf(arr[j]) == -1 && j > i){
                    j--;
                }
                if(i < j && arr[i] != arr[j]){
                    char temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                i++;
                j--;
            }
            return String.valueOf(arr);
        }
        ;public static void main(String[] args) {
            reverseVowels("leetcode");
        }


    }
