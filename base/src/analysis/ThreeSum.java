package analysis;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 算法测试
 * @author ZhangRui
 * 2017年10月21日,下午12:56:44
 */
public class ThreeSum {

	/**
	 * 统计一个文件中，所有和为零的三整数数量
	 * @param a
	 * @return
	 */
	public int count(int[] a) {
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				for (int k = j + 1; k < a.length; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	/**
	 * 读取指定文件
	 * @return
	 */
	public int[] readAllInt() {
		int[] num = new int[1000];
		int i = 0;
		try {
			FileReader fileReader = new FileReader("E:/code/Java/algs4-data/1Kints.txt");
			BufferedReader buf = new BufferedReader(fileReader);
			String readLine = "";
			while ((readLine = buf.readLine()) != null)
				num[i++] = Integer.parseInt(readLine.trim());
			System.out.println("=====================");
			System.out.println("共读到" + i + "个数字");
			fileReader.close();
			buf.close();
		} catch (FileNotFoundException e) {
			System.out.println("没有找到文件！！！");
			e.printStackTrace();
		} catch (NumberFormatException | IOException e) {
			System.out.println("文件读取失败！！！");
			e.printStackTrace();
		}
		return num;
	}

	/**
	 * 打印读到的数组
	 * @param array
	 */
	public void printNum(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
