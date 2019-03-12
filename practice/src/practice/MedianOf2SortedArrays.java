package practice;

import java.util.List;

public class MedianOf2SortedArrays {

    public static void main(String[] args) {

        int arr1[] = {1, 4, 5};
        int arr2[] = {2, 3};

        System.out.println(findMedian(arr1, arr2));

    }

    public double findMedianSortedArrays(final List<Integer> arr1, final List<Integer> arr2) {

        if (arr1.size() > arr2.size()) {
            return findMedianSortedArrays(arr2, arr1);
        }
        int len1 = arr1.size();
        int len2 = arr2.size();

        int low = 0;
        int high = len1;
        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (len1 + len2 + 1) / 2 - partition1;

            int maxLeft1 = partition1 == 0 ? Integer.MIN_VALUE : arr1.get(partition1 - 1);
            int minRight1 = partition1 == len1 ? Integer.MAX_VALUE : arr1.get(partition1);

            int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : arr2.get(partition2 - 1);
            int minRight2 = partition2 == len2 ? Integer.MAX_VALUE : arr2.get(partition2);

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((len1 + len2) % 2 == 0) {
                    return ((double) Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
                } else {
                    return (double) Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }

        }

        return 0;
    }

    public static double findMedian(int arr1[], int arr2[]) {

        if (arr1.length > arr2.length) {
            return findMedian(arr2, arr1);
        }
        int len1 = arr1.length;
        int len2 = arr2.length;

        int low = 0;
        int high = len1;
        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (len1 + len2 + 1) / 2 - partition1;

            int maxLeft1 = partition1 == 0 ? Integer.MIN_VALUE : arr1[partition1 - 1];
            int minRight1 = partition1 == len1 ? Integer.MAX_VALUE : arr1[partition1];

            int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : arr2[partition2 - 1];
            int minRight2 = partition2 == len2 ? Integer.MAX_VALUE : arr2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((len1 + len2) % 2 == 0) {
                    return ((double) Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
                } else {
                    return (double) Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }

        }

        return 0;
    }

}


