package travel.managment.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paytm extends JFrame implements ActionListener{
    
    JButton back;
    Paytm(){
        
        setBounds(450,150,800,550);//use for create panel
        
        JEditorPane pane =new JEditorPane();//use For create the text area and load the website
        pane.setEditable(false);
        try{
            pane.setPage("https://paytm.com/rent-payment");
            
        }catch(Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404</html>");
            
        }
        
        JScrollPane sp=new JScrollPane(pane);//use for create an scroll bar
        getContentPane().add(sp);
        
        back=new JButton("Back");
        back.setBounds(680,20,80,40);
        back.addActionListener(this);
        pane.add(back);
        
        
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            new Payment();
        }
            
        
    }
    public static void main(String[] args){
        new Paytm();
    }
    
}
