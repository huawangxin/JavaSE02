package ��ҵ4;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * ÿ��5�������ǰ�����ں�ʱ��,���߳̽���֮���ʱ���
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
		//����������ǰ̨�߳̽����󣬺�̨�߳�ǿ�ƽ���
		System.out.println("main�߳̽�����");
	}
}
