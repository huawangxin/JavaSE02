package day02;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件字节输出流对已有文件进行写操作
 * 注意事项
 * @author wangxin
 *
 */
public class FosDemo2 {
	public static void main(String[] args) throws IOException{
		//有true则为追加操作，不会覆盖源文件内容，只是追加内容
		/*
		 * FileOutputStream支持一个重载的构造方法
		 * FileOutputStream（String str,boolean append）
		 * 第二个参数指定是否进行之加操作，若不追加，当前文件中的所有内容都会被清除。
		 * 然后重新写数据。要注意这点和RandomAccessFile不同。
		 * 写false和不写的作用一样。
		 */
		FileOutputStream fos=new FileOutputStream("fos.dat",true);
		
		fos.write(99);
		
		fos.close();
	}
}