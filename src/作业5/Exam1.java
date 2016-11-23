package ��ҵ5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Exam1 {

	/**
	 * ��source.txt�ж�ȡ�����е�����������ӡ���ظ����������ظ��Ĵ����������ظ������������������ͬ��������ĸ����.
	 * source.txt�������£�
		1,zhangsan,28
		2,lisi,35
		3,zhangsan,28
		4,wangwu,35
		5,zhangsan,28
		6,lisi,35
		7,zhaoliu,28
		8,tianqi,35

	 */
	public static void main(String[] args) {
		String s = null;
		String name = null;
		//  key:����   value:�ظ�����
		Map<String ,Integer> map = new HashMap<String, Integer>();
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("source.txt")));
			while((s = br.readLine())!=null){
				//��ȡ��8,tianqi,35���еġ�tianqi��
				name = s.split(",")[1];
				if(map.containsKey(name)){
					map.put(name, map.get(name)+1);
				}else{
					map.put(name, 1);
				}
				
			}
			//��mapת��Ϊset����ת��ΪList������ÿһ��Ԫ��ΪEntry
			List<Entry<String ,Integer>> list = new ArrayList<Entry<String ,Integer>>(map.entrySet());
			Collections.sort(list,new Comparator<Entry<String ,Integer>>() {
				@Override
				public int compare(Entry<String ,Integer> o1, Entry<String ,Integer> o2) {
					//����ظ���������ȣ����ȽϽ������
					if(o1.getValue()!=o2.getValue()){
						return o1.getValue()-o2.getValue();
					}
					//����ظ�������ȣ������Ƚ��ַ�����Ĭ�ϰ�����ĸ����
					return o1.getKey().compareTo(o2.getKey());
				}
			});
			//�������
			for (Entry<String, Integer> entry : list) {
				System.out.println(entry.getKey()+":"+entry.getValue());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
