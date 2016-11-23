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
 * 服务端应用程序
 * @author Administrator
 */
public class Server {
	// 运行在服务端的Socket
	private ServerSocket server;
	// 线程池，用于管理客户端连接的交互线程
	private ExecutorService threadPool;
	// 保存所有客户端输出流的集合
	private HashMap<String,PrintWriter> allout;

	/**
	 * 构造方法，用于初始化服务端
	 * 
	 * @throws IOException
	 */
	public Server() throws IOException {
		try {
			/*
			 * 创建ServerSocket时需要指定服务端口
			 */
			System.out.println("初始化服务端");
			server = new ServerSocket(8088);

			// 初始化线程池
			threadPool = Executors.newFixedThreadPool(50);

			// 初始化存放所有客户端输出流的集合
			allout = new HashMap<String,PrintWriter>();

			System.out.println("服务端初始化完毕");
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 服务端开始工作的方法
	 */
	public void start() {
		try {
			/*
			 * ServerSocket的accept方法 用于监听8088端口，等待客户端的连接 该方法是一个阻塞方法，直到一个
			 * 客户端连接，否则该方法一直阻塞。 若一个客户端连接了，会返回该客户端的 Socket
			 */
			while (true) {
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();
				/*
				 * 当一个客户端连接后，启动启动一个线程 ClientHandler，将该客户端的Socket 传入，使得该线程与该
				 * 客户端交互 这样我们能再次进入循环，接收下一个客户端的连接
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
	 * 将给定的输出流共享集合
	 * 
	 * @param p
	 */
	public synchronized void addout(String nickName ,PrintWriter p) {
		allout.put(nickName, p);
	}

	/**
	 * 将给定的输出流从共享集合中删除
	 * 
	 * @param p
	 */
	public synchronized void removeOut(String nickName ) {
		allout.remove( nickName );
	}

	/**
	 * 将给定的消息转发给客户端
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
			System.out.println("服务端初始化失败");
		}

	}

	/*
	 * 服务器中的一个线程，用于与某个客户端 交互 使用线程的目的是使得服务端可以处理多客户端了。
	 */

	class ClientHandler implements Runnable {
		// 当前线程处理的客户端的Socket、
		private Socket socket;
		//当前客户端的ip
		private String ip;
		//当前客户端的昵称
		private String nickname ;
		

		public ClientHandler(Socket socket) {
			this.socket = socket;
			InetAddress address = socket.getInetAddress();
			// 获取远端计算机的IP地址
			ip = address.getHostAddress();
			// address.getCanonicalHostName()
			// 获取客户端的端口号
			int port = socket.getPort();
			System.out.println(ip + ":" + port + " 客户端连接了");
			//改为了使用昵称了，所以不在这里通知了
//			//通知其他用户，该用户上线了
//			sendMessage("["+ip+"]上线了");

		}

		/*
		 * 该线程将当前Socket中的输入流获取 用来循环读取客户端发送过来的消息 (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			/*
			 * 定义在try语句外的目的是，为了在finally中也可以引用到
			 */
			PrintWriter pw = null;
			try {
				/*
				 * 为了让服务端与客户端发送信息 我们需要通过socket 获取输出流。
				 */
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
				pw = new PrintWriter(osw, true);

				/*
				 * 将客户端的输出流存入共享集合 以便是的客户端也能接收服务端转发的消息
				 */
//				addout(pw);
				// Scanner sc = new Scanner(System.in) ;
				//
				// System.out.println(sc.nextLine());
				/*
				 * 通过socket获取远端的地址信息 对于服务端而言，远端就是客户端了
				 */

				/*
				 * 通过刚刚连上的客户端的Socket获取 输入流，来读取客户端发送过来的信息
				 */
				InputStream in = socket.getInputStream();
				/*
				 * 将字节输入流包装为字符输出流，这样 可以指定编码集来读取每一个字符
				 */
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				/*
				 * 将字符流转换为缓冲字符输入流 这样就可以以行为单位读取字符串了
				 */
				BufferedReader br = new BufferedReader(isr);

				/*
				 * 当创建好当前客户端的输入流后
				 * 读取的第一个字符串，应当是昵称
				 */
				nickname = br.readLine() ;
				addout(nickname,pw);
				//通知所有客户端，当前用户上线了
				sendMessage("["+nickname+"]上线了");
				
				String message = null;
				// 读取客户端发送过来的一行字符串
				/*
				 * 读取客户端发送过来的信息这里 windows与linux存在一定的差异: linux:当客户端与服务端断开连接后
				 * 我们通过输入流会读取到null 但这是合乎逻辑的，因为缓冲流的 readLine()方法若返回null就
				 * 表示无法通过该留再读取到信息。 参考之前服务文本文件的判断。
				 * 
				 * windows:当客户端与服务端断开连接后 readLine()方法会抛出异常。
				 */
				while ((message = br.readLine()) != null) {
					message = hexiestr(message) ;
//					 System.out.println(
//					 "客户端说:" + message);
					// pw.println("服务端说:"+message) ;
					/*
					 * 当读取客户端发送过来的一条消息后，将该消息转发给所有客户端
					 */
					// for (PrintWriter o : allout) {
					// o.println(message);
					// }
					
					String siliao = siliaostr(message) ;
					
					if(allout.containsKey(siliao)) {
						message =message.substring(message.indexOf(":")+1) ;
						allout.get(siliao).println(nickname+"对你说:"+message);
					}else{
			
					sendMessage(nickname+"说:"+message);
					}
					

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				// 在windows中的客户顿，
				// 报错通常是因为客户端断开了连接
			}finally {
				/*
				 * 首先将该客户端的输出流从共享集合中删除
				 */
				removeOut(nickname);
				// 输出当前在线人数
				System.out.println("当前在线人数为:" + allout.size());
				//通知其他用户，该用户下线了
				sendMessage("["+nickname+"]下线了");
				/*
				 * 无论是Linux 用户还是windows用户，当予服务端断开连接后、、、 我们都应该在服务端也与客户端断开连接
				 */
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("一个客户端下线了..");
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
