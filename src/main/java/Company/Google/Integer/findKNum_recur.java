package Company.Google.Integer;

/**
 * Created by zhang on 2018/6/25.
 * 4. 国人小哥，全程中文并且放水。0变01，1变10。第0行是0，第一行是01，
 * 第二行是0110，第三行01101001。。。一直下去问求第k行第j个数是什么，递归On时间On空间搞定拍照走人
 *
 *          0
 *          01
 *          0110
 *          01101001
 *          0110100110010110
 *          0110100110010110...... 01
 */
/**
 * 第四题可以二分写的，O(K)复杂度，假如从 0 1开始向下走，最后一层有64个，
 * 如果你要找的j小于32则j一定是0的后代，否则是1的后代，这样每次扔掉一半，k层走k次。
 * */
public class findKNum_recur {
        public static int intersection(int k, int j) {
            if(k<0 || j<0) return -1;
            int total = 1<<k;  // 0001 ---> 1000 找到第k层 长度

            if(j>=total) return -1;
            if(k==0) return 0;
            if(k==1) return j;
            int[][] arr = {{0, 1}, {1, 0}};
            int idx = 0;
            while(total>=2) {
                total = total>>1;
                if(j>=total) {
                    j -= total;
                    idx = arr[idx][1];
                } else {
                    idx = arr[idx][0];
                }
            }
            return arr[idx][0];
        }
        public static int solution(int k, int j){
            String curS = "01";
            int total = 1 << k;
            int c = (int) Math.pow(2,k);
            for (int i = 2; i<k;i++){
                StringBuilder ss = new StringBuilder(curS);
                curS = curS + ss.reverse().toString();
                if (j <= curS.length()){
                    return curS.charAt(j) - '0';
                }
            }
            return -1;
        }
        public static void main(String[] args) {
            for(int i=10;i<16;++i) {
//                System.out.println(intersection(4, i) + " ");
                System.out.println(solution(4,i));
            }
            System.out.println("");
        }
}
