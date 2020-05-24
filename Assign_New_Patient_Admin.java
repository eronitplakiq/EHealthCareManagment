import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Assign_New_Patient_Admin extends JPanel implements ActionListener{

   JFrame frame = new JFrame("Assign New Patient");
   JTextField Username ,Password , Name , Surname , Date , Diagnose , Therapy , Visit , Charge , Bed , Doctor;
   JButton assign , cancel;
   private Client_Database client;
   private Doctor_Database doctor;
   private String [][] data1;
   private String [][] data2;
   
   public Assign_New_Patient_Admin(Client_Database client_data , Doctor_Database doctor_data , String [][] data , String [][] dataa){
      
      JPanel panel = new JPanel();
      panel.setBackground(new Color(255,255,255));
      panel.setBounds(0,0,800,800);
      
      data1 = data;
      data2 = dataa;
      client = client_data;
      doctor = doctor_data;
      
      assign = new JButton("Assign");
      assign.addActionListener(this);
      assign.setBackground(E_Health_Writer.BUTTON);
      assign.setBounds(255,245,95,30);
   
      cancel = new JButton("Cancel");
      cancel.addActionListener(this);
      cancel.setBackground(E_Health_Writer.BUTTON);
      cancel.setBounds(150,245,95,30);
      
      JLabel label_doctor = new JLabel("Doctor Name : ");
      JLabel label_username = new JLabel("Set Username : ");
      JLabel label_password = new JLabel("Set Password : ");
      JLabel label_name = new JLabel("Name : ");
      JLabel label_surname = new JLabel("Surname : ");
      JLabel label_Date = new JLabel("Date patient entered : ");
      JLabel label_Diagnose = new JLabel("Diagnose : ");
      JLabel label_therapy = new JLabel("Therapy : ");
      JLabel label_visit = new JLabel("Doctor visit him at : ");
      JLabel label_charge = new JLabel("Patient Charge($) : ");
      JLabel label_bed = new JLabel("Set Patient's Bed : ");
   
   //initialize the TextFields
   Doctor = new JTextField();
      Name = new JTextField();
      Surname = new JTextField();
      Date = new JTextField();
      Diagnose = new JTextField();
      Therapy = new JTextField();
      Visit = new JTextField();
      Username = new JTextField();
      Password = new JTextField();
      Charge = new JTextField();
      Bed = new JTextField();
   
   //TextField coordinates
   Doctor.setBounds(150,20,200,20);
      Username.setBounds(150,40,200,20);
      Password.setBounds(150,60,200,20);
      Name.setBounds(150,80,200,20);
      Surname.setBounds(150,100,200,20);
      Date.setBounds(150,120,200,20);
      Diagnose.setBounds(150,140,200,20);
      Therapy.setBounds(150,160,200,20);
      Visit.setBounds(150,180,200,20);
      Charge.setBounds(150,220,200,20);
      Bed.setBounds(150,200,200,20);
   
   
   //labels coordinates
      label_doctor.setBounds(20,20,200,20);
      label_username.setBounds(20,40,200,20);
      label_password.setBounds(20,60,200,20);
      label_name.setBounds(20,80,200,20);
      label_surname.setBounds(20,100,200,20);
      label_Date.setBounds(20,120,200,20);
      label_Diagnose.setBounds(20,140,200,20);
      label_therapy.setBounds(20,160,200,20);
      label_visit.setBounds(20,180,200,20);
      label_charge.setBounds(20,220,200,20);
      label_bed.setBounds(20,200,200,20);
   
   //add labels
   frame.add(label_doctor);
      frame.add(label_name);
      frame.add(label_surname);
      frame.add(label_Date);
      frame.add(label_visit);
      frame.add(label_therapy);
      frame.add(label_username);
      frame.add(label_password);
      frame.add(label_Diagnose);
      frame.add(label_charge);
      frame.add(label_bed);
   
   //add the TextFields
   frame.add(Doctor);
      frame.add(Name);
      frame.add(Surname);
      frame.add(Date);
      frame.add(Visit);
      frame.add(Diagnose);
      frame.add(Therapy);
      frame.add(Username);
      frame.add(Password);
      frame.add(Charge);
      frame.add(Bed);
   
   //add buttons
      frame.add(assign);
      frame.add(cancel);
      
      frame.add(panel);
   
      frame.setSize(370,320);
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
         String date = Date.getText();
         String diagnose = Diagnose.getText();
         String therapy = Therapy.getText();
         String visit = Visit.getText();
         int charge = Integer.parseInt(Charge.getText());
         int bednr = Integer.parseInt(Bed.getText());
      
         Key k = new Key(username,password);
         String k1 = k.getUsername();
         String k2 = k.getPassword();
         client.insert(new Client_Record(k , Doctor.getText() ,name , surname , date , diagnose , therapy , visit , charge , bednr));
         frame.setVisible(false);
         new Administrator_Clients(client , doctor,data1 ,data2);
      }
      else{ 
         frame.setVisible(false);
         new Administrator_Clients(client,doctor,data1 , data2);
      }
   
   }
   
   public String newPatient(){
   return Username.getText();
   }
}