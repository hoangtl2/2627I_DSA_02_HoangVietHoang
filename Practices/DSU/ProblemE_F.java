import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class ProblemE_F {
    static class Edge implements Comparable<Edge>{
        int u,v;
        long w;
        public Edge(int u,int v, long w){
            this.u = u;
            this.v= v;
            this.w=w;
        }
        @Override
        public int compareTo(Edge other){
            return Long.compare(this.w, other.w);

        }
    }
    static int[] boss;
    static long[] size;
    static int find_boss(int x){
        if(boss[x] == x){
            return x;
        }
        return boss[x]=find_boss(boss[x]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[n-1];
        for(int i = 0;i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            edges[i] = new Edge(u,v,w);
        }
        Arrays.sort(edges);
        boss = new int[n+1];
        size = new long[n+1];
        for(int i=1;i<=n;i++){
            boss[i]=i;
            size[i]=1;
        }
        long total = 0;
        for (Edge edge : edges){
            int boss_u = find_boss(edge.u);
            int boss_v = find_boss(edge.v);
            if(boss_u != boss_v){
                long scd = size[boss_u]*size[boss_v];
                total += edge.w*scd;
                boss[boss_v] = boss_u;
                size[boss_u] += size[boss_v];
            }
        }
        System.out.println(total);
    }
}
