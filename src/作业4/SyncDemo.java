package 作业4;
/**
 * 线程开发安全问题
 * @author wangxin
 *
 */
public class SyncDemo {
	//桌子上有20个豆子
	public static int beans=20;
	public static void main(String[] args) {
		Thread t1=new Thread(){
			public void run(){
				int bean=0;
				while(true){
					bean=getBean();
					System.out.println(this.getName()+":"+bean);
				}
			}
		};
		Thread t2=new Thread(){
			public void run(){
				int bean=0;
				while(true){
					bean=getBean();
					System.out.println(this.getName()+":"+bean);
				}
			}
		};
		t1.start();
		t2.start();
	}
	//从桌子上去一个豆子
	public synchronized static int getBean(){
		if(beans==0){
			throw new RuntimeException("没有豆子");
		}
		Thread.yield();
		return beans--;
	}
}
