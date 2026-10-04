import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class equalStacks {
    public static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int x : h1) sum1 += x;
        for (int x : h2) sum2 += x;
        for (int x : h3) sum3 += x;
        int p1 = 0, p2 = 0, p3 = 0;
        while (true) {
            if (p1 == h1.length || p2 == h2.length || p3 == h3.length) {
                return 0;
            }
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= h1[p1++];
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= h2[p2++];
            } else {
                sum3 -= h3[p3++];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        String line = reader.readLine();
        if (line == null) return;
        tokenizer = new StringTokenizer(line);
        int n1 = Integer.parseInt(tokenizer.nextToken());
        int n2 = Integer.parseInt(tokenizer.nextToken());
        int n3 = Integer.parseInt(tokenizer.nextToken());
        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n1; i++) h1[i] = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n2; i++) h2[i] = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n3; i++) h3[i] = Integer.parseInt(tokenizer.nextToken());
        System.out.println(equalStacks(h1, h2, h3));
    }
}