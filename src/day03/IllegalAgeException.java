package day03;

/**
 * �Զ����쳣 ��ʾ���䲻�������෶Χ
 * 
 * @author wangxin
 *
 */
public class IllegalAgeException extends Exception {
	private static final long serialVersionUID = 1L;

	public IllegalAgeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public void setAge(int age) throws IllegalAgeException{
		if(age<=0||age>100)throw new IllegalAgeException("�������������");
	}
	public static void main(String[] args) {
		Person p = new Person();
		p.setAge(3);
	}
}
