package practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private static final long serialVersionUID = 1L;
    private int lruSize;

    public LRUCache(int lruSize) {
        super(16, 0.75f, true);
        this.lruSize = lruSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > lruSize;
    }

}

class LRUConcurrentCache<K, V> {
    private final Map<K, V> cache;

    public LRUConcurrentCache(final int maxEntries) {
        this.cache = new LinkedHashMap<K, V>(maxEntries, 0.75F, true) {
            private static final long serialVersionUID = -1236481390177598762L;
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > maxEntries;
            }
        };
    }

    public synchronized void put(K key, V value) {
            cache.put(key, value);
    }

    public synchronized V get(K key) {
            return cache.get(key);
    }
}

public class LRULinkedHashMap {
    public static void main(String args[]) throws Exception {
        int cacheSize = 5;
        Map<Integer, String> mapVehicleNoAndOwner = new LRUCache<>(cacheSize);

        mapVehicleNoAndOwner.put(1000, "Federer");
        mapVehicleNoAndOwner.put(2000, "Bradman");
        mapVehicleNoAndOwner.put(3000, "Jordan");
        mapVehicleNoAndOwner.put(4000, "Woods");
        mapVehicleNoAndOwner.put(5000, "Ali");

        System.out.println("1. Iterating initial cache of size = " + cacheSize);
        demoIterateCache(mapVehicleNoAndOwner);

        int key = 1000;
        System.out.printf("2. Accessting value at key: %d is %s\n", key, mapVehicleNoAndOwner.get(key));

        key = 3000;
        System.out.printf("3. Accessting value at key: %d is %s\n", key, mapVehicleNoAndOwner.get(key));

        System.out.println("4. Iterating cache after accessing its keys: ");
        demoIterateCache(mapVehicleNoAndOwner);

        key = 6000;
        String value = "Don";
        System.out.printf("5. Adding new entry to cache, key=%d, value=%s\n", key, value);
        mapVehicleNoAndOwner.put(6000, "Don");
        key = 7000;
        value = "Campbell";
        System.out.printf("6. Adding new entry to cache, key=%d, value=%s\n", key, value);
        mapVehicleNoAndOwner.put(7000, "Campbell");

        System.out.println("7. Iterating cache after adding entries beyond its size: ");
        demoIterateCache(mapVehicleNoAndOwner);
    }

    private static void demoIterateCache(Map<Integer, String> mapVehicleNoAndOwner) {

        mapVehicleNoAndOwner.forEach((key, value) -> {
            System.out.println("Key:" + key + ", Value:" + value);
        });
    }
}