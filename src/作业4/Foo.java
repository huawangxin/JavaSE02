package 作业4;

import java.util.ArrayList;
import java.util.List;

/*
 * 已知类Foo代码如下，下列锁机制不合适的是
 * 使用synchroinzed需要对一个对象上锁以保证线程同步，
 * 那么这个锁对象的选择应该注意:
 * 1）多个需要同步的线程在访问该同步块时，
 * 看到的应该是同一个锁对象引用，否则达不到同步效果。
 * 2） 在使用同步块时，应当尽量在允许的情况下减少同步范围，
 * 以提高并发的执行效率。
 */
class Foo {
	private List list1 = new ArrayList();
	private List list2 = new ArrayList();
	public void add_1(Object obj) {
		synchronized (list1) {
			list1.add(obj);
		}
	}
	public void remove(Object obj) {
		synchronized (list1) {
			list1.remove(obj);
		}
	}
	public void add_2(Object obj) {
		synchronized (list2) {
			list2.add(obj);
		}
	}
}