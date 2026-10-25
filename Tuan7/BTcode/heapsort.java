import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class heapsort {

    // Ngăn chặn khởi tạo đối tượng vì các phương thức đều là static
    private heapsort() { }

    /**
     * Sắp xếp mảng theo thứ tự tăng dần bằng thuật toán Heapsort.
     * @param pq mảng các phần tử có thể so sánh (Comparable)
     */
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] pq) {
        int n = pq.length;

        // Giai đoạn 1: Tạo Max-Heap (Heapify phase)
        for (int k = n / 2; k >= 1; k--) {
            sink(pq, k, n);
        }

        // Giai đoạn 2: Sắp xếp (Sortdown phase)
        int k = n;
        while (k > 1) {
            exch(pq, 1, k--); // Đưa phần tử lớn nhất về cuối heap
            sink(pq, 1, k);    // Khôi phục tính chất Max-Heap cho phần còn lại
        }
    }

    /***************************************************************************
     * Hàm phụ trợ phục hồi trật tự Max-Heap (chìm xuống).
     ***************************************************************************/
    @SuppressWarnings("rawtypes")
    private static void sink(Comparable[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1)) j++; // Chọn con lớn hơn
            if (!less(pq, k, j)) break;           // Nút cha đã >= con lớn nhất
            exch(pq, k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Các hàm phụ trợ so sánh và hoán vị.
     * Chỉ số được trừ 1 (i - 1, j - 1) để ánh xạ từ hệ 1-based sang mảng 0-based của Java.
     ***************************************************************************/
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }

    // In mảng ra màn hình
    @SuppressWarnings("rawtypes")
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /***************************************************************************
     * Hàm main chạy thử nghiệm với dữ liệu nhập từ bàn phím.
     ***************************************************************************/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        // Đọc tất cả các từ nhập vào
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }

        String[] a = list.toArray(new String[0]);
        heapsort.sort(a);
        show(a);

        scanner.close();
    }
}