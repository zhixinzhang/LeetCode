package Company.Atlassian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.1point3acres.com/bbs/thread-944957-1-1.html
 * 1. 给一堆文件有name和size，每个文件都可能属于一个collection，计算每个collection有哪些文件以及每个collection的size。
 * 
 * 2. Follow up 1: 每个文件可能属于多个collection
*/
public class FileCollection {
    public static void main(String[] args) {
        List<String> files = new ArrayList<>();
        files.add("file1.txt (size: 100)");
        files.add("file2.txt (size: 200) in collection \"collection1\"");
        files.add("file3.txt (size: 200) in collection \"collection1\"");
        files.add("file4.txt (size: 300) in collection \"collection2\"");
        files.add("file5.txt (size: 10)");

        // findCollectionsSize(files, "collection1");

        List<String> files2 = new ArrayList<>();
        files2.add("file1.txt (size: 100)");
        files2.add("file2.txt (size: 200) collectionIds: [\"collection1\"]");
        files2.add("file3.txt (size: 200) collectionIds: [\"collection2\"]");
        files2.add("file4.txt (size: 300) collectionIds: [\"collection2\", \"collection3\"]");
        files2.add("file5.txt (size: 10)");

        findCollectionsSizeFollowUp(files2, "collection2");
    }

    static class Files{
        int totalSize;
        List<String> files;
        List<String> subCollections;
        public Files(){
            this.totalSize = 0;
            this.files = new ArrayList<>();
        }
    }

    static Map<String, Files> collections = new HashMap<>();
    private static int findCollectionsSize(List<String> info, String col){
        int ans = 0;

        for(String file : info){
            String[] data = file.split(" ");
            String fileName = data[0];
            if (data.length < 6) {
                continue;
            }
            String collection = data[5].replaceAll("\"", "");  // "collection2" -> collection2
            String size = data[2].replace(")", "");
            int intSize = Integer.valueOf(size);

            Files files = new Files();
            files = collections.getOrDefault(collection, files);
            files.files.add(fileName);
            files.totalSize = files.totalSize + intSize;
            collections.put(collection, files);

            System.out.println("currenty collection size is : " + files.totalSize);
        }

        
        if (collections.containsKey(col)) {
            ans = collections.get(col).totalSize;
        }

        System.out.println("currenty target collection size is : " + ans);

        return ans;
    }

    private static int findCollectionsSizeFollowUp(List<String> info, String col){
        int ans = 0;

        for(String file : info){
            String[] data = file.split("collectionIds: ");
            
            if (data.length < 2) {
                continue;
            }
            String fileName = data[0].split(" ")[0];
            String size = data[0].split(": ")[0].replace(")", "");
            String allCollections =  data[1].substring(0, data[1].length() - 1);
            String[] collectionArray = allCollections.split(", ");
            
            int intSize = Integer.valueOf(size);

            for (String c : collectionArray){
                String colName = c.replaceAll("\"", "");  // "collection2" -> collection2

                Files files = new Files();
                files = collections.getOrDefault(colName, files);
                files.files.add(fileName);
                files.totalSize = files.totalSize + intSize;
                collections.put(colName, files);
                System.out.println("currenty collection size is : " + files.totalSize);
            }
        }

        
        if (collections.containsKey(col)) {
            ans = collections.get(col).totalSize;
        }

        System.out.println("currenty target collection size is : " + ans);

        return ans;
    }
}
