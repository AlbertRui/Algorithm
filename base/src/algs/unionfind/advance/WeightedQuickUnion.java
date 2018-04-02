package algs.unionfind.advance;

/**
 * 加权quick-union算法
 *
 * @author AlbertRui
 * @date 2018-03-28 21:35
 */
public class WeightedQuickUnion {

    private int[] id;//父链接数组
    private int[] sz;//各个根节点所对应的分量的大小（层数）
    private int count; //连通分量的数量

    public WeightedQuickUnion(int N) {

        count = N;
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }

    }

    public int getCount() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {

        int i = find(p);
        int j = find(q);

        if (i == j) {
            return;
        }

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }

        count--;

    }

}
