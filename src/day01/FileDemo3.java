package day01;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * 创建多级目录下的一个文件
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
		 * 创建文件时应首先判断当前文件所在目录是否存在,
		 * 若不存在，会抛出异常。
		 */
		/*
		 * File  getParentFile()
		 * 获取当前文件或目录的父目录
		 */
//		File parent=file.getParentFile();
//		if(!parent.exists()){
//			parent.mkdirs();
//		}
//		if (!file.exists()) {
//			file.createNewFile();
//			System.out.println("文件创建完毕");
//		}
		File dir=new File("a");
		FileUtils.deleteDirectory(dir);
		System.out.println("已删除");
	}
}
