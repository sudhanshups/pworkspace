package practice.specific;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.IntStream;


public class AllocateRestaurantTable {


    public static void main(String[] args) throws Exception {

        int twoSeaterTables = 2;
        int fourSeaterTables = 3;
        int sixSeaterTables = 1;
/*        int[] groupSize = new int[]{2, 2, 6,1,5,2,3,3};
        int[] arrivalTime = new int[]{5, 10, 16,17,18,19,20,32};*/
        int[] groupSize = new int[]{1};
        int[] arrivalTime = new int[]{170};
        List<List<Event>> events = allocateSeats(twoSeaterTables, fourSeaterTables, sixSeaterTables, groupSize, arrivalTime);

        for (List<Event> timeEvents : events) {
            for (Event e : timeEvents) {
                e.print();
            }
        }

    }


    static List<List<Event>> allocateSeats(int twoSeaterTables, int fourSeaterTables, int sixSeaterTables,
                                           int[] groupSizes, int[] arrivalTimes) {

        Queue<Integer> twoSeaterTableNextFreeTime = new PriorityQueue<>(Comparator.comparingInt(u -> u));
        Queue<Integer> fourSeaterTablesNextFreeTime = new PriorityQueue<>(Comparator.comparingInt(u -> u));
        Queue<Integer> sixSeaterTablesNextFreeTime = new PriorityQueue<>(Comparator.comparingInt(u -> u));

        List<List<Event>> events = new ArrayList<>();

        IntStream.range(0, twoSeaterTables).mapToObj(i -> 0).forEach(twoSeaterTableNextFreeTime::add);
        IntStream.range(0, fourSeaterTables).mapToObj(i -> 0).forEach(fourSeaterTablesNextFreeTime::add);
        IntStream.range(0, sixSeaterTables).mapToObj(i -> 0).forEach(sixSeaterTablesNextFreeTime::add);
        for (int i = 0; i < 181; i++) {
            events.add(new ArrayList<>());
        }

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            int arrivalTime = arrivalTimes[i];
            int timeRequired = 10 + 5 * size;

            int allocatedTime = -1;
            int nextFreeTime = -1;
            int waitTime = -1;
            int tableGot = -1;
            boolean allocated = false;

            if (size <= 2) {
                if ((twoSeaterTableNextFreeTime.peek() < (arrivalTime + 10)) && ((Math.max(twoSeaterTableNextFreeTime.peek(), arrivalTime) + timeRequired) <= 180)) {
                    allocatedTime = Math.max(twoSeaterTableNextFreeTime.poll(), arrivalTime);
                    waitTime = allocatedTime - arrivalTime;
                    nextFreeTime = allocatedTime + timeRequired;
                    twoSeaterTableNextFreeTime.add(nextFreeTime);
                    tableGot = 2;
                    allocated = true;
                }
            } else if (size <= 4) {
                if ((fourSeaterTablesNextFreeTime.peek() < (arrivalTime + 10))
                        && ((Math.max(fourSeaterTablesNextFreeTime.peek(), arrivalTime) + timeRequired) <= 180)) {
                    allocatedTime = Math.max(fourSeaterTablesNextFreeTime.poll(), arrivalTime);
                    waitTime = allocatedTime - arrivalTime;
                    nextFreeTime = allocatedTime + timeRequired;

                    fourSeaterTablesNextFreeTime.add(nextFreeTime);
                    tableGot = 4;
                    allocated = true;
                }
            } else if (size <= 6) {
                if ((sixSeaterTablesNextFreeTime.peek() < (arrivalTime + 10))
                        && ((Math.max(sixSeaterTablesNextFreeTime.peek(), arrivalTime) + timeRequired) <= 180)) {
                    allocatedTime = Math.max(sixSeaterTablesNextFreeTime.poll(), arrivalTime);
                    waitTime = allocatedTime - arrivalTime;
                    nextFreeTime = allocatedTime + timeRequired;
                    sixSeaterTablesNextFreeTime.add(nextFreeTime);
                    tableGot = 6;
                    allocated = true;
                }
            }

            if (allocated) {
                Event arrivalEvent = new Event(allocated, arrivalTime, i + 1, size, 0, tableGot, waitTime);
                Event waitEvent = new Event(allocated, arrivalTime, i + 1, size, 1, tableGot, waitTime);
                Event releaseEvent = new Event(allocated, nextFreeTime, i + 1, size, 2, tableGot, waitTime);
                events.get(arrivalTime).add(arrivalEvent);
                events.get(arrivalTime).add(waitEvent);
                events.get(nextFreeTime).add(releaseEvent);

            } else {
                Event arrivalEvent = new Event(allocated, arrivalTime, i + 1, size, 0, tableGot, waitTime);
                Event releaseEvent = new Event(allocated, arrivalTime, i + 1, size, 2, tableGot, waitTime);
                events.get(arrivalTime).add(arrivalEvent);
                events.get(arrivalTime).add(releaseEvent);
            }
        }
        return events;
    }
}

@AllArgsConstructor
@Data
class Event {
    Boolean allocated;
    int time;
    int groupId;
    int groupSize;
    int actionType;//0-arr,1-wait,2-released
    int table;//2,4,6
    int waitTime;

    void print() {
        String action = "";
        switch (actionType) {
            case 0:
                action = "arrived";
                System.out.println("At t=" + time + ", Group-" + groupId + " of " + groupSize + " guests " + action);
                break;
            case 1:
                action = "waiting";
                System.out.println("At t=" + time + ", Group-" + groupId + " of " + groupSize + " guests " + action
                        + " for " + waitTime + " Got " + table + "-seater table");
                break;
            case 2:
                action = "released";
                System.out.println("At t=" + time + ", Group-" + groupId + " of " + groupSize + " guests " + action
                        +" "+ table + "-seater table");
                break;
        }
    }
}

