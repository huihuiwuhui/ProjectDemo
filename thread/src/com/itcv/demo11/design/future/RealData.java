package com.itcv.demo11.design.future;

public class RealData implements Data {
   private String result;
   
   public RealData(String queryStr){
	   System.out.println("����"+queryStr+"���в�ѯ������һ���ܺ�ʱ�Ĳ�����������");
       try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
       System.out.println("������ϣ���ȡ���");
       result = "��ѯ���";
   }
	@Override
	public String getRequest() {
		return result;
	}

}