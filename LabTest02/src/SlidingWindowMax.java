import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int[] arr1 = {4, 3, 8, 9, 0, 1};
        int k1 = 3;

        int[] arr2 = {9, 8, 6, 4, 3, 1};
        int k2 = 4;

        int[] arr3 = {1, 2, 3, 4, 10, 6, 9, 8, 7, 5};
        int k3 = 3;

        int[] result1 = findMaxSlidingWindow(arr1, k1);
        int[] result2 = findMaxSlidingWindow(arr2, k2);
        int[] result3 = findMaxSlidingWindow(arr3, k3);

        printSlidingWindowMax(arr1, k1, result1);
        printSlidingWindowMax(arr2, k2, result2);
        printSlidingWindowMax(arr3, k3, result3);
    }

    private static int[] findMaxSlidingWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < k; i++) {
            maxHeap.offer(arr[i]);
        }

        result.add(maxHeap.peek());

        for (int i = k; i < arr.length; i++) {
            maxHeap.remove(arr[i - k]);
            maxHeap.offer(arr[i]);
            result.add(maxHeap.peek());
        }

        return listToArray(result);
    }

    private static int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private static void printSlidingWindowMax(int[] arr, int k, int[] result) {
        System.out.print("Input arr[]: " + Arrays.toString(arr));
        System.out.println(", k = " + k);
        System.out.println("Output: " + Arrays.toString(result));
        System.out.printf("Explanation: The window size is %d and the maximum at different iterations are as follows:\n", k);

        for (int i = 0; i < result.length; i++) {
            int windowStart = i;
            int windowEnd = i + k - 1;
            int max = result[i];
            System.out.printf("max(%s) = %d\n", arrayToString(Arrays.copyOfRange(arr, windowStart, windowEnd + 1)), max);
        }

        System.out.printf("Hence, we get arr = %s as output.\n" , Arrays.toString(result));
        System.out.println();
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
