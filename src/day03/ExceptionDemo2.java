package day03;
/**
 * finally块
 * 无论try块中的代码是否出现异常
 * finally块中的代码都要执行
 * 通常我们会在finally中做清理工作、
 * 比如释放连接，关闭流等等
 * @author wangxin
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] args){
		try {
			System.out.println("与数据库建立连接");
			System.out.println("连接成功");
			System.out.println("从数据库中查询数据");
			System.out.println("对数据进行操作");
			String str="a";
			int i=Integer.parseInt(str);
			System.err.println("数据处理完毕");
			System.out.println("将数据保存至数据库");
			
		} catch (Exception e) {
			System.out.println("出现错误了！");
		}finally{
			System.out.println("与数据库断开连接");
		}
		System.out.println("程序结束了");
	}
}
