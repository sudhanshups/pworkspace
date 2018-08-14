package practice.specific;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class CabTripTime implements Comparable<CabTripTime> {
    int time;
    int cabTripTime;
    public CabTripTime(int time, int cabTripTime) {
        this.time = time;
        this.cabTripTime = cabTripTime;
    }
    @Override
    public int compareTo(CabTripTime o) {
        if (this.time > o.time) {
            return 1;
        } else if (this.time < o.time) {
            return -1;
        }
        return 0;
    }
}

public class EfficientCabScheduling {
    public static int getMinimumTime(int n, int k, int[] tripTime) {
        Queue<CabTripTime> p = new PriorityQueue<>();
        for(int i =0;i<tripTime.length;i++){
            p.add(new CabTripTime(tripTime[i],tripTime[i]));
        }
        int trips =0,time=0;
        while(trips<n){
            CabTripTime c = p.remove();
            time= c.time;
            c.time = c.cabTripTime + c.time;
            trips++;
            p.add(c);
        }
        return time;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 1;
        int tripTime[] = {1,2}; // trip time
        Arrays.sort(tripTime);
        System.out.println(getMinimumTime(n,k,tripTime));
    }
}
