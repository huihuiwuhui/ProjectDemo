package com.itcv.demo;

public class MyObject {
   public synchronized void method1(){
	   try {
		System.out.println(Thread.currentThread().getName());
		   Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public synchronized void method2(){
	   System.out.println(Thread.currentThread().getName());
   }
   public static void main(String[] args) {
	  final MyObject obj = new MyObject();
	  /**
	   * t1�߳��ȳ���object�����Lock����t2�߳̿������첽�ķ�ʽ���ö����еķ�synchronized���εķ���
       * t1�߳��ȳ���object�����Lock����t2�߳�������ʱ����ö����е�ͬ��(synchronized)��������Ҫ�ȴ���Ҳ����ͬ��
	   */
	  Thread t1 = new Thread(new Runnable() {
		@Override
		public void run() {
		  obj.method1();
		 }
	  },"t1");
	  t1.start();
	  Thread t2 = new Thread(new Runnable() {
		@Override
		public void run() {
		  obj.method2();
		}
	 },"t2");
	 t2.start();
}
}
