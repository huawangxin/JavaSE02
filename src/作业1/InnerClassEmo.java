package ��ҵ1;
/**
 * �ڲ���
 * @author wangxin
 *
 */
public class InnerClassEmo {
	class B{//��Ա�ڲ���
		int b=2;
	}
	public static class C{//��̬�ڲ���
		static int b=4;
	}
	public static void main(String[] args){
//		class A{int a;}//�ֲ��ڲ��࣬д�ڷ�����
		System.out.println(new InnerClassEmo().new B().b);
		System.out.println(InnerClassEmo.C.b);
	}
}
