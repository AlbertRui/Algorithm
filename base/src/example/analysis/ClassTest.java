package example.analysis;

/**
 * 测试
 *
 * @author ZhangRui
 * 2017年10月21日,下午12:55:08
 */
public class ClassTest {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] num = threeSum.readAllInt();
        System.out.println(threeSum.count(num));
        System.out.println("=========================");
        threeSum.printNum(num);
    }
}
