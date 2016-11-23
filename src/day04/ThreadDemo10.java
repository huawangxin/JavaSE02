package day04;


/**
 * �߳�Эͬ����
 * @author wangxin
 *
 */
public class ThreadDemo10 {
	public static boolean isFinish;
	public static Object obj=new Object();
	public static void main(String[] args) {
		final Thread download=new Thread(){
			public void run(){
				System.out.println("down:��ʼ����ͼƬ����");
				for (int i = 1; i <= 100; i++) {
					System.out.println("down:�����"+i+"%");
				}try{
					Thread.sleep(50);
				}catch (InterruptedException e) {
				}
				System.out.println("down��ͼƬ�������");
				isFinish=true;
				/*
				 * ��ͼƬ������ϣ���Ӧ��֪ͨ��ʾͼƬ���߳̿�ʼ������
				 * notify()ֻ��������һ���ڵ�ǰ�����ϵȴ����߳�
				 * ���ǵ����ĸ������notify()����Ӧ�öԵ�ǰ���������
				 * ��������ǵ�ǰ����
				 */
				synchronized (obj) {
					obj.notify();
				}
				
				System.out.println("down:��ʼ���ظ�������");
				for (int i = 1; i <= 100; i++) {
					System.out.println("down:�����"+i+"%");
				}try{
					Thread.sleep(50);
				}catch (InterruptedException e) {
				}
				System.out.println("down�������������");
			}
		};
		
		
		Thread show=new Thread(){
			public void run(){
				System.out.println("show:��ʼ��ʾͼƬ");
				//����Ӧ�õȴ������߳̽�ͼƬ�������
				try {
					//download.join();
					//��obj�����ϵȴ�
					synchronized (obj) {
						obj.wait();
					}
					
				} catch (InterruptedException e) {
				}
				if(!isFinish){
					throw new RuntimeException("ͼƬ�������");
				}
				System.out.println("��ʾͼƬ���");
			}
		};
		download.start();
		show.start();
	}
}
