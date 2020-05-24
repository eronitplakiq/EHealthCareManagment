import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Doctor extends JPanel implements ActionListener{

   JFrame doctor_frame = new JFrame("Doctor Managment");
   
   JButton button_assign_new_Patient , Log_Out , Watch_Operations , Shifts;
   
   private Client_Database client;
   private Doctor_Database doctor_data;
   private Doctor_Record doctor;
   private String [][] data1;
   private String [][] data2;
   
   public Doctor(Client_Database client_data, Doctor_Database doctor_d , Doctor_Record doctor_rec , String [][] data , String [][] dataa){
      
      data1 = data;
      data2 = dataa;
      doctor_data = doctor_d;
      client = client_data;
      doctor = doctor_rec;
      
      String s = "";
      String s1 = doctor.getName() + " " + doctor.getSurname();
      
      System.out.println(s1);
      
      for(int i = 0; i < data2.length - 1 ; i++){
      System.out.println(data2[i][0]);
      if(data2[i][0].equals(s1)){s = "Shift 1"; break;}
      else{System.out.println("Ask the Manager");break;}
      }
      
      JLabel shift = new JLabel("Your Shift  :  " + s);
      shift.setBounds(100,135,250,20);
      shift.setFont(new Font("Arial" , Font.PLAIN ,  15));
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.white);
      panel.setBounds(0,0,530,400);
      
      JLabel week = new JLabel("This week for you :");
      week.setBounds(80,110,250,20);
      week.setFont(new Font("Arial" , Font.ITALIC , 20));
      
      String [] patients;
      String name = doctor.getName() + " " + doctor.getSurname();
      patients = client.Patients(name);
      //patients = client.addPatient();
      
      JComboBox cb = new JComboBox(patients);
      cb.setBounds(80,60,400,20);
      
      JLabel label_log_in = new JLabel("You are logged in as : ");
      JLabel label_info = new JLabel("  " + doctor.getName() + " " + doctor.getSurname() + " ( " + doctor.getKey().getUsername() + " )");
      
      label_log_in.setBounds(20,25,200,20);
      label_info.setBounds(145,25,180,20);       label_info.setOpaque(true);      label_info.setBackground(Color.cyan);
      
      JLabel label_patients = new JLabel("Patients :");
   
      button_assign_new_Patient = new JButton("Assign new Patient");
      button_assign_new_Patient.addActionListener(this);
      button_assign_new_Patient.setBackground(E_Health_Writer.BUTTON);
      button_assign_new_Patient.setBounds(260,300,150,30);
      
      Watch_Operations = new JButton("Watch Operations");
      Watch_Operations.addActionListener(this);
      Watch_Operations.setBackground(E_Health_Writer.BUTTON);
      Watch_Operations.setBounds(115,300,140,30);
      
      Log_Out = new JButton("Log Out");
      Log_Out.addActionListener(this);
      Log_Out.setBackground(E_Health_Writer.BUTTON);
      Log_Out.setBounds(415,300,80,30);
      
      Shifts = new JButton("Shifts");
      Shifts.addActionListener(this);
      Shifts.setBackground(E_Health_Writer.BUTTON);
      Shifts.setBounds(30,300,80,30);
      
      label_patients.setBounds(15,60,100,20);
      
   //add buttons to the frame
      doctor_frame.add(button_assign_new_Patient);
      doctor_frame.add(Log_Out);
      doctor_frame.add(Watch_Operations);
      doctor_frame.add(Shifts);
      
   //add labels to the frame
      doctor_frame.add(label_patients);
      doctor_frame.add(label_info);
      doctor_frame.add(label_log_in);
      doctor_frame.add(week);
      doctor_frame.add(shift);
      
      //add the checkbox
      doctor_frame.add(cb); 
      doctor_frame.add(panel);
   
      doctor_frame.setLayout(null);
      doctor_frame.setSize(530,400);
      doctor_frame.setResizable(false);
      doctor_frame.setLocationRelativeTo(null);
      doctor_frame.setVisible(true);
   
   }

   public void actionPerformed(ActionEvent e){
   
      if(e.getSource() == button_assign_new_Patient){
      doctor_frame.setVisible(false);
         new Assign_New_Patient(client , doctor_data , doctor , data1 , data2);
      }
      else if(e.getSource() == Log_Out){
      doctor_frame.setVisible(false);
      new E_Health_Writer(client , doctor_data , data1 ,data2);
      }
      else if(e.getSource() == Watch_Operations){
         new Operation(data1 , false);
      }
      else if(e.getSource() == Shifts){
         new Shifts(data2 , false);
      }
   }
}