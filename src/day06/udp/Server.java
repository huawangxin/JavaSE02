package day06.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * �����
 * @author wangxin
 *
 */
public class Server {
	private DatagramSocket socket;
	/*
	 * ����˵�����
	 */
	public void start(){
		try {
			socket = new DatagramSocket(8088);
			byte[] data=new byte[100];
			DatagramPacket recvPacket=new 
			    DatagramPacket(data, data.length);
			//�������ݵ�����
			//ע��÷����Ǹ���������
			socket.receive(recvPacket);
			//���������
			byte[] d=recvPacket.getData();
			//��Ч���ݳ���
			int dlen=recvPacket.getLength();
			/*
			 * String(byte[] b,int offset,int len,
			 * String caarserName)
			 * 
			 * ���������ֽ������У���offset��
			 * ��ʼ����len���ֽڣ��ٸ��ݸ������ַ���ת��Ϊ�ַ���
			 */
			String info=new String(d,0,dlen,"UTF-8");
			System.out.println("�ͻ���˵��"+info);
			
			int port=recvPacket.getPort();
			InetAddress addr=recvPacket.getAddress();
			String sendStr="hello,��ӭ����Ӣ������";
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
