package practice.ibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterviewbitGreedy {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        InterviewbitGreedy ibit = new InterviewbitGreedy();

        //System.out.println(ibit.HighestProduct(new ArrayList<>(Arrays.asList(1, -2, -3, 2, 5, 2))));
        //System.out.println(ibit.Bulbs(new ArrayList<>(Arrays.asList(0,1,0,1))));
        //System.out.println(ibit.seats("....x..xx...x.."));

        //System.out.println(ibit.majority(new ArrayList<>(Arrays.asList(1, 1, 2))));
        //System.out.println(ibit.DistributeCandy(new ArrayList<>(Arrays.asList(7, 5, 2, 6))));
        //System.out.println(ibit.GasStation(new ArrayList<>(Arrays.asList(4, -4, 2)),new ArrayList<>(Arrays.asList(4, 0, 5))));

        System.out.println(ibit.GasStation(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)),
                new ArrayList<>(Arrays.asList(3, 4, 5, 1, 2))));
    }

    int GasStation(ArrayList<Integer> gas, ArrayList<Integer> cost) {
        int fuelRemaining = 0;
        int totalFuel = 0;
        int start = 0;
        int n = gas.size();
        for (int i = 0; i < n; i++) {
            int extraFuel = gas.get(i) - cost.get(i);
            if (fuelRemaining >= 0) {
                fuelRemaining += extraFuel;
            }else{
                fuelRemaining = extraFuel;
                start=i;
            }
            totalFuel +=extraFuel;
        }
        if(totalFuel>=0){
            return start;
        }else {
            return -1;
        }
    }

    int AssignMicetoHoles(ArrayList<Integer> mice, ArrayList<Integer> holes) {
        mice.sort((u, v) -> (u - v));
        holes.sort((u, v) -> (u - v));
        int max = 0;
        for (int i = 0; i < mice.size(); i++) {
            max = Math.max(max, Math.abs(mice.get(i) - holes.get(i)));
        }
        return max;
    }

    int DistributeCandy(ArrayList<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }
        int[] arr = new int[A.size()];
        arr[0] = 1;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > A.get(i - 1)) {
                arr[i] = arr[i - 1] + 1;
            } else {
                arr[i] = 1;
            }
        }
        int ans = 0;
        int p = 1, c;
        ans = Math.max(arr[A.size() - 1], p);
        for (int i = A.size() - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1)) {
                c = p + 1;
            } else {
                c = 1;
            }
            ans += Math.max(arr[i], c);
            p = c;
        }
        return ans;
    }

    int majority(ArrayList<Integer> A) {
        int m = 0, majorityCount = 0;
        for (int a : A) {
            if (majorityCount == 0 || m == a) {
                m = a;
                majorityCount++;
            } else if (m != a) {
                majorityCount--;
            }
        }
        return m;
    }

    int seats(String A) {
        int n = A.length();
        int i;
        int mod = 10000003;
        List<Integer> arr = new ArrayList<>();
        for (i = 0; i < n; i++) {
            if (A.charAt(i) == 'x') {
                arr.add(i);
            }
        }
        int median = arr.size() / 2;
        int occupied = 1;
        int jumps = 0;
        for (i = 0; i < median; i++) {
            jumps += arr.get(median) - arr.get(i) - occupied;
            jumps %= mod;
            occupied++;
        }
        occupied = 1;
        for (i = median + 1; i < arr.size(); i++) {
            jumps += arr.get(i) - arr.get(median) - occupied;
            jumps %= mod;
            occupied++;
        }
        return jumps;
    }

    int Bulbs(ArrayList<Integer> bulbs) {
        int flips = 0;
        boolean firstOn = true;
        for (int i = 0; i < bulbs.size(); i++) {
            if (bulbs.get(i) == 0 && firstOn) {
                firstOn = false;
                flips++;
            } else if (!firstOn) {
                if (!bulbs.get(i).equals(bulbs.get(i - 1)))
                    flips++;
            }
        }
        return flips;
    }


    int HighestProduct(ArrayList<Integer> num) {
        int max1, max2, max3, min1, min2;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        min1 = min2 = Integer.MAX_VALUE;
        for (int a : num) {
            if (a > max1) {
                max3 = max2;
                max2 = max1;
                max1 = a;
            } else if (a > max2) {
                max3 = max2;
                max2 = a;
            } else if (a > max3) {
                max3 = a;
            }

            if (a < min1) {
                min2 = min1;
                min1 = a;
            } else if (a < min2) {
                min2 = a;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
