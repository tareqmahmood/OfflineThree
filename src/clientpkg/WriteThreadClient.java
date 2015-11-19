package clientpkg;

import util.NetworkUtil;

public class WriteThreadClient implements Runnable {

	private Thread thr;
	private NetworkUtil nc;
	String name;

	public WriteThreadClient(NetworkUtil nc, String name) {
		this.nc = nc;
		this.name=name;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
		nc.write(name);
	}
}



