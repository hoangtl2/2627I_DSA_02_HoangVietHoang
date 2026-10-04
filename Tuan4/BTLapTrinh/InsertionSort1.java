import java.util.Scanner;
public class InsertionSort1 {
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : " "));
        }
        System.out.println();
    }
    public static void insertionSort1(int n, int[] arr) {
        int key = arr[n - 1];
        int i = n - 2;
        while (i >= 0 && arr[i] > key) {
            arr[i + 1] = arr[i];
            printArray(arr);
            i--;
        }
        arr[i + 1] = key;
        printArray(arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        insertionSort1(n, arr);
        sc.close();
    }
}