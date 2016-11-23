package ��ҵ3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * ���⣺ͳ��һƬ���� Ҫ�����£�

1����ͳ�Ƴ�һƬ�����г��ֹ����ٸ���ͬ�ĺ���

2����ͳ���ļ���ÿ�����ӳ��ֵĴ���

3�����г���������ǰ10�ĺ���

4�������µ����к��ֵ��ܸ���

��ʾ���ж��Ƿ�Ϊ���ֵ�������ʽΪ��[\u4e00-\u9fa5]��
 * @author wangxin
 *
 */
public class ������ϰ�� {
	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("��ϵͳ.txt");
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
			System.out.println("���ַ������� "+map);
		} catch (FileNotFoundException e) {
			System.out.println("�ļ���ȡʧ��");			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
