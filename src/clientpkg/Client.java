package clientpkg;

import util.NetworkUtil;

import java.util.Scanner;

public class Client implements Runnable
{
	private String name;
	private final String serverAddress = "127.0.0.1";
	private final int serverPort = 33333;
	private Thread thr;
	public Client(String name)
	{
		this.name = name;
		thr = new Thread(this);
		thr.start();
	}

	@Override
	public void run() {
		try {
			NetworkUtil nc = new NetworkUtil(serverAddress,serverPort);
			new ReadThreadClient(nc);
			new WriteThreadClient(nc, name);
		} catch(Exception e) {
			System.out.println (e);
		}
	}
}

