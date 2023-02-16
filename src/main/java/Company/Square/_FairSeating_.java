package Company.Square;
import java.util.*;
// https://leetcode.com/discuss/interview-question/2488194/Square-or-Phone-or-Fair-Seating
/**
 * I am assuming that the table is circular.
So we just need to find how many humans will sit on each side of any Bot.
With 6 humans and 3 bots, there will be 2 humans between every bot. ie 2 on one side and 2 on another.
With 6 humans and 4 bots, some bots will be 2 humans apart some 1 apart. ie 1 on one side and 2 on another side.

Therefore the humans on one side will be (totalHumans / totalBots)
And humans on another side would be Round Up (totalHumans / totalBots)
 * 
*/
public class _FairSeating_ {

    public static void main(String[] args) {
        int human = 6;
        int bot = 4;
        createSeating(human, bot);
     }

     private static String createSeating(int humans, int bots) {
		if(bots > humans)
			return "hb".repeat(humans);

		int left = humans / bots;
		int right = (int) Math.ceil((double)humans / bots);

		char[] seating = new char[humans + bots];
		Arrays.fill(seating, 'h');

		int i=-1;
		boolean isLeft = true;
		while(bots > 0) {
			i += isLeft ? left : right;
			seating[++i] = 'B';
			isLeft = !isLeft;
			bots--;
		}
        System.out.println(new String (seating));

		return new String (seating);

	}

}
