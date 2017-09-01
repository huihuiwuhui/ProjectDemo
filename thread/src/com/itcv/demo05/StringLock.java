package com.itcv.demo05;

public class StringLock {
   public void method(){
	   //new String("�ַ�������")
	   synchronized ("�ַ�������") {
		try {
			while(true){
				System.out.println("��ǰ�̣߳� "+ Thread.currentThread().getName() + "��ʼ");
				Thread.sleep(1000);
				System.out.println("��ǰ�̣߳� "+ Thread.currentThread().getName()+ "����");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
   }
   
   public static void main(String[] args) {
	   final StringLock stringLock = new StringLock();
	   Thread t1 = new Thread(new Runnable() {
		public void run() {
		  stringLock.method();	
		}
	},"t1");
	   Thread t2 = new Thread(new Runnable(){
		   public void run(){
			   stringLock.method();
		   }
	   },"t2");
	   t1.start();
	   t2.start();
	 
}
}
