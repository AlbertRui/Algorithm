package algs.queue.array;

/**
 * 基于数组实现队列
 *
 * @param <T>
 * @author Mr.Zhang
 * 2017年10月20日,下午10:34:06
 */
public class Queue<T> {

    private Object[] data;
    private int size;
    private int top;
    private int tail;

    /**
     * 默认构造器
     */
    public Queue() {

    }

    /**
     * 创建队列
     *
     * @param size
     */
    public Queue(int size) {
        if (size > 0) {
            this.size = size;
            data = new Object[size];
            top = tail = 0;
        } else {
            throw new RuntimeException("初始化大小不能小于0：" + size);
        }
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == tail;
    }

    /**
     * 向队列中插入元素
     *
     * @param num
     * @return
     */
    public boolean addtNum(T num) {
        if (tail == size) {
            throw new RuntimeException("队列已满，无法插入!!!");
        } else {
            data[tail++] = num;
            return true;
        }
    }

    /**
     * 元素出队
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("出队异常！！！");
        } else {
            T num = (T) data[top];
            for (int i = 0; i < data.length - 1; i++) {
                data[top++] = data[top];
            }
            top = 0;
            data[tail - 1] = null;
            tail -= 1;
            return num;
        }
    }

    /**
     * 获得队列中元素的个数
     *
     * @return
     */
    public int getSize() {
        return tail;
    }

    /**
     * 获得队首元素
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public T getTop() {
        return (T) data[top];
    }

    /**
     * 获得队尾元素
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public T getTail() {
        return (T) data[tail - 1];
    }

    /**
     * 打印队列
     */
    public void printQueue() {
        for (int i = 0; i < tail; i++) {
            System.out.println(data[i]);
        }
    }
}