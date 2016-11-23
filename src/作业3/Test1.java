package 作业3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 思路：
 * 首先使用缓冲字符流按行读取每一行的字符串
 * 然后将他们拼接起来
 * 最后在文件中追加写操作，将字符串写出
 * 
 * 作业第一题
 * 大家好！
    hello！
    bye！
大家好！    hello！    bye！
 * @author wangxin
 *文件末尾最后多了一行，内容为每行数据信息累加之和
 */
public class Test1 {
	public static void main(String[] args) {
		try {
			/*
			 * 使用bufferedReader和PrintWriter
			 */
			FileInputStream fis=new FileInputStream("pw.txt");
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			String str=null;
			StringBuilder builder=new StringBuilder();
			while((str=br.readLine())!=null){
				builder.append(str);
			}
			str=builder.toString();
			/*
			 * 追加写操作，需要使用FileOutputStream
			 * 构造方法FileOutputStream(string a,boolean append);
			 */
			String line="";
			String all="";
			while((line=br.readLine())!=null){
				all+=line;
				System.out.println(line);
			}
			FileOutputStream os=new FileOutputStream("pw.txt",true);
			PrintWriter pw=new PrintWriter(os,true);
			System.out.println(all);
			pw.println();
			pw.println(all);
			br.close();
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
