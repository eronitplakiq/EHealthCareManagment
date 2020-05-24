import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class E_Health_Writer extends JPanel implements ActionListener{

   public static final Color BUTTON = new Color(225,225,225);    //color for this button's project
   
   JLabel welcome , username , password;
   JTextField user;
   JPasswordField pass;
   JRadioButton Admin , Doctor ,Client;
   JButton log_in;
   JFrame jf1,jf2;

   private Client_Database client_data;
   private Doctor_Database doctor_data;
   private String [][] data1;
   private String [][] data2;
   private Client_info cInfo;
   private Doctor doctor;

   E_Health_Writer(Client_Database client_base , Doctor_Database doctor_base , String [][] data , String [][] dataa){
      
      data1 = data;
      data2 = dataa;
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.white);
      panel.setBounds(0,0,285,300);
      
      client_data = client_base;
      doctor_data = doctor_base;
   
      jf1 = new JFrame("E-Health Care Managment");
                  
      welcome = new JLabel("E-Health Care Managment");    welcome.setFont(new Font("Arial" , Font.BOLD + Font.ITALIC , 15));
      username = new JLabel("Username : ");
      password = new JLabel("Password : ");
   
      user = new JTextField();
   
      pass = new JPasswordField();
   
      Admin = new JRadioButton("Administrator");   Admin.setBackground(Color.white);
      Doctor = new JRadioButton("Doctor");         Doctor.setBackground(Color.white);
      Client = new JRadioButton("Patient");         Client.setBackground(Color.white);
   
      ButtonGroup bg = new ButtonGroup();
   
   //jp.setBounds(0,170,275,50);
   //jp.setBackground(Color.white);
   
      JButton log_in = new JButton("Log In");
   //JButton sign_up = new JButton("Sign Up");
   
      welcome.setBounds(65,25,300,20);
   
      log_in.setBounds(80,205,130,30);
      log_in.setBackground(BUTTON);
   
   //sign_up.setBounds(180,300,80,40);
   //sign_up.setBackground(Color.gray);
   
      username.setBounds(50,70,100,20);
      password.setBounds(50,95,100,20);
   
      user.setBounds(120,70,100,20);
   
      pass.setBounds(120,95,100,20);
   
      Admin.setBounds(85,130,120,20);
      Doctor.setBounds(85,150,100,20);
      Client.setBounds(85,170,100,20);
   
      log_in.addActionListener(this);
   
      bg.add(Admin); bg.add(Doctor); bg.add(Client);       
            
      //add contents(button , labels and TextFields) to frame
      jf1.add(welcome);
      jf1.add(log_in);
      jf1.add(username);
      jf1.add(password);
      jf1.add(user);
      jf1.add(pass);
      jf1.add(Admin);
      jf1.add(Doctor);
      jf1.add(Client);
      ImageIcon icon = new ImageIcon("doctor.png");
      JLabel label_icon = new JLabel(icon);
      label_icon.setBounds(15,10,50,50);
      jf1.add(label_icon);
      jf1.add(panel);
      
      //frame contents
      jf1.setSize(285,300);
      jf1.setLayout(null);
      jf1.setResizable(false);
      jf1.setLocationRelativeTo(null);
      jf1.setVisible(true);
   
   }

   public void actionPerformed(ActionEvent e)
   {
   
      String username1 = user.getText();
      String password1 = pass.getText();
   
      Key key2 = new Key(username1,  password1);
   
      if(username1.trim().equals("Admin") && password1.trim().equals("admin") && Admin.isSelected())
      { jf1.setVisible(false);
         JOptionPane.showMessageDialog(null , "Log In Successful");
         new Logged_in_as_Administrator(client_data , doctor_data , data1 , data2);
      }
      else if(doctor_data.find(key2) != null && Doctor.isSelected())
      {
         jf1.setVisible(false);
         JOptionPane.showMessageDialog(null , "Log In Successful");
         doctor = new Doctor(client_data , doctor_data , doctor_data.find(key2) , data1 , data2);
      }
      
      else if(client_data.find(key2) != null && Client.isSelected())
      {
         
         jf1.setVisible(false);
         JOptionPane.showMessageDialog(null , "Log In Successful");
         cInfo = new Client_info(client_data.find(key2) , client_data , doctor_data , data1 , data2);
      }
      
      else{ JOptionPane.showMessageDialog(null , "Log In Failed"); }
   
   }

   public static void main(String[] args){
   
      Client_Database cd = new Client_Database(1);
      Doctor_Database dd = new Doctor_Database(1);
      String [][] data1 = new String[12][7];
      String [][] data2 = new String[20][3];
      data2[0][0] = "Eronit";
      new E_Health_Writer(cd, dd , data1 , data2);
      }
   }
