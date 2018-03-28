package algs.queue.array;

/**
 * 队列测试类
 * @author Mr.Zhang
 * 2017年10月20日,下午10:34:34
 */
public class Main {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>(5);
		System.out.println(queue.isEmpty());
		queue.addtNum(1);
		queue.addtNum(2);
		queue.addtNum(3);
		queue.addtNum(4);
		queue.addtNum(5);
		//queue.addtNum(6);
		System.out.println(queue.isEmpty());
		queue.printQueue();
		System.out.println("===========================");
		System.out.println(queue.getSize());
		System.out.println(queue.getTail());
		System.out.println(queue.getTop());
		queue.poll();
		queue.poll();
		queue.poll();
		System.out.println("===========================");
		queue.printQueue();
		System.out.println("===========================");
		System.out.println(queue.getSize());
		System.out.println(queue.getTail());
		System.out.println(queue.getTop());
	}
}
