package day02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * ObjectInputStream
 * 是一个高级流
 * 该流的作用是一个可以将一组字节转换为对应的对象用于对象的反序列化
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
