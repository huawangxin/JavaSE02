package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 批量写入一组字节
 * @author wangxin
 *
 */
public class RandomAccessFileDemo4 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("test.txt", "rw");
		String str="我爱北京天安门";
		/*
		 * string的getBytes()方法：
		 * 将当前字符串按照当前系统默认的字符集转换成对应的字节
		 * UTF-8国际化，英文1字节，中文3字节     
		 * unicode
		 * GBK
		 */
		byte[] buf=str.getBytes("gbk");
		raf.write(buf);
		System.out.println("已完成");
		raf.close();
	}
}
