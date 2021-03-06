package com.itcv.demo06;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileNoAtomic extends Thread{
   //保证不了原子性
	//private static volatile int count;
   //可以保证原子性
	private static AtomicInteger count = new AtomicInteger(0);
  
	private static void addCount(){
	   for(int i=0;i<1000;i++){
		  // count ++;
		   count.incrementAndGet();
	   }
	   System.out.println(count);
   }
   
   public void run(){
	   addCount();
   }
   public static void main(String[] args) {
	VolatileNoAtomic [] arr = new VolatileNoAtomic[10];
	for (int i = 0; i <10;i++) {
		arr[i] = new VolatileNoAtomic();
	}
	
	for (int i = 0; i < 10; i++) {
		arr[i].start();
	}
}
}
