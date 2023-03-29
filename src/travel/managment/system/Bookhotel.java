package travel.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Bookhotel extends JFrame implements ActionListener {
    
    Choice chotel,cac,cfood;
    JTextField tfperson,tfdays;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,bookhotel,back;
    
    Bookhotel(String username){
        this.username=username;
        
        setBounds(200,100,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text=new JLabel("BOOK HOTEL");
        text.setBounds(450,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,30));
        add(text);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));        
        add(lblusername);  
        
        labelusername=new JLabel();
        labelusername.setBounds(250,70,200,20);
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));  
        add(labelusername);
        
        JLabel lblpackege=new JLabel("Select Hotel");
        lblpackege.setFont(new Font("Tahoma",Font.PLAIN,16));          
        lblpackege.setBounds(40,110,200,20);
        add(lblpackege);  
        
        chotel=new Choice();
        chotel.setBounds(250,110,230,20);
        add(chotel);
        
        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
         JLabel lblpersons=new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));                 
        lblpersons.setBounds(40,150,150,25);
        add(lblpersons); 
        
        tfperson=new JTextField("1");
        tfperson.setBounds(250,150,100,25);
        add(tfperson);
        
        JLabel lblday=new JLabel("No.of Days");
        lblday.setFont(new Font("Tahoma",Font.PLAIN,16));                 
        lblday.setBounds(40,190,150,25);
        add(lblday); 
        
        tfdays=new JTextField("1");
        tfdays.setBounds(250,190,100,25);
        add(tfdays);
        
        JLabel lblac=new JLabel("Ac / Non-Ac");
        lblac.setFont(new Font("Tahoma",Font.PLAIN,16));                 
        lblac.setBounds(40,230,150,25);
        add(lblac);
        
        cac=new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230,100,20);
        add(cac);
        
        JLabel lblfood=new JLabel("Food Included");
        lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));                 
        lblfood.setBounds(40,270,150,25);
        add(lblfood);
        
        cfood=new Choice();
        cfood.add("YES");
        cfood.add("NO");
        cfood.setBounds(250,270,100,20);
        add(cfood);

       
        JLabel lblid=new JLabel("Id");
        lblid.setBounds(40,310,150,20);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));          
        add(lblid);  
        
        labelid=new JLabel();
        labelid.setBounds(250,310,200,25);
        add(labelid);  
        
        JLabel lblnumber =new JLabel("Number");
        lblnumber.setBounds(40,350,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));                         
        add(lblnumber);  
        
        labelnumber=new JLabel();
        labelnumber.setBounds(250,350,200,25);
        add(labelnumber);  
        
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(40,390,150,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));          
        add(lblphone);  
        
        labelphone=new JLabel();
        labelphone.setBounds(250,390,200,25);
        add(labelphone);  
        
        JLabel lbltol =new JLabel("Toatal Price");
        lbltol.setBounds(40,430,150,25);
        lbltol.setFont(new Font("Tahoma",Font.PLAIN,16));                         
        add(lbltol);  
        
        labelprice=new JLabel();
        labelprice.setBounds(250,430,200,25);
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
        checkprice.setBounds(40,480,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookhotel=new JButton("Book Hotel");
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(200,480,120,25);
        bookhotel.addActionListener(this);
        add(bookhotel);
       
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(120,515,120,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Book.jpg"));
        Image i2=i1.getImage().getScaledInstance(550, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l12=new JLabel(i3);
        l12.setBounds(500,50,550,400);
        add(l12);
        
        
        
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== checkprice){
            try{
               Conn c = new Conn();
               ResultSet rs=c.s.executeQuery("select * from hotel where name='"+ chotel.getSelectedItem()+"'");
               
               while(rs.next()){
                   int cost=Integer.parseInt(rs.getString("costperperson"));
                   int food=Integer.parseInt(rs.getString("foodincluded"));
                   int ac=Integer.parseInt(rs.getString("acroom"));
                   
                   int persons=Integer.parseInt(tfperson.getText());
                   int days=Integer.parseInt(tfdays.getText());
                   
                   String  acSelected=cac.getSelectedItem();
                   String foodSelected=cfood.getSelectedItem();
                   
                   if(persons * days >0){
                       int total=0;
                       total += acSelected.equals("AC") ? ac: 0 ;
                       total += foodSelected.equals("YES") ? food:0;
                       total +=cost;
                       total = total * persons * days ;
                       labelprice.setText("Rs " +total);
                       
                       
                   }else{
                       JOptionPane.showMessageDialog(null,"Please Enter a Valid Number");
                   }
                   
               }
            
               } catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==bookhotel){
            try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+username+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','"+ tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    
    
    }
    public static void main(String[] args){
        new Bookhotel("kishan@");
        
    }
    
}
