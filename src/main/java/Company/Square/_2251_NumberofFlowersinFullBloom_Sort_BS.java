package Company.Square;
import java.util.*;

// https://leetcode.com/problems/number-of-flowers-in-full-bloom/solutions/1988766/java-solution-96-faster-with-explanation/?languageTags=java
// https://www.1point3acres.com/bbs/thread-901857-1-1.html
public class _2251_NumberofFlowersinFullBloom_Sort_BS {

    public static void main(String[] args) {
        int[][] flowers = new int[][]{{1,6}, {3,7}, {9,12}, {4,13}};
        int[] persons = new int[]{2,3,7,11};
        fullBloomFlowers(flowers, persons);

    }

    public static int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int n = flowers.length;
        int[] startBlooming = new int[n];  // for start blooming at time t.
        int[] endBlooming = new int[n];  // for stop blooming at time t.
        for(int i = 0; i < n; i++){
            startBlooming[i] = flowers[i][0];
            endBlooming[i] = flowers[i][1];
        }
        Arrays.sort(startBlooming);
        Arrays.sort(endBlooming);
        for(int i = 0; i < persons.length; i++){
            int start = 0, end = n - 1 , noOfBloomingFlower = 0 , noOfEndBloomingFlower = 0;
			
			//  first time using binary search for finding  blooming flowers in startBlooming array
			
            while(start <= end){
                int mid = start + (end - start)/2;
                if(startBlooming[mid] <= persons[i]){
                    noOfBloomingFlower = mid + 1;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                } 
            }
			
			//  second time using binary search for finding stricly stop blooming flowers  endBlooming array
			
            start = 0;
            end = n - 1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(endBlooming[mid] < persons[i]){   // this line is more important than other line because keep in mind the strictly value of stop blooming flowers  endBlooming 
                    noOfEndBloomingFlower = mid + 1;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            persons[i] = noOfBloomingFlower - noOfEndBloomingFlower;
        }

        return persons;
    }
}
