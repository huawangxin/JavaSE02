package day07;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;



/**
 * ʹ��DOMд��һ��XML
 * @author wangxin
 */
public class XMLDemo2 {
	public static void main(String[] args) {
		List<Emp> list=new ArrayList<Emp>();
		list.add(new Emp(1, "jack", 33, "��", 5000));
		list.add(new Emp(2, "boss",55, "��", 8000));
		list.add(new Emp(3, "marry", 22, "Ů", 7000));
		list.add(new Emp(4, "kate", 30, "Ů", 10000));
		list.add(new Emp(5, "tom", 23, "��", 12000));
		/*
		 * ����һ��xml�Ļ�������
		 * 1�������ĵ�����Document
		 * 2��ΪDocument��Ӹ��ڵ�
		 * 3��Ϊ���ڵ������״�ṹ
		 * 4������xmlWiter
		 * 5��ΪxmlWriterָ��д��Ŀ��
		 * 6��д��xml
		 */
		//1
		//ͨ��DocumentHelper����Document����
		Document doc=DocumentHelper.createDocument();
		//2
		/*
		 * Document�ķ���
		 * Element addElement(String  name)
		 * �÷����������ĵ�����Ӹ������ֵĸ�Ԫ�أ�
		 * ���ص�Elementʵ���ͱ�ʾ�ø�Ԫ��
		 * ��Ҫע����ǣ��÷���ֻ�ܵ���һ�Σ�
		 * ���õڶ��λ��׳��쳣
		 */
		Element root=doc.addElement("list");
		/*
		 * ѭ�����ÿһ��Ա����Ϣ
		 */
		for(Emp e: list){
			/*
			 * Elementͬ��֧�ַ�����
			 * Element addElemnet(String name)
			 * ��ǰ��ǩ����Ӹ������ֵ��ӱ�ǩ
			 */
			Element emp=root.addElement("emp");
			//��emp��ǩ������ӱ�ǩname
			Element  name=emp.addElement("name");
			name.addText(e.getName());
			//��emp��ǩ������ӱ�ǩage
			emp.addElement("age").addText(e.getAge()+"");
			emp.addElement("gender").addText(e.getGender()+"");
			emp.addElement("salary").addText(e.getSalary()+"");
			/*
			 * Ϊ��ǩ�������
			 * Element addAttribute(String name,String value)
			 * Ϊ��ǰ��ǩ��Ӹ��������Լ���Ӧֵ������
			 * ����ֵ��ȻΪ��ǰ��ǩ
			 * ��������Ŀ���ǿ������������������ �ͺ���
			 * StringBuilder��append�ķ���ֵЧ�������á�
			 */
			emp.addAttribute("id", e.getId()+"");
			
			
		}
		/*
		 * ���˳�ѭ����n��ôDocument�еĽṹ���Ѿ���������
		 * ��Ҫ����д��xml
		 */
		try{
			XMLWriter writer=new XMLWriter( );
			FileOutputStream out=new FileOutputStream("myemp.xml");
			writer.setOutputStream(out);
			
			/*
			 * ��Document����д��Ҫ�ļ���
			 * ��ʱ�ὫDocumentת��Ϊxml��ʽд���ļ�
			 */
			writer.write(doc);
			writer.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
