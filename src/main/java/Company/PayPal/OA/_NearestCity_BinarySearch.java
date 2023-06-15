package Company.PayPal.OA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * https://leetcode.com/discuss/interview-question/949904/amazon-oa2-nearest-city
 * Anyone can provide the solution, java plz:

Given a list of points, find the nearest points that shares either an x or a y coordinate with the queried point.

The distance is denoted on a Euclidean plane: the difference in x plus the difference in y.

Input

numOfPoints, an integer representing the number of points;

points, a list of strings representing the names of each point [i];

xCoordinates, a list of integers representing the X coordinates of each point[i];

yCoordinates, a list of integers representing the Y coordinates of each point[i];

numOfQueriedPoints, an integer representing the number of points queried;

queriedPoints, a list of strings representing the names of the queried points.
 * 
*/
public class _NearestCity_BinarySearch {
    static class City {
        int[] pos = new int[2];
        int idx;
        String name;
        City(int x, int y, String name, int idx) {
            this.pos[0] = x;
            this.pos[1] = y;
            this.name = name;
            this.idx = idx;
        }
    }

    public static String[] findNearestCities(String[] names, int[] xs, int[] ys, String[] queries) {
        HashMap<String, City> cities = new HashMap<>();
        HashMap<Integer, ArrayList<City>> xCities = new HashMap<>();
        HashMap<Integer, ArrayList<City>> yCities = new HashMap<>();

        for(int i = 0; i < names.length; i++) {
            City city = new City(xs[i], ys[i], names[i], i);
            cities.put(names[i], city);

            // store cities in the same x or y
            xCities.computeIfAbsent(xs[i], k -> new ArrayList<>());
            xCities.get(xs[i]).add(city);
            yCities.computeIfAbsent(ys[i], k -> new ArrayList<>());
            yCities.get(ys[i]).add(city);
        }

        // sort all list, cost O(NlogN)
        for(ArrayList<City> c : xCities.values()) {
            c.sort(Comparator.comparingInt(o -> o.pos[1]));
        }
        for(ArrayList<City> c : yCities.values()) {
            c.sort(Comparator.comparingInt(o -> o.pos[0]));
        }

        String[] ans = new String[queries.length];

        // find neighbor cities by binary search, cost O(NlogN)
        for(int i = 0; i < queries.length; i++) {
            City query = cities.get(queries[i]);

            String res = null;
            City xMin = null;
            City yMin = null;
            int dis1 = Integer.MAX_VALUE;
            int dis2 = Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;
            ArrayList<City> xq = xCities.get(query.pos[0]);
            if(xq.size() > 1) {
                xMin = findMinDis(xq, 0, xq.size() - 1, 0, query);
                dis1 = Math.abs(xMin.pos[1] - query.pos[1]);
            }
            ArrayList<City> yq = yCities.get(query.pos[1]);
            if(yq.size() > 1) {
                yMin = findMinDis(yq, 0, yq.size() - 1, 1, query);
                dis2 = Math.abs(yMin.pos[0] - query.pos[0]);
            }

            if(xMin != null || yMin != null) {
                boolean condition = dis1 < dis2;
                if(dis1 == dis2 && xMin != null && yMin != null) {
                    condition = xMin.idx < yMin.idx;
                }
                res = condition ? xMin.name : yMin.name;
            }

            ans[i] = res;
        }

        return ans;
    }

    public static City findMinDis(ArrayList<City> cities, int low, int high, int axis, City target) {
        int otherAxis = 1-axis;
        int mid = (low+high)/2;
        City midCity = cities.get(mid);
        
        if(midCity == target) {
            int dis1 = Integer.MAX_VALUE;
            int dis2 = Integer.MAX_VALUE;
            if(mid - 1 >= 0) {
                dis1 = Math.abs(cities.get(mid - 1).pos[otherAxis] - target.pos[otherAxis]);
            }
            if(mid + 1 < cities.size()) {
                dis2 = Math.abs(cities.get(mid + 1).pos[otherAxis] - target.pos[otherAxis]);
            }

            boolean condition = dis1 < dis2;
            if(dis1 == dis2) {
                condition = cities.get(mid - 1).idx < cities.get(mid + 1).idx;
            }

            return condition ? cities.get(mid - 1) : cities.get(mid + 1);
        } else if(midCity.pos[otherAxis] > target.pos[otherAxis]) {
            return findMinDis(cities, low, mid, axis, target);
        } else {
            return findMinDis(cities, mid+1, high, axis, target);
        }
    }
}
