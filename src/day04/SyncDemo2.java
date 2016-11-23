package day04;
/**
 * 有效的减少同步异常问题
 * 多线程必须看到的锁对象必须是同一对象，否则不起效果
 * 如果synchronized块在某一非静态方法中，通常锁对象写的就是this
 * @author wangxin
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final SyncDemo2 demo=new SyncDemo2();
		Thread 小红帽=new Thread(){
			public void run(){
				demo.buy(getName());
			}
		};
		Thread 大灰狼=new Thread(){
			public void run(){
				demo.buy(getName());
			}
		};
		小红帽.start();
		大灰狼.start();
	}
	public void buy(String name){
		System.out.println(name+"正在挑衣服");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();		
		}
		System.out.println(name+"挑完衣服了");
		synchronized (this) {
			System.out.println(name+"准备试衣服了");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();		
			}
			System.out.println(name+"试完衣服了");
		}
		System.out.println(name+"结账。");
	}
//	public static void buy(String name){
//		synchronized (name) {
//			System.out.println(name+"正在挑衣服");
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();		
//			}
//			System.out.println(name+"试完衣服了");
//		}
//		System.out.println(name+"结账。");
//	}
	
}
