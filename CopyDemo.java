package day03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * ????¡Á?¡¤??¡Â??????¡À?????
 * @author wangxin
 *
 */
public class CopyDemo {
	public static void main(String [] args){
		try {
			FileInputStream fis=new FileInputStream("./src/day03/CopyDemo.java");
			InputStreamReader isr=new InputStreamReader(fis);
			FileOutputStream fos=new FileOutputStream("CopyDemo.java");
			OutputStreamWriter osw=new OutputStreamWriter(fos);
			int d=-1;
			while((d=fis.read())!=-1){
				osw.write(d);
			}
			System.out.println("?????¨º¡À?");
			osw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
