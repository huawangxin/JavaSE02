package day03;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * PritWriter是具有自动行刷新的缓冲字符输出流。
 * 其中参数outputstream与writer的构造参数提供了一个可以传入boolean值参数
 * @author wangxin
 *
 */
public class PrintWriterDemo {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos=new FileOutputStream("pw.txt");
		OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
		/*
		 * 创建具有自动行刷新的PritWriter后，每当我们使用println方法写出
		 * 字符串后，都会自动flush
		 * 但一定要清楚，这无疑会增加写出次数而降低写出效率。
		 */
		PrintWriter pw=new PrintWriter(osw,true);
		pw.print("我爱北京天安门");
		pw.print("hh");
		pw.close();
	}
}
