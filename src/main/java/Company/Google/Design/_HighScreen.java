package Company.Google.Design;

/**
 * Created by zhang on 2018/6/30.
 * 1. 已知screen的高和宽，给你最小和最大的fontSize，要求给定一个string，将string用竟可能大的fontSize显示在screen里。已知两个API getHeight(intfontSize),
 * getWidth(char c, int fontSize)，可以得到每个character在不同fontSize下的高和宽。
 */
public class _HighScreen {
    public int getLargestFont(String s, int height, int width, int small, int big){
        int left = small;
        int right = big;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (!canFit(s,height,width,mid)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }
    // string can not be split
    public int getHeight(int a){
        return a;
    }
    public int getWidth(char c ,int a){
        return a;
    }
    public boolean canFit(String s, int height, int width, int font){
        int rows = height / getHeight(font);
        int len = s.length();
        int i = 0;
        for (int row = 0; row < rows && i < len; row ++){
            int w = 0;
            // fit as much chars as possible in current row
            while( i < len && w + getWidth(s.charAt(i), font) <= width){
                w += getWidth(s.charAt(i),font);
                ++i;
            }
        }
        return i >= len;
    }
    public boolean canFifSentence(String s, int height, int width, int font){
        int rows = height / getHeight(font);
        String[] words = s.split(" ");
        int n = words.length;
        int i = 0;
        int curWidth = 0;
        for (int row = 0; row < rows && i < n;  ++row){
            while (i < n && curWidth + getSetencWidth(words[i],font) <= width){
                ++i;
                curWidth += getWidth(' ',font);
            }
        }
        return i >= n;
    }
    public int getSetencWidth(String s, int font){
        int width = 0;
        for (int i = 0; i<s.length(); i++){
            width += getWidth(s.charAt(i),font);
        }
        return width;
    }
}
