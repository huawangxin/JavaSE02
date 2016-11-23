package day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * 读取一个字节数组的数据
 * @author wangxin
 *
 */
public class RandomAccessFileDemo5 {
	public static void main(String [] args) throws IOException{
		RandomAccessFile raf=new RandomAccessFile("test.txt", "r");
		/*
		 * int read(byte[] buf)
		 * 一次尝试从文件中读取第一个位置处起
		 * 存放实际读取到的字节数
		 * 返回值为实际读取到的字节数
		 */
		byte[] buf=new byte[50];
		int len=raf.read(buf);
		System.out.println(len);
		System.out.println(Arrays.toString(buf));
		/*
		 * 从字节数组转化为对应的字符串
		 */
		String str=new String(buf,"GBK");
		System.out.println(str.trim());
		buf.clone();
		
		
	}
}
