package day02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * ObjectOutputStream
 * 是一个高级流
 * 该流的功能室可以讲给定的对象转换为字节后写出
 * 用于对象序列化
 * @author wangxin
 *
 */
public class OOSDemo {
	public static void main(String[] args) throws IOException{
		List<String> list=new ArrayList<String>();
		list.add("家住在北京");
		list.add("汉族");
		list.add("其他信息");
		Persen persen=new Persen("李白",15,'男',1000,list);
		FileOutputStream fos=new FileOutputStream("person.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		/*
		 * void writeObject(Object o)
		 * ObjectOutoputStream提供的方法
		 * 可以讲给定的对象转换为一组字节后写出
		 */
		oos.writeObject(persen);
		System.out.println("序列号完毕");
		oos.close();
	}
}
