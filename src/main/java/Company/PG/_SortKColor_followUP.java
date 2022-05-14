package Company.PG;

/**
 * Created by zhang on 2018/1/29.
 */
// 排序东西 每个东西有优先级  sort color 的变种 O（n） one pase
// use two pointer left and right
//
public class _SortKColor_followUP {
    static class pack{
        int val;            //priority
        char c;
        public pack(int value, Character c){
            this.val = value;
            this.c = c;
        }
    }
    public static void sortPack(pack[] packs){
        // c d b a b a d c
        // a a b b c c d d
        if (packs == null || packs.length == 0) return;
        int len = packs.length;
        for (int i = 0; i < len; i++){
            while (packs[i].val > 0){
                int pri = packs[i].val;
                if (packs[pri - 1].val > 0){
                    packs[i] = packs[pri - 1];
                    packs[pri - 1].val = -1;
                }else if (packs[pri - 1].val <= 0) {
                    // 2. Bucket is using or the bucket is empty.
                    packs[pri - 1].val--;
                    // delete the A[i];
                    packs[i].val = 0;
                }
            }
        }
        int c = 0;
    }
    private static void swap(pack []colors, int i, int j){
        pack temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
    public static void main(String[] args){
        pack a = new pack(0,'a');
        pack b = new pack(1,'b');
        pack c = new pack(2,'c');
        pack d = new pack(3,'d');
        //c d b a b a d c
//        char[] c = new char[]{c d b a b a d c};
        pack[] arr = new pack[8];
        arr[0] = c;
        arr[1] = d;
        arr[2] = b;
        arr[3] = a;
        arr[4] = b;
        arr[5] = a;
        arr[6] = d;
        arr[7] = c;
        sortPack(arr);
        int r = 0;
    }
}
