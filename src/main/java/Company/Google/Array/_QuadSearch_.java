package Company.Google.Array;

/**
 * Created by zhang on 2018/8/8.
 */
public class _QuadSearch_ {
    public long quad(int x, int y){
        int res = 0;
        long len = (long) Math.pow(2,16);
        long start = 0, end = len * len - 1;
        int[] leftUp = {0, 0};
        int[] rightDown = {65535, 65535};// 2 ^ 16 - 1
        while (start < end){
            int[] mid = new int[2];
            mid[0] = (leftUp[0] + rightDown[0]) / 2;
            mid[1] = (leftUp[1] + rightDown[1]) / 2;
            int area = 0;
            if (x > mid[0]) {
                if (y > mid[1]) area = 3; //落在右下
                else area = 0;//左下。
            }
            else {
                if (y > mid[1]) area = 2;//右上
                else area = 1;//左上
            }
            //更新start end
            start = ((end - start + 1) / 4) * area + start;
            end = ((end - start + 1) / 4) * (area + 1) - 1 + start;
            if (area == 0) {
                leftUp[0] = mid[0] + 1;
                rightDown[1] = mid[1];
            }
            else if (area == 1) {
                rightDown[0] = mid[0];
                rightDown[1] = mid[1];
            }
            else if (area == 2) {
                leftUp[1] = mid[1] + 1;
                rightDown[0] = mid[0];
            }
            else {
                leftUp[0] = mid[0] + 1;
                leftUp[1] = mid[1] + 1;
            }
        }
        return start;
    }
}
