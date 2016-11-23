package day03;
/**
 * java就近调用原则
 * java先调用子类方法，没有就找抽象类、接口（都有会报错），最后Object
 * null是引用类型，不考虑基本类型。
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
