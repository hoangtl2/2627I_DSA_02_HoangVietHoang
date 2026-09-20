public class FixQuickFInd {
    private int[] leader;
    public FixQuickFInd(int n) {
        leader = new int[n];
        for (int i = 0; i < n; i++) {
            leader[i] = i;
        }
    }
    public int find(int i) {
        return leader[i];
    }
    public void union(int p, int q) {
        int pid = leader[p];
        int qid = leader[q];

        if (pid == qid) return;

        for (int i = 0; i < leader.length; i++) {
            if (leader[i] == pid) {
                leader[i] = qid;
            }
        }
    }
    public static void main(String[] args) {
        int n = 3;
        FixQuickFInd uf = new FixQuickFInd(n);
        uf.union(1, 0);
        uf.union(0, 2);
        int root0 = uf.find(0);
        int root1 = uf.find(1);
        System.out.println("Leader của 1 là " + root1);
        System.out.println("Leader của 0 là " + root0);
    }
}