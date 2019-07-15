package company.Houzz;

/**
 * Created by zhang on 2018/1/17.
 */
//20 = 2 * 2 * 5
    //2 * 47
public class PrimeDivid {
    public static void main(String[] args){
//        System.out.println(resolvePrime(1764));
        // 2*2*2*2*5*5*5*11*19 = 418000
//        System.out.println(resolvePrime_pow(418000));
        System.out.println(resolvePrime_reverse(1764));

    }

    public static String resolvePrime(int num) {
        StringBuilder res = new StringBuilder();
        int prime = 2;    //smallest prime
        while(num >= prime){
            if(num % prime == 0){    //  10 % 2 == 0
                num /= prime;
                res.append(prime + "*");   // 2*
            }else {
                prime ++;   // find next prime
            }
        }
        return res.toString().substring(0,res.toString().length()-1);
    }
    public static String resolvePrime_pow(int num) {
            StringBuilder res = new StringBuilder();
            int prime = 2;
            int countPrime = 0;
            while (num >= prime){
                if (num % prime == 0){
                    num /= prime;
                    countPrime ++;
                }else{
                    if (countPrime == 1)
                        res.append(prime).append('*');
                    else if (countPrime != 0)
                        res.append(prime).append('^').append(countPrime).append('*');
                    prime ++;
                    countPrime = 0;
                }
            }
            if (countPrime == 1)
                res.append(prime);
            else if (countPrime != 0)
                res.append(prime).append('^').append(countPrime);
            return res.toString();
        }

    public static String resolvePrime_reverse(int num) {
        StringBuilder res = new StringBuilder();
        int prime = 2;
        int countPrime = 0;
        while (num >= prime){
            if (num % prime == 0){
                num /= prime;
                countPrime ++;
            }else{
                StringBuilder curRes = new StringBuilder();
                if (countPrime == 1)
                    curRes.append(prime).append('*').append(res);
                else if (countPrime != 0)
//                    if (res.length()!=0)
                        curRes.append(prime).append('^').append(countPrime).append('*').append(res);
//                    else
//                        curRes.append(prime).append('^').append(countPrime);
                prime ++;
                if (countPrime != 0)
                    res = curRes;
                countPrime = 0;
            }
        }
//        int c = res.lastIndexOf("*");
        if (res.lastIndexOf("*") == res.length()-1)
            res.replace(res.length()-1,res.length(),"");
        String r = "";
        if (countPrime == 1)
            r = prime + "*" + res.toString();
//            res.append(prime);
        else if (countPrime != 0)
            r = prime + "*" + countPrime + res.toString();
        return r;
    }
}