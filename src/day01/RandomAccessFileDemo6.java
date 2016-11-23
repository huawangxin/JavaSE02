package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 基于缓存形式复制文件
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
		 * 若返回值为-1，表示未有数据可读了  
		 * EOF
		 */
		while((len=src.read(buf))!=-1){
			des.write(buf,0,len);
		}
		long end=System.currentTimeMillis();
		System.out.println("耗时： "+(end-start)+"毫秒");
		src.close();
		des.close();
	}
}
