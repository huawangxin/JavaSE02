package ��ҵ2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �û������ķ�ʽʵ���ļ����ƶ�
 * @author wangxin
 *
 */
public class Test4 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("fis.dat");
		//���������ֽ�������
		BufferedInputStream bis=new BufferedInputStream(fis);
		FileOutputStream fos=new FileOutputStream("fos.dat");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		int d=-1;
		while((d=bis.read())!=-1){
			bos.write(d);
		}
		System.out.println("�ƶ����");
		fos.close();
		fis.close();
	}
}
