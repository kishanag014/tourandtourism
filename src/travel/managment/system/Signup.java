package travel.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener{
    JButton create,back;
    JTextField tfname,tfusername,tfanswer,tfpassword;
    JComboBox security;
    
    Signup(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(51,204,255));
        p1.setBounds(0, 0, 500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        lblusername.setBounds(50,20,125,25);
        p1.add(lblusername);
        
        tfusername =new JTextField();
        tfusername.setBounds(190,20,180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        JLabel lblname=new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        lblname.setBounds(50,60,125,25);
        p1.add(lblname);
        
        tfname =new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        lblpassword.setBounds(50,100,125,25);
        p1.add(lblpassword);
        
        tfpassword =new JTextField();
        tfpassword.setBounds(190,100,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel lblsecurity=new JLabel("Security Question");
        lblsecurity.setForeground(Color.DARK_GRAY);
        lblsecurity.setFont(new Font("Tahoma",Font.BOLD,14));
        lblsecurity.setBounds(50,140,125,25);
        p1.add(lblsecurity);
        
        security =new JComboBox();
        security.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
			"Your child SuperHero?", "Your childhood Name ?" }));
        security.setBounds(190,140,180,25);
        p1.add(security);
        
        JLabel lblanswer=new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
        lblanswer.setBounds(50,180,125,25);
        p1.add(lblanswer);
        
        tfanswer =new JTextField();
        tfanswer.setBounds(190,180,180,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        create=new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(50,250,100,30);
        create.addActionListener(this);
        p1.add(create);
      
        back=new JButton("Back");
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(270,250,100,30);
        p1.add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login1.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580, 50,250 ,250);
        add(image);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
                Conn c=new Conn();
        if(ae.getSource() == create){
            
            String username=tfusername.getText();
            String name=tfname.getText();
            String password=tfpassword.getText();
            String question=(String)security.getSelectedItem();
            String answer=tfanswer.getText();
            
            String query= "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
          
               int i= c.s.executeUpdate(query);
               if(i>0){
                JOptionPane.showMessageDialog(null,"Account Created Successfully");   
                }
               tfusername.setText("");
               tfname.setText("");
               tfpassword.setText("");
               tfanswer.setText("");            
                       }
              if(ae.getSource()==back){
            setVisible(false);
            new Login().setVisible(true);
                c.c.close();
        }
        }catch(Exception e){
                e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Signup().setVisible(true);
       
    
    }
}