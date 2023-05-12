package Company.Atlassian.FileCollection;

/*
file1.txt (size: 100)
file2.txt (size: 200) in collection "collection1"
file3.txt (size: 200) in collection "collection1"
file4.txt (size: 300) in collection "collection2"
file5.txt (size: 10)
*/

/*
collection "collection1"
collection "collection2" parentCollection "collection1"
*/

// list files 
// total size  -> 810
// list collections 
// co11 : 400
// col2 : 300 


// O(N * Log N)  N is number of collections

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class F {
     
    
    public static void main(String[] args) {
        F s = new F();
        s.addNewFile("file1.txt", 100, Arrays.asList(""));
        s.addNewFile("file2.txt", 200, Arrays.asList("collection1"));
        s.addNewFile("file3.txt", 200, Arrays.asList("collection1"));
        s.addNewFile("file4.txt", 300, Arrays.asList("collection2"));
        s.addNewFile("file5.txt", 10, Arrays.asList(""));
        
        s.addNewFile("file7.txt", 1000, Arrays.asList("collection6"));
        // s.addNewFile("file8.txt", 1000, Arrays.asList("collection7", "collection8"));
        // s.addNewFile("file9.txt", 1200, Arrays.asList("collection8", "collection9"));
        
        s.addNewFile("file7.txt", -10000, Arrays.asList("collection7"));
        s.addNewFile("file7.txt", 10, Arrays.asList("collection7"));
        s.addNewFile("file7.txt", 200, Arrays.asList("collection7"));
        
        s.addNewFile("*(&*&*&(*)).txt", 200, Arrays.asList("collection7"));
        s.listCollection();
    }  
    
    // O(N)
    Map<String, Collection> collectionDetailsMap = new HashMap<>();   // Collec name  value -> Collection details
    int totalFileSize = 0;
    
    public void addNewFile(String fileName, int size, List<String> collections){
        if (fileName == null || size < 0 || collections == null || collections.size() == 0){
           return; 
        }
        
        totalFileSize += size;
        File file = new File(collections, fileName, size);
        for (String cName : collections){
            Collection col = collectionDetailsMap.getOrDefault(cName, new Collection(cName));  // retrieve or create new Collection
            col.size += size;
            col.files.add(file);
            
            collectionDetailsMap.put(cName, col);
        }
    }
    
    public void listCollection(){
        // List<Map.Entry<String, Collection>> collections = new ArrayList<>();
        // collections.addAll(collectionDetailsMap.entrySet());
        // Collections.sort
        List<Collection> ans = new ArrayList<>();
        PriorityQueue<Collection> minHeap = new PriorityQueue<>(new Comparator<Collection>() {
            @Override
            public int compare(Collection e1, Collection e2){
                if (e1.size != e2.size){
                    return e1.size - e2.size;
                } else {
                    return e2.name.compareTo(e1.name);
                }
            }
        });
        
        // O(N * Log N) 
        for (String cName : collectionDetailsMap.keySet()){
            minHeap.add(collectionDetailsMap.get(cName));
        }
        
        while (!minHeap.isEmpty()){
            ans.add(minHeap.poll());
        }
        Collections.reverse(ans);
        
        System.out.println("File system total size : " + totalFileSize);
        for (Collection c : ans){
            if (!c.name.equals("")){
                System.out.println("Collection name is : " + c.name + " , " + c.size);
            }
        }
        
    }
    
  class Collection {
     String name;
     List<File> files;
     // List<Collection> childCollections;
     // Collection parrentCollection;
     int size;
     
     public Collection(String name){
         this.name = name;
         this.files = new ArrayList<>();
         this.size = 0;
     }
 }   
    
  class File {
     List<String> collections;
     String name;
     int size;
     
     public File(String n, int size){
        this.name = n;
        this.size = size;
     }
     
        public File(List<String> collections, String n, int size){
        this.name = n;
        this.size = size;
        this.collections = collections;
     }
 }

}
