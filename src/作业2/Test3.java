package 作业2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 用自定义缓存区的方式实现文件的移动
 * @author wangxin
 *
 */
public class Test3 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("abc.dat");
		FileOutputStream fos=new FileOutputStream("abccopy.dat");
		int d=-1;
		byte[] b=new byte[32];
		while((d=fis.read(b))!=-1){
			fos.write(b,0,d);
		}
		System.out.println("移动完毕");
		fis.close();
		fos.close();
	}
	
}
