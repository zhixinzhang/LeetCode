//package String;
//import java.util.*;
//
//public class _639_DecodeWays2_DP{
//	public int NumDecodings(string s) {
//        if (s.length == 0 || s[0] == '0') return 0;
//
//        long dp0 = 1, dp1 = s[0] == '*' ? 9 : 1;
//
//        for (int i = 1; i < s.Length; i++)
//        {
//            long dp2 = 0;
//
//            if (s[i - 1] == '*')
//            {
//                if (s[i] == '*')
//                {
//                    dp2 = dp0 * (9 + 6) + 9 * dp1;
//                }
//                else if ((int)s[i] <= (int)'6')
//                {
//                    dp2 = dp0 * 2 + (s[i] == '0' ? 0 : dp1);
//                }
//                else
//                {
//                    dp2 = dp0 + dp1;
//                }
//            }
//            else
//            {
//                if (s[i] == '*')
//                {
//                    if (s[i - 1] == '1')
//                    {
//                        dp2 = dp0 * 9 + dp1 * 9;
//                    }
//                    else if (s[i - 1] == '2')
//                    {
//                        dp2 = dp0 * 6 + dp1 * 9;
//                    }
//                    else
//                    {
//                        dp2 = dp1 * 9;
//                    }
//                }
//                else
//                {
//                    var decode = ((int)s[i - 1] - (int)'0') * 10 + ((int)s[i] - (int)'0');
//                    if (decode >= 10 && decode <= 26)
//                    {
//                        dp2 = dp0;
//                    }
//
//                    if (decode % 10 != 0)
//                    {
//                        dp2 += dp1;
//                    }
//                }
//
//            }
//
//            dp0 = dp1 % (1000000007);
//            dp1 = dp2 % (1000000007);
//        }
//
//        return (int)(dp1 % (1000000007));
//    }
//}