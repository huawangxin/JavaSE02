package ��ҵ4;
/**
 * �߳̿�����ȫ����
 * @author wangxin
 *
 */
public class SyncDemo {
	//��������20������
	public static int beans=20;
	public static void main(String[] args) {
		Thread t1=new Thread(){
			public void run(){
				int bean=0;
				while(true){
					bean=getBean();
					System.out.println(this.getName()+":"+bean);
				}
			}
		};
		Thread t2=new Thread(){
			public void run(){
				int bean=0;
				while(true){
					bean=getBean();
					System.out.println(this.getName()+":"+bean);
				}
			}
		};
		t1.start();
		t2.start();
	}
	//��������ȥһ������
	public synchronized static int getBean(){
		if(beans==0){
			throw new RuntimeException("û�ж���");
		}
		Thread.yield();
		return beans--;
	}
}
