package day02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * ���������д�����ݵ�ע������
 * @author wangxin
 *
 */
public class BosDemo {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos=new FileOutputStream("hh.jpg");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		String str="ΰ������ë��ϯ";
		byte[] buf=str.getBytes("UTF-8");
		bos.write(buf);
		bos.flush();
		bos.close();
		/*
		 * flushǿ�ƽ���ǰ�������еĻ�����������ȫ��д�������ۻ������Ƿ�װ��
		 * closeʱ��Ҳ���Զ�����һ��flush
		 */
	}
}
