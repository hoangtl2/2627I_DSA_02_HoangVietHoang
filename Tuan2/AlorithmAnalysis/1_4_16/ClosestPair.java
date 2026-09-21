import java.util.Arrays;
import java.util.Scanner;
public class ClosestPair {
    public static void findClosestPair(double[] a) {
        if (a == null || a.length < 2) {
            System.out.println("Mảng cần 2 phần tử.");
            return;
        }
        Arrays.sort(a);
        double minDiff = a[1] - a[0];
        double p1 = a[0];
        double p2 = a[1];
        for (int i = 2; i < a.length; i++) {
            double currentDiff = a[i] - a[i - 1];
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                p1 = a[i - 1];
                p2 = a[i];
            }
        }
        System.out.println("(" + p1 + ", " + p2 + ")");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N: ");
        int n = sc.nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }
        findClosestPair(a);
        sc.close();
    }
}