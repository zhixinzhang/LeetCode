package DataStructure.Integer;

/**
 * @author Luke Zhang
 * @Date 2021-05-09 19:00
 */
public class _273_IntegertoEnglishWords_Iteerative {

    public static void main(String[] args){
        numberToWords(1999999);
    }
    private static final String[] map1 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] map2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] map3 = {"", " Thousand", " Million", " Billion"};


    public static String numberToWords(int num) {
        if (num == 0) return "Zero";

        int weight = 0;
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int n = num % 1000;
            String s = getEng(n);

            if(s.length() != 0) {
                sb.insert(0, " " + s + map3[weight]);
            }
            weight++;
            num = num / 1000;
        }

        return sb.toString().trim();
    }

    public static String getEng (int num) {
        if (num == 0)
            return "";

        StringBuilder sb = new StringBuilder();

        int h = num / 100;
        if(h != 0) {
            sb.append(map1[h] + " " + "Hundred");
        }

        num = num % 100;
        if(num < 20) {
            sb.append(" " + map1[num]);
            return sb.toString().trim();
        }


        int t = num / 10;
        if(t != 0) {
            sb.append(" " + map2[t]);
        }
        num = num % 10;
        if(num != 0) {
            sb.append(" " + map1[num]);
        }

        return sb.toString().trim();
    }
}
