package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ����д��һ���ֽ�
 * @author wangxin
 *
 */
public class RandomAccessFileDemo4 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("test.txt", "rw");
		String str="�Ұ������찲��";
		/*
		 * string��getBytes()������
		 * ����ǰ�ַ������յ�ǰϵͳĬ�ϵ��ַ���ת���ɶ�Ӧ���ֽ�
		 * UTF-8���ʻ���Ӣ��1�ֽڣ�����3�ֽ�     
		 * unicode
		 * GBK
		 */
		byte[] buf=str.getBytes("gbk");
		raf.write(buf);
		System.out.println("�����");
		raf.close();
	}
}
