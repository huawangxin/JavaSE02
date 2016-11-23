package day04;
/**
 * 第一种创建线程的方式
 * 继承Thread类，重写run方法
 * @author wangxin
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		//有先后顺序的运行方式我们称之为同步运行
//		for(int i=0;i<1000;i++){
//			System.out.println("你是谁啊");
//		}
//		for (int i = 0; i < 1000; i++) {
//			System.out.println("我是查水表的");
//		}
		Thread t1=new MyThread1();
		Thread t2=new MyThread2();
		//start方法把线程拉入到线程调度，这时，线程进入runnable状态，
		/*
		 * 等待线程调度分配时间片段
		 * 当线程调度将时间分配给当前线程，该方法的run方法才开始被执行。
		 * 当线程调度将时间片段执行完毕，线程结束最终被回收
		 * 在线程的run 方法执行期间，该线程处于走走停停。
		 */
		t1.start();
		t2.start();
	}
}
class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("你是谁啊"+i);
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("我是查水表的"+i);
		}
	}
}
