
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahsan Riaz
 */
public class ChatServer implements Runnable
{
    String currentClient="";
    String clientA;
    String clientB;
    ServerSocket ss;
    Socket soc1;
    Socket soc2;
    
    DataInputStream in1;
    DataOutputStream out1;
    DataInputStream in2;
    DataOutputStream out2;  
    int sport;
    String msg="";
    int count;
    public ChatServer(int port)
    {
        try
        {
            ss = new ServerSocket(port);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        soc1 = null;
        soc2 = null;
        in1 = null;
        in2 = null;
        out1 = null;
        out2 = null;
        count = 0;
        sport=port;
    }
   public void registration(String name)
   {
       try
       {
           if(count==0)
           {
               soc1 = ss.accept();
               clientA = name;
               in1 = new DataInputStream(soc1.getInputStream());
               out1 = new DataOutputStream(soc1.getOutputStream());
           }
           else if(count==1)
           {
               soc2 = ss.accept();
               clientB = name;
               in2 = new DataInputStream(soc2.getInputStream());
               out2 = new DataOutputStream(soc2.getOutputStream());
           }
           count = count +1;
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
   }

    @Override
    public void run() 
    {
        ReadWrite obj1 = new ReadWrite(clientA,in1,out2);
        ReadWrite obj2 = new ReadWrite(clientB, in2, out1);
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        t1.start();
        t2.start();
    }
}

                