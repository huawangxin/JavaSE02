package 作业1;
/**
 * 
 * @author wangxin
 *
 */
public class Test递归 {
	public static void main(String[] args) {
		System.out.println(add(100));
	}
	/*
	 * 使用当前的数字累加之前的每一个数字
	 * 知道1为止
	 * 递归：
	 * 1：首先考虑极端情况，什么时候停止
	 * 2：每一种可能发生的情况是否都考虑了
	 * 3：方法内部遇到重复干这件事，调用该方法即可（这里就是递归调用）
	 * @param n
	 */
	public static int add(int n){
		if(n==1){
			return 1;
		}else {
			return add(n-1);
		}
	}
}
