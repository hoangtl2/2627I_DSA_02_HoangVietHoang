import java.util.Scanner;
import java.util.Stack;
public class QueueTwoStacks {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    public QueueTwoStacks() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    public void enqueue(int x) {
        inStack.push(x);
    }
    private void shiftStacks() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
    public int dequeue() {
        shiftStacks();
        if (outStack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return outStack.pop();
    }
    public int printFront() {
        shiftStacks();
        if (outStack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return outStack.peek();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueTwoStacks queue = new QueueTwoStacks();
        if (scanner.hasNextInt()) {
            int q = scanner.nextInt();
            for (int i = 0; i < q; i++) {
                int type = scanner.nextInt();
                if (type == 1) {
                    int x = scanner.nextInt();
                    queue.enqueue(x);
                } else if (type == 2) {
                    queue.dequeue();
                } else if (type == 3) {
                    System.out.println(queue.printFront());
                }
            }
        }
        scanner.close();
    }
}