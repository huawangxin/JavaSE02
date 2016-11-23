package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ���ڻ�����ʽ�����ļ�
 * @author wangxin
 *
 */
public class RandomAccessFileDemo6 {
	public static void main(String [] args) throws IOException{
		RandomAccessFile src=new RandomAccessFile("hh.wmv", "r");
		RandomAccessFile des=new RandomAccessFile("copy.wmv", "rw");
		long start=System.currentTimeMillis();
		byte[] buf=new byte[1024*10];
		int len=-1;
		/*
		 * int read(byte[] buf)
		 * ������ֵΪ-1����ʾδ�����ݿɶ���  
		 * EOF
		 */
		while((len=src.read(buf))!=-1){
			des.write(buf,0,len);
		}
		long end=System.currentTimeMillis();
		System.out.println("��ʱ�� "+(end-start)+"����");
		src.close();
		des.close();
	}
}
