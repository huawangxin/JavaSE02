package day06;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * �����Ӧ�ó���
 * @author Administrator
 */
public class Server {
	// �����ڷ���˵�Socket
	private ServerSocket server;
	// �̳߳أ����ڹ���ͻ������ӵĽ����߳�
	private ExecutorService threadPool;
	// �������пͻ���������ļ���
	private HashMap<String,PrintWriter> allout;

	/**
	 * ���췽�������ڳ�ʼ�������
	 * 
	 * @throws IOException
	 */
	public Server() throws IOException {
		try {
			/*
			 * ����ServerSocketʱ��Ҫָ������˿�
			 */
			System.out.println("��ʼ�������");
			server = new ServerSocket(8088);

			// ��ʼ���̳߳�
			threadPool = Executors.newFixedThreadPool(50);

			// ��ʼ��������пͻ���������ļ���
			allout = new HashMap<String,PrintWriter>();

			System.out.println("����˳�ʼ�����");
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * ����˿�ʼ�����ķ���
	 */
	public void start() {
		try {
			/*
			 * ServerSocket��accept���� ���ڼ���8088�˿ڣ��ȴ��ͻ��˵����� �÷�����һ������������ֱ��һ��
			 * �ͻ������ӣ�����÷���һֱ������ ��һ���ͻ��������ˣ��᷵�ظÿͻ��˵� Socket
			 */
			while (true) {
				System.out.println("�ȴ��ͻ�������...");
				Socket socket = server.accept();
				/*
				 * ��һ���ͻ������Ӻ���������һ���߳� ClientHandler�����ÿͻ��˵�Socket ���룬ʹ�ø��߳����
				 * �ͻ��˽��� �����������ٴν���ѭ����������һ���ͻ��˵�����
				 */
				Runnable handler = new ClientHandler(socket);
				// Thread t = new Thread(handler) ;
				// t.start();
				threadPool.execute(handler);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �������������������
	 * 
	 * @param p
	 */
	public synchronized void addout(String nickName ,PrintWriter p) {
		allout.put(nickName, p);
	}

	/**
	 * ��������������ӹ�������ɾ��
	 * 
	 * @param p
	 */
	public synchronized void removeOut(String nickName ) {
		allout.remove( nickName );
	}

	/**
	 * ����������Ϣת�����ͻ���
	 * 
	 * @param message
	 */
	public synchronized void sendMessage(String message) {
		Set<Entry<String, PrintWriter>>set = allout.entrySet() ;
		for (Entry<String, PrintWriter> e : set) {
			e.getValue().println(message);
		}
		
	}

	public static void main(String[] args) {
		Server server;
		try {
			server = new Server();
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("����˳�ʼ��ʧ��");
		}

	}

	/*
	 * �������е�һ���̣߳�������ĳ���ͻ��� ���� ʹ���̵߳�Ŀ����ʹ�÷���˿��Դ����ͻ����ˡ�
	 */

	class ClientHandler implements Runnable {
		// ��ǰ�̴߳���Ŀͻ��˵�Socket��
		private Socket socket;
		//��ǰ�ͻ��˵�ip
		private String ip;
		//��ǰ�ͻ��˵��ǳ�
		private String nickname ;
		

		public ClientHandler(Socket socket) {
			this.socket = socket;
			InetAddress address = socket.getInetAddress();
			// ��ȡԶ�˼������IP��ַ
			ip = address.getHostAddress();
			// address.getCanonicalHostName()
			// ��ȡ�ͻ��˵Ķ˿ں�
			int port = socket.getPort();
			System.out.println(ip + ":" + port + " �ͻ���������");
			//��Ϊ��ʹ���ǳ��ˣ����Բ�������֪ͨ��
//			//֪ͨ�����û������û�������
//			sendMessage("["+ip+"]������");

		}

		/*
		 * ���߳̽���ǰSocket�е���������ȡ ����ѭ����ȡ�ͻ��˷��͹�������Ϣ (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			/*
			 * ������try������Ŀ���ǣ�Ϊ����finally��Ҳ�������õ�
			 */
			PrintWriter pw = null;
			try {
				/*
				 * Ϊ���÷������ͻ��˷�����Ϣ ������Ҫͨ��socket ��ȡ�������
				 */
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
				pw = new PrintWriter(osw, true);

				/*
				 * ���ͻ��˵���������빲���� �Ա��ǵĿͻ���Ҳ�ܽ��շ����ת������Ϣ
				 */
//				addout(pw);
				// Scanner sc = new Scanner(System.in) ;
				//
				// System.out.println(sc.nextLine());
				/*
				 * ͨ��socket��ȡԶ�˵ĵ�ַ��Ϣ ���ڷ���˶��ԣ�Զ�˾��ǿͻ�����
				 */

				/*
				 * ͨ���ո����ϵĿͻ��˵�Socket��ȡ ������������ȡ�ͻ��˷��͹�������Ϣ
				 */
				InputStream in = socket.getInputStream();
				/*
				 * ���ֽ���������װΪ�ַ������������ ����ָ�����뼯����ȡÿһ���ַ�
				 */
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				/*
				 * ���ַ���ת��Ϊ�����ַ������� �����Ϳ�������Ϊ��λ��ȡ�ַ�����
				 */
				BufferedReader br = new BufferedReader(isr);

				/*
				 * �������õ�ǰ�ͻ��˵���������
				 * ��ȡ�ĵ�һ���ַ�����Ӧ�����ǳ�
				 */
				nickname = br.readLine() ;
				addout(nickname,pw);
				//֪ͨ���пͻ��ˣ���ǰ�û�������
				sendMessage("["+nickname+"]������");
				
				String message = null;
				// ��ȡ�ͻ��˷��͹�����һ���ַ���
				/*
				 * ��ȡ�ͻ��˷��͹�������Ϣ���� windows��linux����һ���Ĳ���: linux:���ͻ��������˶Ͽ����Ӻ�
				 * ����ͨ�����������ȡ��null �����ǺϺ��߼��ģ���Ϊ�������� readLine()����������null��
				 * ��ʾ�޷�ͨ�������ٶ�ȡ����Ϣ�� �ο�֮ǰ�����ı��ļ����жϡ�
				 * 
				 * windows:���ͻ��������˶Ͽ����Ӻ� readLine()�������׳��쳣��
				 */
				while ((message = br.readLine()) != null) {
					message = hexiestr(message) ;
//					 System.out.println(
//					 "�ͻ���˵:" + message);
					// pw.println("�����˵:"+message) ;
					/*
					 * ����ȡ�ͻ��˷��͹�����һ����Ϣ�󣬽�����Ϣת�������пͻ���
					 */
					// for (PrintWriter o : allout) {
					// o.println(message);
					// }
					
					String siliao = siliaostr(message) ;
					
					if(allout.containsKey(siliao)) {
						message =message.substring(message.indexOf(":")+1) ;
						allout.get(siliao).println(nickname+"����˵:"+message);
					}else{
			
					sendMessage(nickname+"˵:"+message);
					}
					

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				// ��windows�еĿͻ��٣�
				// ����ͨ������Ϊ�ͻ��˶Ͽ�������
			}finally {
				/*
				 * ���Ƚ��ÿͻ��˵�������ӹ�������ɾ��
				 */
				removeOut(nickname);
				// �����ǰ��������
				System.out.println("��ǰ��������Ϊ:" + allout.size());
				//֪ͨ�����û������û�������
				sendMessage("["+nickname+"]������");
				/*
				 * ������Linux �û�����windows�û����������˶Ͽ����Ӻ󡢡��� ���Ƕ�Ӧ���ڷ����Ҳ��ͻ��˶Ͽ�����
				 */
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("һ���ͻ���������..");
				}
			}
		}

	}
	public String siliaostr(String str){
		
		int fir =str.indexOf("\\")+1 ;
		int las =str.indexOf(":") ;
		if(fir<=0||las<=0){
			return str ;
		}else{
		String sub =str.substring(fir,las ) ;
	
		return sub ;
		}
	}
	public String hexiestr(String str){
		String s = str.replaceAll("(sb|cao|ca)", "**") ;
		return s ;
	}

}
