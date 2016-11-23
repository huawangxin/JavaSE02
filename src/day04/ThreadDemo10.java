package day04;


/**
 * 线程协同问题
 * @author wangxin
 *
 */
public class ThreadDemo10 {
	public static boolean isFinish;
	public static Object obj=new Object();
	public static void main(String[] args) {
		final Thread download=new Thread(){
			public void run(){
				System.out.println("down:开始下载图片。。");
				for (int i = 1; i <= 100; i++) {
					System.out.println("down:已完成"+i+"%");
				}try{
					Thread.sleep(50);
				}catch (InterruptedException e) {
				}
				System.out.println("down：图片下载完成");
				isFinish=true;
				/*
				 * 当图片下载完毕，就应当通知显示图片的线程开始工作了
				 * notify()只会随机解除一个在当前对象上等待的线程
				 * 我们调用哪个对象的notify()，就应该对当前对象加锁，
				 * 锁对象就是当前对象
				 */
				synchronized (obj) {
					obj.notify();
				}
				
				System.out.println("down:开始下载附件。。");
				for (int i = 1; i <= 100; i++) {
					System.out.println("down:已完成"+i+"%");
				}try{
					Thread.sleep(50);
				}catch (InterruptedException e) {
				}
				System.out.println("down：附件下载完成");
			}
		};
		
		
		Thread show=new Thread(){
			public void run(){
				System.out.println("show:开始显示图片");
				//这里应该等待下载线程将图片下载完毕
				try {
					//download.join();
					//在obj对象上等待
					synchronized (obj) {
						obj.wait();
					}
					
				} catch (InterruptedException e) {
				}
				if(!isFinish){
					throw new RuntimeException("图片下载完毕");
				}
				System.out.println("显示图片完毕");
			}
		};
		download.start();
		show.start();
	}
}
