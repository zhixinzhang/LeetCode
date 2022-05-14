package NewMan2021;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author: luke
 * @Date: 2020/10/25 17:51
 * Link : https://leetcode.com/problems/video-stitching/
 */
public class _1024_VideoStitching_ArraysSort {
    public static int videoStitching(int[][] clips, int T) {
        if (clips == null || clips.length == 0 || clips[0].length == 0) {
            return 0;
        }
        Arrays.sort(clips, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        // [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]]
        // [[0,2],[1,5],[1,9],[4,6],[5,9],[8,10]]
        // [0, 5] -> [0, 9] -> [1, 10]
        // count 3
        int count = 0;
        int current = 0;

        for(int i = 0; i < clips.length; ) {
            if(clips[i][0] > current) {
                return -1;
            }
            int maxEnd = current;
            // while loop to handle case like [0, 4][2, 5][2, 6][4, 8]  -> [0, 8] one cut
            while(i < clips.length && clips[i][0] <= current) {
                maxEnd = Math.max(maxEnd, clips[i][1]);
                i++;
            }
            count++;
            current = maxEnd;
            if(current >= T) {
                return count;
            }
        }
        return -1;
    }

    public static void main(String[] args){
//        int[][] clips = new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
//        int[][] clips = new int[][]{{0,4},{2,8}};
        int[][] clips = new int[][]{{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        videoStitching(clips, 9);
    }
}
