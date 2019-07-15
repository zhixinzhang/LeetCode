package DataStructure.Array;


//注意：就是判断四个坐标能否构成一个正方形，注意这四个坐标是乱序的，因此你无法确定哪两个坐标处于对角线位置。思路是计算两两坐标之间的距离，并将它们存储，如果是正方形应当只有两种长度的距离，以此为判断正方形的根据（如果坐标都为整数，
//那么等边三角形加上外心这种情况似乎是不会出现的，如果还有问题请指正）。注意判断距离为0的情况
public class _593_ValidSquare{
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d1 = getDist(p1, p2);
        if (d1 == 0 || d1 != getDist(p3, p4)) return false;
        int d2 = getDist(p1, p3);
        if (d2 == 0 || d2 != getDist(p2, p4)) return false;
        int d3 = getDist(p1, p4);
        if (d3 == 0 || d3 != getDist(p2, p3)) return false;
        if (d1 == d2 || d1 == d3 || d2 == d3) return true;
        return false;
    }
    
    private int getDist(int [] p1, int [] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}