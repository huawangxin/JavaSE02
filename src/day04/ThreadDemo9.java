package day04;
/**
 * join可以使线程同步
 * @author wangxin
 *
 */
public class ThreadDemo9 {
	//表示图盘是否下载完毕
	public static boolean isFinish;
	public static void main(String[] args) {
		final Thread download=new Thread(){
			public void run(){
				System.out.println("down:开始下载图片。。");
				for (int i = 1; i <= 100; i++) {
					System.out.println("down:已完成"+i);
				}try{
					Thread.sleep(50);
				}catch (InterruptedException e) {
				}
				System.out.println("down：图片下载完成");
				isFinish=true;
			}
		};
		/*
		 * main方法中定义了一个内部类show，
		 * 该内部类中若向引用main方法中的其他局部变量，
		 * 那么这个变量必须是final的
		 */
		Thread show=new Thread(){
			public void run(){
				System.out.println("show:开始显示图片");
				//这里应该等待下载线程将图片下载完毕
				try {
					download.join();
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
