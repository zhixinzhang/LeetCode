package Company.Sony;

/**
 * @author Luke Zhang
 * @Date 2021-05-03 16:27
 *
 * https://leetcode.com/problems/excel-sheet-column-number/solution/
 */
public class _171_ExcelSheetColumnNumber_26Decimal {

    public int titleToNumber(String s) {
        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            result = result * 26;
            // In Java, subtracting characters is subtracting ASCII values of characters
            result += (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
