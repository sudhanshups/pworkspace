package practice.backtracking;

public class TugOfWar {

    public static void main(String[] args) {

        int arr[] = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
                //{4, 100, 1, 23, 20, 3, 5, -3, 89, 54};
                //{3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
        //{4, 100, 1, 23, 20} and {3, 5, -3, 89, 54}.

        TugOfWar a = new TugOfWar();
        a.tugOfWar(arr);
    }


    public static int diff = Integer.MAX_VALUE;

    void tugOfWar(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int required = arr.length / 2;
        tugOfWarUtil(arr, required, sum, 0, 0, 0);


    }

    void tugOfWarUtil(int[] arr, int required, int totalSum, int currentSum, int index, int elementCount) {
        if (elementCount > required || index >= arr.length) {
            return;
        }

        if (required == elementCount) {
            if (diff > Math.abs(currentSum - (totalSum - currentSum))) {
                diff = Math.abs(currentSum - (totalSum - currentSum));
                System.out.println("Diff updated " + diff);
            }
            return;
        }
        //include the current element
        tugOfWarUtil(arr, required, totalSum, currentSum + arr[index], index + 1, elementCount + 1);

        //exclude the current element
        tugOfWarUtil(arr, required, totalSum, currentSum, index + 1, elementCount);
    }
}
