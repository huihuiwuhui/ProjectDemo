package com.itcv.demo07;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchListAdd {
	private volatile static List list = new ArrayList<>();
	  
	  public void add(){
		   list.add("bjsxt");
	  }
	  public int size(){
		  return list.size();
	  }
	  
	  public static void main(String[] args) throws Exception{
		  
		final  CountDownLatchListAdd noifyList = new CountDownLatchListAdd();
		/**
		 * 1��ʾ�������
		 */
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					  	for (int i = 0; i < 10; i++) {
					  		noifyList.add();
					  		System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"�����һ��Ԫ��");
					  		Thread.sleep(500);
					  		if(noifyList.size()==5){
					  			System.out.println("�����߳�");
					  			countDownLatch.countDown();
					  		}
						}				
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
						if(noifyList.size() !=5){
							System.out.println("�ȴ��С�����������");
							countDownLatch.await();
						}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("��ǰ�߳��յ�֪ͨ�� "+ Thread.currentThread().getName() + "list size =5 �߳�ֹͣ");
			    throw new RuntimeException();
			}
		},"t2");
		t2.start();
      //  Thread.sleep(500);
		t1.start();
	}
}
