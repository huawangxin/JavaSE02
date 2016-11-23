package 作业3;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class countTxt {
	public static void main(String[] args) {
		String file="神级系统.txt";
		Map<Character,Integer> map = count(file);
		System.out.println("文本中各个文字的个数："+map);
		System.out.println("文本中有多少不同的汉字："+ map.size());
		List<Entry<Character,Integer>> list = new ArrayList<Entry<Character,Integer>>();
		list.addAll(map.entrySet());
		Collections.sort(list,new Comparator<Entry<Character,Integer>>() {
			public int compare(Entry<Character, Integer> o1,
					Entry<Character, Integer> o2) {
				return o2.getValue()-o1.getValue();
			}
		});
		for(int i=0;i<10;i++){
			System.out.println(list.get(i));
		}
		int sum = 0;
		Iterator<Entry<Character, Integer>> it = list.iterator();
		while(it.hasNext()){
			sum = sum+it.next().getValue();
		}
		System.out.println("文件的总字数："+sum);
	}
    public static Map<Character,Integer> count(String file){
    	try{
    		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    		InputStreamReader in = new InputStreamReader(new FileInputStream(file),"GBK");
    		int ch;
    		while((ch = in.read())!=-1){
    			char c = (char)ch;
    			String str = c+"";
    			if(str.matches("[\u4e00-\u9fa5]")){
    				Integer n = map.get(c);
    				map.put(c, n==null?1:n+1);
    			}
    		}
    		in.close();
    		return map;
    	}catch(IOException e){
    		e.printStackTrace();
    	}
		return null;
    }
}

