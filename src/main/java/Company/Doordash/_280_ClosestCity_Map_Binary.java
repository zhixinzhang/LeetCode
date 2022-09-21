package Company.Doordash;

import java.util.*;


/**
 *  https://www.lintcode.com/problem/280/solution/65502
 * @author Luke(New Man) Zhang
 * @Date 9/18/2022 10:51 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class _280_ClosestCity_Map_Binary {
    /**
     * @param : an array of integers, the x coordinates of each city[i]
     * @param : an array of integers, the y coordinates of each city[i]
     * @param : an array of strings that represent the names of each city[i]
     * @param : an array of strings that represent the names of query locations
     * @return: the closest city for each query
     */
    /*
    Map<name, int[]> 存city name and x, y
    Map<x, List<City name>> 存同一个x下的y
    Map<y, List<City name>> 存同一个y下的x
    对于每个q中的城市, 查找到它对应的x和y. 然后去hashMap中找和它最接近的greater和smaller x/y,
    得出的x/y再compare 得到更小的那个城市.
    */
    class City {
        String name;
        int x;
        int y;
        public City(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }
    }
    public String[] nearestNeighbor(int[] x, int[] y, String[] c, String[] q) {
        // write your code here
        String[] res = new String[q.length];
        HashMap<String, City> nameToCity = new HashMap<>();
        HashMap<Integer, List<City>> xToCity = new HashMap<>();
        HashMap<Integer, List<City>> yToCity = new HashMap<>();
        for (int i = 0; i < c.length; i++) {
            City city = new City(c[i], x[i], y[i]);
            nameToCity.put(c[i], city);
            xToCity.putIfAbsent(x[i], new ArrayList<City>());
            xToCity.get(x[i]).add(city);
            yToCity.putIfAbsent(y[i], new ArrayList<City>());
            yToCity.get(y[i]).add(city);
        }

        int i = 0;
        for (String qName : q) {
            City qCity = nameToCity.get(qName);
            int qX = qCity.x, qY= qCity.y;
            // 找到y上最近的城市, 和x上最近的城市
            City closestYCity = findClosest(qY, xToCity.get(qX), false, qName), closestXCity = findClosest(qX, yToCity.get(qY), true, qName);
            if (closestXCity == null && closestYCity == null) {
                res[i] = "NONE";
            } else if (closestXCity == null) {
                res[i] = closestYCity.name;
            } else if (closestYCity == null) {
                res[i] = closestXCity.name;
            } else {
                int diff = Math.abs(closestYCity.y) - Math.abs(closestXCity.x);
                if (diff == 0) {
                    res[i] = closestYCity.name.compareTo(closestXCity.name) < 0 ? closestYCity.name : closestXCity.name;
                } else if (diff < 0) {
                    res[i] = closestYCity.name;
                } else {
                    res[i] = closestXCity.name;
                }
            }
            i++;
        }
        return res;
    }

    // 可以二分找smallestLarge和largestSmall. 懒了, 直接one pass遍历一遍了
    private City findClosest(int p, List<City> cities, boolean isX, String name) {
        City closest = null;
        int closestDiff = Integer.MAX_VALUE;
        for (City c : cities) {
            int v = isX ? c.x : c.y;
            int diff = Math.abs(v - p);
            if (diff <= closestDiff && !c.name.equals(name)) {
                if ((diff == closestDiff && c.name.compareTo(closest.name) < 0) || diff < closestDiff) {
                    closestDiff = diff;
                    closest = c;
                }
            }
        }
        return closest;
    }
}
