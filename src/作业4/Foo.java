package ��ҵ4;

import java.util.ArrayList;
import java.util.List;

/*
 * ��֪��Foo�������£����������Ʋ����ʵ���
 * ʹ��synchroinzed��Ҫ��һ�����������Ա�֤�߳�ͬ����
 * ��ô����������ѡ��Ӧ��ע��:
 * 1�������Ҫͬ�����߳��ڷ��ʸ�ͬ����ʱ��
 * ������Ӧ����ͬһ�����������ã�����ﲻ��ͬ��Ч����
 * 2�� ��ʹ��ͬ����ʱ��Ӧ�����������������¼���ͬ����Χ��
 * ����߲�����ִ��Ч�ʡ�
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