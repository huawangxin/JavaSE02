package 作业4;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 每个5秒输出当前的日期和时间,主线程结束之后计时完毕
 * @author wangxin
 *
 */
public class Timing {
	public static void main(String[] args) {
		Thread d=new Thread(){
			public void run(){
				while(true){
					Date d=new Date();
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd  HH:ss:mm");
					System.out.println(sdf.format(d));
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		d.setDaemon(true);
		d.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		//进程中所有前台线程结束后，后台线程强制结束
		System.out.println("main线程结束了");
	}
}
