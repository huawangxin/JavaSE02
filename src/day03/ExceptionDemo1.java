package day03;
/**
 * java�쳣��������е�try catch
 * ���û�б�try��Χʱ��java����쳣�׸����ø÷���֮��ķ�����
 * ����main�ľ���������������ֱ��kell
 * @author wangxin
 *
 */
public class ExceptionDemo1 {
	public static void main(String [] args){
		//java.lang.NullPointerException
		System.out.println("����ʼ��");
		try {
			String str="a";
			//�����ֿ�ָ���쳣��jvm����һ����ָ���쳣��ʵ���������׳���
			//���õĳ������Ƕ�Ӧ�������һ��catch����һ��Exception
			System.out.println(str.length());
			System.out.println(str.charAt(0));
			System.out.println(Integer.parseInt(str));
		} catch (NullPointerException e) {
			System.out.println("������һ����ָ��");		
		}catch (StringIndexOutOfBoundsException e) {
			System.out.println("������һ���ַ����±�Խ��");		
		}catch (Exception e) {
			System.out.println("�������Ǵ���");		
		}
		System.out.println("���������");
	}
}
