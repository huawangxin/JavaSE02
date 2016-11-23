package ื๗าต1;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Test5 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("hh.txt", "r");
		raf.skipBytes(8);
		byte[] buf=new byte[7];
		raf.read(buf);
		System.out.println(new String(buf));
		raf.close();
	}
}
