package day03;
/**
 * java�ͽ�����ԭ��
 * java�ȵ������෽����û�о��ҳ����ࡢ�ӿڣ����лᱨ�������Object
 * null���������ͣ������ǻ������͡�
 * 
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		dosome(null);
	}
	public static void dosome(int d){
		System.out.println("int");
	}
	public static void dosome(Object d){
		System.out.println("Object");
	}
	public static void dosome(ArrayList d){
		System.out.println("ArrayList");
	}
	public static void dosome(List d){
		System.out.println("List");
	}
	public static void dosome(Collection d){
		System.out.println("Collection");
	}
}
