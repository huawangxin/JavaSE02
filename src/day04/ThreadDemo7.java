package day04;
/**
 * ��̨�̣߳��ػ��߳�
 * �ص㣺
 * ������������ǰ̨�̶߳�����ʱ����̨�߳̽��������ۺ�̨�߳��Ƿ�������
 * @author wangxin
 *
 */
public class ThreadDemo7 {
	public static void main(String[] args) {
		//rose �����ߣ�ǰ̨�߳�
		Thread rose=new Thread(){
			public void run(){
				for(int i=0;i<10;i++){
					System.out.println("rose :let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("rose: AAAAAAAAAAaaaaa");
				System.out.println("��Ч����ͨ");
			}
		};
		//jack �����ߣ���̨�߳�
		Thread jack=new Thread(){
			public void run(){
				for(int i=0;i<10;i++){
					System.out.println("jack :you jump,I jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
		};
		rose.start();
		//���ú�̨�߳�Ӧ��start����֮ǰ����
		jack.setDaemon(true);
		jack.start();
		System.out.println("main����ִ������");
		
	}
}
