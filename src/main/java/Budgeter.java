import java.util.*;

public class Budgeter {
    public static void main(String[] args){
        double totalIncome, totalExpense;
        Scanner sc = new Scanner(System.in);
        opening();
        totalIncome = GetTotalIncome(sc);
        totalExpense = GetTotalExpense(sc);
        printInfo(totalIncome,totalExpense);
    }
    public static void opening(){
        System.out.println("This program asks for your monthly income and\n" +
                "expenses, then tells you your net monthly income.");
    }
    private static double GetTotalIncome(Scanner sc){
        int categories;
        double sum = 0;
        System.out.print("How many categories of income? ");
        categories = sc.nextInt();
        for(int i = 0; i<categories; i++){
            System.out.print("    Next income amount? $");
            sum+= sc.nextDouble();
        }
        return sum;
    }
    public static double GetTotalExpense (Scanner sc){
        int choice;
        int categories;
        double sum = 0;
        System.out.print("Enter 1) monthly or 2) daily expenses? ");
        choice = sc.nextInt();
        if(choice == 1){
            System.out.print("How many categories of expense? ");
            categories = sc.nextInt();
            for(int i = 0; i<categories; i++){
                System.out.print("Next expense amount? $");
                sum = sum + sc.nextDouble();
            }
        }
        if(choice == 2){
            System.out.print("How many categories of expense? ");
            categories = sc.nextInt();
            for(int i=0; i<categories;i ++){
                System.out.print("    Next expense amount? $");
                sum = sum + sc.nextDouble();
            }
            sum*= 31;
        }
        return sum;
    }
    private static void printInfo(double totalIncome, double totalExpense){
        double diff = totalIncome - totalExpense;
        System.out.printf("Total income = $%.2f ($%.2f/day)%n ", totalIncome, (totalIncome/31));
        System.out.printf("Total expenses = $%.2f($%.2f/day)%n ", totalExpense,(totalExpense/31));
        if(diff>0){
            System.out.printf("You earned $%.2f more than you spent this month.%n", diff);
            if(diff>250)
                System.out.println("You are a big saver.");
            else
                System.out.println("You are a saver.");
        }
        else{
            diff = diff * -1;
            // I found this line very useful in turing it back to possitive
            System.out.printf("You spent $ $%.2f more than you earned this month.%n", diff);
            if(diff>=-250 && diff<0)
                System.out.println("You're a spender.");
            else
                System.out.println("You're a big spender.");
        }
    }
}
