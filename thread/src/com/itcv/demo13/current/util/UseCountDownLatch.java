package com.itcv.demo13.current.util;

import java.util.concurrent.CountDownLatch;

public class UseCountDownLatch {
	 
    public static void main(String[] args) {
    	final CountDownLatch countDown = new CountDownLatch(2);
		Thread t1 = new Thread(new Runnable() {
			public void run() {
					try {
						System.out.println("�����߳�"+Thread.currentThread().getName()+"�ȴ������̴߳�����ɡ�������");
						countDown.await();
						System.out.println("t1�̼߳���ִ�С�����");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run(){
			  try {
				System.out.println("t2�߳̽��г�ʼ������������������");
			    Thread.sleep(3000);
				System.out.println("t2�̳߳�ʼ����ϣ�֪ͨt1�̼߳�����������");  
				countDown.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		},"t2");
		
		Thread t3 = new Thread(new Runnable(){
			@Override
			public void run(){
			  try {
				System.out.println("t3�߳̽��г�ʼ������������������");
			    Thread.sleep(4000);
				System.out.println("t3�̳߳�ʼ����ϣ�֪ͨt1�̼߳�����������");  
				countDown.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		},"t3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
