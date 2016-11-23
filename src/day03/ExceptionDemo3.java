package day03;
/**
 * finally引发的血案
 * finally里通常是不用return的
 * @author wangxin
 *
 */
public class ExceptionDemo3 {
	public static void main(String[] args) {
		System.out.println(test(null)+","+test("")+","+test("0"));
	}
	public static int test(String str) {
		try {
			return str.charAt(0)-'0';
		} catch (NullPointerException e) {
			return 1;
		} catch (Exception e) {
			return 2;
		}
		finally{
			return 3;
		}
	}
}
