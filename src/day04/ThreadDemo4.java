package day04;
/**
 * ��ȡִ�е�ǰ����Ƭ�ε��߳�
 * Thread currentThread()
 * ���Ե���thread�ṩ�ľ�̬����
 * @author wangxin
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		//��ȡ�ľ��ǵ���main�������߳�
		Thread t=Thread.currentThread();
		System.out.println("����main���߳�Ϊ��"+t);
		testCurrent();
		//����һ���߳�
		Thread t1=new Thread(){
			public void run(){
				//��ȡ��ǰ�߳�
				Thread myt=Thread.currentThread();
				System.out.println("�Լ��������߳�Ϊ��"+myt);
				testCurrent();
			}
		};
		t1.start();
	}
	public static void testCurrent(){
		//��ȡ������η������߳����ƣ�
		Thread t=Thread.currentThread();
		System.out.println("����testCurrent�ķ������̣߳�"+t);
		
	}
}
