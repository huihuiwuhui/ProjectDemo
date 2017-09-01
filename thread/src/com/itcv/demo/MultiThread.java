package com.itcv.demo;

public class MultiThread {
  private static int num =0;
  /**
   * ����static֮���ȡ�������༶���
   * ����static��ȡ���Ƕ��󼶱����
   * synchronized ��ȡ�������Ƕ��󼶱�ģ�������ĳ��������
   * @param tag
   */
  public static synchronized void printNum(String tag){
	  try {
		if(tag.equals("a")){
			  num = 100;
			  System.out.println("tag a set number over");
			  Thread.sleep(1000);
		  }else{
			  num = 200;
			  System.out.println("tag b set number over");
		  }
		System.out.println("tag:"+tag+"num:"+num);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
  } 
  /**
   * һ���������һ����
   * @param args
   */
  public static void main(String[] args) {
	  MultiThread m1 = new MultiThread();
	  MultiThread m2 = new MultiThread();
	  Thread t1 = new Thread(new Runnable() {
		@Override
		public void run() {
			m1.printNum("a");
		}
	  });
	  t1.start();
	  Thread t2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
          m2.printNum("b");			
		}
	});
	  t2.start();
}
}
