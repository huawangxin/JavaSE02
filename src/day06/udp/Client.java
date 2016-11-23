package day06.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * �ͻ���
 */
public class Client {
	private DatagramSocket socket;
	/*
	 * �ͻ��˵�����
	 */
	public void start(){
		try{
			socket = new DatagramSocket();
			String str="��ã�����ˣ�";
			byte[] data=str.getBytes("UTF-8");
			//�����׼����������д��ַ��װ������
			InetAddress address=
					InetAddress.getByName("192.168.0.80");
			int port=8088;
			//�������Ͱ�
			DatagramPacket sendPacket=new 
			DatagramPacket(data,data.length,address,port);
			//���䷢�ͳ�ȥ
			socket.send(sendPacket);
			byte[] recvBuf=new byte[100];
			DatagramPacket recvPacket=new 
				DatagramPacket(recvBuf, recvBuf.length);
			socket.receive(recvPacket);
			String str2=new String(recvPacket.getData(),
					0,recvPacket.getLength());
			System.out.println("�����˵:"+str2);
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
