package ��ҵ2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import ��ҵ1.Emp;

public class Test52 {
	public static void main(String[] args) throws Exception{
		new Test52().gg();
		new Test52().hh();
	}
	public void hh() throws Exception{
		FileInputStream fis=new FileInputStream("emplist.obj");
		ObjectInputStream ois=new ObjectInputStream(fis);
		List emps=(List)ois.readObject();
		System.out.println("���������");
		System.out.println(emps);
		ois.close();
	}
	public void gg() throws Exception{
		FileOutputStream fos=new FileOutputStream("emplist.obj");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		List<Test51> emps=new ArrayList<Test51>();
		emps.add(new Test51("����",33,"��",9000));
		emps.add(new Test51("df",33,"��",9000));
		emps.add(new Test51("dfg",33,"��",9000));
		emps.add(new Test51("dfgsdf",33,"��",9000));
		oos.writeObject(emps);
		System.out.println("���л����");
		oos.close();
	}
}
