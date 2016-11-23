package day06.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * 客户端
 */
public class Client {
	private DatagramSocket socket;
	/*
	 * 客户端的启动
	 */
	public void start(){
		try{
			socket = new DatagramSocket();
			String str="你好！服务端！";
			byte[] data=str.getBytes("UTF-8");
			//打包：准备包裹，填写地址，装入数据
			InetAddress address=
					InetAddress.getByName("192.168.0.80");
			int port=8088;
			//创建发送包
			DatagramPacket sendPacket=new 
			DatagramPacket(data,data.length,address,port);
			//将其发送出去
			socket.send(sendPacket);
			byte[] recvBuf=new byte[100];
			DatagramPacket recvPacket=new 
				DatagramPacket(recvBuf, recvBuf.length);
			socket.receive(recvPacket);
			String str2=new String(recvPacket.getData(),
					0,recvPacket.getLength());
			System.out.println("服务端说:"+str2);
			socket.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		Client client=new Client();
		client.start();
	}
}
