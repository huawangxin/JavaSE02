package 作业1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InnerClassEmo2 {
	/*
	 * 匿名内部类
	 */
	public static void main(String[] args) {
		List<Emp> emps=new ArrayList<Emp>();
		emps.add(new Emp("zs",12));
		emps.add(new Emp("ls",14));
		emps.add(new Emp("ww",11));
		//Collections.sort(emps,new DD());
		Collections.sort(emps,new Comparator<Emp>() {
			public int compare(Emp o1, Emp o2) {
				return o1.age-o2.age;
			}
		});
		System.out.println(emps);
	}
}
class DD implements Comparator<Emp>{

	@Override
	public int compare(Emp o1, Emp o2) {
		return o1.age-o2.age;
	}
	
}