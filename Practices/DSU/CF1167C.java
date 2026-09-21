import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class CF1167C {
    static int[] boss;
    static int[] size;

    static int find_boss(int x) {
        if (boss[x] == x) return x;
        return boss[x] = find_boss(boss[x]);
    }

    static void union(int u, int v) {
        int rootU = find_boss(u);
        int rootV = find_boss(v);
        if (rootU != rootV) {
            if (size[rootU] < size[rootV]) {
                boss[rootU] = rootV;
                size[rootV] += size[rootU];
            } else {
                boss[rootV] = rootU;
                size[rootU] += size[rootV];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boss = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            boss[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k > 0) {
                int firstMember = Integer.parseInt(st.nextToken());
                for (int j = 1; j < k; j++) {
                    int otherMember = Integer.parseInt(st.nextToken());
                    union(firstMember, otherMember); // Gộp người đầu tiên với các thành viên còn lại
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(size[find_boss(i)]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}