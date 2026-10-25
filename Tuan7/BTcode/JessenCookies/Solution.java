package JessenCookies;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(N);
        for (int i = 0; i < N; i++) {
            pq.add(scanner.nextInt());
        }
        scanner.close();

        int operations = 0;

        while (pq.size() > 1 && pq.peek() < K) {
            int m1 = pq.poll(); // Bánh ít ngọt nhất
            int m2 = pq.poll(); // Bánh ít ngọt thứ hai

            int newSweetness = m1 + 2 * m2;
            pq.add(newSweetness);

            operations++;
        }

        if (!pq.isEmpty() && pq.peek() >= K) {
            System.out.println(operations);
        } else {
            System.out.println(-1);
        }
    }
}