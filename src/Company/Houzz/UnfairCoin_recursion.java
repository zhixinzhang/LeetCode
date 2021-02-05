package Company.Houzz;

/**
 * Created by zhang on 2018/1/22.
 */
public class UnfairCoin_recursion {
    int foo() // given method that returns 0 with 60% probability and 1 with 40%
    {
        // some code here
        return 0;
    }

    // returns both 0 and 1 with 50% probability
    int my_fun()
    {
        int val1 = foo();
        int val2 = foo();
        if (val1 == 0 && val2 == 1)
            return 0;   // Will reach here with 0.24 probability
        if (val1 == 1 && val2 == 0)
            return 1;   // // Will reach here with 0.24 probability
        return my_fun();  // will reach here with (1 - 0.24 - 0.24) probability
    }

    int main()
    {
//        printf ("%d ", my_fun());
        return 0;
    }
}
