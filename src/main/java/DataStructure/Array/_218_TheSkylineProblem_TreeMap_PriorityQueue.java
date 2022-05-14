package DataStructure.Array;

import java.util.*;

/**
 * @Author: Luke(New Man) Zhang
 * @Date: 2021/1/8 2:25
 * Link :
 * Description: https://leetcode.com/problems/the-skyline-problem/discuss/805811/Java-solution-using-tree-map-with-succinct-explanation
 *
 * Inspired by Tushar Roy's youtube video.
 *
 * Idea is to convert the input into buildingPoints that represent start and end of a building. So for n buildings there will be n*2 buildingPoints.
 * We sort the building points in the following order :
 *
 * Keep buildings that start first i.e whose beginning buildingPoint.x coordinate comes first.
 * If two buildings have the same buildingPoint.x coordinate,
 * a. if both are start, i.e BuildingPoint represents the start of the building for both the buildings, Keep the one with higher height first.
 * b.if both are end, i.e BuildingPoint represents the end of the building for both the buildings, Keep the one with lower height first.
 * c. Else keep the building point representing start of the building first.
 * Process these sorted building points one by one, using a tree map or a priority Queue. Tree map provides the remove method with O(log(n)) while priority queue gives it in O(n)
 */
public class _218_TheSkylineProblem_TreeMap_PriorityQueue {

    private static class BuildingPoint implements Comparator<BuildingPoint> {
        int x;
        int height;
        boolean isStart;

        BuildingPoint(){

        }

        BuildingPoint(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }

        @Override
        public int compare(BuildingPoint b1, BuildingPoint b2){
            if(b1.x == b2.x){
                // b1 b2 -> b2 b1 if height of b2 > b1
                if(b1.isStart && b2.isStart) return b2.height - b1.height;
                    //Always have start before end
                else if(!b1.isStart && b2.isStart) return 1;
                else if(b1.isStart && !b2.isStart) return -1;
                else if(!b1.isStart && !b2.isStart) return b1.height - b2.height;
            }
            return b1.x - b2.x;
        }
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        BuildingPoint[] buildingPoints = new BuildingPoint[ buildings.length * 2];
        int k=0;
        for(int[] building : buildings){
            BuildingPoint start = new BuildingPoint(building[0],building[2],true);
            buildingPoints[k++] = start;
            BuildingPoint end = new BuildingPoint(building[1],building[2],false);
            buildingPoints[k++] = end;
        }

        Arrays.sort(buildingPoints, new BuildingPoint());
        List<List<Integer>> result = new ArrayList<>();

        //To show height and count of heights
        //max value first comparator applied
        TreeMap<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
        int max = 0;
        map.put(0,0);

        for (BuildingPoint buildingPoint : buildingPoints) {
            if (buildingPoint.isStart) {
                map.compute(buildingPoint.height, (key, value) -> (value == null) ? 1 : value + 1);
            } else {
                map.compute(buildingPoint.height,(key,value) ->{
                    if(value==1) return null;
                    value = value-1;
                    return value;
                });
                int a = 1;
            }
            if(map.firstKey() != max){
                max = map.firstKey();
                result.add(Arrays.asList(buildingPoint.x, map.firstKey()));

            }
        }

        return result;
    }




        public List<List<Integer>> getSkyline_TreeMap(int[][] buildings) {

        List<List<Integer>> arr = new ArrayList<>();
        for (int[] build : buildings){
            arr.add(new ArrayList<>(Arrays.asList(build[0], build[2], 0)));
            arr.add(new ArrayList<>(Arrays.asList(build[1], build[2], 1)));
        }

        arr.sort((a,b) -> {
            if(!a.get(0).equals(b.get(0))){
                return a.get(0) - b.get(0);
            }
            else{
                return (a.get(2).equals(0)?-a.get(1):a.get(1)) - (b.get(2).equals(0)?-b.get(1):b.get(1));
            }
        });

        TreeMap<Integer,Integer> map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        int max = 0;

        for (List<Integer> i : arr) {
            if(map.size()==0){
                map.put(0,1);
                max = 0;
            }

            if(i.get(2) == 0){
                if(max < i.get(1)){
                    ans.add(new ArrayList(Arrays.asList(i.get(0),i.get(1))));
                    map.put(i.get(1), map.getOrDefault(i.get(1),0)+1);
                    max = i.get(1);
                }
                else{
                    map.put(i.get(1),map.getOrDefault(i.get(1),0)+1);
                }
            } else {

                int val = map.get(i.get(1));
                if(val == 1){
                    map.remove(i.get(1));
                }
                else{
                    map.put(i.get(1),val-1);
                }
                if(max==i.get(1) && val == 1){
                    max=map.floorKey(max);
                    ans.add(new ArrayList(Arrays.asList(i.get(0),max)));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[][] buildings = new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
//                [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ];
        getSkyline(buildings);
    }
}
