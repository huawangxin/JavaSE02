package ��ҵ1;

import java.io.File;

public class Test {
	/*
	 *����һ��File����Ȼ����ɾ�� 
	 */
	public static void main(String args[]) {
		File file=new File("aa");
		new Test().deleteFile(file);
	}
	public static void deleteFile(File file){
		if(file.isDirectory()){
			//�����Ŀ¼����Ҫ���Ƿ�������
			File[] subs=file.listFiles();
			//��ɾ����������
			for(File sub:subs){
				deleteFile(sub);
			}
		}
		file.delete();
	}
}
