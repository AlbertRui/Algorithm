package algs.graph.undirect.symbol;

import algs.graph.undirect.Graph;
import algs.util.SymbolTable;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**
 * 基于无向图实现符号图
 *
 * @author AlbertRui
 * @date 2018-04-01 21:22
 */
public class SymbolGraph {

    private SymbolTable<String, Integer> st;//符号名——>索引
    private String[] keys;//索引——>符号名
    private Graph graph;

    public SymbolGraph(String stream, String sp) throws FileNotFoundException {
        st = new SymbolTable<>();
        FileInputStream fis = new FileInputStream(new File(stream));
        //第一遍，构造索引
        Scanner scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
        scanner.useLocale(Locale.US);
        while (scanner.hasNextLine()) {
            //读取字符串
            String[] a = scanner.nextLine().split(sp);
            //为每个不同的字符串关联一个索引
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }
        //用来获取顶点名的反向索引是一个数组
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }
        graph = new Graph(st.size());
        //第二遍，构造图
        scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
        scanner.useLocale(Locale.US);
        while (scanner.hasNextLine()) {
            //将每一行的第一顶点和该行的其他顶点相连
            String[] a = scanner.nextLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                graph.addEdge(v, st.get(a[i]));
            }
        }
    }

    public boolean contains(String s) {
        return st.contains(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Graph getGraph() {
        return graph;
    }
}
