import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CSES1192 {
    static int[] boss;
    static int find_boss(int x) {
        if (boss[x] == x) return x;
        return boss[x] = find_boss(boss[x]);
    }
    static boolean union(int u, int v) {
        int rootU = find_boss(u);
        int rootV = find_boss(v);
        if (rootU != rootV) {
            boss[rootV] = rootU;
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        int totalCells = n * m;
        boss = new int[totalCells];
        int totalRooms = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                int id = i * m + j;
                if (map[i][j] == '.') {
                    boss[id] = id;
                    totalRooms++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '.') {
                    int currentId = i * m + j;
                    if (j + 1 < m && map[i][j + 1] == '.') {
                        int rightId = i * m + (j + 1);
                        if (union(currentId, rightId)) {
                            totalRooms--;
                        }
                    }
                    if (i + 1 < n && map[i + 1][j] == '.') {
                        int downId = (i + 1) * m + j;
                        if (union(currentId, downId)) {
                            totalRooms--;
                        }
                    }
                }
            }
        }
        System.out.println(totalRooms);
    }
}