package 作业1;
/**
 * 内部类
 * @author wangxin
 *
 */
public class InnerClassEmo {
	class B{//成员内部类
		int b=2;
	}
	public static class C{//静态内部类
		static int b=4;
	}
	public static void main(String[] args){
//		class A{int a;}//局部内部类，写在方法里
		System.out.println(new InnerClassEmo().new B().b);
		System.out.println(InnerClassEmo.C.b);
	}
}
