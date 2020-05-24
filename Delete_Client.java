import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Delete_Client extends JPanel implements ActionListener{

   private Client_Database client;
   private Doctor_Database doctor;
   private String [][] data1;
   private String [][] data2;
   
   JFrame frame = new JFrame("Delete Client");
   JTextField Username , Password;
   JButton Cancel , Delete;

   public Delete_Client(Client_Database client_data, Doctor_Database doctor_data, String [][] data , String [][] dataa){
      
      data1 = data;
      data2 = dataa;
      client = client_data;
      doctor = doctor_data;
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.white);
      panel.setBounds(0,0,400,300);
      
      String [] patients = client.PatientsKeys();   //patients keys
      String [] doctors = doctor.DoctorsKeys();     //doctors keys
      
      JLabel info = new JLabel("<html>Write down the username and password of client <br>            you want to remove.</html>");
      info.setBounds(60,85,500,40);
      
      JLabel label_patients = new JLabel("Patients :");
      JLabel label_doctors = new JLabel("Doctors :");
      JLabel label_username = new JLabel("Username : ");
      JLabel label_password = new JLabel("Password : ");
      label_patients.setBounds(20,20,200,20);
      label_doctors.setBounds(20,50,200,20);
      label_username.setBounds(45,130,200,20);
      label_password.setBounds(45,155,200,20);
   
      JComboBox ComboBox_patients = new JComboBox(patients); //initialize combobox
      ComboBox_patients.setBounds(85,20,300,20); //combobx location
      JComboBox ComboBox_doctors = new JComboBox(doctors); //initaialize combobox
      ComboBox_doctors.setBounds(85,50,300,20); //combobox location
   
   //initialze buttons
      Cancel = new JButton("Cancel");
      Delete = new JButton("Delete");
      
      //buttons background color
      Cancel.setBackground(E_Health_Writer.BUTTON);
      Delete.setBackground(E_Health_Writer.BUTTON);
   
   //initialize TextFields
      Username = new JTextField();
      Password = new JTextField();
   
   //TextField locations
      Username.setBounds(120,130,200,20);
      Password.setBounds(120,155,200,20);
   
   //button locations and add ActionListener
      Cancel.setBounds(120,190,95,30);             Cancel.addActionListener(this);
      Delete.setBounds(220,190,100,30);            Delete.addActionListener(this);
   
   //add labels to frame
      frame.add(label_patients);
      frame.add(label_doctors);
      frame.add(label_username);
      frame.add(label_password);
      frame.add(info);
   
   //add ComboBoxes to frame
      frame.add(ComboBox_patients);
      frame.add(ComboBox_doctors);
   
   //add buttons to frame
      frame.add(Cancel);
      frame.add(Delete);
   
   //add TextFields to frame
      frame.add(Username);
      frame.add(Password);
   
      frame.add(panel);
   
   //frame contents
      frame.setSize(400,300);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   
   }

   public void actionPerformed(ActionEvent e){
   
      if(e.getSource() == Cancel){
         frame.setVisible(false);
         new Administrator_Clients(client , doctor , data1 , data2);
      }
      
      else{
      
         String username = Username.getText();
         String password = Password.getText();
      
         Key k = new Key(username , password);
      
         if(client.find(k) != null){
            client.delete(k);
            frame.setVisible(false);
            new Administrator_Clients(client , doctor , data1 , data2);
         }
         else if(doctor.find(k) != null){
            doctor.delete(k);
            frame.setVisible(false);
            new Administrator_Clients(client , doctor , data1 , data2);
         }
         else if(client.find(k) == null && doctor.find(k) == null){
            JOptionPane.showMessageDialog(null , "There is no client with these info's");
         }
      }
   }
}