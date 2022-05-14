package Company.Stripe;

import java.io.*;
import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/16/2021 10:43 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class ServerPenalty {
    public static void main(String[] args) {
        try {
//            testComputePenalty();
//            testFindBestRemovalTime();
            testGetBestCycleTimes();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static final String UP = "0";
    public static final String DOWN = "1";
    public static final String BEGIN = "BEGIN";
    public static final String END = "END";

    public static int compute_penalty(String log, int remove_at) {
        int count = 0;
        String[] server = log.split("\\s+");
        int n = server.length;
        if (remove_at < 0 || remove_at > n) {
            return -1;
        }
        for (int i = 0; i < remove_at; i++) {
            if (DOWN.equals(server[i])) {
                count++;
            }
        }
        for (int i = remove_at; i < n; i++) {
            if (UP.equals(server[i])) {
                count++;
            }
        }
        return count;
    }

    public static int find_best_removal_time(String log) {
        String[] server = log.split("\\s+");
        System.out.println(log);
        int size = server.length;
        int min = size + 1;
        int holder = -1;
        for (int i = 0; i <= size; i++) {
            int cur = compute_penalty(log, i);
            if (min > cur) {
                min = cur;
                holder = i;
            }
        }
        System.out.println(holder);

        return holder;
    }

//    public static int find_best_removal_time_oneLoop(String log) {
//        String[] server = log.split("\\s+");
//        System.out.println(log);
//        int size = server.length;
//
//        int[] leftUpPrefix = new int[size + 1];
//        int[] rightDownSuffix = new int[size + 1];
//
//        int count = 0;
//        for (int l = 1; l <= size ; l++){
//            leftUpPrefix[l] = count;
//            if (server[l - 1].equals("1"))
//                count++;
//        }
//
//        count = 0;
//        for (int r = size; r >= 1; r--){
//            rightDownSuffix[r] = count;
//            if (server[r - 1] == "0")
//                count++;
//        }
//
//        int min = size + 1;
//        int index = -1;
//        for (int i = 0; i <= size; i++ ) {
//            int curVal = leftUpPrefix[i] + rightDownSuffix[i];
//            if (curVal < min) {
//                min = curVal;
//                index = i;
//            }
//        }
//
//        System.out.println(index);
//        return index;
//    }


    public static int[] get_best_removal_times(String fileName) {
        String log = "";
        List<Integer> list = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                log += myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] server = log.split("\\s+");
        Arrays.stream(server).forEach(i -> System.out.println(i));

        int anchor = -1;
        int ptr = 0;
        int len = server.length;
        while (ptr < len) {
            if (BEGIN.equals(server[ptr])) {
                anchor = ptr + 1;
            }
            if (anchor != -1 && END.equals(server[ptr]) && ptr - anchor > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = anchor; i < ptr; i++) {
                    sb.append(server[i]);
                    sb.append(" ");
                }
                int cur = find_best_removal_time(sb.toString());
                list.add(cur);
                anchor = -1;
            }
            ptr++;
        }

        int n  = list.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = list.get(i);
        }
        return res;
    }




    //// TESTS
    public static <T> void assertEquals(T actual, T expected) {
        if (expected == null && actual == null || actual != null && actual.equals(expected)) {
            System.out.println("PASSED");
        } else {
            throw new AssertionError("Expected:\n  " + expected + "\nActual:\n  " + actual + "\n");
        }
    }


    public static void testComputePenalty() {
        //
        System.out.println("compute_penalty");
        assertEquals(compute_penalty("0 0 1 1 1 1 0 ", 0), 3);
        assertEquals(compute_penalty("0 0 0 1 1 1 1", 7), 4);
        assertEquals(compute_penalty("0 0 0 1 1 1 1", 3), 0);
        assertEquals(compute_penalty("", 0), 0);
        assertEquals(compute_penalty("1 1 1 1 0 0 0", 3), 6);
    }

    public static void testFindBestRemovalTime() {
        System.out.println("find_best_removal_time");
//        assertEquals(find_best_removal_time("0 0 0 1 1 1 1") ,3);
//        assertEquals(find_best_removal_time_oneLoop("0 0 0 1 1 1 1") ,3);
        assertEquals(find_best_removal_time(""), 0);
        assertEquals(find_best_removal_time("1 1 1 1"), 0);
        assertEquals(find_best_removal_time("0 0 0 0"), 4);
        assertEquals(find_best_removal_time("1 0 0 0 0 1 1 1 0 1 1 0 0 1 1 1 1 0 0 1 1 0 1 1 1"), 5);
        assertEquals(find_best_removal_time("1 1 1 1 1 0 0 0 1 1 1 1 0 0 0 1 1 1 0 1 0 0 1 0 1"), 0);
        assertEquals(find_best_removal_time("0 0 1 1 1 0 0 1 0 0 1 1 1 0 0 1 1 0 0 0 1 0 1 0 0"), 25);
    }


    public static void testGetBestCycleTimes() throws FileNotFoundException, UnsupportedEncodingException, IOException {

        // write to a file
        PrintWriter writer = new PrintWriter("serverA.log", "UTF-8");
        writer.println("0 0 0 BEGIN 0 0 0 0 BEGIN 0 0");
        writer.println(" 0 0 0 END 0 END 0 0 0 END");
        writer.println(" 0 0 0 0 BEGIN 0 0 0 END");
        writer.close();
        int[] example_A_answer = {5, 3};
        int[] actual = get_best_removal_times("serverA.log");
        if (Arrays.equals(actual, example_A_answer)) {
            System.out.println("PASSED");
        } else {
            throw new AssertionError("Expected:\n  " + Arrays.toString(example_A_answer) + "\nActual:\n  " + Arrays.toString(actual) + "\n");
        }

        writer = new PrintWriter("serverB.log", "UTF-8");
        writer.println("0 0 0 BEGIN 0 0 0 0 BEGIN 0 0 0 1");
        writer.println(" 1 1 1 END 0 END 0 BEGIN 1 1 END");
        writer.println(" 0 0 0 0 BEGIN 0 0 1 1 1 0 0 1 0 0");
        writer.println(" 1 1 1 0 0 1 1 0 0 0 1 0 1 0 0 END END");
        writer.close();
        int[] example_B_answer = {3, 0, 25};
        actual = get_best_removal_times("serverB.log");
        if (Arrays.equals(actual, example_B_answer)) {
            System.out.println("PASSED");
        } else {
            throw new AssertionError("Expected:\n  " + Arrays.toString(example_B_answer) + "\nActual:\n  " + Arrays.toString(actual) + "\n");
        }

    }
}
