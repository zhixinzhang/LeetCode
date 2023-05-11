package Company.Atlassian.FileCollection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FileSystem {

    public static void main(String args[]) {
        
        FileSystem fileSystem = new FileSystem();
       
        fileSystem.addFileToDirectory("file1.txt", 100, "");
        fileSystem.addFileToDirectory("file2.txt", 100, "collection1");
        fileSystem.addFileToDirectory("file3.txt", 200, "collection1");
        fileSystem.addFileToDirectory("file4.txt", 300, "collection3");
        fileSystem.addFileToDirectory("file5.txt", 400, "collection4");
        fileSystem.addFileToDirectory("file5.txt", 400, "collection5");
        System.out.println(fileSystem.getSizeOfAllFiles());
        List<Directory> topNCollections = fileSystem.getNCollection(3);
        
        for (Directory collection: topNCollections)
            System.out.println(collection.name+" " + collection.size+" ");
    }  


    Map<String, FileSystemAttributes> directoryDetailsMap; 
    PriorityQueue<Directory> directoryHeap;
    HashSet<Directory> isDirectoryPresentInHeap;
    
    int allFileSize;
    
    public FileSystem() {
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
        isDirectoryPresentInHeap = new HashSet<>();
        this.allFileSize = 0;
    }
    
    public int getSizeOfAllFiles() {
        return this.allFileSize;
    }
        
    public void addFileToDirectory (String fileName, int size, String dName) {
        File file;
        if (dName.equals("")) {
            file = new File(fileName, size);
            directoryDetailsMap.put(fileName, file);
        } else {
            Directory d = (Directory)directoryDetailsMap.getOrDefault(dName, new Directory(dName));
            file = new File(d, fileName, size);
            
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
        
        allFileSize += size;
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
}

// interface FileSystemAttributes {}

// class Directory implements FileSystemAttributes{
    
//     String name;
//     List<File> files;
//     int size;
    
//     public Directory (String name) {
//         this.name = name;
//         files = new ArrayList<>();
//         this.size = 0;
//     }
// }

// class File implements FileSystemAttributes {

//     Directory directory;
//     String name;
//     int size;

//     public File(Directory d, String n, int size) {
//         this.directory = d;
//         this.name = n;
//         this.size = size;
//     }
    
//     public File(String n, int size) {
//         this.name = n;
//         this.size = size;
//     }    
// }
