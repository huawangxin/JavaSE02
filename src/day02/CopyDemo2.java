package day02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * ʹ�û������ӿ��дЧ��
 * @author wangxin
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws Exception{
		FileInputStream fis=new FileInputStream("test.txt");
		BufferedInputStream bis=new BufferedInputStream(fis);
		FileOutputStream fos=new FileOutputStream("copy3.txt");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		int d=-1;
		while((d=fis.read())!=-1){
			fos.write(d);
		}
		System.out.println("�������");
		/*
		 * �ر���ʱ��ֻ�ر������ĸ߼���
		 */
		fis.close();
		fos.close();

	}
}
