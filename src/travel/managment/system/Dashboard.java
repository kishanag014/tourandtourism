package travel.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
    
    String username;
    JButton addPersonalDetails,viewPersonalDetails,updatePersonalDetails,checkPackages,bookPackage,viewHotels,viewPackage,destinations,bookHotel,viewBookedHotel;
    JButton payments,calculators,notepad,about,deletePersonalDetails;
    Dashboard(String username){
        this.username=username;
        setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon();
        JLabel icon=new JLabel(i3);
        icon.setBounds(5,5,100,70);
        p1.add(icon);
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(30,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,40));
        p1.add(heading);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        addPersonalDetails =new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,42);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tamoha",Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        updatePersonalDetails =new JButton("Upadate Personal Details");
        updatePersonalDetails.setBounds(0,42,300,42);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tamoha",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.addActionListener(this);

        p2.add(updatePersonalDetails);
        
        viewPersonalDetails =new JButton("View Details");
        viewPersonalDetails.setBounds(0,84,300,42);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tamoha",Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,140));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        deletePersonalDetails =new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,126,300,42);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tamoha",Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,40));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);
        
        checkPackages =new JButton("Check Package");
        checkPackages.setBounds(0,168,300,42);
        checkPackages.setBackground(new Color(0,0,102));
        checkPackages.setForeground(Color.WHITE);
        checkPackages.setFont(new Font("Tamoha",Font.PLAIN,20));
        checkPackages.setMargin(new Insets(0,0,0,110));
        checkPackages.addActionListener(this);

        p2.add(checkPackages);
        
        bookPackage =new JButton("Book Package");
        bookPackage.setBounds(0,210,300,42);
        bookPackage.setBackground(new Color(0,0,102));
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setFont(new Font("Tamoha",Font.PLAIN,20));
        bookPackage.setMargin(new Insets(0,0,0,120));
        bookPackage.addActionListener(this);        
        p2.add(bookPackage);
        
        viewPackage =new JButton("View Package");
        viewPackage.setBounds(0,252,300,42);
        viewPackage.setBackground(new Color(0,0,102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("Tamoha",Font.PLAIN,20));
        viewPackage.setMargin(new Insets(0,0,0,120));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);
        
        viewHotels =new JButton("View Hotels");
        viewHotels.setBounds(0,294,300,42);
        viewHotels.setBackground(new Color(0,0,102));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font("Tamoha",Font.PLAIN,20));
        viewHotels.setMargin(new Insets(0,0,0,140));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);
        
        bookHotel =new JButton("Book Hotel");
        bookHotel.setBounds(0,336,300,42);
        bookHotel.setBackground(new Color(0,0,102));
        bookHotel.setForeground(Color.WHITE);
        bookHotel.setFont(new Font("Tamoha",Font.PLAIN,20));
        bookHotel.setMargin(new Insets(0,0,0,150));
        bookHotel.addActionListener(this);
        p2.add(bookHotel);
        
        viewBookedHotel =new JButton("View Book Hotel");
        viewBookedHotel.setBounds(0,378,300,42);
        viewBookedHotel.setBackground(new Color(0,0,102));
        viewBookedHotel.setForeground(Color.WHITE);
        viewBookedHotel.setFont(new Font("Tamoha",Font.PLAIN,20));
        viewBookedHotel.setMargin(new Insets(0,0,0,110));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);
        
        destinations =new JButton("Destinations");
        destinations.setBounds(0,420,300,42);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tamoha",Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,150));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        payments =new JButton("Payments");
        payments.setBounds(0,462,300,42);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tamoha",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,165));
        payments.addActionListener(this);
        p2.add(payments);
        
        calculators =new JButton("Calculators");
        calculators.setBounds(0,504,300,42);
        calculators.setBackground(new Color(0,0,102));
        calculators.setForeground(Color.WHITE);
        calculators.setFont(new Font("Tamoha",Font.PLAIN,20));
        calculators.setMargin(new Insets(0,0,0,160));
        calculators.addActionListener(this);
        p2.add(calculators);
        
        notepad =new JButton("Notepad");
        notepad.setBounds(0,546,300,42);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tamoha",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,170));
        notepad.addActionListener(this);
        p2.add(notepad);
        
        about =new JButton("About");
        about.setBounds(0,588,300,42);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tamoha",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,200));
        about.addActionListener(this);
        p2.add(about);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5=i4.getImage().getScaledInstance(1650, 1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);
        
        JLabel text=new JLabel("Travel and Tourism Management System");
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Raleway",Font.PLAIN,50));
        image.add(text);
         
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae ){
        if(ae.getSource()==addPersonalDetails){
            new AddCustomer(username);
            
        }else
            if(ae.getSource()==viewPersonalDetails){
                new ViewCustomer(username);
    }else 
                if(ae.getSource()==updatePersonalDetails){
                    new UpdateCustomer(username);
        
    }else 
                    if(ae.getSource()==checkPackages)
                    {
                        new CheckPackage();
                    }else 
                        if(ae.getSource()==bookPackage){
                        new BookPackage(username);   
                    }else 
                            if(ae.getSource()==viewPackage){
                                new ViewPackage(username);
                        
                    }
                        else
                            if(ae.getSource()==viewHotels){
                                new CheckHotels();
                            }else
                                if(ae.getSource()==destinations){
                                    new Destinations();
                                }
        else
                                    if(ae.getSource()==bookHotel){
                                        new Bookhotel(username);
                                    }else
                                        if(ae.getSource()==viewBookedHotel){
                                            new ViewBookedHotel(username);
                                            
                                        }else 
                                            if(ae.getSource()==payments){
                                                new Payment();
                                            }
                                            else 
                                                if(ae.getSource()==calculators){
                                                    try{
                                                      Runtime.getRuntime().exec("calc.exe"); //use for connect calculator
                                                    }catch(Exception e){
                                                        e.printStackTrace();
                                                    }
                                                
                                            }else 
                                                 if(ae.getSource()==notepad){                                                     
                                                        try{
                                                        Runtime.getRuntime().exec("notepad.exe"); //use for connect notepad
                                                   }catch(Exception e){
                                                        e.printStackTrace();
                                                    }
                                            }else 
                                                  if(ae.getSource()==about){
                                                      new About();
                                                  }
                                                  else if(ae.getSource()==deletePersonalDetails){
                                                      new DeletePersonalDetails(username);
                                                  }
        
    }
    public static void main(String[] args){ 
        new Dashboard("kishan@");
        
    }
    
}
