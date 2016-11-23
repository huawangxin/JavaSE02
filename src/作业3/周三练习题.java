package 作业3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 例题：统计一片文章 要求如下：

1）：统计出一片文章中出现过多少个不同的汉字

2）：统计文件中每个汉子出现的次数

3）：列出字数排名前10的汉字

4）：文章的所有汉字的总个数

提示：判断是否为汉字的正则表达式为“[\u4e00-\u9fa5]”
 * @author wangxin
 *
 */
public class 周三练习题 {
	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("神级系统.txt");
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			String str=br.readLine();
			str=str.replaceAll("^[\u4e00-\u9fa5]+","");
			Map<Character,Integer> map=new HashMap<Character,Integer>();
			for(int i=0;i<str.length();i++){
				char c=str.charAt(i);
				if(map.containsKey(c)){
					map.put(c, map.get(c)+1);
				}else {
					map.put(c, 1);
				}
			}
			System.out.println("各字符数量： "+map);
		} catch (FileNotFoundException e) {
			System.out.println("文件读取失败");			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
