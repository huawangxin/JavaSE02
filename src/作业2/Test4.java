package 作业2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 用缓冲流的方式实现文件的移动
 * @author wangxin
 *
 */
public class Test4 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("fis.dat");
		//创建缓冲字节输入流
		BufferedInputStream bis=new BufferedInputStream(fis);
		FileOutputStream fos=new FileOutputStream("fos.dat");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		int d=-1;
		while((d=bis.read())!=-1){
			bos.write(d);
		}
		System.out.println("移动完毕");
		fos.close();
		fis.close();
	}
}
