package Company.Square.Algo;

public class _528_RandomPickWithWeight_BS {
    static private int[] prefixSums;
    static private int totalSum;

    public static void _528_RandomPickWithWeight_BS(int[] w) {
        prefixSums = new int[w.length];

        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            prefixSums[i] = prefixSum;
        }
        totalSum = prefixSum;
    }

    public static int pickIndex() {
        double target = totalSum * Math.random();

        // run a binary search to find the target zone
        int low = 0, high = prefixSums.length;
        while (low < high) {
            // better to avoid the overflow
            int mid = low + (high - low) / 2;
            if (target > prefixSums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        
        return low;
    }

    public static void main(String[] args){
        _528_RandomPickWithWeight_BS(new int[]{1, 3});
        pickIndex();
    }
}
