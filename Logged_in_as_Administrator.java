import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Logged_in_as_Administrator extends JPanel implements ActionListener{

   JFrame admin_frame;
   JButton shift_button , operation_button , clients_button ,  sign_out_button;

   private Client_Database client;
   private Doctor_Database doctor;
   private String [][] data1;
   private String [][] data2;
   
   E_Health_Writer e_health;

/*-----------------------------------------------------------------*/

/*------------------------------------------------------------------*/

   Logged_in_as_Administrator(Client_Database client_data , Doctor_Database doctor_data , String [][] data , String [][] dataa){
      
      data1 = data;
      data2 = dataa;
      client = client_data;
      doctor = doctor_data;
   
   /*---------------------------------------------------
   -------------------------------------------------------
   ----------------------------------------------------- */

   /*----------------------------------------------------------------
   --------------------------------------------------------------
   ------------------------------------------------------------------*/
   
      int frame_width = 270; //frame width
      int frame_height = 300; //frame height
      int button_width = 120; //width of buttons
      
      
      JPanel panel = new JPanel();
      panel.setBounds(0,0,frame_width, frame_height);
      panel.setBackground(Color.white);
      
   //creates the frame with it's name
      admin_frame = new JFrame("Administrator");
   
      JLabel label_log_in = new JLabel(" You are logged in as administrator.");         //create a label to help the user
      JLabel label_perform = new JLabel("Choose the action you want to perform :");    //create a label to help the user
      JLabel no_label = new JLabel("");
   
      label_log_in.setBounds(20,10,230,20);     //set the location of log_in label
      label_log_in.setOpaque(true);          label_log_in.setBackground(E_Health_Writer.BUTTON);
      label_log_in.setFont(new Font("Arial" , Font.PLAIN , 15));
      label_perform.setBounds(20,50,275,20);    //set the location of perform label
      
   //creating buttons with their names
      shift_button = new JButton("Shifts");
      operation_button = new JButton("Operations");
      clients_button = new JButton("Clients");
      sign_out_button = new JButton("Sign out");
   
   //we set the button's locations
      shift_button.setBounds((frame_width - button_width)/2,85,button_width,30);
      operation_button.setBounds((frame_width - button_width)/2, 120 , button_width , 30);
      clients_button.setBounds((frame_width - button_width)/2, 155 , button_width , 30);
      sign_out_button.setBounds((frame_width - button_width)/2 , 190 , button_width, 30);
   
   //now we set the background color of buttons ; and we add ActionListener
      shift_button.setBackground(E_Health_Writer.BUTTON);            shift_button.addActionListener(this);
      sign_out_button.setBackground(E_Health_Writer.BUTTON);         sign_out_button.addActionListener(this);
      clients_button.setBackground(E_Health_Writer.BUTTON);          clients_button.addActionListener(this);
      operation_button.setBackground(E_Health_Writer.BUTTON);        operation_button.addActionListener(this);
   
   //now add the buttons to the frame
      admin_frame.add(shift_button); 
      admin_frame.add(operation_button); 
      admin_frame.add(clients_button);
      admin_frame.add(sign_out_button);
   
   //add's the label to the frame
      admin_frame.add(label_log_in);
      admin_frame.add(label_perform);
      admin_frame.add(no_label);
      admin_frame.add(panel);
      
    //frame contens   
      admin_frame.setSize(frame_width,frame_height);
      admin_frame.setVisible(true);
      admin_frame.setResizable(false);
      admin_frame.setLocationRelativeTo(null);
   
   }

   public void actionPerformed(ActionEvent e){
   
      if(e.getSource() == sign_out_button){
         admin_frame.setVisible(false);
         e_health = new E_Health_Writer(client ,doctor , data1 , data2);
      }
      
      else if(e.getSource() == clients_button){
         admin_frame.setVisible(false);
         new Administrator_Clients(client, doctor , data1 , data2);
      }
      else if(e.getSource() == shift_button){
         new Shifts(data2 , true);
      }
      else if(e.getSource() == operation_button){
      new Operation(data1 , true);
      }
   }

}