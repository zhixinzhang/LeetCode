package Company.Square.Algo.StringWord;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

//https://www.1point3acres.com/bbs/thread-828680-1-1.html
// https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/

// 先 build huffamn tree 
/**
 * Create a leaf node for each unique character and build a min heap of all leaf nodes (Min Heap is used as a priority queue. The value of frequency field is used to compare two nodes in min heap. Initially, the least frequent character is at root)
Extract two nodes with the minimum frequency from the min heap.
 
Create a new internal node with a frequency equal to the sum of the two nodes frequencies. Make the first extracted node as its left child and the other extracted node as its right child. Add this node to the min heap.
Repeat steps#2 and #3 until the heap contains only one node. The remaining node is the root node and the tree is complete.
Let us understand the algorithm with an example:
 * 
 * 
*/
class MinHeapNode implements Comparable<MinHeapNode> {
    char data;
    int freq;
    MinHeapNode left, right;
     
    MinHeapNode(char data, int freq) {
        this.data = data;
        this.freq = freq;
    }
     
    public int compareTo(MinHeapNode other) {
        return this.freq - other.freq;
    }
}

public class Huffman_DecoderAndEncoding {
    private static Map<Character, String> codes = new HashMap<>();
    private static Map<Character, Integer> freq = new HashMap<>();
    private static PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>();
     
    public static void main(String[] args) {
        // String str = "geeksforgeeks";
        String str = "bad";
        String encodedString = "";
        String decodedString = "";
        calcFreq(str);
        HuffmanCodes(str.length());
        System.out.println("Character With their Frequencies:");
        for (Entry<Character, String> entry : codes.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for (char c : str.toCharArray()) {
            encodedString += codes.get(c);
        }
        System.out.println("\nEncoded Huffman data:");
        System.out.println(encodedString);
        decodedString = decodeFile(minHeap.peek(), encodedString);
        System.out.println("\nDecoded Huffman Data:");
        System.out.println(decodedString);
    }
     
    private static void HuffmanCodes(int size) {
        for (Entry<Character, Integer> entry : freq.entrySet()) {
            minHeap.add(new MinHeapNode(entry.getKey(), entry.getValue()));
        }
        while (minHeap.size() != 1) {
            MinHeapNode left = minHeap.poll();
            MinHeapNode right = minHeap.poll();
            MinHeapNode top = new MinHeapNode('$', left.freq + right.freq);
            top.left = left;
            top.right = right;
            minHeap.add(top);
        }
        storeCodes(minHeap.peek(), "");
    }
     
    private static void calcFreq(String str) {
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
    }
     
    private static void storeCodes(MinHeapNode root, String str) {
        if (root == null) {
            return;
        }
        if (root.data != '$') {
            codes.put(root.data, str);
        }
        storeCodes(root.left, str + "0");
        storeCodes(root.right, str + "1");
    }
     
    private static String decodeFile(MinHeapNode root, String s) {
        String ans = "";
        MinHeapNode curr = root;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
            if (curr.left == null && curr.right == null) {
                ans += curr.data;
                curr = root;
            }
        }
        return ans + '\0';
    }
}
