
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahsan Riaz
 */
public class ReadWrite implements Runnable {

    String client;
    DataInputStream in;
    DataOutputStream out;

    public ReadWrite(String client, DataInputStream in, DataOutputStream out) {
        this.client = client;
        this.in = in;
        this.out = out;
    }
    
    @Override
    public void run() {
        try
        {
            while(true)
            {
                String s = in.readUTF();
                String msg[] = s.split(":");
                String message = client + ": " + msg[1];
                if(msg[1].length()>0)
                {
                    out.writeUTF(message);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
