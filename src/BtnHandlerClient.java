
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahsan Riaz
 */
public class BtnHandlerClient implements ActionListener 
{
    ClientGUI client;
    public BtnHandlerClient(ClientGUI client)
    {
        this.client = client;
    }
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getActionCommand().equals("Send") )
        {
            if(client.inputText.getText().length()>0)
            {
                try
                {
                  
                    client.ser.currentClient=client.clientName;
                    String msg = client.inputText.getText();
                    String s = client.textArea.getText();
                    s = s+"\n" + client.clientName+": "+ msg;
                    client.textArea.setText(s);
                    client.out.writeUTF(client.clientName+":"+msg);
                    
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                client.inputText.setText("");
            }   
        }
    }
    
}
