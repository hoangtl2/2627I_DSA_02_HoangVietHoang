import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class w10_tailop_25020160 {

    public static class Pair {
        private final int min;
        private final int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int min() {
            return min;
        }

        public int max() {
            return max;
        }
    }

    private w10_tailop_25020160() { }

    public static Pair findMinMax(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException();
        }
        return findMinMax(a, 0, a.length - 1);
    }

    private static Pair findMinMax(int[] a, int lo, int hi) {
        if (lo == hi) {
            return new Pair(a[lo], a[lo]);
        }

        if (hi == lo + 1) {
            if (a[lo] < a[hi]) {
                return new Pair(a[lo], a[hi]);
            } else {
                return new Pair(a[hi], a[lo]);
            }
        }

        int mid = lo + (hi - lo) / 2;

        Pair leftPair = findMinMax(a, lo, mid);
        Pair rightPair = findMinMax(a, mid + 1, hi);

        int overallMin = Math.min(leftPair.min(), rightPair.min());
        int overallMax = Math.max(leftPair.max(), rightPair.max());

        return new Pair(overallMin, overallMax);
    }

    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();

        if (a.length == 0) {
            return;
        }

        Pair result = findMinMax(a);

        StdOut.println("Min = " + result.min());
        StdOut.println("Max = " + result.max());
    }
}