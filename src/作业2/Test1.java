package 作业2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 设计一个程序，将你在控制台输入的String字符串追加到exam.txt中。

如：exam.txt 中原本有“好好学习”;你在控制台输入“天天向上”，exam.txt打开后变成

“好好学习天天向上”。
 * @author wangxin
 *

提示：RandomAccessFile类中的seek（Long)方法将文件指针文件某个字节；

      length（）方法获取文件字节数。
 */
public class Test1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("test.txt", "rw");
		Scanner scanner=new Scanner(System.in);
		raf.seek(raf.length());
		String ss=scanner.nextLine();
		raf.write(ss.getBytes());
		System.out.println("完成操作");
		raf.close();
		
	}
}
