package ��ҵ5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Exam2 {

	/**
	 * ����һ���ļ�����¼ѧ���ķ�����scores.txt,�������£�
		����,60,70,80
		����,70,60,50
		����,71,72,73
		����,80,90,100
		����,80,80,80
		
		���һ�����򣬶�ȡ����ļ������ݣ����㲢������ݵ�result.txt�����ļ��������£�
		�༶��������
		�༶ƽ��������
		ȥ��һ����߷֣�һ����ͷ�ƽ��������
		��һ��ƽ���֣�
		�ڶ���ƽ���֣�
		������ƽ���֣�
		��߷�ѧ����
		��ͷ�ѧ����

	 */
	public static void main(String[] args) {
		String s = null;
		List<Student> stus = new ArrayList<Student>();
		double allScore = 0;//����ѧԱ�ܳɼ�
		double first = 0;//��һ���ܳɼ�
		double second = 0;//�ڶ����ܳɼ�
		double third = 0;//�������ܳɼ�
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("scores.txt"),"GBK"));
			PrintWriter out = new PrintWriter("result.txt","gbk");
			while ((s=in.readLine())!=null) {
				String[] ss = s.split(",");
				//DOuble.parseDouble():���ַ���ת��ΪDouble
				Student stu = new Student(ss[0],Double.parseDouble(ss[1]),Double.parseDouble(ss[2]),Double.parseDouble(ss[3]));
				stus.add(stu);
			}

			out.println(" �༶��������"+stus.size());

			for (Student stu : stus) {
				allScore += stu.getSum();
				first += stu.getFirst();
				second += stu.getSecond();
				third += stu.getThird();
			}
			Collections.sort(stus,new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return Double.compare(o2.getSum(), o1.getSum());
				}
			});
			Student best = stus.get(0);
			Student last = stus.get(stus.size()-1);
			double cj = allScore-best.getSum()-last.getSum();
			cj/=(stus.size()-2);
			out.println("ȥ��һ����߷֣�һ����ͷ�ƽ��������"+cj);
			out.println("��һ��ƽ���ɼ���"+first/stus.size());
			out.println("�ڶ���ƽ���ɼ���"+second/stus.size());
			out.println("������ƽ���ɼ���"+third/stus.size());
			out.println("��߷�ѧ����"+best);
			out.println("��ͷ�ѧ����"+last);
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 *  �༶��������5
ȥ��һ����߷֣�һ����ͷ�ƽ��������225.16666666666666
��һ��ƽ���ɼ���73.5
�ڶ���ƽ���ɼ���74.6
������ƽ���ɼ���77.0
��߷�ѧ����[����:80.0,90.0,100.0]
��ͷ�ѧ����[����:70.0,60.0,50.0]
 */
}
class Student {
	String name;
	double first;
	double second;
	double third;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFirst() {
		return first;
	}
	public Student() {
	}
	public Student(String name, double first, double second, double third) {
		super();
		this.name = name;
		this.first = first;
		this.second = second;
		this.third = third;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public double getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public double getThird() {
		return third;
	}
	public void setThird(int third) {
		this.third = third;
	}
	/**
	 * ѧԱ�ܳɼ�
	 * @return
	 */
	public double getSum(){
		return first+second+third;
	}
	@Override
	public String toString() {
		return "["+name+":"+first+","+second+","+third+"]";
	}
}
