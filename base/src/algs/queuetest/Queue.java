package com.algs4.queuetest;

/**
 * @author Mr.Zhang
 * 2017��10��20��,����10:34:06
 * @param <T>
 */
public class Queue<T> {

	private Object[] data;
	private int size;
	private int top;
	private int tail;
	
	/**
	 * Ĭ�Ϲ�����
	 */
	public Queue() {
		
	}

	/**
	 * ��������
	 * @param size
	 */
	public Queue(int size) {
		if(size > 0) {
			this.size = size;
			data = new Object[size];
			top = tail = 0;
		} else {
			throw new RuntimeException("��ʼ����С����С��0��" + size);
		}
	}
	
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return top == tail ? true : false;
	}

	/**
	 * ������в���Ԫ��
	 * @param num
	 * @return
	 */
	public boolean addtNum(T num) {
		if(tail == size) {
			throw new RuntimeException("�����������޷�����!!!");
		} else {
			data[tail ++] = num;
			return true;
		}
	}
	
	/**
	 * Ԫ�س���
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T poll() {
		if(isEmpty()) {
			throw new RuntimeException("�����쳣������");
		} else {
			T num = (T) data[top];
			for (int i = 0; i < data.length - 1; i++) {
				data[top ++] = data[top];
			}
			top = 0;
			data[tail -1] = null;
			tail -= 1;
			return num;
		}
	}
	
	/**
	 * ��ö�����Ԫ�صĸ���
	 * @return
	 */
	public int getSize() {
		return tail;
	}

	/**
	 * ��ö���Ԫ��
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getTop() {
		return (T) data[top];
	}

	/**
	 * ��ö�βԪ��
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getTail() {
		return (T) data[tail -1];
	}

	/**
	 * ��ӡ����
	 */
	public void printQueue() {
		for (int i = 0; i < tail; i ++) {
			System.out.println(data[i]);
		}
	}
}
