package ��ҵ1;
/**
 * ���һ��Ŀ¼��������չ��Ϊ.txt���ļ�
 * ע���׺�����ִ�Сд
 */
import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

public class Test1 {
	public static void main(String []args){
		File file=new File(".");
		Collection<File> files=FileUtils.listFiles(file, new String[]{"jar","txt"}, true);
		for(File f:files){
			System.out.println(f);
		}
	}
}
