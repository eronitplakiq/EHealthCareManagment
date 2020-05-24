import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* *Client_info show's client's info based on it's key user logged in */

public class Client_info extends JPanel implements ActionListener{

   JFrame frame = new JFrame("Client (Your Info)");   //Client_Info frame
   JLabel Name , Doctor , Hour_Visit , Diagnose , Therapy , Day_Visit , Charge;    //Client;s info labels

   private Client_Database client_d;
   private Doctor_Database doctor;
   private String [][] data1;
   private String [][] data2;
   
/*Constructor Client_info construcs a JFrame with client's info
   *@param client - takes the info's based on its client's record */
   public Client_info( Client_Record client , Client_Database client_data , Doctor_Database doctor_data , String [][] data , String [][] dataa)
   {
      
      data1 = data;
      data2 = dataa;
      client_d = client_data;
      doctor = doctor_data;
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.white);
      panel.setBounds(0,0,800,800);
            
      JButton Back_button = new JButton("Log out");         //by this button the user log out
   
      Back_button.setBackground(E_Health_Writer.BUTTON);    //butotn's background color
      Back_button.setBounds(210,210,80,30);                 //coordinates of button
   
      Name = new JLabel("  " + client.getName() + " " + client.getSurname() + "(" + client.getKey().getUsername() + ")");  //show the client's name and username
      Doctor = new JLabel(client.getDoctor());                      //Doctor's name
      Hour_Visit = new JLabel(client.getVisit());         //Time the Doctor visits the patient
      Diagnose = new JLabel(client.getDiagnose());          //Diagnose of patient
      Therapy = new JLabel(client.getTherapy());            //Therapy of patient
      Day_Visit = new JLabel(client.getDate());             //Date the client started the treatment in the hospital
      Charge = new JLabel("Your charge : " + client.getCharge());
   
   //Labels for client;s info
      JLabel Logged_In = new JLabel("You are logged in as :");
      JLabel label_Doctor = new JLabel("Your Doctor : ");
      JLabel label_Doctor_visit = new JLabel("Doctor visits you at : ");
      JLabel label_Diagnose = new JLabel("Your diagnose : ");
      JLabel label_Your_Therapy = new JLabel("Your Therapy :");
      JLabel label_Day_Visit = new JLabel("Date you entered : ");
   
   //Label's client info's taken from Client Record coordinates
      Name.setBounds(145,20,170,20);      Name.setOpaque(true);    Name.setBackground(Color.cyan);
      Doctor.setBounds(150,70,200,20);
      Hour_Visit.setBounds(150,90,200,20);
      Diagnose.setBounds(150,110,200,20);
      Therapy.setBounds(150,130,200,20);
      Day_Visit.setBounds(150,150,200,20);
      Charge.setBounds(25,190,200,20);
   
   //label's for client's info coordinates
      Logged_In.setBounds(20,20,120,20);
      label_Doctor.setBounds(25,70,300,20);
      label_Doctor_visit.setBounds(25,90,300,20);
      label_Diagnose.setBounds(25,110,300,20);
      label_Your_Therapy.setBounds(25,130,300,20);
      label_Day_Visit.setBounds(25,150,300,20);
   
      Back_button.addActionListener(this);   //we add the actionListener to button log_out
   
   //add the labels to the frame
      frame.add(Logged_In);
      frame.add(label_Doctor);
      frame.add(label_Doctor_visit);
      frame.add(label_Diagnose);
      frame.add(label_Your_Therapy);
      frame.add(label_Day_Visit);
   
   //add the button to the frame
      frame.add(Back_button);
   
   //add the info to the frame
      frame.add(Name);
      frame.add(Doctor);
      frame.add(Hour_Visit);
      frame.add(Therapy);
      frame.add(Diagnose);
      frame.add(Day_Visit);
      frame.add(Charge);
      
      frame.add(panel);
      
   //set frame actions
      frame.setSize(350,300);  //frame size
      frame.setLayout(null);
      frame.setLocationRelativeTo(null); //set the frame in the middle of window
      frame.setVisible(true); //frame visible
      frame.setResizable(false); //frame not resizable
   
   }

//if button "Log Out" is performed user log out
   public void actionPerformed(ActionEvent e){
      frame.setVisible(false);
      new E_Health_Writer(client_d , doctor , data1 ,data2);
   }

}