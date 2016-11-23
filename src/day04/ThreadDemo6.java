package day04;
/**
 * 线程优先级(默认为5)
 * 1-10
 * 理论上，线程优先级高的线程，被分配时间的片段的次数多
 * @author wangxin
 *
 */
public class ThreadDemo6 {
	public static void main(String[] args) {
		Thread max=new Thread(){
			public void run(){
				for(int i=0;i<5000;i++){
					System.out.println("max");
				}
			}
		};
		Thread min=new Thread(){
			public void run(){
				for(int i=0;i<5000;i++){
					System.out.println("min");
				}
			}
		};
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		min.start();
		max.start();
	}
}
