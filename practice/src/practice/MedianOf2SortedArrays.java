package practice;

import java.util.List;

public class MedianOf2SortedArrays {

    public static void main(String[] args) {

        int arr1[] = {1, 4, 5};
        int arr2[] = {2, 3};

        System.out.println(findMedian(arr1, arr2));

    }
    
/*
x1,x2,x3
y1,y2,y3,y4
 */
    public static double findMedian(int arr1[], int arr2[]) {

        if (arr1.length > arr2.length) {
            return findMedian(arr2, arr1);
        }
        int len1 = arr1.length;
        int len2 = arr2.length;

        int low = 0;
        int high = len1;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (len1 + len2 + 1) / 2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : arr1[partitionX - 1];
            int minRightX = partitionX == len1 ? Integer.MAX_VALUE : arr1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : arr2[partitionY - 1];
            int minRightY = partitionY == len2 ? Integer.MAX_VALUE : arr2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((len1 + len2) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }

        }

        return 0;
    }

}


