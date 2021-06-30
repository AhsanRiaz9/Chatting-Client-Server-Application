
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahsan Riaz
 */
public class ClientGUI implements Runnable
{
    ChatServer ser ;
    Socket soc;
    DataInputStream in;
    DataOutputStream out; 
    String clientName = "";
    JFrame frame;
    JPanel mainPanel;
    JPanel p1,p2,p3;
    JLabel msgLabel;
    JEditorPane textArea;
    JTextField inputText;
    JButton sendButton;
    BtnHandlerClient hnd;
    public ClientGUI(ChatServer ser,String name,String addr,int port)
    {
        this.ser = ser;
        hnd = new BtnHandlerClient(this);
        clientName = name;
        initGUI();
        try
        {
            soc = new Socket(addr, port);
            System.out.println("connected to server");
            out = new DataOutputStream(soc.getOutputStream());
            in = new DataInputStream(soc.getInputStream());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    public void initGUI()
    {
        frame = new JFrame("Client");
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx=1;
        gbc.gridx = 0;  
        gbc.gridy = 0;  
        p1 = new JPanel();
        p1.setBackground(Color.ORANGE);
        System.out.println(clientName);
        msgLabel = new JLabel("Current User : "+clientName);
        p1.add(msgLabel);
        mainPanel.add(p1,gbc);
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1));
        p2.setBackground(Color.CYAN);
        textArea = new JEditorPane();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        p2.add(scrollPane);
        gbc.gridx = 0;  
        gbc.gridy = 1;
        gbc.ipadx=3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 3;
        gbc.weighty = 1;
        
        mainPanel.add(p2,gbc);
        p3 = new JPanel();
        p3.setLayout(new GridLayout(1,2));
        p3.setBackground(Color.gray);
        inputText = new JTextField();
        p3.add(inputText);
        sendButton = new JButton("Send");
        sendButton.addActionListener(hnd);
        p3.add(sendButton);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;
        gbc.weighty = 0.2;
        gbc.gridx = 0;  
        gbc.gridy = 2; 
        mainPanel.add(p3,gbc);
        frame.add(mainPanel);
        frame.setSize(600, 650);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void run() 
    {
        try
        {
            while(true)
            {
                String msg = in.readUTF();
                if(msg.length()>0)
                {
                    textArea.setText(textArea.getText() + "\n" + msg);
                }
                this.ser.currentClient="";
            }   
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

   
}
