//package String;
//import java.util.*;
//
////先求最大公约数 在一个个相加
//public class _592_FractionAdditionandSubtraction{
//	public String fractionAddition(String expression) {
//    String[] fracs = expression.split("(?=[-+])"); // splits input string into individual fractions
//    String res = "0/1";
//    for (String frac : fracs) res = add(res, frac); // add all fractions together
//    return res;
//}
//
//public String add(String frac1, String frac2) {
//    int[] f1 = Stream.of(frac1.split("/")).mapToInt(DataStructure.Integer::parseInt).toArray(),
//          f2 = Stream.of(frac2.split("/")).mapToInt(DataStructure.Integer::parseInt).toArray();
//    int numer = f1[0]*f2[1] + f1[1]*f2[0], denom = f1[1]*f2[1];
//    String sign = "";
//    if (numer < 0) {sign = "-"; numer *= -1;}
//    return sign + numer/gcd(numer, denom) + "/" + denom/gcd(numer, denom); // construct reduced fraction
//}
//
//// Computes gcd using Euclidean algorithm
//public int gcd(int x, int y) { return x == 0 || y == 0 ? x + y : gcd(y, x % y); }
//}