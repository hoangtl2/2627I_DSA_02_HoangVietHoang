import java.util.Scanner;
public class FarthestPair {
    public static void findFarthestPair(double[] a) {
        if (a == null || a.length < 2) {
            System.out.println("Mảng cần 2 phần tử.");
            return;
        }
        double min = a[0];
        double max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println("(" + min + ", " + max + ")");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N: ");
        int n = sc.nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }
        findFarthestPair(a);
        sc.close();
    }
}