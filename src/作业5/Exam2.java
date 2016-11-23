package 作业5;

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
	 * 创建一个文件来记录学生的分数：scores.txt,内容如下：
		张三,60,70,80
		李四,70,60,50
		王五,71,72,73
		赵六,80,90,100
		田七,80,80,80
		
		完成一个程序，读取这个文件的内容，计算并输出内容到result.txt，该文件内容如下：
		班级总人数：
		班级平均分数：
		去掉一个最高分，一个最低分平均分数：
		第一科平均分：
		第二科平均分：
		第三科平均分：
		最高分学生：
		最低分学生：

	 */
	public static void main(String[] args) {
		String s = null;
		List<Student> stus = new ArrayList<Student>();
		double allScore = 0;//所有学员总成绩
		double first = 0;//第一科总成绩
		double second = 0;//第二科总成绩
		double third = 0;//第三科总成绩
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("scores.txt"),"GBK"));
			PrintWriter out = new PrintWriter("result.txt","gbk");
			while ((s=in.readLine())!=null) {
				String[] ss = s.split(",");
				//DOuble.parseDouble():将字符串转换为Double
				Student stu = new Student(ss[0],Double.parseDouble(ss[1]),Double.parseDouble(ss[2]),Double.parseDouble(ss[3]));
				stus.add(stu);
			}

			out.println(" 班级总人数："+stus.size());

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
			out.println("去掉一个最高分，一个最低分平均分数："+cj);
			out.println("第一科平均成绩："+first/stus.size());
			out.println("第二科平均成绩："+second/stus.size());
			out.println("第三科平均成绩："+third/stus.size());
			out.println("最高分学生："+best);
			out.println("最低分学生："+last);
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 *  班级总人数：5
去掉一个最高分，一个最低分平均分数：225.16666666666666
第一科平均成绩：73.5
第二科平均成绩：74.6
第三科平均成绩：77.0
最高分学生：[赵六:80.0,90.0,100.0]
最低分学生：[李四:70.0,60.0,50.0]
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
	 * 学员总成绩
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
