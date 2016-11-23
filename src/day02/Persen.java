package day02;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.List;
/*
 * һ����������ͨ��ObjectOutputStream�������л�����ô�ö��������������
 * ʵ��Serializable�ӿ�
 * �ýӿ�û�ж����κγ��󷽷���ʵ�ָýӿ�
 * �������ڱ�ʶ��ǰ���ʵ�����Ա����л�
 */
public class Persen implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * ������������ӻ��޸��ˣ����汾�Ų���
	 * ��ô�����л�ʱ�ᾡ���ܼ������а汾
	 * ���汾�ŷ����˸ı䣬��ô�����л�ʱ���׳��쳣
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
//		Persen p=new Persen("���",15,'��',10000,null);
//		RandomAccessFile raf=new RandomAccessFile("person.obj","rw");
//		/*
//		 * д�ַ�����Ӳ���У�Ҫ����������
//		 * 1�����ַ���ת����һ���ֽ�
//		 * 2����һ���ֽ�д��Ӳ�������ñ���
//		 * 
//		 * 1:��һ���ض������ݽṹת��Ϊһ��һ���ֽڵĹ��̣���֮Ϊ���л�
//		 * 2��������д��Ӳ�������ñ���Ĺ��̳�֮Ϊ���־û�
//		 * 
//		 * ���л��뷴���л�һ�����ڣ�1�����䣻2������
//		 */
//		raf.writeInt(123);
//		raf.write("���".getBytes());
//		raf.close();
//	}
}
