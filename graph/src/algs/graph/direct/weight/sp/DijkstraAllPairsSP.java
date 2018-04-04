package algs.graph.direct.weight.sp;

import algs.graph.direct.weight.DirectedEdge;
import algs.graph.direct.weight.EdgeWeightedDigraph;

/**
 * 任意两点之间的最短路径
 *
 * @author AlbertRui
 * @date 2018-04-04 17:41
 */
public class DijkstraAllPairsSP {

    private DijkstraSP[] all;

    DijkstraAllPairsSP(EdgeWeightedDigraph digraph) {
        all = new DijkstraSP[digraph.V()];
        for (int v = 0; v < digraph.V(); v++) {
            all[v] = new DijkstraSP(digraph, v);
        }
    }

    Iterable<DirectedEdge> path(int s, int t) {
        return all[s].pathTo(t);
    }

    double dist(int s, int t) {
        return all[s].distTo(t);
    }

}
