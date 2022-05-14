//package google.DataStructure.Tree.Array;
//
//import javafx.util.Pair;
//
//import java.util.DataStructure.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//
///**
// * Created by zhang on 2018/7/11.
// *
// * https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
// */
//public class _Minimumnumberofswapsrequiredtosortanarray {
//    // Function returns the minimum number of swaps
//    // required to sort the array
//    public static int minSwaps(int[] arr)
//    {
//        int n = arr.length;
//
//        // Create two arrays and use as pairs where first
//        // array is element and second array
//        // is position of first element
//        DataStructure.ArrayList<Pair<DataStructure.Integer, DataStructure.Integer>> arrpos =
//                new DataStructure.ArrayList <Pair <DataStructure.Integer, DataStructure.Integer> > ();
//        for (int i = 0; i < n; i++)
//            arrpos.add(new Pair <DataStructure.Integer, DataStructure.Integer> (arr[i], i));
//
//        // Sort the array by array element values to
//        // get right position of every element as the
//        // elements of second array.
//        arrpos.sort(new Comparator<Pair<DataStructure.Integer,DataStructure.Integer>>()
//        {
//            @Override
//            public int compare(Pair<DataStructure.Integer, DataStructure.Integer> o1,
//                               Pair<DataStructure.Integer, DataStructure.Integer> o2)
//            {
//                if (o1.getKey() > o2.getKey())
//                    return -1;
//
//                    // We can change this to make it then look at the
//                    // words alphabetical order
//                else if (o1.getKey().equals(o2.getKey()))
//                    return 0;
//
//                else
//                    return 1;
//            }
//        });
//
//        // To keep track of visited elements. Initialize
//        // all elements as not visited or false.
//        Boolean[] vis = new Boolean[n];
//        Arrays.fill(vis, false);
//        // Initialize result
//        int ans = 0;
//        // Traverse array elements
//        for (int i = 0; i < n; i++) {
//            // already swapped and corrected or
//            // already present at correct pos
//            if (vis[i] || arrpos.get(i).getValue() == i)
//                continue;
//
//            // find out the number of  node in
//            // this cycle and add in ans
//            int cycle_size = 0;
//            int j = i;
//            while (!vis[j])
//            {
//                vis[j] = true;
//
//                // move to next node
//                j = arrpos.get(j).getValue();
//                cycle_size++;
//            }
//
//            // Update answer by adding current cycle.
//            ans += (cycle_size - 1);
//        }
//
//        // Return result
//        return ans;
//    }
//    // Driver program to test the above function
//    public static void main(String[] args)
//    {
//        int []a = {1, 5, 4, 3, 2};
////        minSwaps(a);
//        System.out.println(minSwaps(a));
//    }
//}
//
