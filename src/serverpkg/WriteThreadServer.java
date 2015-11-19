package serverpkg;

import util.NetworkUtil;

import java.lang.management.ManagementFactory;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WriteThreadServer implements Runnable {

	private Thread thr;
	private static ServerController controller;

	String name;
	public Hashtable<String, NetworkUtil> table;

	public WriteThreadServer(Hashtable<String, NetworkUtil> table, String name) {
		this.table = table;
		this.name = name;
		this.thr = new Thread(this);
		thr.start();
	}

	synchronized void shouldWeWait()
	{
		while(MainServer.clientToSend == null)
		{
			try {
				wait();
				System.out.println("waiting...");
			} catch (InterruptedException e) {
				System.out.println("Interrupted error");
			}
		}
	}

	
	public void run() {
		while (true) {
			try{
				System.out.println("Waiting for msg");
				String cName = MainServer.query.get();
				Client client = MainServer.query.client;
				System.out.println("got it");
				NetworkUtil nc = table.get(cName);
				String msg = controller.msgBox.getText();
				if (nc != null) {
					nc.write(msg);
				} else {
					System.out.println("Client " + name + " unavailable");
				}
				MainServer.clientList.remove(client);
			}catch(Exception e){
				System.out.println("Oh snap");
			}
		}
	}

	public static void setController(ServerController c)
	{
		controller = c;
	}

}



