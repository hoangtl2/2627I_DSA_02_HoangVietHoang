import java.util.Scanner;

public class w7_tailop_25020160 {
        static class CustomPriorityQueue {
        private int[] heap;
        private int size;
        private boolean isMaxHeap;

        public CustomPriorityQueue(int capacity, boolean isMaxHeap) {
            this.heap = new int[Math.max(capacity, 10)];
            this.size = 0;
            this.isMaxHeap = isMaxHeap;
        }
        public int size() {
            return size;
        }
        public boolean isEmpty() {
            return size == 0;
        }
        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("rỗng");
            }
            return heap[0];
        }
        public void offer(int value) {
            if (size == heap.length) {
                resize(heap.length * 2);
            }
            heap[size] = value;
            siftUp(size);
            size++;
        }
        public int poll() {
            if (isEmpty()) {
                throw new IllegalStateException("rỗng");
            }
            int root = heap[0];
            heap[0] = heap[size - 1];
            size--;
            if (size > 0) {
                siftDown(0);
            }
            return root;
        }
        private boolean compare(int a, int b) {
            return isMaxHeap ? (a > b) : (a < b);
        }
        private void siftUp(int index) {
            int current = index;
            while (current > 0) {
                int parent = (current - 1) / 2;
                if (compare(heap[current], heap[parent])) {
                    swap(current, parent);
                    current = parent;
                } else {
                    break;
                }
            }
        }
        private void siftDown(int index) {
            int current = index;
            while (2 * current + 1 < size) {
                int leftChild = 2 * current + 1;
                int rightChild = 2 * current + 2;
                int priorityChild = leftChild;

                if (rightChild < size && compare(heap[rightChild], heap[leftChild])) {
                    priorityChild = rightChild;
                }
                if (compare(heap[priorityChild], heap[current])) {
                    swap(current, priorityChild);
                    current = priorityChild;
                } else {
                    break;
                }
            }
        }
        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        private void resize(int newCapacity) {
            int[] newHeap = new int[newCapacity];
            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int N = scanner.nextInt();
        CustomPriorityQueue maxPQ = new CustomPriorityQueue(N / 2 + 2, true);
        CustomPriorityQueue minPQ = new CustomPriorityQueue(N / 2 + 2, false);
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            if (maxPQ.isEmpty() || num <= maxPQ.peek()) {
                maxPQ.offer(num);
            } else {
                minPQ.offer(num);
            }
            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.offer(maxPQ.poll());
            } else if (minPQ.size() > maxPQ.size()) {
                maxPQ.offer(minPQ.poll());
            }
            if (maxPQ.size() == minPQ.size()) {
                double median = (double) (maxPQ.peek() + minPQ.peek()) / 2.0;
                System.out.printf("%.1f\n", median);
            } else {
                System.out.printf("%.1f\n", (double) maxPQ.peek());
            }
        }

        scanner.close();
    }
}