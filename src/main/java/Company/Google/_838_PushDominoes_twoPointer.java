package google;

/**
 * Created by zhang on 2018/5/31.
 */
public class _838_PushDominoes_twoPointer {
        public String pushDominoes(String dominoes) {
//            char[] aa = dominoes.toCharArray();
//            String res = new String();
            char[] a = dominoes.toCharArray();
            int L = -1, R = -1;//positions of last seen L and R
            for (int i = 0; i <= dominoes.length(); i++)
                if (i == a.length || a[i] == 'R') {
                    if (R > L)//R..R, turn all to R
                        while (R < i)
                            a[R++] = 'R';
                    R = i;
                } else if (a[i] == 'L')
                    if (L > R || (R == -1 && L == -1))//L..L, turn all to L
                        while (++L < i)
                            a[L] = 'L';
                    else { //R...L
                        L = i;
                        int lo = R + 1, hi = L - 1;
                        while (lo < hi) { //one in the middle stays '.'
                            a[lo++] = 'R';
                            a[hi--] = 'L';
                        }
                    }
            return new String(a);
        }
    }
