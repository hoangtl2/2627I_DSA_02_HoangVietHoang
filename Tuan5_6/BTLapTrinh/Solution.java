
import java.util.List;
public class Solution {
    public static int findMedian(List<Integer> arr) {
        int[] a = arr.stream().mapToInt(i -> i).toArray();
        int k = a.length / 2;
        return quickSelect(a, 0, a.length - 1, k);
    }
    private static int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low];
        }
        int pi = partition(arr, low, high);
        if (pi == k) {
            return arr[pi];
        } else if (k < pi) {
            return quickSelect(arr, low, pi - 1, k);
        } else {
            return quickSelect(arr, pi + 1, high, k);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}