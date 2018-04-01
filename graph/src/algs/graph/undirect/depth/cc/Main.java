package algs.graph.undirect.depth.cc;

import algs.graph.undirect.Graph;
import algs.util.Bag;

import java.util.Scanner;

/**
 * @author AlbertRui
 * @date 2018-04-01 20:32
 */
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(new Scanner(System.in));
        ConnectedComponent cc = new ConnectedComponent(graph);
        int m = cc.getCount();
        System.out.println(m + " components");
        Bag<Integer>[] components = (Bag<Integer>[]) new Bag[m];
        for (int i = 0; i < m; i++) {
            components[i] = new Bag<>();
        }
        for (int v = 0; v < graph.V(); v++) {
            components[cc.id(v)].add(v);
        }
        for (int i = 0; i < m; i++) {
            for (int v : components[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
