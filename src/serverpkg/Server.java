package serverpkg;

import util.NetworkUtil;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class Server implements Runnable {

	private ServerSocket ServSock;
	public int i = 1;
	public static Hashtable<String, NetworkUtil> table;
	public Thread thr;

	
	public Server() {
		System.out.println("Entered");
		this.thr = new Thread(this);
		thr.start();
	}
	
//	public static void main(String args[]) {
//		Server objServer = new Server();
//	}

	@Override
	public void run() {
		table = new Hashtable<>();
		try {
			ServSock = new ServerSocket(33333);
			new WriteThreadServer(table, "Server");
			System.out.println("Waiting");
			while (true) {
				Socket clientSock = ServSock.accept();
				System.out.println("Connected");
				NetworkUtil nc = new NetworkUtil(clientSock);
				new ReadThreadServer(nc);
			}
		}catch(Exception e) {
			System.out.println("Server starts:"+e);
		}
	}
}


