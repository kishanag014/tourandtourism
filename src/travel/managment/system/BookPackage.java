package travel.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {
    
    Choice cpackage;
    JTextField tfperson;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,bookPackage,back;
    
    BookPackage(String username){
        this.username=username;
        
        setBounds(200,150,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text=new JLabel("BOOK PACKAGE");
        text.setBounds(400,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));        
        add(lblusername);  
        
        labelusername=new JLabel();
        labelusername.setBounds(250,70,200,20);
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));  
        add(labelusername);
        
        JLabel lblpackege=new JLabel("Select Package");
        lblpackege.setFont(new Font("Tahoma",Font.PLAIN,16));          
        lblpackege.setBounds(40,110,200,20);
        add(lblpackege);  
        
        cpackage=new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,100,20);
        add(cpackage);
        
         JLabel lblpersons=new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));                 
        lblpersons.setBounds(40,150,150,25);
        add(lblpersons); 
        
        tfperson=new JTextField("1");
        tfperson.setBounds(250,150,200,25);
        add(tfperson);
       
        JLabel lblid=new JLabel("Id");
        lblid.setBounds(40,190,150,20);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));          
        add(lblid);  
        
        labelid=new JLabel();
        labelid.setBounds(250,190,200,25);
        add(labelid);  
        
        JLabel lblnumber =new JLabel("Number");
        lblnumber.setBounds(40,230,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));                         
        add(lblnumber);  
        
        labelnumber=new JLabel();
        labelnumber.setBounds(250,230,200,25);
        add(labelnumber);  
        
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(40,270,150,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));          
        add(lblphone);  
        
        labelphone=new JLabel();
        labelphone.setBounds(250,270,200,25);
        add(labelphone);  
        
        JLabel lbltol =new JLabel("Toatal Price");
        lbltol.setBounds(40,310,150,25);
        lbltol.setFont(new Font("Tahoma",Font.PLAIN,16));                         
        add(lbltol);  
        
        labelprice=new JLabel();
        labelprice.setBounds(250,310,200,25);
        add(labelprice);  
        
        
        
        try{
        
            Conn conn=new Conn();
            String query="select * from customer where username= '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
        
            }
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        checkprice=new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(40,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookPackage=new JButton("Book Package");
        bookPackage.setBackground(Color.BLACK);
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setBounds(200,380,120,25);
        bookPackage.addActionListener(this);
        add(bookPackage);
       
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(120,415,120,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l12=new JLabel(i3);
        l12.setBounds(550,50,500,400);
        add(l12);
        
        
        
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== checkprice){
            String pack= cpackage.getSelectedItem();
            int cost=0;
            if(pack.equals("Gold Package")){
                cost =cost+12000;
                
            }else if(pack.equals("Silver Package")){
                cost=cost+10000;
            }else{
                cost=cost+8000;
            }
            int persons=Integer.parseInt(tfperson.getText());
            cost=cost*persons;
            labelprice.setText("Rs "+cost);
                   
        }else if(ae.getSource()==bookPackage){
            try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+username+"','"+cpackage.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    
    
    }
    public static void main(String[] args){
        new BookPackage("kishan@");
        
    }
    
}
