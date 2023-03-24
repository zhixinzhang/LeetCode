package Company.Circle.OA;

import java.util.*;

public class _SimpleCloudStorage2_ {

    static String[][] queries2 = new String[][]{
        {"ADD_FILE", "/dir/file1.txt", "5"},
        {"ADD_FILE", "/dir/file2", "20"},
        {"ADD_FILE", "/dir/deeper/file3.mov", "9"},
        {"GET_LARGEST_N", "/dir", "2"},
        {"GET_LARGEST_N", "/dir/file", "3"},
        {"GET_LARGEST_N", "/another_dir", "3"},
        {"ADD_FILE", "/big_file.mp4", "20"},
        {"GET_LARGEST_N", "/", "2"}
    };
 
    static String[][] queries = new String[][]{
        {"ADD_FILE", "/dir/file1.txt", "5"},
        {"ADD_FILE", "/dir/file2", "20"},
        {"ADD_FILE", "/dir/aile2", "20"},
        {"ADD_FILE", "/dir/deeper/file3.mov", "9"},
        {"GET_LARGEST_N", "/dir", "2"},
        {"GET_LARGEST_N", "/dir/file", "3"},
        {"GET_LARGEST_N", "/another_dir", "3"},
        {"ADD_FILE", "/big_file.mp4", "20"},
        {"GET_LARGEST_N", "/", "2"}
    };

    static String[][] queries1 = new String[][]{
        {"ADD_FILE", "/dir/file1.txt", "5"},
        {"ADD_FILE", "/dir/file2", "20"},
        {"ADD_FILE", "/dir/file1", "20"},
        {"ADD_FILE", "/air/file1", "20"},
        {"ADD_FILE", "/air/file12", "120"},
        {"GET_LARGEST_N", "/", "3"}
    };
    static Map<String, String> cache = new HashMap<>(); 
    static PriorityQueue<File> sortedQ = null;
    static class File {
        String fileName;
        String size;

        public File(String file, String size){
            this.fileName = file;
            this.size = size;
        }
    }
    public static void main(String[] args){
        cache = new HashMap<>(); 
        sortedQ = new PriorityQueue<File>(new Comparator<File>() {
            @Override
            public int compare(File f1, File f2){
                if (f1.size.equals(f2.size)){
                    return f1.fileName.compareTo(f2.fileName);
                    
                } else {
                    return Integer.valueOf(f2.size) - Integer.valueOf(f1.size);
                }
            }
        });

        System.out.println("Level 2: ");
        String[] ans = new String[queries2.length];

        int i = 0;
        for (String[] query : queries2){
            String fun = query[0];
            if (fun.equals("ADD_FILE")){
                ans[i] = addFile(query[1], query[2]);
            } else if (fun.equals("GET_FILE_SIZE")){
                ans[i] = getFileSize(query[1]);
            } else if (fun.equals("MOVE_FILE")){
                ans[i] = moveFile(query[1], query[2]);
            } else if (fun.equals("GET_LARGEST_N")){
                ans[i] = getLargestN(query[1], query[2]);
            }
            i++;
        }

        for (String s : ans){
            System.out.println(s + ", ");
        }
    }

    private static String addFile(String fileName, String size){
        String res = "overwritten";
        if (!cache.containsKey(fileName)){
            res = "created";
        }
        cache.put(fileName, size);
        return res;  
    }


    private static String getFileSize(String fileName){
        String res = "";
        if (cache.containsKey(fileName)){
            res = cache.get(fileName);
        }
        return res; 
    }

    private static String moveFile(String fileNameFrom, String fileNameTo){
        if (!cache.containsKey(fileNameFrom) || cache.containsKey(fileNameTo)) {
            return "false";
        }
        String size = cache.get(fileNameFrom);
        cache.put(fileNameTo, size);
        cache.remove(fileNameFrom);
        return "true";
    }

    private static String getLargestN(String fileNameFrom, String N){
        if (Integer.valueOf(N)  <= 0) {
            return "";
        }

        sortedQ.clear();
        for (String key : cache.keySet()){
            sortedQ.add(new File(key, cache.get(key)));
        }

        int i = 0, n = Integer.valueOf(N);
        StringBuilder sb = new StringBuilder();
        while (!sortedQ.isEmpty()){
            File file = sortedQ.poll();
            if (file.fileName.startsWith(fileNameFrom)){
                sb.append(file.fileName);
                sb.append("(");
                sb.append(file.size);
                sb.append("), ");
                i++;
            }
            if (i >= n) {
                break;
            }
        }

        if (sb.length() <= 1) {
            return "";
        }

        String ans = sb.substring(0, sb.length() - 2);
        return ans;
    }
}
