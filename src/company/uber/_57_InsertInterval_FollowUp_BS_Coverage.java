package company.uber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/9/12.
 * 跟LC 57 一样，BS 最快
 */


public class _57_InsertInterval_FollowUp_BS_Coverage {
    static class Coverage{
        int left;
        int right;
        List<int[]> list = new ArrayList<>();
        public Coverage(){}
        public Coverage(int left, int right){
            this.left = left;
            this.right = right;
        }
        public void addRange(int left, int right){
            if (list.isEmpty())
                list.add(new int[]{left,right});
            else if (list.get(0)[0] > right)
                list.add(0, new int[]{left, right});
            else if (list.get(list.size()-1)[1] < left)
                list.add(new int[]{left,right});
            else{
                int startIdx = findL_bs(left);
                int endIdx = findR_bs(right);
                if (startIdx == endIdx){
                    // put new array element(minleft, maxright)
                    list.set(startIdx, new int[]{Math.min(left, list.get(startIdx)[0]), Math.max(right, list.get(startIdx)[1])});
                }else {
                    List<int[]> cur = new ArrayList<>();
                    for (int i = 0; i < startIdx; i++)
                        cur.add(list.get(i));
                    cur.add(new int[]{Math.min(left, list.get(startIdx)[0]), Math.max(right, list.get(endIdx)[1])});
                    for (int i = endIdx + 1; i < list.size(); i++)
                        cur.add(list.get(i));
                    list = cur;
                }
            }
        }

        public void print(){
            for (int i = 0; i < list.size(); i++){
                System.out.print("(" + list.get(i)[0] + "," + list.get(i)[1] + ")");
            }
        }

        public int findL_bs(int val){
            int l = 0, r = list.size()-1, mid;
            while (l <= r){
                mid = l + (r - l) / 2;
                int[] curCov = list.get(mid);
                if (curCov[0] <= val || curCov[1] >= val)
                    return mid;
                if (curCov[0] > val)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            return l;
        }
        public int findR_bs(int val){
            int l = 0, r = list.size()-1, mid;
            while (l <= r){
                mid = l + (r - l) / 2;
                int[] curCov = list.get(mid);  // 1  3    8  9     7
                if (curCov[0] <= val && curCov[1] >= val)
                    return mid;
                if (curCov[1] < val)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            return l;
        }
    }

    public static void main(String[] args){
        Coverage c = new Coverage();
        c.addRange(1, 4);
        c.addRange(7, 10);
        c.addRange(13, 16);
        c.addRange(18, 20);

        c.addRange(8, 17);
        c.print();
    }
}
