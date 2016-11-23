package 作业5;

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
	 * 从source.txt中读取出所有的姓名，并打印出重复的姓名和重复的次数，并按重复次数排序，如果次数相同按姓名字母排序.
	 * source.txt内容如下：
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
		//  key:姓名   value:重复次数
		Map<String ,Integer> map = new HashMap<String, Integer>();
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("source.txt")));
			while((s = br.readLine())!=null){
				//截取“8,tianqi,35”中的“tianqi”
				name = s.split(",")[1];
				if(map.containsKey(name)){
					map.put(name, map.get(name)+1);
				}else{
					map.put(name, 1);
				}
				
			}
			//将map转换为set，再转换为List，其中每一个元素为Entry
			List<Entry<String ,Integer>> list = new ArrayList<Entry<String ,Integer>>(map.entrySet());
			Collections.sort(list,new Comparator<Entry<String ,Integer>>() {
				@Override
				public int compare(Entry<String ,Integer> o1, Entry<String ,Integer> o2) {
					//如果重复次数不相等，将比较结果返回
					if(o1.getValue()!=o2.getValue()){
						return o1.getValue()-o2.getValue();
					}
					//如果重复次数相等，继续比较字符串（默认按照字母排序）
					return o1.getKey().compareTo(o2.getKey());
				}
			});
			//迭代输出
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
