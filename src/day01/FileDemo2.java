package day01;

import java.io.File;
import java.io.FileFilter;

/**
 * listFiles����֧���ļ�������
 * FileFilter�ӿ�
 * ʵ�ָýӿ���Ҫʵ�ֳ��󷽷���
 *  boolean accept(File f)
 *  �÷�����Ҫ���Ƕ����������
 *  
 *  listFiles�����Ὣ��ǰĿ¼������accept�����������
 * @author wangxin
 *
 */
public class FileDemo2 {
	public static void main(String[] args) {
		File dir=new File(".");
		if(dir.isDirectory()){
			//����������ʵ��
			FileFilter filter=new MyFilter();
			//ʹ�ù���������
			File[] subs=dir.listFiles(filter);
			for(File sub:subs){
				System.out.println(sub.getName());
			}
		}
	}
}
class MyFilter implements FileFilter{
	public boolean accept(File file) {
		System.out.println("���ڹ���");
		return file.getName().startsWith(".");
	}
	
}