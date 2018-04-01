package algs.graph.direct.depth;

import algs.graph.direct.Digraph;
import algs.util.Bag;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author AlbertRui
 * @date 2018-04-01 23:04
 */
public class Main {
    /**
     * Unit tests the {@code DirectedDFS} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            // read in digraph from command-line argument
            scanner = new Scanner(new BufferedInputStream(new FileInputStream(new File(args[0]))), "UTF-8");
            Digraph G = new Digraph(scanner);
            // read in sources from command-line arguments
            Bag<Integer> sources = new Bag<Integer>();
            for (int i = 1; i < args.length; i++) {
                int s = Integer.parseInt(args[i]);
                sources.add(s);
            }

            // multiple-source reachability
            DirectedDFS dfs = new DirectedDFS(G, sources);

            // print out vertices reachable from sources
            for (int v = 0; v < G.V(); v++) {
                if (dfs.marked(v)) System.out.print(v + " ");
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
