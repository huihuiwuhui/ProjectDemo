package com.itcv.jvm.demo01;

public class Test02 {

	public static void main(String[] args) {
		//	1: -XX:+PrintGC ��ӡ��־
		// -Xms:���ó�ʼ�Ѵ�С
		// -Xmx:����java�����ܻ�õ����Ѵ�С
		//-Xmn:������������С
		//-XX:SurvivorRatio:������������from/toռ�õı��� from:to ��Сһ��
		// -XX:+UseSerialGC ���ô��л�����
		//-XX:+PrintGC -Xms5m -Xmx20m -XX:+UseSerialGC -XX:+PrintGCDetails	
	   //-Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
	
	   //�ڶ�������
	  //-XX:NewRatio=�����/������
	  //-Xms20m -Xmx20m -XX:NewRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
		
		byte [] b =null;
		//������ϵͳ����10Mb�ռ�
		for (int i = 0; i < 10; i++) {
			b = new byte [1*1024*1024];
			
		}
	}

}
