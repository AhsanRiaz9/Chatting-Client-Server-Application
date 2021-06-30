
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
public class RegisterBtnHnd implements ActionListener{

    RegistrerationGUI g;
    public RegisterBtnHnd(RegistrerationGUI ref)
    {
        g = ref;
    }
   
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getActionCommand().equals("Register"))
        {
            String s1 = g.txt1.getText();
            String s2 = g.txt2.getText();
            if(!s1.equals(s2) && s1.length()>0 && s2.length()>0)
            {
                g.flag=true;
                System.out.println("Registration Successful");
            }
            
        }
    }
    
}
