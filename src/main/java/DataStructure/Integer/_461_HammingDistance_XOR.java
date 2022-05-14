package DataStructure.Integer;

public class _461_HammingDistance_XOR{
	public int hammingDistance_O(int x, int y) {
		if (x == y) return 0;
		int res = 0;
		for(int i = 0; i<31;i++){
			int bx = x % 2;                 // 8     1001
			int by = y % 2;                 // 6     0110
			if(by != bx) res++;
			x = x/2;
			y = y/2;  // 6 3 1 0
		}
		return res;
	}
	public static int hammingDistance(int x, int y) {
	    int xor = x ^ y, count = 0;
	    // find xor 1 numbers
	    for (int i = 0;i < 32;i++) {
//			int c = xor >> i;
//			int b = c & 1;
//			count += b;
	    	count += (xor >> i) & 1;
		}
	    return count;
	}
	public static void main(String[] args){
		hammingDistance(3,10);
		// 0 0 1 1
		// 1 0 1 0
		// 1 0 0 1   xor
	}
	
}