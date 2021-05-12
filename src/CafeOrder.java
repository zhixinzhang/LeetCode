import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 5/10/2021 10:29 PM
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
 *
 * What would you like? banana
 * What would you like? cakePoP
 * What would you like? latte
 * What would you like? bagel
 * What would you like? banana
 * What would you like? CHeckOUT
 * You ordered: banana, cakePoP, latte, bagel, banana, 5 items total
 */

public class CafeOrder {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String outPut = "You ordered: ";
        int count = 0;
        cafeOrder(console, outPut, count);
    }

    // TODO: Your Code Here -> Write a method
    // called cafeOrder for this problem
    public static void cafeOrder(Scanner console, String outPut, int count){

        String categories;
        System.out.print("What would you like? ");
        categories = console.nextLine();
        String text =  categories.toLowerCase();
        if (text.equals("checkout")){
            outPut += count + " items total";
            System.out.println(outPut);
            outPut = "";
            count = 0;
            return;
        } else {
            count++;
            outPut += categories + ", ";
            cafeOrder(console, outPut, count);
        }

        return;
    }

//    public static void cafeOrder(Scanner console){
//        String output ="You ordered: ";
//        int count = 0;
//        while (console.hasNextLine()){
//            String value = console.nextLine().toLowerCase();
//            if (value == "checkout") {
//                output += count + " items total";
//                System.out.println(output);
//                return;
//            } else {
//                output += value + ", ";
//            }
//            count ++;
//        }
//    }
}
