package day02;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.List;
/*
 * 一个对象若想通过ObjectOutputStream进行序列化，那么该对象所属的类必须
 * 实现Serializable接口
 * 该接口没有定义任何抽象方法，实现该接口
 * 仅仅用于标识当前类的实例可以被序列化
 */
public class Persen implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 当类的属性增加或修改了，若版本号不变
	 * 那么反序列化时会尽可能兼容现有版本
	 * 若版本号发生了改变，那么反序列化时会抛出异常
	 */
	private String name;
	private int age;
	private char gender;
	private transient double salary;
	private List<String> otherInfo;
	
	public String toString(){
		return name+","+age+","+gender+","+salary+","+otherInfo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gener) {
		this.gender = gener;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<String> getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}

	public Persen(String name, int age, char gender, double salary,
			List<String> otherInfo) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.otherInfo = otherInfo;
	}

	
	
//	public static void main(String[] args) throws IOException {
//		Persen p=new Persen("李白",15,'男',10000,null);
//		RandomAccessFile raf=new RandomAccessFile("person.obj","rw");
//		/*
//		 * 写字符串到硬盘中，要经历两件事
//		 * 1：将字符串转换成一组字节
//		 * 2：将一组字节写入硬盘做长久保存
//		 * 
//		 * 1:将一个特定的数据结构转换为一个一组字节的过程，称之为序列化
//		 * 2：将数据写入硬盘做长久保存的过程称之为：持久化
//		 * 
//		 * 序列化与反序列化一半用于：1：传输；2，保存
//		 */
//		raf.writeInt(123);
//		raf.write("你好".getBytes());
//		raf.close();
//	}
}
