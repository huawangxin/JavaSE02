package day03;
/**
 * Exception���õķ���
 * @author wangxin
 *
 */
public class ExceptionDemo4 {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		String str=null;
		try {
			
			System.out.println(str.length());
		} catch (Exception e) {
			//�鿴������Ϣ
			e.printStackTrace();
			System.out.println("�����ˣ�������");
			System.out.println(e.getMessage());
			System.out.println(Integer.parseInt(str));
		}
		System.out.println("���������");
	}
}
