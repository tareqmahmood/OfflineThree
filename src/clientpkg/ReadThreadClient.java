package clientpkg;

import util.NetworkUtil;

public class ReadThreadClient implements Runnable {
    private Thread thr;
    private NetworkUtil nc;
    private static ClientController controller;

    public ReadThreadClient(NetworkUtil nc) {
        this.nc = nc;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            String s=(String) nc.read();
            controller.msgBox.setText(s);
            System.out.println(s);
        } catch(Exception e) {
            System.out.println (e);
        }
        nc.closeConnection();
    }

    public static void getController(ClientController c)
    {
        controller = c;
    }
}



