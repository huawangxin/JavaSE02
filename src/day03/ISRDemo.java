package day03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * InputstreamReader
 * 字符输入流
 * 用于读取字符数据的流
 * @author wangxin
 *
 */
public class ISRDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("osw.txt");
		InputStreamReader isr=new InputStreamReader(fis);
		int d=-1;
		while((d=isr.read())!=-1){
			char c=(char)d;
			System.out.print(c);
		}
		isr.close();
	}
}
