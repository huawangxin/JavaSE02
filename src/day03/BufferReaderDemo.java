package day03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


/**
 * BufferReader
 * 缓冲字节输入流
 * 可以以行为单位读取字符串
 * @author wangxin
 *
 */
public class BufferReaderDemo {
	public static void main(String [] args) throws Exception{
		FileInputStream fis=new FileInputStream("pw.txt");
		InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
		BufferedReader br=new BufferedReader(isr);
		/*
		 * String readLine()
		 * 一次读取一行字符串，该方法会判断读取待换行符为止，
		 * 将之前的一行，将之前的一行字符串
		 * 若该方法返回的字符串为null，说明没有数据可读。
		 */
		String str=null;
		while((str=br.readLine())!=null){
			System.out.println(str);
		}
		br.close();
	}
}
