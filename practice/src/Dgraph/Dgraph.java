package Dgraph;


import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ConcurrentHashMap {
    private final ReadWriteLock[] readWriteLock;

    List<Map<String, String>> arr;
    int parallizationRequired;

    ConcurrentHashMap(int parallizationRequired) {
        readWriteLock = new ReentrantReadWriteLock[parallizationRequired];
        arr = new ArrayList<>();
        this.parallizationRequired = parallizationRequired;
        for (int i = 0; i < parallizationRequired; i++) {
            arr.add(new HashMap<>());
            readWriteLock[i] = new ReentrantReadWriteLock();
        }
    }

    public boolean contains(String k) {

        int segment = k.hashCode() % parallizationRequired;
        if (k == null) {
            return false;
        }
        try {
            readWriteLock[segment].readLock().lock();
            return arr.get(segment).containsKey(k);
        } catch (Exception e) {
        } finally {
            readWriteLock[segment].readLock().unlock();
        }
        return false;
    }

    public void put(String k, String v) {
        if (k == null) {
            return;
        }
        int segment = k.hashCode() % parallizationRequired;
        try {
            readWriteLock[segment].writeLock().lock();

            arr.get(segment).put(k, v);
        } catch (Exception e) {
        } finally {
            readWriteLock[segment].writeLock().unlock();
        }
    }

    public void print() {
        for (Map<String, String> map : arr) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey());
            }
        }
    }
}

class Task extends Thread {
    List<String> list;
    ConcurrentHashMap concurrentHashMap;

    Task(List<String> input, ConcurrentHashMap concurrentHashMap) {
        super();
        list = input;
        this.concurrentHashMap = concurrentHashMap;
    }

    public void run() {
        for (String s : list) {
            concurrentHashMap.put(s, "");
        }
    }
}

public class Dgraph {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(3);
        concurrentHashMap.print();

        Thread t1 = new Task(new ArrayList<>(Arrays.asList("abc", "def", "ghi")), concurrentHashMap);
        Thread t2 = new Task(new ArrayList<>(Arrays.asList("1", "2", "3")), concurrentHashMap);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        concurrentHashMap.print();

    }
}
