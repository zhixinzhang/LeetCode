package DataStructure.String;

/**
 * Created by zhang on 2018/4/29.
 *
 * 思路：刚一看这个题的时候没有思路，知道应该是用dfs或backtracking一类的算法，但是不知道如何下手，只好看答案，看了答案之后恍然大悟，其实很简单。
 解题的关键在于确定前两个数，只要确定了前两个数，后面的数可以依次计算出来，要么符号条件要么不符合条件。那么如何确定前两个数？
 首先分析如何确定第一个数，第一个数的最小的长度是1（只包含一个数字），最大的长度是（L-1）/2，其中L为字符串的长度，最大的长度一定小于总长度的一半，比如如果总长度是5，第一个数长度不能超过2，如果总长度是6，第一个数长度也不能超过2，所以最大的长度是（L-1）/2,。
 再确定第二个数的范围，第二个数从第一个数后面开始，第三个数从第二个数后面开始，我们首先知道，第三个数肯定至少和第一个数与第二个数一样大，因为是和嘛，若第二个数从i开始到j-1结束，那么第三个数长度最大为L-j，这个长度一定大于等于第一个数和第二个数长度的较大者，即：L-j>=i && L-j>=j-i。
 */
//https://blog.csdn.net/x_i_y_u_e/article/details/50724390
public class _306_AdditiveNumber_recursion {
    public boolean isAdditiveNumber(String num) {
        int L = num.length();
        //确定第一个数，最终用num.subStr(0,i)来确定第一个数，所以i可以用来标示第一个数的长度，
        //但是下标i不包含在第一个数中
        for(int i=1;i<=(L-1)/2;i++){

            //如果长度大于等于2，则不能以0开头
            if(num.startsWith("0") && i>=2) break;

            //确定第二个数，第一个数用num.subStr(i,j),包括i，不包括j，所以长度为j-i,
            //第三个数从下标j开始，长度最长为L-1-j+1，即L-j
            for(int j=i+1;(L-j)>=i && (L-j)>=j-i;j++){
                if(num.charAt(i)=='0' && j-i>=2) break;

                long num1 = Long.parseLong(num.substring(0,i));
                long num2 = Long.parseLong(num.substring(i,j));

                if(isAdditive(num.substring(j), num1, num2)){
                    return true;
                }
            }
        }
        return false;
    }

    //判断由num1,num2和后续的字串能否构成加法序列
    public boolean isAdditive(String remain,long num1,long num2){

        if(remain.equals("")) return true;

        long sum = num1+num2;

        String sumStr = ""+sum;
        if(!remain.startsWith(sumStr)) return false;

        return isAdditive(remain.substring(sumStr.length()), num2, sum);
    }
}
