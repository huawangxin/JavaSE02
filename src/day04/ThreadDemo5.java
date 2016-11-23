package day04;
/**
 * �߳�����API
 * @author wangxin
 *
 */
public class ThreadDemo5 {
	public static void main(String[] args) {
		//��ȡ����main�������̵߳������Ϣ
		Thread t=Thread.currentThread();
		//��ȡ�߳�ID��ͨ����ϵͳ����
		long id=t.getId();
		System.out.println("id:"+id);
		/*
		 * ��ȡ�̵߳����֣�ͨ����ϵͳָ��
		 * ��ʽΪ��Thread-X
		 * ���Ǹ�ʽ��main�������߳����Ʋ��������
		 */
		String name=t.getName();
		System.out.println("name:"+name);
		//��ȡ�̵߳����ȼ�
		int p=t.getPriority();
		System.out.println("���ȼ���"+p);
		//��ȡ�߳�״̬
		System.out.println("state:"+t.getState());
		//��ȡ�߳��Ƿ����
		System.out.println("alive"+t.isAlive());
		//��ȡ�߳��Ƿ�Ϊ��̨
		System.out.println("daemon"+t.isDaemon());
		//��ȡ�߳��Ƿ��ж�
		System.out.println("interrupt"+t.isInterrupted());
		
		
		System.out.println();
		
	}
}
