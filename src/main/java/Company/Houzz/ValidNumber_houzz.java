package Company.Houzz;

/**
 * Created by zhang on 2018/1/22.
 */
public class ValidNumber_houzz {
    public static void main(String[] args)throws Exception{
        valid("12.34x59");
        valid("12.34 59");
        valid("1 2.3459");
        valid("12.34.59");
        valid("-1.234");
    }
    public static float valid (String s) throws Exception{
        Exception e = new Exception();
        StringBuilder sb = new StringBuilder();
        int neagtive = 1;
        int left, right;
        for (int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if ((c =='+' || c =='-') && i != 0 || i == 0 && c =='0' )
                throw new Exception("invalid number");
            if (Character.isDigit(c)){

            }
        }
        return neagtive;
    }
}
