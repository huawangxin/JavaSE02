package ��ҵ2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ���Զ��建�����ķ�ʽʵ���ļ����ƶ�
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
		System.out.println("�ƶ����");
		fis.close();
		fos.close();
	}
	
}
