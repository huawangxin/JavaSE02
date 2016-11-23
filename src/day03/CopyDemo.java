package day03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * 使用字符流复制文本文件
 * @author wangxin
 *
 */
public class CopyDemo {
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("./src/day03/CopyDemo.java");
		FileOutputStream fos=new FileOutputStream("CopyDemo.java");
		InputStreamReader isr=new InputStreamReader(fis);
		OutputStreamWriter osw=new OutputStreamWriter(fos);
		int d=-1;
		while((d=isr.read())!=-1){
			osw.write(d);
		}
		System.out.println("拷贝完毕");
		osw.close();
	}
}
