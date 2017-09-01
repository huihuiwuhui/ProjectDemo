package com.itcv.demo11.design.producer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
    //��������
	private BlockingQueue<Data> queue;
	//���߳��Ƿ�������������ǿ�ƴ����ڴ���ˢ�µĹ��ܣ���ʱ�����̵߳�״̬
	private volatile boolean isRunning = true;
	//id������
	private static AtomicInteger count = new AtomicInteger();
	//�������
	private static Random r = new Random();
	
	public Producer(BlockingQueue queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		 while(isRunning){
			 try {
				 //�������0 ����1000 ���� ��ʾ��ȡ���ݣ����������ݺ�ʱ��
				Thread.sleep(r.nextInt(1000));
				//��ȡ�����ݽ����ۼơ�������
				int id = count.incrementAndGet();
				//����ͨ��һ��getData������ȡ��
				Data data  = new Data(Integer.toString(id),"����" + id);
			    System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+",��ȡ�����ݣ�idΪ��"+id+",����װ�ص�������������.....");
			    if(this.queue.offer(data,2,TimeUnit.SECONDS)){
			    	System.out.println("�ύ����������ʧ��.....");
			    }
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
	}
   
	public void stop(){
		this.isRunning = false;
	}
}
