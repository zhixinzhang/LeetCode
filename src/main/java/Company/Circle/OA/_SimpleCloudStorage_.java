package Company.Circle.OA;

import java.util.*;

public class _SimpleCloudStorage_ {
 
    static String[][] queries = new String[][]{
        {"ADD_FILE", "/file-a.txt", "4"},
        {"ADD_FILE", "/file-a.txt", "8"},
        {"ADD_FILE", "/dir-a/dir-c/file-b.txt", "5"},
        {"ADD_FILE", "/dir-a/dir-c/file-c.txt", "4"},
        {"ADD_FILE", "/dir-b/file-f.txt", "3"},
        {"GET_FILE_SIZE", "/file-a.txt"},
        {"GET_FILE_SIZE", "/file-c.txt"},
        {"MOVE_FILE", "/dir-b/file-f.txt", "/dir-a/dir-c/file-k.txt"},
        {"MOVE_FILE", "/dir-b/file-a.txt", "/dir-a/dir-c/file-b.txt"},
        {"MOVE_FILE", "/file-a.txt", "/dir-a/dir-c/file-b.txt"},
    };
    static Map<String, String> cache = new HashMap<>(); 
    public static void main(String[] args){
        cache = new HashMap<>(); 
        String[] ans = new String[queries.length];
        int i = 0;
        for (String[] query : queries){
            String fun = query[0];
            if (fun.equals("ADD_FILE")){
                ans[i] = addFile(query[1], query[2]);
            } else if (fun.equals("GET_FILE_SIZE")){
                ans[i] = getFileSize(query[1]);
            } else if (fun.equals("MOVE_FILE")){
                ans[i] = moveFile(query[1], query[2]);
            }
            i++;
        }

        for (String s : ans){
            System.out.println(s + ", ");
        }

        System.out.println("Level 2: ");
        ans = new String[queries.length];
        i = 0;
        for (String[] query : queries){
            String fun = query[0];
            if (fun.equals("ADD_FILE")){
                ans[i] = addFile(query[1], query[2]);
            } else if (fun.equals("GET_FILE_SIZE")){
                ans[i] = getFileSize(query[1]);
            } else if (fun.equals("MOVE_FILE")){
                ans[i] = moveFile(query[1], query[2]);
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

        return res;  // created
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
}
