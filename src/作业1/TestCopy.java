package ��ҵ1;

import java.io.IOException;
import java.io.RandomAccessFile;
public class TestCopy {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("miss.jpg", "r");
		RandomAccessFile raf1=new RandomAccessFile("copy.jpg", "rw");
		/*
		 * ʹ���ֽ�������ʽ�����ļ�
		 */
		int len=-1;
		byte[] buf=new byte[1024];
		while((len=raf.read(buf))!=-1){
			raf.write(buf,0,len);
		}
		System.out.println("�������");
		raf.close();
		raf1.close();
	}
}