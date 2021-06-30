/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahsan Riaz
 */
public class Driver 
{
    public static void main(String[] args) 
    {
        RegistrerationGUI reg = new RegistrerationGUI();
        while(reg.flag==false)
        {
            System.out.println("Registeration ...");
        }
        reg.fr.setVisible(false);
        System.out.println("testing ...");
        ChatServer ser = new ChatServer(4422);
        String clientA = reg.txt1.getText();
        String clientB = reg.txt2.getText();
        ClientGUI c1 = new ClientGUI(ser,clientA,"127.0.0.1",4422);
        ClientGUI c2 = new ClientGUI(ser,clientB,"127.0.0.1",4422);
        ser.registration(c1.clientName);
        ser.registration(c2.clientName);
        c1.frame.setLocation(0, 50);
        c2.frame.setLocation(650, 50);
        Thread t1 = new Thread(ser);
        t1.start();
        Thread t2 = new Thread(c1);
        t2.start();
        Thread t3 = new Thread(c2);
        t3.start();
    }
       
}
