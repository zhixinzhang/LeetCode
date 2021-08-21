package Company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 7/20/2021 12:47 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

// Loan :
// 2020-01-01 10000 18.48

//  payments
/**
 * 2020-02-01 1000
 * 2020-03-01 1200
 * 2020-04-01 1333.33
 * 2020-05-01 1555.55
 * */


// 2020-01-01 10000 18.48  18.48 / 365 days -> 0.04 (each day interest)
// 2020-02-01  -1000    10000 + (0.04 * 30 days * 10000 -> 10180) - 1000
// Loan : 2020-02-01  9180  18.48
public class Upstart {


    public static void main(String[] args) throws Exception{
        String path1 = "D:\\IdeaProjects\\LeetCode\\src\\Company\\loan_tape.txt";
        String path2 = "D:\\IdeaProjects\\LeetCode\\src\\Company\\payments.txt";
        double ans = calculate(path1, path2);
        System.out.println("total principal is  : "  + ans);
    }


    private static double calculate(String loanPath, String paymentPath) throws Exception{
        FileInputStream loanFile =  new FileInputStream(loanPath);
        BufferedReader bf = new BufferedReader(new InputStreamReader(loanFile));
        String startDate = "";
        double principal = 0.00;
        double rate = 0.00;  //
        double dailyRate = 0.00;
        String strLine;
        while ((strLine = bf.readLine()) != null){
            String[] info = strLine.split(" ");
            startDate = info[0];
            principal = Double.valueOf(info[1]);
            rate = Double.valueOf(info[2]);
        }
        loanFile.close();
        dailyRate = rate / 100 / 365;
        System.out.println("dailyRate is  : "  + dailyRate);

        // 2020-01-01 10000 18.48  18.48 / 365 days -> 0.04 (each day interest)
        // 2020-02-01  -1000    10000 + (0.04 * 30 days * 10000 -> 10180) - 1000
        FileInputStream paymentFile =  new FileInputStream(paymentPath);
        bf = new BufferedReader(new InputStreamReader(paymentFile));
        double income = 0.00;
        String payLine;
        String currentDate;
        while ((payLine = bf.readLine()) != null){
            String[] info = payLine.split(" ");
            currentDate = info[0];
            double curPayment = Double.valueOf(info[1]);

            int dayPassed = Math.abs(Integer.valueOf(currentDate) - Integer.valueOf(startDate));
            startDate = currentDate;
            if (principal <= 0) {
                principal -= curPayment; // current total principal
            } else {
                income = dayPassed * dailyRate * principal;
                principal += income - curPayment; // current total principal
            }

        }

        return principal;
    }
}
