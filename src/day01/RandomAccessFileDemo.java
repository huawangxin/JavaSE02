package day01;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile���ڶ�д�ļ����ݵ���
 * @author wangxin
 *
 */
public class RandomAccessFileDemo {
	public static void main(String []args) throws IOException{
		/*
		 * ����Ŀ��Ŀ¼��һ����Ϊdemo.dat
		 * ���ļ����ݽ��ж�д
		 */
		RandomAccessFile raf=new RandomAccessFile("demo.dat", "rw");
//		File file=new File("demo.dat");
//		RandomAccessFile raf2=new RandomAccessFile(file, "rw");
		/*
		 * void write(int n)
		 * д������intֵ�á���8λ��
		 * ֻд1���ֽ�
		 * 00000000 00000000 00000000 00000000 
		 * 1:��֪���Ҳ�֪��
		 * 2��֪�����Ҳ�֪��
		 * 3��֪������֪����
		 * 4:��֪����֪����
		 */
		int num=97;
		raf.write(num);
		int num1=100;
		raf.write(num1);
		int num2=-1;
		raf.write(num2);
		System.out.println(Integer.toBinaryString(num));
		/*
		 * ʹ��IO��һ��Ҫ�ǵùر�
		 */
		raf.close();
	}
}
