package ��ҵ1;
/**
 * 
 * @author wangxin
 *
 */
public class Test�ݹ� {
	public static void main(String[] args) {
		System.out.println(add(100));
	}
	/*
	 * ʹ�õ�ǰ�������ۼ�֮ǰ��ÿһ������
	 * ֪��1Ϊֹ
	 * �ݹ飺
	 * 1�����ȿ��Ǽ��������ʲôʱ��ֹͣ
	 * 2��ÿһ�ֿ��ܷ���������Ƿ񶼿�����
	 * 3�������ڲ������ظ�������£����ø÷������ɣ�������ǵݹ���ã�
	 * @param n
	 */
	public static int add(int n){
		if(n==1){
			return 1;
		}else {
			return add(n-1);
		}
	}
}
