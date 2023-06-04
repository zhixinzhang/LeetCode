package Company.Square.OOP;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class SimilarCouponDesign {
    static class Coupon{
        String id;
        String name;
        public Coupon(String id, String name){
            this.id = id;
            this.name = name;
        }
    }

    static class Customer{
        String id;
        double similarity;
        int[] coups;
        public Customer(String id){
            this.id = id;
            coups = new int[5];
        }
    }
    
    public static void main(String[] args) {
        
        
    }

    private static List<Coupon> matchCustomer(Customer c1, List<Customer> customers){
        List<Coupon> ans = new ArrayList<>();
        PriorityQueue<Customer> minPQ = new PriorityQueue<Customer>(new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2){
                return Double.compare(c2.similarity, c1.similarity);
            }
        });

        for (Customer c2 : customers){
            double similarity = findSimilarity(Integer.valueOf(c1.id), Integer.valueOf(c2.id));
            c2.similarity = similarity;
            minPQ.add(c2);
            if (minPQ.size() > 3) {
                minPQ.poll();
            }
        }

        
        while (!minPQ.isEmpty()){
            Customer c = minPQ.poll();
            int[] coups = c.coups;
            
            for (int i = 0; i < coups.length; i++){
                if (coups[i] == 1) {
                    // ans.add(c.coups);
                }
            }
        }


        return ans;
    }

    private static double findSimilarity(int a, int b){
        Random r = new Random();
        double ans = r.nextDouble(a, b);
        return  ans;
    }
}
