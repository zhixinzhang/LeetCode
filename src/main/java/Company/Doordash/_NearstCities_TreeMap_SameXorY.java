package Company.Doordash;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 8/19/2021 11:23 PM
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
 * 
 * Determine the name of the nearest city that shares either an x or a y coordinate with the queried city.
 */

public class _NearstCities_TreeMap_SameXorY {

    public static void main(String[] args) {
        String[] cities = {"axx", "axy", "az", "axd", "aa", "abc", "abs", "p"};
        int[] xValues = {0,1,2,4,5,0,1,0};
        int[] yValues = {1,2,5,3,4,2,0,2};
        String[] queries = {"axx", "axy", "abs", "zmm"};
        System.out.println(getNearestCities(cities, xValues, yValues, queries));
    }

    static class CityDist{
        int dist;
        String name;

        public CityDist(int dist, String city){
            this.dist = dist;
            this.name =city;
        }
    }

    private static List<String> getNearestCities(String[] names, int[] x, int[] y, String[] query){
        HashMap<Integer, TreeMap<Integer, String>> sameXCityMap = new HashMap<>();
        HashMap<Integer, TreeMap<Integer, String>> sameYCityMap = new HashMap<>();
        HashMap<String, int[]> nameToXYMap = new HashMap<>();

        for (int i = 0; i < names.length; i++){
            String name = names[i];
            int xLocation = x[i];
            int yLocation = y[i];

            sameXCityMap.computeIfAbsent(xLocation, key -> new TreeMap<>()).put(yLocation, name);
            sameYCityMap.computeIfAbsent(yLocation, key -> new TreeMap<>()).put(xLocation, name);
            nameToXYMap.put(name, new int[]{xLocation, yLocation});
        }

        // use treeMap to get closest city
        List<String> res = new ArrayList<>();
        for (String queriedCity : query){
            CityDist minCity = new CityDist(Integer.MAX_VALUE, "NONE");
            int[] queriedLocation = nameToXYMap.get(queriedCity);
            if (queriedLocation == null) {
                res.add(minCity.name);
                continue;
            }
            int qX = queriedLocation[0], qY = queriedLocation[1];
            TreeMap<Integer, String> sameXCities = sameXCityMap.get(qX);
            TreeMap<Integer, String> sameYCities = sameYCityMap.get(qY);

            Map.Entry<Integer, String> sameXLowerCity = sameXCities.lowerEntry(qY);
            updateCloserCity(sameXLowerCity, qY, minCity);

            Map.Entry<Integer, String> sameXHigherCity = sameXCities.higherEntry(qY);
            updateCloserCity(sameXHigherCity, qY, minCity);

            Map.Entry<Integer, String> sameYLowerCity = sameYCities.lowerEntry(qX);
            updateCloserCity(sameYLowerCity, qX, minCity);

            Map.Entry<Integer, String> sameYHigherCity = sameYCities.higherEntry(qX);
            updateCloserCity(sameYHigherCity, qX, minCity);

            res.add(minCity.name);
        }


        return res;
    }

    private static void updateCloserCity(Map.Entry<Integer, String> sameCoorCity, int querLocation, CityDist cityDist){
        if (sameCoorCity != null){
            int location = sameCoorCity.getKey();
            String cityName = sameCoorCity.getValue();

            int curDis = Math.abs(location - querLocation);
            if (curDis < cityDist.dist || (curDis == cityDist.dist && cityName.compareTo(cityDist.name) < 0)) {
                cityDist.dist = curDis;
                cityDist.name = cityName;
            }
        }
    }

}



