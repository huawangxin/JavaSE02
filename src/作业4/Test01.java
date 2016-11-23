package 作业4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test01 {
/*
 * 从source.txt中读取出所有的姓名，
 * 并打印出重复的姓名和重复的次数，并按重复次数排序，
 * 如果次数相同按姓名字母排序.
	  source.txt内容如下：
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
		Map<String, Integer> map=new HashMap<String, Integer>();
		try {
			BufferedReader br=new BufferedReader(
					new InputStreamReader(
				new FileInputStream("demo.txt")));
			String s=null;
			String name=null;
			while((s=br.readLine())!=null){
				name=s.split(",")[1];
				if(map.containsKey(name)){
					map.put(name, map.get(name)+1);
				}else{
					map.put(name, 1);
				}
			}
			Set<Entry<String, Integer>> set=map.entrySet();
			List<Entry<String, Integer>> list=new 
					ArrayList<Entry<String,Integer>>(set);
			Collections.sort(list,new 
					Comparator<Entry<String, Integer>>() {
				public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
					int i=o1.getValue();
					int j=o2.getValue();
					if(i!=j){
						return i-j;
					}
					return o1.getKey().
							compareTo(o2.getKey());}});
			for(Entry<String, Integer> entry:list){
				String n=entry.getKey();
				Integer i=entry.getValue();
				System.out.println(n+":"+i);
			}
		} catch (IOException e) {
			e.printStackTrace();		
		}
	}
}
