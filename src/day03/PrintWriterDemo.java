package day03;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * PritWriter�Ǿ����Զ���ˢ�µĻ����ַ��������
 * ���в���outputstream��writer�Ĺ�������ṩ��һ�����Դ���booleanֵ����
 * @author wangxin
 *
 */
public class PrintWriterDemo {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos=new FileOutputStream("pw.txt");
		OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
		/*
		 * ���������Զ���ˢ�µ�PritWriter��ÿ������ʹ��println����д��
		 * �ַ����󣬶����Զ�flush
		 * ��һ��Ҫ����������ɻ�����д������������д��Ч�ʡ�
		 */
		PrintWriter pw=new PrintWriter(osw,true);
		pw.print("�Ұ������찲��");
		pw.print("hh");
		pw.close();
	}
}
