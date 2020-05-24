import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Assign_New_Doctor extends JPanel implements ActionListener{

   JFrame frame = new JFrame("Assign New Doctor");
   JTextField Username ,Password , Name , Surname , Age , Specialization , Qualify , Number;
   JButton assign , cancel;
   private Doctor_Database doctor;
   private Client_Database client;
   private String [][] data1;
   private String [][] data2;
   
   public Assign_New_Doctor( Doctor_Database doctor_data , Client_Database client_data , String [][] data , String [][] dataa){
      
      data1 = data;
      data2 = dataa;
      doctor = doctor_data;
      client = client_data; 
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.white);
      panel.setBounds(0,0,370,260);
      
      assign = new JButton("Assign");
      assign.addActionListener(this);
      assign.setBackground(E_Health_Writer.BUTTON);
      assign.setBounds(255,185,95,30);
   
      cancel = new JButton("Cancel");
      cancel.addActionListener(this);
      cancel.setBackground(E_Health_Writer.BUTTON);
      cancel.setBounds(150,185,95,30);
   
      JLabel label_username = new JLabel("Set Username : ");
      JLabel label_password = new JLabel("Set Password : ");
      JLabel label_name = new JLabel("Name : ");
      JLabel label_surname = new JLabel("Surname : ");
      JLabel label_age = new JLabel("Age : ");
      JLabel label_specialization = new JLabel("Specialization : ");
      JLabel label_qualify = new JLabel("Qualify : ");
      JLabel label_number = new JLabel("Phone Number : ");
   
   //initialize the TextFields
      Username = new JTextField();
      Password = new JTextField();
      Name = new JTextField();
      Surname = new JTextField();
      Age = new JTextField();
      Specialization = new JTextField();
      Qualify = new JTextField();
      Number = new JTextField();
   
   //TextField coordinates
      Username.setBounds(150,20,200,20);
      Password.setBounds(150,40,200,20);
      Name.setBounds(150,60,200,20);
      Surname.setBounds(150,80,200,20);
      Age.setBounds(150,100,200,20);
      Specialization.setBounds(150,120,200,20);
      Qualify.setBounds(150,140,200,20);
      Number.setBounds(150,160,200,20);
   
   
   //labels coordinates
      label_username.setBounds(20,20,200,20);
      label_password.setBounds(20,40,200,20);
      label_name.setBounds(20,60,200,20);
      label_surname.setBounds(20,80,200,20);
      label_age.setBounds(20,100,200,20);
      label_specialization.setBounds(20,120,200,20);
      label_qualify.setBounds(20,140,200,20);
      label_number.setBounds(20,160,200,20);
   
   //add labels
      frame.add(label_name);
      frame.add(label_surname);
      frame.add(label_age);
      frame.add(label_specialization);
      frame.add(label_qualify);
      frame.add(label_username);
      frame.add(label_password);
      frame.add(label_number);
   
   //add the TextFields
      frame.add(Name);
      frame.add(Surname);
      frame.add(Age);
      frame.add(Number);
      frame.add(Specialization);
      frame.add(Qualify);
      frame.add(Username);
      frame.add(Password);
   
   //add buttons
      frame.add(assign);
      frame.add(cancel);
      
      frame.add(panel);
   
      frame.setSize(370,260);
      frame.setLayout(null);
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
   
   }

   public void actionPerformed(ActionEvent e){
   
      if(e.getSource() == assign){
         String username = Username.getText().toLowerCase().trim();
         String password = Password.getText();
         String name = Name.getText();
         String surname = Surname.getText();
      //int numri = new Integer(nr).intValue();
         int age = Integer.parseInt(Age.getText());
         String specialization = Specialization.getText();
         String qualify = Qualify.getText();
         String number = Number.getText();
      
         Key k = new Key(username,password);
         String k1 = k.getUsername();
         String k2 = k.getPassword();
         doctor.insert(new Doctor_Record(k ,name , surname , age , specialization , qualify , number));
         frame.setVisible(false);
         new Administrator_Clients(client , doctor , data1 , data2);
      }
      else{ 
         frame.setVisible(false);
         new Administrator_Clients(client , doctor , data1 , data2);
      }
   
   }
}