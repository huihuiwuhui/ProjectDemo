package com.itcv.demo13.current.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class UseFuture implements Callable<String>{
	 private String para;
	 
	 public UseFuture(String para){
		 this.para = para;
	 }
	
	 @Override
     public String call() throws Exception {
	    Thread.sleep(3000);
	    String result = this.para +"�������";
		return result;
		}
	 
     public static void main(String[] args) throws Exception {
		String query = "query";
		//����FutureTask,���Ҵ�����Ҫ��������ҵ���߼�������࣬����һ����ʵ����Callable�ӿڵ���
		FutureTask<String> future = new FutureTask<String>(new UseFuture(query));
        //����һ���̶��̵߳��̳߳����߳���Ϊ1
		ExecutorService executor = Executors.newFixedThreadPool(1);
		//�����ύ����future,�����߳�ִ��RealData��call
		//submit ��execute�����𣺵�һ����submit���Դ���ʵ��Callable�ӿڵ�ʵ�����󣬵ڶ�����submit�����з���ֵ
        Future f = executor.submit(future);//����null
        System.out.println("�������");
        System.out.println(f.get());
        //�����������������ݲ�����Ҳ����������ִ������ҵ���߼�
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //���û�ȡ���ݷ��������call()����û��ִ����ɣ�����Ȼ����еȴ�
        System.out.println("���ݣ�"+future.get());
        executor.shutdown();
        
     }

	
}
