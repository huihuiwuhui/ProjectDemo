package com.itcv.demo05;
/**
 * һ������������Է����仯����Ӱ����
 * @author Admin
 *
 */
public class ModifyLock {
	
	private String name;
	private int age;
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	public synchronized void changeAttributte(String name,int age){
		System.out.println("��ǰ�߳� ��" + Thread.currentThread().getName() + "��ʼ");
		this.setName(name);
		this.setAge(age);
		System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName() + "�޸Ķ�������Ϊ��"
		+ this.getName() + ", "+ this.getAge());
	}

	

	public static void main(String[] args) {
		final ModifyLock modifyLock = new ModifyLock();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				modifyLock.changeAttributte("����",20);
			}
		},"t1");
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				modifyLock.changeAttributte("����", 21);
			}
		},"t2");
		t1.start();
		t2.start();
	}
}
