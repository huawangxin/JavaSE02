package day02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * ObjectOutputStream
 * ��һ���߼���
 * �����Ĺ����ҿ��Խ������Ķ���ת��Ϊ�ֽں�д��
 * ���ڶ������л�
 * @author wangxin
 *
 */
public class OOSDemo {
	public static void main(String[] args) throws IOException{
		List<String> list=new ArrayList<String>();
		list.add("��ס�ڱ���");
		list.add("����");
		list.add("������Ϣ");
		Persen persen=new Persen("���",15,'��',1000,list);
		FileOutputStream fos=new FileOutputStream("person.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		/*
		 * void writeObject(Object o)
		 * ObjectOutoputStream�ṩ�ķ���
		 * ���Խ������Ķ���ת��Ϊһ���ֽں�д��
		 */
		oos.writeObject(persen);
		System.out.println("���к����");
		oos.close();
	}
}
