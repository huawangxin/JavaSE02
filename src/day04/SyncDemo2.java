package day04;
/**
 * ��Ч�ļ���ͬ���쳣����
 * ���̱߳��뿴���������������ͬһ���󣬷�����Ч��
 * ���synchronized����ĳһ�Ǿ�̬�����У�ͨ��������д�ľ���this
 * @author wangxin
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final SyncDemo2 demo=new SyncDemo2();
		Thread С��ñ=new Thread(){
			public void run(){
				demo.buy(getName());
			}
		};
		Thread �����=new Thread(){
			public void run(){
				demo.buy(getName());
			}
		};
		С��ñ.start();
		�����.start();
	}
	public void buy(String name){
		System.out.println(name+"�������·�");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();		
		}
		System.out.println(name+"�����·���");
		synchronized (this) {
			System.out.println(name+"׼�����·���");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();		
			}
			System.out.println(name+"�����·���");
		}
		System.out.println(name+"���ˡ�");
	}
//	public static void buy(String name){
//		synchronized (name) {
//			System.out.println(name+"�������·�");
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();		
//			}
//			System.out.println(name+"�����·���");
//		}
//		System.out.println(name+"���ˡ�");
//	}
	
}
