package Company.Doordash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _NearestNeighborCity_Map {


    public static void main(String[] args) {
        String[] cities = {"axx", "axy", "az", "axd", "aa", "abc", "abs", "p"};
        int[] xValues = {0,1,2,4,5,0,1,0};
        int[] yValues = {1,2,5,3,4,2,0,2};
        String[] queries = {"axx", "axy", "abs", "zmm"};
        System.out.println(closestCities(cities, xValues, yValues, queries));
    }


    public static List<String> closestCities(String[] cities, int[] x, int[] y, String[] queries) {
        int n = cities.length;
        Map<String, Integer> map = new HashMap<>(); // city : index
        for(int i=0; i<n; i++) {
            map.put(cities[i], i);
        }
        
        List<String> res = new ArrayList<>();
        for(int i=0; i<queries.length; i++) {
            res.add(getClosestCity(cities, x, y, queries[i], map));
        }
        return res;
    }

private static String getClosestCity(String[] cities, int[] x, int[] y, String queryCity, Map<String, Integer> map) {
    int res = -1, minDist = Integer.MAX_VALUE;
    if(!map.containsKey(queryCity)) return "NONE";
    
    int queryIndex = map.get(queryCity);
    int r = x[queryIndex], c = y[queryIndex];
    for(int i=0; i<cities.length; i++) {
        if(i == queryIndex) continue;
        if(x[i] == r || y[i] == c) {
            int dist = Math.abs(x[i]-r) + Math.abs(y[i]-c);
            if(dist < minDist) {
                res = i;
                minDist = dist;
            } else if(dist == minDist) {
                if(cities[i].compareTo(cities[res]) < 0) {
                    res = i;
                }
            }
        }
    }
    return res == -1 ? "NONE" : cities[res];
}
}
