package 作业2;

import java.io.Serializable;

/**
 * 实现emplist的序列化与反序列化
 * @author wangxin
 *
 */
public class Test51 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	private double salary;
	public Test51(String name, int age, String gender, double salary) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Test51 [name=" + name + ", age=" + age + ", gender=" + gender
				+ ", salary=" + salary + "]";
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public  int hashCode(){
		final int prime=31;
		int result=1;
		result=prime*result+((name==null)?0:name.hashCode());
		return result;
	}
	
}
