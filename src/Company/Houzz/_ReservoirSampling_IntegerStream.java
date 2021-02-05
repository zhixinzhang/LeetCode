package Company.Houzz;
import java.util.*;

//http://blog.sina.com.cn/s/blog_48e3f9cd01019jyr.html
//https://www.geeksforgeeks.org/reservoir-sampling/
/**
 * Created by zhang on 2018/1/21.
 */
/**
 * 1) Create an array reservoir[0..k-1] and copy first k items of stream[] to it.
 2) Now one by one consider all items from (k+1)th item to nth item.
 …a) Generate a random number from 0 to i where i is index of current item in stream[]. Let the generated random number is j.
 …b) If j is in range 0 to k-1, replace reservoir[j] with arr[i]
 */
//0 1 2 3 4 5 6 7 8 9   n = 10
// k = 3
// maintance  arr[3] = {0,1,2}
// next element 3 have possible 3/4 to swap arr[0,1,2] = k/(k+1)
public class _ReservoirSampling_IntegerStream {

        // A function to randomly select k items from stream[0..n-1].
        static void selectKItems(int stream[], int n, int k)
        {
            int i;   // index for elements in stream[]

            // reservoir[] is the output array. Initialize it with
            // first k elements from stream[]
            int reservoir[] = new int[k];
            for (i = 0; i < k; i++)
                reservoir[i] = stream[i];
            Random r = new Random();
            // Iterate from the (k+1)th element to nth element
            for (; i < n; i++)
            {
                // Pick a random index from 0 to i.
                int j = r.nextInt(i + 1);

                // If the randomly  picked index is smaller than k,
                // then replace the element present at the index
                // with new element from stream
                if(j < k)
                    reservoir[j] = stream[i];
            }
            System.out.println("Following are k randomly selected items");
            System.out.println(Arrays.toString(reservoir));
        }

        //Driver Program to test above method
    public static void main(String[] args) {
        int stream[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int n = stream.length;
        int k = 5;
        selectKItems(stream, n, k);
    }
}
