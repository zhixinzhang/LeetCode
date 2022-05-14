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
 */

public class NearstCities_TreeMap {

    public static void main(String[] args){



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
            sameYCityMap.computeIfAbsent(xLocation, key -> new TreeMap<>()).put(xLocation, name);
            nameToXYMap.put(name, new int[]{xLocation, yLocation});
        }

        // use treeMap to get closest city
        List<String> res = new ArrayList<>();
        for (String queriedCity : query){
            CityDist minCity = new CityDist(Integer.MAX_VALUE, "NONE");
            int[] queriedLocation = nameToXYMap.get(queriedCity);
            int qX = queriedLocation[0], qY = queriedLocation[1];
            TreeMap<Integer, String> sameXCities = sameXCityMap.get(queriedCity);
            TreeMap<Integer, String> sameYCities = sameYCityMap.get(queriedCity);

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
                cityDist.dist = curDis;
            }
        }
    }


}



