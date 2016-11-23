package day07;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 * 使用DOM解析XML文件
 * @author wangxin
 *
 */
public class XMLDemo1 {
	public static void main(String [ ] args){
		try{
			/*
			 * 解析XML文件的基本流程
			 * 1：创建SAXReader，用来读取XML文件
			 * 2：指定xml文件是的SAXReader读取，并解析文档对象Document
			 * 3：获取根元素
			 * 4：获取每一个元素，从而达到解析的目的。
			 */
			//1
			//org.dom4j.xxxx
			SAXReader reader=new SAXReader( );
			//2
			/*
			 * 常用的读取方法
			 * Document read(InputStream in)
			 * Document read(Reader read)
			 * Document read(File file)
			 */
			File xmlFile=new File("emp.xml");
			/*
			 * read方法的作用：
			 * 读取给定的xml，并将其解析转换为一个Document对象。
			 * 实际上这里已经完成了对整个xml解析的工作。并将所有内容封装到了Document对象中
			 * Document对象可以描述当前xml文档。
			 */
			Document doc=reader.read(xmlFile);
			//3
			Element root=doc.getRootElement();
			
			/*
			 * Element element(String name)
			 * 获取单签变迁第一个名为给定名字的标签
			 * List element(String name)
			 * 获取当前标签下所有给定名字的标签
			 * List elements()
			 * 获取当前标签下的所有子标签
			 */
			List<Element> elements=root.elements("emp");
			
			/*
			 * 创建一个集合，用于保存xml中的每一个用户信息。
			 * 我们先将用户信息取出，然后创建一个emp实例，将信息设置
			 * 到该实例的响应属性上，最终将所有emp对象存入集合中
			 */
			List<Emp> list=new ArrayList<Emp>( );
			/*
			 * 遍历每一个emp标签
			 */
			for(Element emp:elements){
				//创建一个Emp对象，用于保存信息
				Emp e=new Emp( );
				
				//解析emp标签
				//获取name的值
				/*
				 * 首先，获取名为“name”的子标签
				 * 其次，获取前后标签中间的文本
				 */
				Element ename=emp.element("name");
				String name=ename.getText();
				
				//获取年龄
//				Element eage=emp.element("age");
//				String age=eage.getText();
				//获取年龄
				/*
				 * string elementText(String name)
				 * 获取当前标签中名为给定名字的子标签中间的文本
				 * 该方法于上面获取“name”的两句话等效
				 */
				
				String ageStr=emp.elementText("age");
				int age=Integer.parseInt(ageStr);
				//解析性别
				String  gender=emp.elementText("gender");
				//解析工资
				int salary=Integer.parseInt(emp.elementText("salary"));
				
				
				e.setAge(age);
				e.setName(name);
				e.setGender(gender);
				e.setSalary(salary);
				/*
				 * 通过Element获取元素属性
				 * Attribute attribute(String name)
				 * 获取当前标签中指定名字的属性
				 */
				//获取id属性
			Attribute attr=emp.attribute("id");
			//获取该属性的值
			/*
			 * Attribute表示一个属性，常用方法：
			 * String getValue()
			 * 获取该属性的值
			 * String getName()
			 * 获取该属性的名字
			 */
			int id=Integer.parseInt(attr.getValue());
			e.setId(id);
			//将Emp对象存入集合
			list.add(e);
			
			}
			
			System.out.println("解析了"+list.size()+"个员工信息");
			//输出每个员工信息
			for(Emp e:list){
				System.out.println(e);
			}
		}catch(Exception e){
			
		}
	}
}
