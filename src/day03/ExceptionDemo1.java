package day03;
/**
 * java异常处理机制中的try catch
 * 如果没有被try包围时，java会把异常抛给调用该方法之外的方法，
 * 调用main的就是虚拟机，虚拟机直接kell
 * @author wangxin
 *
 */
public class ExceptionDemo1 {
	public static void main(String [] args){
		//java.lang.NullPointerException
		System.out.println("程序开始啦");
		try {
			String str="a";
			//当出现空指针异常后，jvm创建一个空指针异常的实例，将它抛出来
			//良好的程序我们都应该在最后一个catch捕获一个Exception
			System.out.println(str.length());
			System.out.println(str.charAt(0));
			System.out.println(Integer.parseInt(str));
		} catch (NullPointerException e) {
			System.out.println("出现了一个空指针");		
		}catch (StringIndexOutOfBoundsException e) {
			System.out.println("出现了一个字符串下标越界");		
		}catch (Exception e) {
			System.out.println("反正就是错了");		
		}
		System.out.println("程序结束啦");
	}
}
