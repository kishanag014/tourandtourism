package travel.managment.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    JButton back;
    
    About(){
        
        setBounds(550,160,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel l1=new JLabel("ABOUT");
        l1.setBounds(230,10,100,40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l1);
        
        String s= "About Projects         \n"+
                " \n" +
                "The objective of the Travel and Tourism Management System project is to develop a system that automates the processes and activites of a travel and the purpose is to design a system using which one can perform all operations related to traveling. \n"+
                " \n" +
                "This application will help in accessing the information related to travel to the particuler destination with great ease. The users can track the information related to their tours woth great case through this application. The travel agency information can also be obtained this application.  \n" +
                " \n" +
                "Advantages of Project:\n" +
                " \n" +
                "1. Gives accurate information. \n" +
                "2. Simplifies the manual work. \n" +
                "3. It minimizes the documentation related work. \n" +
                "4. Provides up to date information. \n" +
                "5. Friendly Environment by providing warning massages. \n" +
                "6. Travelers details can be provided. \n" +
                "7. Booking confirmation notification. \n "+
                " \n\n" +
                "                                          Thank you for visiting this Application       \n\n";
        
        TextArea area=new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);
        
        back=new JButton("Back");
        back.setBounds(200,420,100,25);
        back.addActionListener(this);
        add(back);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== back){
            
            setVisible(false);
            
        }
        
    }
    public static void main(String[] args){
        new About();
    }
    
}
