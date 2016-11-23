package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 向文件中写入基本数据类型
 * @author wangxin
 *
 */
public class RandomFileDemo7 {
	public static void main(String [] args) throws IOException{
		RandomAccessFile raf=new RandomAccessFile("raf.dat","rw");
		int num=Integer.MAX_VALUE;
		//将int值写入文件
		/*
		 * 01111111  11111111 11111111 11111111
		 * num>>>24
		 */
//		raf.write(num>>>24);
//		raf.write(num>>>16);
//		raf.write(num>>>8);
//		raf.write(num);
		//连续写4个字节，将int 值写入
		raf.writeInt(num);
		raf.writeDouble(1.4);
		raf.writeLong(12341);
		
		raf.close();
	}
}
