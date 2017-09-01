package com.itcv.demo11.design.master;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
      //Ӧ����һ����װ����ļ���
	  private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<Task>();
      //2.ʹ��hashMapȥ�������е�worker����
	  private HashMap<String,Thread> workers = new HashMap<String,Thread>();
	  
	  //3.ʹ��һ��������װÿһ��worker����ִ������Ľ����
	  private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String,Object>();
      
	  //4.���췽��
	  public Master(Worker worker,int workerCount){
		  //ÿһ��worker������Ҫ��Master������workQueue�����������ȡ��resultMap����������ύ
		  worker.setWorkerQueue(this.workQueue);
		  worker.setReultMap(this.resultMap);
		  for(int i = 0; i<workerCount;i++){
			  //key��ʾÿһ��worker�����֣�value��ʾ�߳�ִ�ж���
			  workers.put("�ӽڵ�"+Integer.toString(i), new Thread(worker));
		  }
	  }
	  
	  public void submit(Task task){
		  this.workQueue.add(task);
	  }
	  //6.��Ҫ��һ��ִ�еķ���������Ӧ�ó��� �����е�worker������
	  public void excute(){
		  for(Map.Entry<String,Thread> me :workers.entrySet()){
			  me.getValue().start();
		  }
	  }
	  
	  //�ж��߳��Ƿ�ִ�����
	  public boolean isComplete(){
		  for(Map.Entry<String,Thread> me :workers.entrySet()){
			  if(me.getValue().getState() !=Thread.State.TERMINATED){
				  return false;
			  }
		  } 
		  return true;
	  }
	  //���ؽ����
	  public long getResult(){
		  long ret =0L;
		  for (Map.Entry<String,Object> me:resultMap.entrySet()) {
			  //���ܵ��߼�
			ret += (Integer)me.getValue();
		}
		  return ret;
	  }
}
