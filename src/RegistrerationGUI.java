
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahsan Riaz
 */
public class RegistrerationGUI 
{
    JFrame fr;
    JLabel lb1,lb2;
    JTextField txt1,txt2;
    JButton btn;
    Boolean flag = false;
    RegisterBtnHnd hnd;
    public RegistrerationGUI()
    {
        hnd = new RegisterBtnHnd(this);
        initGUI();
    }
    public void initGUI()
    {
        fr = new JFrame("Registration");
        fr.setLayout(new GridLayout(5,1));
        lb1 = new JLabel("Enter Name for Client A");
        txt1= new JTextField();
        lb2 = new JLabel("Enter Name for Client B");
        txt2=new JTextField();
        btn = new JButton("Register");
        btn.addActionListener(hnd);
        fr.add(lb1);
        fr.add(txt1);
        fr.add(lb2);
        fr.add(txt2);
        fr.add(btn);
        fr.setSize(400,400);
        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
    }
}
