package travel.managment.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class ViewBookedHotel extends JFrame implements ActionListener{
    
    JButton back;
    
    ViewBookedHotel(String username){
        
        setBounds(350,160,1000,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(350,10,350,30);
        add(text);
        
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);  
        
        JLabel labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblname=new JLabel("Hotel Name");
        lblname.setBounds(30,90,250,25);
        add(lblname);  
        
         JLabel labelname=new JLabel();
        labelname.setBounds(220,90,250,25);
        add(labelname);  
        
         JLabel lblperson=new JLabel("Total Persons");
        lblperson.setBounds(30,130,150,25);
        add(lblperson);  
        
         JLabel labelperson=new JLabel();
        labelperson.setBounds(220,130,150,25);
        add(labelperson);
        
         JLabel lbldays=new JLabel("Total Days");
        lbldays.setBounds(30,170,150,25);
        add(lbldays);  
        
        JLabel labeldays=new JLabel();
        labeldays.setBounds(220,170,150,25);
        add(labeldays);
        
        JLabel lblac=new JLabel("Ac / Non-Ac");
        lblac.setBounds(30,210,150,25);
        add(lblac);  
        
        JLabel labelac=new JLabel();
        labelac.setBounds(220,210,150,25);
        add(labelac); 
        
        JLabel lblfood=new JLabel("Food Included ?");
        lblfood.setBounds(30,250,150,25);
        add(lblfood);  
        
        JLabel labelfood=new JLabel();
        labelfood.setBounds(220,250,150,25);
        add(labelfood);  
        
        JLabel lblid=new JLabel("Id");
        lblid.setBounds(30,290,150,25);
        add(lblid);  
        
         JLabel labelid=new JLabel();
        labelid.setBounds(220,290,150,25);
        add(labelid);  
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(30,330,150,25);
        add(lblnumber);  
        
         JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,330,150,25);
        add(labelnumber);  
        
         JLabel lblphone=new JLabel("Phone No.");
        lblphone.setBounds(30,370,150,25);
        add(lblphone);  
        
         JLabel labelphone=new JLabel();
        labelphone.setBounds(220,370,410,25);
        add(labelphone);  
        
         JLabel lblprice=new JLabel("Total Cost");
        lblprice.setBounds(30,410,150,25);
        add(lblprice);  
        
        JLabel labelprice=new JLabel();
        labelprice.setBounds(220,410,410,25);
        add(labelprice); 
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,460,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450,50,500,400);
        add(image);
        
        try{
        
            Conn conn=new Conn();
            String query="select * from bookhotel where username= '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                labelperson.setText(rs.getString("person"));
                labeldays.setText(rs.getString("days"));
                labelac.setText(rs.getString("ac"));
                labelfood.setText(rs.getString("food"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));
               
            }
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
            
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args){
    
    new ViewBookedHotel("kishan@");
    }
    
}
