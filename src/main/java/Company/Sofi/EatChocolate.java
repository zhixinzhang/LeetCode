package Company.Sofi;

import java.util.PriorityQueue;

public class EatChocolate {
    public static void main(String[] args) {
        int[] cho = new int[]{10, 5, 8, 4, 11, 21};
        eatCho(cho, 4);
    }

    private static double eatCho(int[] cho, int k){
        PriorityQueue<Double> pq = new PriorityQueue<>((a,b) -> (b.compareTo(a)));
        for (int c : cho){
            pq.add(Double.valueOf(c));
        }
        double ans = 0;
        while(k > 0){
            k--;
            double value = pq.poll() / 2;
            System.out.println(value);
            ans += value;
            pq.add(value);
        }

        System.out.println(ans);
        return ans;
    }
}
