package 作业3;

import java.util.ArrayList;

public class 第二次周测 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		if(list==null){}
		if(list.isEmpty()){}
		list.add("java");
		list.add("aaa");
		list.add("java");
		list.add("java");
		list.add("bbb");
		
		for (int i = list.size() - 1; i >= 0; i--) {
			if ("java".equals(list.get(i))) {
			list.remove(i);
			}
			}
		System.out.println(list);
	}
}
