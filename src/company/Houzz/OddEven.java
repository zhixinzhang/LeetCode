package company.Houzz;

/**
 * Created by zhang on 2018/1/19.
 */
public class OddEven {
    public static void main(String[] args){
        maximumCycleLength(1,3);
    }
    public static int maximumCycleLength(int minN, int maxN) {
        int maxCycle = 0;
        for (; minN <= maxN; ++minN) {
            int c = minN;
            maxCycle = Math.max(maxCycle, cycleLength(minN));
        }
        return maxCycle;
    }

    /**
     * Calculates the cycle length for the provided {@code n}.
     *
     * @param n The value of {@code n} for which the
     * @return The cycle length for the provided {@code n}.
     */
    public static int cycleLength(int n) {
        //4 - 2 - 1
        //3 - 10 - 5 - 16 - 8 - 4 - 2 - 1
        int cycles = 0;
        while (n != 1) {
            n = (n % 2 == 0) ? n / 2 : 3*n + 1;
            cycles += 1;
        }
        return cycles;
    }
}
