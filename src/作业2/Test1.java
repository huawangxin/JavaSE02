package ��ҵ2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * ���һ�����򣬽����ڿ���̨�����String�ַ���׷�ӵ�exam.txt�С�

�磺exam.txt ��ԭ���С��ú�ѧϰ��;���ڿ���̨���롰�������ϡ���exam.txt�򿪺���

���ú�ѧϰ�������ϡ���
 * @author wangxin
 *

��ʾ��RandomAccessFile���е�seek��Long)�������ļ�ָ���ļ�ĳ���ֽڣ�

      length����������ȡ�ļ��ֽ�����
 */
public class Test1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("test.txt", "rw");
		Scanner scanner=new Scanner(System.in);
		raf.seek(raf.length());
		String ss=scanner.nextLine();
		raf.write(ss.getBytes());
		System.out.println("��ɲ���");
		raf.close();
		
	}
}
