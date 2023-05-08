package Company.Roblox;

/**
 * This is a greedy problem, 
Keep track of maximum no of frogs involved in croaking and realse one frog each time croak is completed ('k' is found).
For all non valid cases return -1.

Approach
Iterate over each character and keep track of maximum no of frogs involved in croaking by calculating max of 'c' at each steps 
bcz no of frogs currently 
croaking will be equal to count of 'c'.As soon as 'K' of croak is found release one frog by reducing each character of croak by one.
 * 
*/
public class _1419_MinimumNumberofFrogsCroaking_Greedy {
    public static int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs == null || croakOfFrogs.length() == 0) {
            return -1;
        }
        int[] letterCounts = new int[26]; 
        int count = 0;
        int maxCount = 0;
        
        for (char c : croakOfFrogs.toCharArray()) {
            letterCounts[c - 'a'] ++; 
            // do boundary count 
            if (c == 'c') { // left boundary
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                if (!isValid(c, letterCounts)) 
                    return -1; 
                if (c == 'k') { // right boundary 
                    count--;
                }
            }
        }
        // check if the string is finished
        return count == 0 ? maxCount : -1;
    }

    // check string validity
    private static boolean isValid(char c, int[] counts) {
        char prevChar;
        if (c == 'r') prevChar = 'c';
        else if (c == 'o') prevChar = 'r';
        else if (c == 'a') prevChar = 'o';
        else prevChar = 'a'; 

        return counts[prevChar - 'a'] >= counts[c - 'a']; 
    }

    public static void main(String[] args){
        minNumberOfFrogs("aaa");
    }
}
