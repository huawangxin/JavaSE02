package 作业1;

import java.io.File;

public class Test {
	/*
	 *给定一个File对象，然后将其删除 
	 */
	public static void main(String args[]) {
		File file=new File("aa");
		new Test().deleteFile(file);
	}
	public static void deleteFile(File file){
		if(file.isDirectory()){
			//如果是目录，还要看是否有子项
			File[] subs=file.listFiles();
			//先删除所有子项
			for(File sub:subs){
				deleteFile(sub);
			}
		}
		file.delete();
	}
}
