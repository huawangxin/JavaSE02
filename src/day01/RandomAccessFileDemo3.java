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
		 * 1:创建一个RandomAccessFile用于读取用于复制的文件
		 * 2：创建一个RandmoAccessFile用于将源文件中的数据写入该文件
		 * 3：循环从原文件中读取每一个字节并写入目标文件中
		 * 4：关闭两个RandomAcessFile
		 */
		long start=System.currentTimeMillis();
		RandomAccessFile src=new RandomAccessFile("zhishishuli.xmind", "r");
		RandomAccessFile des=new RandomAccessFile("方阳.xmind", "rw");
		int d=-1;
		while((d=src.read())!=-1){
			des.write(d);
		}
		System.out.println("拷贝完毕");
		src.close();
		des.close();
		long end=System.currentTimeMillis();
		System.out.println("耗时："+(end-start)+"毫秒");
		
		
	}
}
