package com.itcv.demo08;

public class ThreadLocalDemo {
  public static ThreadLocal<String> tl = new ThreadLocal<String>();
  public void setTl(String value){
	  tl.set(value);
  }	
  public void getTl(){
	  System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"tl��ֵΪ��"+tl.get());
  }
  public static void main(String[] args) {
	final ThreadLocalDemo tld = new ThreadLocalDemo();
	Thread t1 = new Thread(new Runnable() {
		public void run() {
			tld.setTl("���");
			tld.getTl();
		}
	},"t1");
	t1.start();
	Thread t2 = new Thread(new Runnable() {
		public void run() {
			tld.getTl();
		}
	},"t2");
	try {
		t2.sleep(1000);
		t2.start();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
