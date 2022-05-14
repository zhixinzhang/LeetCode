package DataStructure.Integer;

/**
 * @author Luke(New Man) Zhang
 * @Date 2/5/2021 12:00 AM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 */

public class _168_ExcelSheetColumnTitle_StringBuilder {
    public String convertToTitle(int n){
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            result.append((char)('A' + n % 26));
            n /= 26;
        }
        result.reverse();
        return result.toString();
    }
}
