package serverpkg;

import sun.applet.Main;
import util.NetworkUtil;

public class ReadThreadServer implements Runnable {
    private Thread thr;
    private NetworkUtil nc;

    public ReadThreadServer(NetworkUtil nc) {
        this.nc = nc;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while(true) {
                String name = (String) nc.read();
                if(name == null) {
                    continue;
                }
                Server.table.put(name, nc);
                Client c = new Client(name);
                MainServer.clientList.add(c);
                MainServer.clientActionMap.put(c.getAction(), c.getName());
                System.out.println(name);
            }
        } catch(Exception e) {
            System.out.println (e);
        }
        nc.closeConnection();
    }
}



