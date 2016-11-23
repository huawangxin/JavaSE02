package 作业1;
/**
 * 输出一个目录中左右拓展名为.txt的文件
 * 注意后缀名区分大小写
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
