public class PriorityQueue {
}
public class PriorityQueue {
    private int[] arr;
    private int size;
    private int capacity;

    public PriorityQueue(int k) {
        this.capacity = k;
        this.arr = new int[k];
        this.size = 0;
    }

    public PriorityQueue() {
        this(1000);
    }

    public void insert(int x) {
        if (size >= capacity) {
            return;
        }
        arr[size] = x;
        size++;
    }

    public int deleteMin() {
        if (size == 0) {
            throw new RuntimeException();
        }

        int minIndex = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        int minValue = arr[minIndex];
        arr[minIndex] = arr[size - 1];
        size--;

        return minValue;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}