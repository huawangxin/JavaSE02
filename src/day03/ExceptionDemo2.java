package day03;
/**
 * finally��
 * ����try���еĴ����Ƿ�����쳣
 * finally���еĴ��붼Ҫִ��
 * ͨ�����ǻ���finally��������������
 * �����ͷ����ӣ��ر����ȵ�
 * @author wangxin
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] args){
		try {
			System.out.println("�����ݿ⽨������");
			System.out.println("���ӳɹ�");
			System.out.println("�����ݿ��в�ѯ����");
			System.out.println("�����ݽ��в���");
			String str="a";
			int i=Integer.parseInt(str);
			System.err.println("���ݴ������");
			System.out.println("�����ݱ��������ݿ�");
			
		} catch (Exception e) {
			System.out.println("���ִ����ˣ�");
		}finally{
			System.out.println("�����ݿ�Ͽ�����");
		}
		System.out.println("���������");
	}
}