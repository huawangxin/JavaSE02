package day03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * OutputStreamWriter
 * 字符输出流，以字符为单位写出数据
 * 字符流只用于读写字符数据
 * @author wangxin
 *
 */
public class OSWDemo {
	public static void main(String [] args) throws IOException{
		/*
		 * 向文件中写出文本数据（写字符串）
		 * 1：向文件中与数据（FileOutputStream）
		 * 2:写的是文本数据（）
		 */
		FileOutputStream fos=new FileOutputStream("osw.txt");
		/*
		 * OutputStreamWriter的特点是
		 * 可以将给定的字符串按照特定的字符集转换成字节后写出
		 * 使用构造方法：
		 * outputStreamWriter(OutputStream out,String charsetName)
		 */
		OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
		//这样就可以直接写字符串了
		fos.write("大家".getBytes());
		fos.write("O(∩_∩)O~".getBytes());
		fos.close();
		osw.close();
	}
}
