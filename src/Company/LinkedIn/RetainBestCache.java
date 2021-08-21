package Company.LinkedIn;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 6/24/2021 10:35 AM
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

/*
 * For reference, here are the Rankable and DataSource interfaces.
 * You do not need to implement them, and should not make assumptions
 * about their implementations.
 */

public class RetainBestCache<K, T extends RetainBestCache.Rankable> {
    int entriesToRetain;
    Map<K, T> keyValueMap; // map<key, val>
    Map<Long, List<K>> rankKeyMap; // map<rank, list<key>>
    DataSource<K, T> ds;

    /* Constructor with a data source (assumed to be slow) and a cache size */
    public RetainBestCache(DataSource<K, T> ds, int entriesToRetain) {
        this.keyValueMap = new HashMap<>();
        this.rankKeyMap = new TreeMap<>();
        this.ds = ds;
        this.entriesToRetain = entriesToRetain;
    }

    /* Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,
     * retrieves it from the data source. If the cache is full, attempt to cache the returned data,
     * evicting the T with lowest rank among the ones that it has available
     * If there is a tie, the cache may choose any T with lowest rank to evict.
     */

    public T get(K key) {
        if (keyValueMap.containsKey(key)) {
            return keyValueMap.get(key);
        }
        T val = ds.get(key);
        keyValueMap.put(key, val);
        rankKeyMap.put(val.getRank(), new ArrayList<>());
        rankKeyMap.get(val.getRank()).add(key);
        while (keyValueMap.size() > entriesToRetain) {
            Long lowestRank = rankKeyMap.keySet().iterator().next();
            K k = rankKeyMap.get(lowestRank).get(0);
            rankKeyMap.get(lowestRank).remove(0);
            if (rankKeyMap.get(lowestRank).size() == 0) {
                rankKeyMap.remove(lowestRank);
            }
            keyValueMap.remove(k);
        }
        return val;
    }


    public interface Rankable {
        /**
         * Returns the Rank of this object, using some algorithm and potentially
         * the internal state of the Rankable.
         */
        long getRank();
    }

    public interface DataSource<K, T extends Rankable> {
        T get(K key);
    }
}


