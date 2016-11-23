package day06.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 服务端
 * @author wangxin
 *
 */
public class Server {
	private DatagramSocket socket;
	/*
	 * 服务端的启动
	 */
	public void start(){
		try {
			socket = new DatagramSocket(8088);
			byte[] data=new byte[100];
			DatagramPacket recvPacket=new 
			    DatagramPacket(data, data.length);
			//接收数据到包中
			//注意该方法是个阻塞方法
			socket.receive(recvPacket);
			//拆包拿数据
			byte[] d=recvPacket.getData();
			//有效数据长度
			int dlen=recvPacket.getLength();
			/*
			 * String(byte[] b,int offset,int len,
			 * String caarserName)
			 * 
			 * 将给定的字节数组中，从offset处
			 * 开始连续len个字节，再根据给定的字符串转换为字符串
			 */
			String info=new String(d,0,dlen,"UTF-8");
			System.out.println("客户端说："+info);
			
			int port=recvPacket.getPort();
			InetAddress addr=recvPacket.getAddress();
			String sendStr="hello,欢迎来到英雄联盟";
			byte[] sendBuf=sendStr.getBytes();
			DatagramPacket sendPacket=new DatagramPacket
					(sendBuf, sendBuf.length,addr,port);
			socket.send(sendPacket);
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String [] args){
		Server server=new Server();
		server.start();
	}
}
