package com.itcv.demo11.design.master;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {

	private ConcurrentLinkedQueue<Task> workQueue;
	private ConcurrentHashMap<String,Object> resultMap;
	public void setWorkerQueue(ConcurrentLinkedQueue<Task> workQueue){
		this.workQueue = workQueue;
	}
	public void setReultMap(ConcurrentHashMap<String,Object> resultMap){
		this.resultMap = resultMap;
	}
	@Override
	public void run() {
		while(true){
			Task input = this.workQueue.poll();
			if(input == null) break;
			//������ȥ��ҵ����
			Object output = handle(input);
			this.resultMap.put(Integer.toString(input.getId()), output);
		}
	}
	
	private Object handle(Task input){
		Object output = null;
		try {
			//��ʾ����task����ĺ�ʱ�����������ݵļӹ���Ҳ�����ǲ������ݿ⡣������
			Thread.sleep(500);
			output = input.getPrice();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
}
