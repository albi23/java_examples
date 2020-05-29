package generictype.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MapUtils {

    /*
    Map sort by values
    */
    public static <K, V extends Comparable<V>> Map<K, V> sortByValuesReserved(final Map<K, V> map) {
        return sortByValues(map, true);
    }

    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map, boolean reversed) {
        int direction = (reversed) ? -1 : 1;
        Comparator<K> valueComparator = (k1, k2) -> {
            int compare = direction * map.get(k1).compareTo(map.get(k2));
            return (compare == 0) ? 1 : compare; // not return  0 protect before override values
        };
        return new TreeMap(valueComparator) {{
            putAll(map);
        }};
    }
}
