package day02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ʹ���ļ����ֽ����������ʵ���ļ��ĸ���
 * @author wangxin
 *
 */
public class CopyDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("src.jpg");
		FileOutputStream fos=new FileOutputStream("copy1.jpg");
		byte[] buf=new byte[10240];
		int len=-1;
		while((len=fis.read())!=-1){
			fos.write(buf,0,len);
		}
		System.out.println("�������");
		fis.close();
		fos.close();
	}
}
