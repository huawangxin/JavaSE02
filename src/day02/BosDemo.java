package day02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * 缓冲输出流写出数据的注意事项
 * @author wangxin
 *
 */
public class BosDemo {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos=new FileOutputStream("hh.jpg");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		String str="伟大领袖毛主席";
		byte[] buf=str.getBytes("UTF-8");
		bos.write(buf);
		bos.flush();
		bos.close();
		/*
		 * flush强制将当前缓冲流中的缓冲区的数据全部写出，无论缓冲区是否被装满
		 * close时，也会自动调用一次flush
		 */
	}
}
