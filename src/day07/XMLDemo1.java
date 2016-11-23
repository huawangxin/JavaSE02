package day07;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 * ʹ��DOM����XML�ļ�
 * @author wangxin
 *
 */
public class XMLDemo1 {
	public static void main(String [ ] args){
		try{
			/*
			 * ����XML�ļ��Ļ�������
			 * 1������SAXReader��������ȡXML�ļ�
			 * 2��ָ��xml�ļ��ǵ�SAXReader��ȡ���������ĵ�����Document
			 * 3����ȡ��Ԫ��
			 * 4����ȡÿһ��Ԫ�أ��Ӷ��ﵽ������Ŀ�ġ�
			 */
			//1
			//org.dom4j.xxxx
			SAXReader reader=new SAXReader( );
			//2
			/*
			 * ���õĶ�ȡ����
			 * Document read(InputStream in)
			 * Document read(Reader read)
			 * Document read(File file)
			 */
			File xmlFile=new File("emp.xml");
			/*
			 * read���������ã�
			 * ��ȡ������xml�����������ת��Ϊһ��Document����
			 * ʵ���������Ѿ�����˶�����xml�����Ĺ����������������ݷ�װ����Document������
			 * Document�������������ǰxml�ĵ���
			 */
			Document doc=reader.read(xmlFile);
			//3
			Element root=doc.getRootElement();
			
			/*
			 * Element element(String name)
			 * ��ȡ��ǩ��Ǩ��һ����Ϊ�������ֵı�ǩ
			 * List element(String name)
			 * ��ȡ��ǰ��ǩ�����и������ֵı�ǩ
			 * List elements()
			 * ��ȡ��ǰ��ǩ�µ������ӱ�ǩ
			 */
			List<Element> elements=root.elements("emp");
			
			/*
			 * ����һ�����ϣ����ڱ���xml�е�ÿһ���û���Ϣ��
			 * �����Ƚ��û���Ϣȡ����Ȼ�󴴽�һ��empʵ��������Ϣ����
			 * ����ʵ������Ӧ�����ϣ����ս�����emp������뼯����
			 */
			List<Emp> list=new ArrayList<Emp>( );
			/*
			 * ����ÿһ��emp��ǩ
			 */
			for(Element emp:elements){
				//����һ��Emp�������ڱ�����Ϣ
				Emp e=new Emp( );
				
				//����emp��ǩ
				//��ȡname��ֵ
				/*
				 * ���ȣ���ȡ��Ϊ��name�����ӱ�ǩ
				 * ��Σ���ȡǰ���ǩ�м���ı�
				 */
				Element ename=emp.element("name");
				String name=ename.getText();
				
				//��ȡ����
//				Element eage=emp.element("age");
//				String age=eage.getText();
				//��ȡ����
				/*
				 * string elementText(String name)
				 * ��ȡ��ǰ��ǩ����Ϊ�������ֵ��ӱ�ǩ�м���ı�
				 * �÷����������ȡ��name�������仰��Ч
				 */
				
				String ageStr=emp.elementText("age");
				int age=Integer.parseInt(ageStr);
				//�����Ա�
				String  gender=emp.elementText("gender");
				//��������
				int salary=Integer.parseInt(emp.elementText("salary"));
				
				
				e.setAge(age);
				e.setName(name);
				e.setGender(gender);
				e.setSalary(salary);
				/*
				 * ͨ��Element��ȡԪ������
				 * Attribute attribute(String name)
				 * ��ȡ��ǰ��ǩ��ָ�����ֵ�����
				 */
				//��ȡid����
			Attribute attr=emp.attribute("id");
			//��ȡ�����Ե�ֵ
			/*
			 * Attribute��ʾһ�����ԣ����÷�����
			 * String getValue()
			 * ��ȡ�����Ե�ֵ
			 * String getName()
			 * ��ȡ�����Ե�����
			 */
			int id=Integer.parseInt(attr.getValue());
			e.setId(id);
			//��Emp������뼯��
			list.add(e);
			
			}
			
			System.out.println("������"+list.size()+"��Ա����Ϣ");
			//���ÿ��Ա����Ϣ
			for(Emp e:list){
				System.out.println(e);
			}
		}catch(Exception e){
			
		}
	}
}
