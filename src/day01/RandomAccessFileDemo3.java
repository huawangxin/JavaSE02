package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * @author wangxin
 *
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args) throws IOException {
		/*
		 * 1:����һ��RandomAccessFile���ڶ�ȡ���ڸ��Ƶ��ļ�
		 * 2������һ��RandmoAccessFile���ڽ�Դ�ļ��е�����д����ļ�
		 * 3��ѭ����ԭ�ļ��ж�ȡÿһ���ֽڲ�д��Ŀ���ļ���
		 * 4���ر�����RandomAcessFile
		 */
		long start=System.currentTimeMillis();
		RandomAccessFile src=new RandomAccessFile("zhishishuli.xmind", "r");
		RandomAccessFile des=new RandomAccessFile("����.xmind", "rw");
		int d=-1;
		while((d=src.read())!=-1){
			des.write(d);
		}
		System.out.println("�������");
		src.close();
		des.close();
		long end=System.currentTimeMillis();
		System.out.println("��ʱ��"+(end-start)+"����");
		
		
	}
}
