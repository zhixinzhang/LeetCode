package Company.Atlassian.FileCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/discuss/interview-experience/1504593/atlassian-sde-2-p4-september-2021-bangalore-offer
public class FileSystemMultipleDirNoInterface {

    public static void main(String args[]) {
        
        FileSystemMultipleDirNoInterface fileSystem = new FileSystemMultipleDirNoInterface();
       
        fileSystem.addFileToDirectory("file1.txt", 100, Arrays.asList(""));
        fileSystem.addFileToDirectory("file2.txt", 100, Arrays.asList("collection1"));
        fileSystem.addFileToDirectory("file3.txt", 200, Arrays.asList("collection1"));
        fileSystem.addFileToDirectory("file4.txt", 300, Arrays.asList("collection1", "collection2"));
        fileSystem.addFileToDirectory("file6.txt", 400, Arrays.asList("collection1", "collection2"));
        fileSystem.addFileToDirectory("file7.txt", 400, Arrays.asList("collection1", "collection2"));
        fileSystem.addFileToDirectory("file8.txt", 1000, Arrays.asList("collection3", "collection4"));
        System.out.println(fileSystem.getSizeOfAllFiles());
        List<Directory> topNCollections = fileSystem.getNCollection(6);
        
        for (Directory collection: topNCollections)
            System.out.println("Collection Name is : " + collection.name + " " + collection.size+" ");


        System.out.println("Extra test");

        fileSystem.addFileToDirectory("file9.txt", 3000, Arrays.asList("collection6"));
        System.out.println(fileSystem.getSizeOfAllFiles());   
        topNCollections = fileSystem.getNCollection(2);
        
        for (Directory collection: topNCollections)
            System.out.println(collection.name+" " + collection.size+" "); 

        System.out.println("Extra test");

        fileSystem.addFileToDirectory("file10.txt", 3000, Arrays.asList("collection7"));
        System.out.println(fileSystem.getSizeOfAllFiles());   
        topNCollections = fileSystem.getNCollection(2);
        
        for (Directory collection: topNCollections)
            System.out.println(collection.name+" " + collection.size+" "); 
        // checkDirectory();
    }  


    Map<String, Directory> directoryDetailsMap; 
    // PriorityQueue<Directory> directoryHeap;
    
    int allFileSize;
    
    public FileSystemMultipleDirNoInterface() {
        directoryDetailsMap = new HashMap<>();
        // directoryHeap = new PriorityQueue<Directory>((a, b) -> b.size - a.size);
        // directoryHeap = new PriorityQueue<Directory>(new Comparator<Directory>() {
        //     @Override
        //     public int compare(Directory d1, Directory d2) {
        //         if (d1.size != d2.size) {
        //             return d2.size - d1.size;
        //         } else {
        //             return d1.name.compareTo(d2.name);
        //         }
        //     }
        // });

        this.allFileSize = 0;
    }
    
    public int getSizeOfAllFiles() {
        return this.allFileSize;
    }
        
    public void addFileToDirectory(String fileName, int size, List<String> dNames) {

        File file = new File(dNames, fileName, size);
        for (String dName : dNames){
            Directory d = (Directory)directoryDetailsMap.getOrDefault(dName, new Directory(dName));
            d.size += size;
            d.files.add(file);
            
            directoryDetailsMap.put(dName, d);
        }
        
        allFileSize += size; // ?
    }

    public List<Directory> getNCollection(int n) {
        
        if (n <= 0)
            return new ArrayList<>();
           
        List<Directory> output = new ArrayList<>();
        // O(N * log N)
        // PriorityQueue<Directory> PQCopy = new PriorityQueue<Directory>(directoryHeap);
        
        // for (int i = 0; i < n; i++) {
        //     if (PQCopy.isEmpty()) {
        //         break;
        //     }
        //     Directory d = PQCopy.poll();
        //     output.add(d);
        // }
        
        // return output;

        // O(N * Log K)
        // PriorityQueue<Directory> minHeap = new PriorityQueue<Directory>((a,b) -> (a.size - b.size));
        PriorityQueue<Directory> minHeap = new PriorityQueue<Directory>(new Comparator<Directory>() {
            @Override
            public int compare(Directory d1, Directory d2) {
                if (d1.size != d2.size) {
                    return d1.size - d2.size;
                } else {
                    return d1.name.compareTo(d2.name);
                }
            }
        });
        for (String dName : directoryDetailsMap.keySet()){
            minHeap.add(directoryDetailsMap.get(dName));
            if (minHeap.size() > n) {
                minHeap.poll();
            }
        }
        
        while (!minHeap.isEmpty()){
            Directory c = minHeap.poll();
            output.add(c);
        }

        Collections.reverse(output);
        return output;
    }

    public void checkDirectory() {
        for (Map.Entry<String, Directory> entry : directoryDetailsMap.entrySet()){
            System.out.println(entry.getKey() + "  ");
            if (entry.getValue() instanceof Directory) {
                Directory d = (Directory) entry.getValue();
                for (File s : d.files){
                    System.out.println(s.name);
                }
            }
            
        }
    }
}

class Directory {
    
    String name;
    List<File> files;
    int size;
    
    public Directory (String name) {
        this.name = name;
        files = new ArrayList<>();
        this.size = 0;
    }
}

class File{

    List<String> directory;
    String name;
    int size;

    public File(List<String> directory, String n, int size) {
        this.directory = directory;
        this.name = n;
        this.size = size;
    }
    
    public File(String n, int size) {
        this.name = n;
        this.size = size;
    }    
}
