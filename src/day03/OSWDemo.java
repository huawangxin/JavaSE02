package day03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * OutputStreamWriter
 * �ַ�����������ַ�Ϊ��λд������
 * �ַ���ֻ���ڶ�д�ַ�����
 * @author wangxin
 *
 */
public class OSWDemo {
	public static void main(String [] args) throws IOException{
		/*
		 * ���ļ���д���ı����ݣ�д�ַ�����
		 * 1�����ļ��������ݣ�FileOutputStream��
		 * 2:д�����ı����ݣ���
		 */
		FileOutputStream fos=new FileOutputStream("osw.txt");
		/*
		 * OutputStreamWriter���ص���
		 * ���Խ��������ַ��������ض����ַ���ת�����ֽں�д��
		 * ʹ�ù��췽����
		 * outputStreamWriter(OutputStream out,String charsetName)
		 */
		OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
		//�����Ϳ���ֱ��д�ַ�����
		fos.write("���".getBytes());
		fos.write("O(��_��)O~".getBytes());
		fos.close();
		osw.close();
	}
}
