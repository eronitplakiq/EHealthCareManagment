import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Administrator_Clients extends JPanel implements ActionListener{

   private Client_Database client;
   private Doctor_Database doctor;
   private String [][] data1;
   private String [][] data2;
   
   JFrame frame = new JFrame("Staff ( Clients )");
   JButton Back , Assign_Doctor , Assign_Patient , Delete_Client;

   public Administrator_Clients(Client_Database client_data , Doctor_Database doctor_data, String [][] data , String [][] dataa){
      
      data1 = data;
      data2 = dataa;
      client = client_data;
      doctor = doctor_data;
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.white);
      panel.setBounds(0,0,285,300);
      
      String [] patients = client.allPatients();      //an array that contains all the patients info
   
      JComboBox ComboBox_patients = new JComboBox(patients);   //this combobox show the array with the patient;s info
      ComboBox_patients.setBounds(90,20,500,20);   //cobobox location
         
      JLabel label_patients = new JLabel("Patients :");  
      label_patients.setBounds(20,20,100,20);
      
      JLabel label_doctors = new JLabel("Doctors :");
      label_doctors.setBounds(20,50,100,20);
      
      JLabel bug = new JLabel(); //a label to fix a bug
      
      String [] doctors = doctor.allDoctors();  //an array that contains all the doctors info
      
      JComboBox ComboBox_doctors = new JComboBox(doctors);  //this combobox show the array with the doctor's info
      ComboBox_doctors.setBounds(90,50,500,20);    //combobox location
      
      //we initialize the buttons
      Back = new JButton("Back");
      Assign_Patient = new JButton("Assign Patient");
      Assign_Doctor = new JButton("Assign Doctor");
      Delete_Client = new JButton("Delete Client");
      
      //Buttons background Color
      Back.setBackground(E_Health_Writer.BUTTON);
      Assign_Patient.setBackground(E_Health_Writer.BUTTON);
      Assign_Doctor.setBackground(E_Health_Writer.BUTTON);
      Delete_Client.setBackground(E_Health_Writer.BUTTON);
      
      //buttons locations
      Back.setBounds(5,220,143,30);
      Assign_Doctor.setBounds(153,220, 144,30);
      Assign_Patient.setBounds(302,220,143,30);
      Delete_Client.setBounds(451,220,144,30);
      
      //add labels to frame
      frame.add(label_patients);
      frame.add(label_doctors);
      
      //add buttons to frame and add ActionListener to buttons
      frame.add(Back);                 Back.addActionListener(this);
      frame.add(Assign_Doctor);        Assign_Doctor.addActionListener(this);
      frame.add(Assign_Patient);       Assign_Patient.addActionListener(this);
      frame.add(Delete_Client);        Delete_Client.addActionListener(this);
      
      //add comboboxes to frame
      frame.add(ComboBox_patients);
      frame.add(ComboBox_doctors);
      
      frame.add(panel);
      
      //frame 
      frame.setSize(605,300);
      frame.setVisible(true);
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
   
   }
   
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == Back){
         frame.setVisible(false);
         new Logged_in_as_Administrator(client , doctor , data1 , data2);
      }
      else if(e.getSource() == Assign_Doctor){
         frame.setVisible(false);
         new Assign_New_Doctor(doctor , client , data1 , data2);
      }
      else if(e.getSource() == Assign_Patient){
         frame.setVisible(false);
         new Assign_New_Patient_Admin(client , doctor , data1 , data2);
      }
      else{
         frame.setVisible(false);
         new Delete_Client(client, doctor , data1 , data2);
      }
   }
}