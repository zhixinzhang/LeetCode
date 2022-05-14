package Company.Micorsoft;

import java.io.*;
import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/13/2021 8:05 PM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 */

public class _FindKElementsinFile_PQ {

    public void read () throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("path"));
        String line = reader.readLine();

        int k = 3;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        while (line != null) {
            int val = Integer.parseInt(line);
            line = reader.readLine();
            minHeap.add(val);
            maxHeap.add(val);

            if (minHeap.size() > k) {
                minHeap.poll();
            }

            if (maxHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
}
