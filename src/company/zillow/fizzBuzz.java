package company.zillow;


/**
 * Created by zhang on 2018/9/23.
 */
public class fizzBuzz {
    public static void main(String[] args){


        // without if
        for (int i = 0; i <= 100; i++){
            String s = "";
            s = i % 15 == 0 ? "FizzBuzz" : (i % 3 == 0) ? "Fizz" : (i % 5 == 0) ? "Buzz" : "noraml Number";
            System.out.println("number " + i + "  is " + s);
        }

        //if
        for (int i = 0; i <= 100; i++){
            if (i % 15 == 0)
                System.out.println("number  " + i + "  is FizzBuzz" );
            else if (i % 3 == 0){
                System.out.println("number  " + i + "  is Fizz" );
            }else if(i % 5 == 0)
                System.out.println("number  " + i + "  is Buzz" );
            else
                System.out.println("number  " + i + "  is not normal number" );
        }

        // Not using "%" operation
        int n = 100;
        int fizz = 3, buzz = 5, fizzbuzz = 15;
        for(int i = 1;i <= n ;i++){
            if (i == fizzbuzz){
                System.out.println("number  " + i + " is fizzbuzz");
                fizz = fizzbuzz + 3;
                buzz = fizzbuzz + 5;
                fizzbuzz += 15;
            }else if (i == fizz){
                System.out.println("number  " + i + " is fizz");
                fizz += 3;
            }else if (i == buzz){
                System.out.println("number  " + i + " is buzz");
                buzz += 5;
            }else {
                System.out.println("number  " + i + " is Normal Number");
            }
        }
    }
}
