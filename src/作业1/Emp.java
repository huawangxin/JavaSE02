package ��ҵ1;


public class Emp {
	String name1;
	private String name;
	private char gender;
	int  age;
	private int salary;
	static String cname="����";
	//��̬�����----���غ�ֻ����һ��
	//����������ж��
	static{
		System.out.println("cname:"+cname);
	}
	public Emp() {
		System.out.println("name:"+name);
	}
	public Emp(String name){
		this.name=name;
	}
	public Emp(String string, int j) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Emp:"+name;
	}
	@Override
	public boolean equals(Object o) {
		if(o==null){
			return false;
		}
		if(o==this){
			return true;
		}
		if(o instanceof Emp){
			Emp e=(Emp)o;
			return e.name==this.name;
		}
		return false;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
