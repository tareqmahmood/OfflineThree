package serverpkg;

import clientpkg.*;

/**
 * Created by tareq on 11/19/2015.
 */
public class Query {
    public boolean val = false;
    public String name;
    public Client client;
    synchronized void put(String s, Client c)
    {
        while(val)
        {
            try{
                wait();
            }catch(InterruptedException e)
            {
                System.out.println("Query error");
            }

        }
        name = s;
        client = c;
        val = true ^ val;
        notifyAll();
    }

    synchronized String get()
    {
        while(!val)
        {
            try{
                wait();
            }catch(InterruptedException e)
            {
                System.out.println("Query error");
            }
        }
        val = true ^ val;
        notifyAll();
        return name;
    }

}
