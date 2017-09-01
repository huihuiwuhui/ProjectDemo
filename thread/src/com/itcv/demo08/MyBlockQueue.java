package com.itcv.demo08;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
/**
 * ��������
 * @author Admin
 *
 */
import java.util.concurrent.atomic.AtomicInteger;
public class MyBlockQueue {
    //ʵ����һ��Ԫ�صļ���
	private final LinkedList<Object> list = new LinkedList<Object>();
    /**
     * ����һ��������
     */
	private AtomicInteger count = new AtomicInteger(0);
	
	private final int minSize = 0;
	private final int maxSize;
	public MyBlockQueue(int size){
		this.maxSize = size;
	}
	private  final Object lock = new Object();
	public void put(Object obj){
		synchronized (lock) {
			while(count.get()==this.maxSize){
			  try {
				lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			}
			list.add(obj);
			System.out.println("�����һ��Ԫ��");
			//�������ۼ�
			count.incrementAndGet();
			//������һ���߳�
			lock.notify();
		}
		
	}
	
	public Object take(){
		Object ret = null;
		synchronized (lock) {
			while(count.get() == this.minSize){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ret = list.removeFirst();
			//����������
			count.decrementAndGet();
			lock.notify();
		}
		return ret;
	}
	
	public int getSize(){
		return count.get();
	}
	
	public static void main(String[] args) {
	final	MyBlockQueue mq = new MyBlockQueue(5);
		mq.put("a");
		mq.put("b");
		mq.put("c");
		mq.put("d");
		mq.put("e");
		System.out.println("��ǰ���еĳ��ȣ�"+mq.getSize());
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				mq.put("f");
				mq.put("g");
			}
		},"t1");
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Object o1 = mq.take();
				System.out.println("�Ƴ���Ԫ��Ϊ��"+o1);
				Object o2 = mq.take();
				System.out.println("�Ƴ���Ԫ��Ϊ��"+o2);
			}
		},"t2");
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
}
