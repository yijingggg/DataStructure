import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {45, 7, 2, 8, 19, 3};
        selectionSortSmallest(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{45, 7, 2, 8, 19, 3};
        selectionSortLargest(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{10, 34, 2, 56, 7, 67, 88, 42};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{10, 34, 2, 56, 7, 67, 88, 42};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{10, 34, 2, 56, 7, 67, 88, 42};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSortSmallest(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIndex]) minIndex = j;

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void selectionSortLargest(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int maxIndex = i;
            for (int j = i - 1; j >= arr.length; j--)
                if (arr[j] > arr[maxIndex]) maxIndex = j;

            if (maxIndex != i) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j;
            for (j = i - 1; j >= 0 && current < arr[j]; j--)
                arr[j + 1] = arr[j];
            arr[j + 1] = current;
        }
    }

    public static void bubbleSort(int[] arr) {
        boolean needNextPass = true;
        for (int i = 1; i < arr.length && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            //Merge sort the first half
            int[] firstHalf = new int[arr.length / 2];
            System.arraycopy(arr, 0, firstHalf, 0, arr.length / 2);
            mergeSort(firstHalf);

            //Merge sort the second half
            int secondHalfLength = arr.length - arr.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(arr, arr.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            //Merge firstHalf with secondHalf into arr
            merge(firstHalf, secondHalf, arr);
        }
    }


    public static void merge(int[] arr1, int[] arr2, int[] temp) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < arr1.length && current2 < arr2.length) {
            if (arr1[current1] < arr2[current2])
                temp[current3++] = arr1[current1++];
            else
                temp[current3++] = arr2[current2++];
        }

        while (current1 < arr1.length)
            temp[current3++] = arr1[current1++];
        while (current2 < arr2.length)
            temp[current3++] = arr2[current2++];
    }
}
