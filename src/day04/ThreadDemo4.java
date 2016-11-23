package day04;
/**
 * 获取执行当前代码片段的线程
 * Thread currentThread()
 * 可以调用thread提供的静态方法
 * @author wangxin
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		//获取的就是调用main方法的线程
		Thread t=Thread.currentThread();
		System.out.println("调用main的线程为："+t);
		testCurrent();
		//创建一个线程
		Thread t1=new Thread(){
			public void run(){
				//获取当前线程
				Thread myt=Thread.currentThread();
				System.out.println("自己创建的线程为："+myt);
				testCurrent();
			}
		};
		t1.start();
	}
	public static void testCurrent(){
		//获取调用这段方法的线程名称！
		Thread t=Thread.currentThread();
		System.out.println("调用testCurrent的方法的线程："+t);
		
	}
}
