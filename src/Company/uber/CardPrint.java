package Company.uber;

/**
 * Created by zhang on 2018/9/18.
 * http://www.1point3acres.com/bbs/thread-430544-1-1.html
 */
public class CardPrint {
    int[] cards = new int[13];
    public void add(int n){
        cards[n]++;
        int count = 0;
        int i = 0;
        for (; i < 13; i++){
            if (cards[i] != 0)
                count++;
            else
                count = 0;
            if (count == 5)
                break;
        }
        if (count == 5){
            int r = i - 4;
            for (; r <= i; r++){
                cards[r]--;
                System.out.println(r + ",");
            }
        }
    }

    public static void main(String[] args){
        CardPrint c = new CardPrint();
        c.add(1);
        c.add(7);
        c.add(6);
        c.add(4);
        c.add(5);
        c.add(3);
    }
}
