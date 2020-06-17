package XianQiao.CCI;

/**
 * @Author: Xianqiao
 * @Date: 5/30/20 19:13
 */
public class CCI_3URLify {
    /** Write a method to replace all spaces in a string with '%20'. You may assume that the string
     *  has sufficient space at the end to hold the additional characters, and that you are given the "true"
     * length of the string. (Note: if implementing in Java, please use a character array so that you can
     * perform this operation in place.*/

    /** Solution 1 */
    void replaceSpaces(char[] str, int truelength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < truelength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = truelength + spaceCount * 2;
        if (truelength < str.length) str[truelength] = '\0'; //End Array
        for (i = truelength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }
}
