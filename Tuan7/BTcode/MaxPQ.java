import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Triển khai Max Priority Queue sử dụng Binary Max-Heap.
 * Mảng heap bắt đầu từ chỉ số 1 để tối ưu việc tính toán cha - con:
 * - Cha của nút k: k / 2
 * - Con trái của nút k: 2 * k
 * - Con phải của nút k: 2 * k + 1
 */
public class MaxPQ<Key> implements Iterable<Key> {
    private Key[] pq;                    // Mảng lưu trữ các phần tử từ chỉ số 1 đến n
    private int n;                       // Số lượng phần tử hiện có trong priority queue
    private Comparator<Key> comparator;  // Comparator tùy chọn (nếu không dùng thứ tự tự nhiên)

    /**
     * Khởi tạo hàng đợi rỗng với dung lượng ban đầu chỉ định.
     */
    @SuppressWarnings("unchecked")
    public MaxPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Khởi tạo hàng đợi rỗng với dung lượng mặc định là 1.
     */
    public MaxPQ() {
        this(1);
    }

    /**
     * Khởi tạo hàng đợi với dung lượng ban đầu và comparator tùy biến.
     */
    @SuppressWarnings("unchecked")
    public MaxPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Khởi tạo hàng đợi rỗng với comparator tùy biến.
     */
    public MaxPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }


    @SuppressWarnings("unchecked")
    public MaxPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++) {
            pq[i + 1] = keys[i];
        }
        for (int k = n / 2; k >= 1; k--) {
            sink(k);
        }
        assert isMaxHeap();
    }


    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }


    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    // Thay đổi kích thước mảng khi vượt ngưỡng hoặc quá dư thừa
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void insert(Key x) {
        // Nhân đôi kích thước mảng nếu đã đầy
        if (n == pq.length - 1) resize(2 * pq.length);

        // Đặt phần tử vào cuối và cho nổi lên (swim) đúng vị trí
        pq[++n] = x;
        swim(n);
        assert isMaxHeap();
    }

    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key max = pq[1];
        exch(1, n--);       // Hoán vị gốc với phần tử cuối cùng
        sink(1);            // Cho phần tử mới ở gốc chìm xuống đúng vị trí
        pq[n + 1] = null;   // Tránh rò rỉ bộ nhớ (loitering) cho Garbage Collector

        // Thu hẹp mảng về 1/2 khi số phần tử chỉ chiếm 1/4 dung lượng
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        assert isMaxHeap();
        return max;
    }

    private void swim(int k) {
        // Nếu nút con lớn hơn nút cha, đổi chỗ và tiếp tục xét lên trên
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        // Chìm xuống đến khi không còn con hoặc đã lớn hơn cả 2 con
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++; // Chọn con lớn hơn
            if (!less(k, j)) break;           // Nút cha đã >= con lớn nhất
            exch(k, j);
            k = j;
        }
    }

    @SuppressWarnings("unchecked")
    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    // Kiểm tra tính toàn vẹn của Max-Heap
    private boolean isMaxHeap() {
        for (int i = 1; i <= n; i++) {
            if (pq[i] == null) return false;
        }
        for (int i = n + 1; i < pq.length; i++) {
            if (pq[i] != null) return false;
        }
        if (pq[0] != null) return false;
        return isMaxHeapOrdered(1);
    }

    private boolean isMaxHeapOrdered(int k) {
        if (k > n) return true;
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left <= n && less(k, left)) return false;
        if (right <= n && less(k, right)) return false;
        return isMaxHeapOrdered(left) && isMaxHeapOrdered(right);
    }

    @Override
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {
        private MaxPQ<Key> copy;

        public HeapIterator() {
            if (comparator == null) copy = new MaxPQ<>(size());
            else copy = new MaxPQ<>(size(), comparator);
            for (int i = 1; i <= n; i++) {
                copy.insert(pq[i]);
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMax();
        }
    }

    /***************************************************************************
     * Unit test trực tiếp với chuẩn vào/ra của Java.
     ***************************************************************************/
    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<>();
        Scanner scanner = new Scanner(System.in);

        // Nhập các chuỗi cách nhau bởi dấu cách.
        // Nhập dấu "-" tương ứng với thao tác gọi delMax().
        while (scanner.hasNext()) {
            String item = scanner.next();
            if (!item.equals("-")) {
                pq.insert(item);
            } else if (!pq.isEmpty()) {
                System.out.print(pq.delMax() + " ");
            }
        }
        System.out.println("(" + pq.size() + " left on pq)");
        scanner.close();
    }
}