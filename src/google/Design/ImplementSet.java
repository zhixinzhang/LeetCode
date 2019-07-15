package google.Design;
import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
//https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
/**
 * Created by zhang on 2018/7/1.
 */
public class ImplementSet {
    public String solution(){
        HashSet<String> hs = new HashSet<>();
        HashMap<Integer, String> hm = new HashMap<>();
        HashMap<String, Integer> hmIndex = new HashMap<>();

        hm.put(1,"a");
        hm.put(2,"c");
        hm.put(3,"a");
        hm.put(4,"c");
        hm.put(5,"a");
        hm.put(6,"c");
        hs.remove("a");
        hs.add("c");

        add(hm,hmIndex,hs,"c");
        remove(hm,hmIndex,hs,"c");
        String res = getRandom(hm,hs);
        return res;
    }
    public void add(HashMap<Integer, String> hm,HashMap<String, Integer> hmIndex, HashSet<String> hs, String name){
        if (!hs.contains(name)) {
            hs.add(name);
            hm.put(hm.size()+1, name);
            hmIndex.put(name,hm.size()+1);
        }
    }

    public void remove(HashMap<Integer, String> hm,HashMap<String, Integer> hmIndex, HashSet<String> hs, String name){
        if (hs.contains(name)){
            hs.remove(name);
            int index = hmIndex.get(name);
            hm.remove(index);
            hmIndex.remove(name);
        }
    }

        public String getRandom(HashMap<Integer, String> hm, HashSet<String> hs){
        if (hs.isEmpty()) return "";
        Random rm = new Random();
        int r = rm.nextInt(hm.size());
        String name = hm.get(r);
        if (hs.contains(name))
            return name;
        else
            return "";
    }







    // class to represent the required data structure
    class MyDS
    {
        ArrayList<Integer> arr;   // A resizable array

        // A hash where keys are array elements and vlaues are
        // indexes in arr[]
        HashMap<Integer, Integer>  hash;

        // Constructor (creates arr[] and hash)
        public MyDS()
        {
            arr = new ArrayList<Integer>();
            hash = new HashMap<Integer, Integer>();
        }

        // A Theta(1) function to add an element to MyDS
        // data structure
        void add(int x)
        {
            // If ekement is already present, then noting to do
            if (hash.get(x) != null)
                return;

            // Else put element at the end of arr[]
            int s = arr.size();
            arr.add(x);

            // And put in hash also
            hash.put(x, s);
        }

        // A Theta(1) function to remove an element from MyDS
        // data structure
        void remove(int x)
        {
            // Check if element is present
            Integer index = hash.get(x);
            if (index == null)
                return;

            // If present, then remove element from hash
            hash.remove(x);

            // Swap element with last element so that remove from
            // arr[] can be done in O(1) time
            int size = arr.size();
            Integer last = arr.get(size-1);
            Collections.swap(arr, index,  size-1);

            // Remove last element (This is O(1))
            arr.remove(size-1);

            // Update hash table for new index of last element
            hash.put(last, index);
        }

        // Returns a random element from MyDS
        int getRandom()
        {
            // Find a random index from 0 to size - 1
            Random rand = new Random();  // Choose a different seed
            int index = rand.nextInt(arr.size());

            // Return element at randomly picked index
            return arr.get(index);
        }

        // Returns index of element if element is present, otherwise null
        Integer search(int x)
        {
            return hash.get(x);
        }
    }
}
