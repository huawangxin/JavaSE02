package day01;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * �����༶Ŀ¼�µ�һ���ļ�
 * 
 */
public class FileDemo3 {
	public static void main(String []args) throws IOException{
		
		File file=new File("a"+File.separator
				+"b"+File.separator
				+"c"+File.separator
				+"d"+File.separator
				+"e"+File.separator
				+"f"+File.separator
				+"g"+File.separator
				+"h.txt");
		/*
		 * �����ļ�ʱӦ�����жϵ�ǰ�ļ�����Ŀ¼�Ƿ����,
		 * �������ڣ����׳��쳣��
		 */
		/*
		 * File  getParentFile()
		 * ��ȡ��ǰ�ļ���Ŀ¼�ĸ�Ŀ¼
		 */
//		File parent=file.getParentFile();
//		if(!parent.exists()){
//			parent.mkdirs();
//		}
//		if (!file.exists()) {
//			file.createNewFile();
//			System.out.println("�ļ��������");
//		}
		File dir=new File("a");
		FileUtils.deleteDirectory(dir);
		System.out.println("��ɾ��");
	}
}
