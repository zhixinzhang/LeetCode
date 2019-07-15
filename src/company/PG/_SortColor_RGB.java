package company.PG;

/**
 * Created by zhang on 2018/1/29.
 */
public class _SortColor_RGB {
    class PocketColor {
        int data;
        char c;
        PocketColor() {
        }
        PocketColor(int data, char c) {
            this.data = data;
            this.c = c;
        }
    }
    public class Solution {
        public void sort(PocketColor[] colors) {
            int left = 0;
            int right = colors.length-1;
            int i = 0;
            while (i <= right){
                if (colors[i].c == 'r')
                    swap(colors, i++, left++);
                else if(colors[i].c == 'g')
                    i++;
                else
                    swap(colors, i, right--);
            }
        }

        private void swap(PocketColor []colors, int i, int j){
            PocketColor temp = colors[i];
            colors[i] = colors[j];
            colors[j] = temp;
        }
    }
}
