package day02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * ObjectInputStream
 * ��һ���߼���
 * ������������һ�����Խ�һ���ֽ�ת��Ϊ��Ӧ�Ķ������ڶ���ķ����л�
 * @author wangxin
 *
 */
public class ISDemo {
	public static void main(String[] args) throws IOException, Exception {
		FileInputStream fis=new FileInputStream("person.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Persen p=(Persen)ois.readObject();
		System.out.println(p);
		ois.close();
	}
}
