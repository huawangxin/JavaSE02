package day02;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ʹ���ļ��ֽ�������������ļ�����д����
 * ע������
 * @author wangxin
 *
 */
public class FosDemo2 {
	public static void main(String[] args) throws IOException{
		//��true��Ϊ׷�Ӳ��������Ḳ��Դ�ļ����ݣ�ֻ��׷������
		/*
		 * FileOutputStream֧��һ�����صĹ��췽��
		 * FileOutputStream��String str,boolean append��
		 * �ڶ�������ָ���Ƿ����֮�Ӳ���������׷�ӣ���ǰ�ļ��е��������ݶ��ᱻ�����
		 * Ȼ������д���ݡ�Ҫע������RandomAccessFile��ͬ��
		 * дfalse�Ͳ�д������һ����
		 */
		FileOutputStream fos=new FileOutputStream("fos.dat",true);
		
		fos.write(99);
		
		fos.close();
	}
}