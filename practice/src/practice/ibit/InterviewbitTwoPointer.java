package practice.ibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InterviewbitTwoPointer {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        InterviewbitTwoPointer ibit = new InterviewbitTwoPointer();
        /*ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 5, 8, 10));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(6, 9, 15));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(2, 3, 6, 6));*/
        //ibit.merge(A, B);
        //System.out.println(ibit.intersect(A, B));
        //System.out.println(ibit.findMaxMinDiffInArrays(A, B,C));

/*        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 1, -9, -7, -8, 2, -8, 2, 3, -8));
        System.out.println(ibit.threeSumClosest(A, -1));*/

/*        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, -1, -4));
        System.out.println(ibit.threeSumZero(A));*/

/*        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,1,1,1));
        System.out.println(ibit.nTriangle(A));*/

       /* ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 5));
        System.out.println(ibit.diffPossible(A, 3));*/
/*
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 3, 3, 5, 4));
        System.out.println(ibit.removeDuplicates(A));
        System.out.println(A)*/
        ;

        /*// ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3));
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 1, 2));
        System.out.println(ibit.removeDuplicatesKeep2(A));
        System.out.println(A);*/

        /*ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 0, 1, 2, 0, 3, 2, 2, 2, 1, 0, 0, 0, 1, 0, 0, 2, 2, 2, 3,
                2, 3, 1, 2, 1, 2, 2, 3, 2, 3, 0, 3, 0, 2, 1, 2, 0, 0, 3, 2, 3, 0, 3, 0, 2, 3, 2, 2, 3, 1, 3, 3, 0, 3, 3,
                0, 3, 3, 2, 0, 0, 0, 0, 1, 3, 0, 3, 1, 3, 1, 0, 2, 3, 3, 3, 2, 3, 3, 2, 2, 3, 3, 3, 1, 3, 2, 1, 0, 0, 0,
                1, 0, 3, 2, 1, 0, 2, 3, 0, 2, 1, 1, 3, 2, 0, 1, 1, 3, 3, 0, 1, 2, 1, 2, 2, 3, 1, 1, 3, 0, 2, 2, 2, 2, 1,
                0, 2, 2, 2, 1, 3, 1, 3, 1, 1, 0, 2, 2, 0, 2, 3, 0, 1, 2, 1, 1, 3, 0, 2, 3, 2, 3, 2, 0, 2, 2, 3, 2, 2, 0,
                2, 1, 3, 0, 2, 0, 2, 1, 3, 1, 1, 0, 0, 3, 0, 1, 2, 2, 1, 2, 0, 1, 0, 0, 0, 1, 1, 0, 3, 2, 3, 0, 1, 3, 0,
                0, 1, 0, 1, 0, 0, 0, 0, 3, 2, 2, 0, 0, 1, 2, 0, 3, 0, 3, 3, 3, 0, 3, 3, 1, 0, 1, 2, 1, 0, 0, 2, 3, 1, 1, 3, 2));
//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1,3, 1, 2));
        System.out.println(ibit.removeElement(A, 2));
        System.out.println(A);*/

        /*ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 1, 0, 2, 1, 0));
        ibit.sortColors(A);
        System.out.println(A);*/

       /* ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1, 1, 1));
        System.out.println(ibit.maxone(A, 2));*/

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 10));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2, 15, 20));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(10, 12));
        System.out.println(ibit.minimize(A, B, C));

        System.out.println(ibit.countInversions(new ArrayList<>(Arrays.asList(2, 1, 1))));
    }

    //trap water
    int trap(int height[]) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }


    public int countInversions(ArrayList<Integer> A) {
        int low = 0, high = A.size() - 1;
        int inversion = mergeSort(A, low, high);
        return inversion;
    }

    private int mergeSort(final ArrayList<Integer> A, int low, int high) {
        if (low >= high)
            return 0;
        int mid = (low + high) / 2;
        int inversion = mergeSort(A, low, mid);
        inversion += mergeSort(A, mid + 1, high);
        inversion += merge(A, low, mid, high);
        return inversion;
    }

    private int merge(final ArrayList<Integer> A, int low, int mid, int high) {
        int i, j, k;
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (i = 0; i < n1; i++) {
            L[i] = A.get(i + low);
        }
        for (i = 0; i < n2; i++) {
            R[i] = A.get(i + mid + 1);
        }
        i = j = 0;
        k = low;
        int inversion = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A.set(k++, L[i++]);
            } else {
                inversion += n1 - i;
                A.set(k++, R[j++]);
            }
        }
        while (i < n1) {
            A.set(k++, L[i++]);
        }
        while (j < n2) {
            A.set(k++, R[j++]);
        }

        return inversion;
    }

    class Element {
        int index;
        List<Integer> arr;

        Element(int x, List<Integer> a) {
            index = x;
            arr = a;
        }
    }

    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        Queue<Element> queue = new PriorityQueue<>((u, v) -> (u.arr.get(u.index) - v.arr.get(v.index)));
        queue.add(new Element(0, A));
        queue.add(new Element(0, B));
        queue.add(new Element(0, C));

        int min = Integer.MAX_VALUE;
        while (queue.size() > 2) {
            Element a = queue.poll();
            Element b = queue.poll();
            Element c = queue.poll();

            int aE = a.arr.get(a.index);
            int bE = b.arr.get(b.index);
            int cE = c.arr.get(c.index);

            min = Math.min(min,
                    Math.max(Math.abs(aE - bE),
                            Math.max(Math.abs(bE - cE),
                                    Math.abs(cE - aE))));


            if (a.index + 1 < a.arr.size()) {
                queue.add(new Element(a.index + 1, a.arr));
            }
            queue.add(b);
            queue.add(c);
        }
        return min;
    }

    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        int maxL = 0;
        int zerosIncluded = 0;
        int start = 0;
        while (i < A.size()) {
            queue.add(i);
            if (A.get(i) == 0) {
                zerosIncluded++;
            }
            while (zerosIncluded > B) {
                int pop = queue.poll();
                if (A.get(pop) == 0)
                    zerosIncluded--;
            }
            if (maxL < queue.size()) {
                maxL = queue.size();
                start = queue.peek();
            }
            i++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (i = start; i < start + maxL; i++) {
            res.add(i);
        }
        return res;
    }

    public void sortColors(ArrayList<Integer> a) {
        int l = 0;
        int h = a.size() - 1;
        int t;
        for (int i = 0; i <= h && l < h; ) {
            if (a.get(i) == 0) {
                t = a.get(l);
                a.set(l, a.get(i));
                a.set(i, t);
                l++;
                i++;
            } else if (a.get(i) == 2) {
                t = a.get(h);
                a.set(h, a.get(i));
                a.set(i, t);
                h--;
            } else if (a.get(i) == 1) {
                i++;
            }
        }
    }

    public int removeElement(ArrayList<Integer> a, int b) {
        int l = 0;
        for (int i = 0; i < a.size(); i++) {
            while (i < a.size() && a.get(i) == b) {
                i++;
            }
            if (i >= a.size()) {
                break;
            }
            a.set(l, a.get(i));
            l++;

        }
        return l;
    }

    public int removeDuplicatesKeep2(ArrayList<Integer> a) {
      /*  int i = 0;
        boolean changed = true;
        for (int j = 1; j < a.size(); j++) {
            if (a.get(i).equals(a.get(j)) && changed) {
                i++;
                a.set(i, a.get(j));
                changed = false;
            } else if (!a.get(i).equals(a.get(j))) {
                i++;
                a.set(i, a.get(j));
                changed = true;
            }
        }
        return i + 1;
        */
        if (a.size() < 3) {
            return a.size();
        }
        int l = 2;
        for (int i = 2; i < a.size(); i++) {
            a.set(l, a.get(i));
            if (!a.get(l).equals(a.get(l - 2))) {
                l++;
            }
        }
        return l;
    }


    public int removeDuplicates(ArrayList<Integer> a) {
        int i = 0;
        for (int j = 1; j < a.size(); j++) {
            if (!a.get(i).equals(a.get(j))) {
                i++;
                a.set(i, a.get(j));
            }
        }
        return i + 1;
    }

    public int diffPossible(ArrayList<Integer> array, int lf) {
        if (array.size() <= 1)
            return 0;

        lf = Math.abs(lf);
        int l = 0;
        int h = 1;
        while (h < array.size() && l < h) {
            int a = array.get(l);
            int b = array.get(h);
            if (lf == (a - b) || lf == (b - a)) {
                return 1;
            }
            if (lf > (b - a)) {
                h++;
            } else {
                l++;
            }
            if (l == h)
                h++;
        }
        return 0;
    }

    public int nTriangle(ArrayList<Integer> A) {
        A.sort((u, v) -> (u - v));
        long res = 0;
        int k = 0;
        for (int i = 0; i < A.size() - 2; i++) {
            k = i + 2;
            for (int j = i + 1; j < A.size(); j++) {
                while (k < A.size() && (long) (A.get(i) + A.get(j)) > (long) A.get(k)) {
                    k++;
                }

                if (k > j) {
                    res += k - j - 1;
                }
                res = res % (1000000007l);
            }
        }
        return (int) res;
    }


    public ArrayList<ArrayList<Integer>> threeSumZero(ArrayList<Integer> A) {
        A.sort((u, v) -> (u - v));
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < A.size() - 2; ) {
            int l = i + 1;
            int r = A.size() - 1;
            int a = A.get(i);
            while (l < r) {

                int b = A.get(l);
                int c = A.get(r);
                int sum = a + b + c;
                if (sum == 0) {
                    ArrayList<Integer> x = new ArrayList<>();
                    x.add(a);
                    x.add(b);
                    x.add(c);
                    res.add(x);
                    while (l < A.size() && A.get(l) == b) {
                        l++;
                    }
                    while (r > l && A.get(r) == c) {
                        r--;
                    }

                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
            while (i < A.size() && A.get(i) == a) {
                i++;
            }
        }

        return res;
    }


    public int threeSumClosest(ArrayList<Integer> A, int B) {
        int closest = Integer.MAX_VALUE;
        int closestSum = 0;
        A.sort((u, v) -> (u - v));
        for (int j = 1; j < A.size() - 1; j++) {
            int i = 0;
            int k = A.size() - 1;
            while (i < j && j < k) {
                int sum = A.get(i) + A.get(j) + A.get(k);
                if (Math.abs(B - sum) < closest) {
                    closest = Math.abs(B - sum);
                    closestSum = sum;
                }
                if (sum == B) {
                    return sum;
                } else if (sum < B) {
                    i++;
                } else {
                    k--;
                }
            }
        }

        return closestSum;
    }


    public int findMaxMinDiffInArrays(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int i = 0, j = 0, k = 0;
        if (A.size() == 0 || B.size() == 0 || C.size() == 0) {
            return 0;
        }
        int a, b, c;
        int diff = Integer.MAX_VALUE;
        while (i < A.size() && j < B.size() && k < C.size()) {
            a = A.get(i);
            b = B.get(j);
            c = C.get(k);
            diff = Math.min(diff, Math.abs(Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c))));
            if (Math.min(a, Math.min(b, c)) == a) {
                i++;
            } else if (Math.min(a, Math.min(b, c)) == b) {
                j++;
            } else {
                k++;
            }
        }
        return diff;
    }


    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        int i = 0, j = 0;
        ArrayList<Integer> C = new ArrayList<>();
        while (i < A.size() && j < B.size()) {
            if (A.get(i).equals(B.get(j))) {
                C.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return C;

    }

    public void merge(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> c = new ArrayList<>(A.size() + B.size());
        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                c.add(A.get(i++));
            } else {
                c.add(B.get(j++));
            }
        }
        while (i < A.size()) {
            c.add(A.get(i++));
        }
        while (j < B.size()) {
            c.add(B.get(j++));
        }
        for (i = 0; i < A.size(); i++) {
            A.set(i, c.get(i));
        }
        for (; i < c.size(); i++) {
            A.add(c.get(i));
        }
    }
}
