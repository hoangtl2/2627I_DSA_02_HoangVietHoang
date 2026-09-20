public class BuggyQuickFind{
    private int[] leader;
    public BuggyQuickFind(int n){
        leader = new int[n];
        for(int i = 0; i < n; i++){
            leader[i]=i;
        }
    }
    public int find(int i){
        return leader[i];
    }
    public void union(int p, int q){
        for(int i = 0; i < leader.length; i++){
            if(leader[i] == leader[p]){
                leader[i] = leader[q];
            }
        }
    }
    public static void main(String[] args){
        int n=3;
        // Sử dụng testcase đã  nói bên Solution1
        BuggyQuickFind uf = new BuggyQuickFind(n);
        uf.union(1,0);
        uf.union(0,2);
        int root0 = uf.find(0);
        int root1 = uf.find(1);
        System.out.println("Leader của 1 là "+root1);
        System.out.println("Leader của 0 là "+root0);
    }
}

