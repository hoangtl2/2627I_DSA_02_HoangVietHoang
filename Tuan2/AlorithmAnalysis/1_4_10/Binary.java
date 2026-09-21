import java.util.Arrays;
import java.util.Scanner;
public class Binary {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        int result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                result = mid;
                hi = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Nhập " + n + " số nguyên:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        System.out.print("key: ");
        int key = sc.nextInt();
        int index = rank(key, a);
        if (index != -1) {
            System.out.println(index);
        } else {
            System.out.println(-1);
        }
        sc.close();
    }
}