package com.itcv.demo10;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class UseQueue {
public static void main(String[] args) throws Exception{
	//�������������޽����  ConcurrentLinkedQueue
	/*ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<String>();
    q.offer("a");
    q.offer("b");
    q.offer("c");
    q.offer("d");
    q.add("e");
    System.out.println(q.poll());//��ͷ��ȡ��Ԫ�أ����Ӷ�����ɾ��
    System.out.println(q.size());
    System.out.println(q.peek());//��ͷ��ȡ��Ԫ��
    System.out.println(q.size());*/
	
    //����5�����ȵ������н����  ��ʼ����ʱ������ʼ��һ������
  /*  ArrayBlockingQueue<String> array = new ArrayBlockingQueue<String>(5);
    array.add("a");
    array.add("b");
    array.add("c");
    array.add("d");
    array.add("e");
    System.out.println(array.offer("f", 2, TimeUnit.SECONDS));
    System.out.println(array.size());*/
   
  /*LinkedBlockingQueue<String> link = new LinkedBlockingQueue<String>();
    link.offer("a");
    link.offer("b");
    link.offer("c");
    link.offer("d");
    link.offer("e");
    link.offer("f");
    System.out.println(link.size());*/
	
}
}
