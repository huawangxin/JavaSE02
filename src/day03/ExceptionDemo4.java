package day03;
/**
 * Exception常用的方法
 * @author wangxin
 *
 */
public class ExceptionDemo4 {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		String str=null;
		try {
			
			System.out.println(str.length());
		} catch (Exception e) {
			//查看错误信息
			e.printStackTrace();
			System.out.println("出错了！！！！");
			System.out.println(e.getMessage());
			System.out.println(Integer.parseInt(str));
		}
		System.out.println("程序结束了");
	}
}
