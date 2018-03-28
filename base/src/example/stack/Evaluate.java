package example.stack;

import algs.stack.list.Stack;

import java.util.Scanner;

/**
 * Dijkstra的双栈算数表达式求值算法
 *
 * @author AlbertRui
 * @date 2018-03-28 20:06
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        //读取字符，如果是字符串则压入栈
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("(")) {
            } else if (s.equals("+")) {
                ops.push(s);
            } else if (s.equals("-")) {
                ops.push(s);
            } else if (s.equals("*")) {
                ops.push(s);
            } else if (s.equals("/")) {
                ops.push(s);
            } else if (s.equals("sqrt")) {
                ops.push(s);
            } else if (s.equals(")")) {
                //如果字符为")",弹出运算符和操作数，计算结果并压入栈
                String op = ops.pop();
                double val = vals.pop();
                if (op.equals("+")) {
                    val = vals.pop() + val;
                } else if (op.equals("-")) {
                    val = vals.pop() - val;
                } else if (op.equals("*")) {
                    val = vals.pop() * val;
                } else if (op.equals("/")) {
                    val = vals.pop() / val;
                } else if (op.equals("sqrt")) {
                    val = Math.sqrt(val);
                }
            } else {
                //如果字符既非运算符，也非括号，将他作为double值压入栈
                vals.push(Double.parseDouble(s));
            }
        }
        System.out.println(vals.pop());
    }
}
