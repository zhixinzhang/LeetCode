package Company.Atlassian.FileCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FileSystemMultipleDictionary {

    public static void main(String args[]) {
        
        FileSystemMultipleDictionary fileSystem = new FileSystemMultipleDictionary();
       
        fileSystem.addFileToDirectory("file1.txt", 100, Arrays.asList());
        fileSystem.addFileToDirectory("file2.txt", 100, Arrays.asList("collection1"));
        fileSystem.addFileToDirectory("file3.txt", 200, Arrays.asList("collection1"));
        fileSystem.addFileToDirectory("file4.txt", 300, Arrays.asList("collection1", "collection2"));
        fileSystem.addFileToDirectory("file6.txt", 400, Arrays.asList("collection1", "collection2"));
        fileSystem.addFileToDirectory("file7.txt", 400, Arrays.asList("collection1", "collection2"));
        fileSystem.addFileToDirectory("file8.txt", 1000, Arrays.asList("collection3", "collection4"));
        System.out.println(fileSystem.getSizeOfAllFiles());
        List<Directory> topNCollections = fileSystem.getNCollection(3);
        
        for (Directory collection: topNCollections)
            System.out.println(collection.name+" " + collection.size+" ");

        fileSystem.addFileToDirectory("file9.txt", 3000, Arrays.asList("collection6"));   
        topNCollections = fileSystem.getNCollection(2);
        
        for (Directory collection: topNCollections)
            System.out.println(collection.name+" " + collection.size+" "); 

        // checkDirectory();
    }  


    Map<String, FileSystemAttributes> directoryDetailsMap; 
    PriorityQueue<Directory> directoryHeap;
    HashSet<Directory> isDirectoryPresentInHeap;
    
    int allFileSize;
    
    public FileSystemMultipleDictionary() {
        isDirectoryPresentInHeap = new HashSet<>();
        directoryDetailsMap = new HashMap<>();
        // directoryHeap = new PriorityQueue<Directory>((a, b) -> b.size - a.size);
        directoryHeap = new PriorityQueue<Directory>(new Comparator<Directory>() {
            @Override
            public int compare(Directory d1, Directory d2) {
                if (d1.size != d2.size) {
                    return d2.size - d1.size;
                } else {
                    return d1.name.compareTo(d2.name);
                }
            }
        });

        this.allFileSize = 0;
    }
    
    public int getSizeOfAllFiles() {
        return this.allFileSize;
    }
        
    public void addFileToDirectory(String fileName, int size, List<String> dNames) {

        File file;
        if (dNames.isEmpty()) {
            file = new File(fileName, size);
            directoryDetailsMap.put(fileName, file);
        } else {
            file = new File(dNames, fileName, size);
            for (String dName : dNames){
                Directory d = (Directory)directoryDetailsMap.getOrDefault(dName, new Directory(dName));
                d.size += size;
                d.files.add(file);

                if (!isDirectoryPresentInHeap.contains(d)) {
                    directoryHeap.add(d);
                    isDirectoryPresentInHeap.add(d);
                }else{
                    directoryHeap.remove(d);
                    directoryHeap.add(d);
                }
                
                directoryDetailsMap.put(dName, d);
            }
        }
        
        allFileSize += size; // ?
    }

    public List<Directory> getNCollection(int n) {
        
        if (n <= 0)
            return new ArrayList<>();
           
        List<Directory> output = new ArrayList<>();
        PriorityQueue<Directory> PQCopy = new PriorityQueue<Directory>(directoryHeap);
        
        for (int i = 0; i < n; i++) {
            Directory d = PQCopy.poll();
            output.add(d);
        }
        
        return output;
    }

    public void checkDirectory() {
        for (Map.Entry<String, FileSystemAttributes> entry : directoryDetailsMap.entrySet()){
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

interface FileSystemAttributes {}

class Directory implements FileSystemAttributes{
    
    String name;
    List<File> files;
    int size;
    
    public Directory (String name) {
        this.name = name;
        files = new ArrayList<>();
        this.size = 0;
    }
}

class File implements FileSystemAttributes {

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