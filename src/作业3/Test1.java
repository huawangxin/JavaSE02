package ��ҵ3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * ˼·��
 * ����ʹ�û����ַ������ж�ȡÿһ�е��ַ���
 * Ȼ������ƴ������
 * ������ļ���׷��д���������ַ���д��
 * 
 * ��ҵ��һ��
 * ��Һã�
    hello��
    bye��
��Һã�    hello��    bye��
 * @author wangxin
 *�ļ�ĩβ������һ�У�����Ϊÿ��������Ϣ�ۼ�֮��
 */
public class Test1 {
	public static void main(String[] args) {
		try {
			/*
			 * ʹ��bufferedReader��PrintWriter
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
			 * ׷��д��������Ҫʹ��FileOutputStream
			 * ���췽��FileOutputStream(string a,boolean append);
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
