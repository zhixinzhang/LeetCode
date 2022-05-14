package Company.PG;

/**
 * Created by zhang on 2018/1/28.
 * 如果一个点在三角形内，其与三角形的三个点构成的三个子三角形的面积等于大三角形的面积。否则，大于大三角形的面积。
 * 2）向量法：先求出这个三角形的对应的平行四边形的面积。然后这个面积的1/2就是三角形的面积了。

   先随意选择两个点，如B、C通过其坐标相减得向量（B，C）。记得谁减另一个就是指向谁。然后求出其中一个点和剩下一个点的向量。这两个向量的叉乘的便是平行四边形的面积。除以2就是三角形的面积。
 （注意这里是叉乘 (cross product)，而非点乘（dot product））
 */
public class _IsPointInTriangle_Area {
     static class POINT {
        int x;
        int y;

        public POINT(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final double ABS_DOUBLE_0 = 0.0001;

    public static boolean isInTriangle(POINT A, POINT B, POINT C, POINT P) {
        double ABC = triAngleArea(A, B, C);
        double ABp = triAngleArea(A, B, P);
        double ACp = triAngleArea(A, C, P);
        double BCp = triAngleArea(B, C, P);
        double sumOther = ABp + ACp + BCp;
        if (-ABS_DOUBLE_0 < (ABC - sumOther) && (ABC - sumOther) < ABS_DOUBLE_0) {// 若面积之和等于原三角形面积，证明点在三角形内
            return true;
        } else {
            return false;
        }
    }

    private static double triAngleArea(POINT A, POINT B, POINT C) {// 由三个点计算这三个点组成三角形面积
        POINT ab, bc;
        ab = new POINT(B.x - A.x, B.y - A.y);//
        bc = new POINT(C.x - B.x, C.y - B.y);
        return Math.abs((ab.x * bc.y - ab.y * bc.x) / 2.0);
    }

}
