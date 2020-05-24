import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Operation extends JPanel implements ActionListener{

   JFrame frame;
   JButton Back , DeleteAll , CreateMore;
   private String [][] operation_clients;
   private boolean b1;

   public Operation(String [][] oc , boolean b){
   
      operation_clients = oc;
      b1 = b;
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.white);
      panel.setBounds(0,0,665,400);
      
      frame = new JFrame("Operations");
   
      JLabel label_operations = new JLabel("Active Operations : ");
      label_operations.setFont(new Font("Arial" , Font.BOLD, 18));
      label_operations.setBounds(45,20,200,20);
   
      String [] operation_info = {"Theater" , "Operation Type" , "Patient Name" , "Doctor" , "Assistant" , "Date" , "Time" };
   
   //String [][] operation_clients = new String[30][7];
      JTable table = new JTable(operation_clients , operation_info);
      JScrollPane scroll = new JScrollPane(table);
      scroll.setBounds(10,50,640,215);
   
   
   //initialize Back button
      Back = new JButton("Back");
      Back.setBackground(E_Health_Writer.BUTTON);
      Back.setBounds(385,275,100,30);
      Back.addActionListener(this);
      if(b==false){ Back.setBounds(270,275,100,30); }
   
      //initialize DeleteAll button
      DeleteAll = new JButton("Delete All");
      DeleteAll.setBackground(E_Health_Writer.BUTTON);
      DeleteAll.addActionListener(this);
      DeleteAll.setBounds(155,275,100,30);
      DeleteAll.setVisible(b);
      
      //initialize CreateMore button
      CreateMore = new JButton("More Space");
      CreateMore.setBackground(E_Health_Writer.BUTTON);
      CreateMore.addActionListener(this);
      CreateMore.setBounds(265,275,110,30);
      CreateMore.setVisible(b);
      
   //add the labels to the frame
      frame.add(label_operations);
   
   //add the Table to frame
      frame.add(scroll);
   
   //add the buttons to the frame
      frame.add(Back);
      frame.add(DeleteAll);
      frame.add(CreateMore);
      
   //create and add a icon in the frame
      ImageIcon icon = new ImageIcon("bed.png");
      JLabel label_icon = new JLabel(icon);
      label_icon.setBounds(0,0,50,50);
      frame.add(label_icon);

      //add panel to frame
      frame.add(panel);
   
   //frame contents
      frame.setSize(665,360);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   
   }

   public void actionPerformed(ActionEvent e){
   
      if(e.getSource() == Back){
         frame.setVisible(false);
      }
      else if(e.getSource() == DeleteAll){
      frame.setVisible(false);
      for(int i = 0 ; i != operation_clients.length ; i++){
      for(int j = 0 ; j != operation_clients[0].length ; j++){
      operation_clients[i][j] = null;
      }
      }
      new Operation(operation_clients , b1);
      }
      else if(e.getSource() == CreateMore){
      frame.setVisible(false);
      String [][] operations_temp = new String[operation_clients.length * 2][operation_clients[0].length];
      for(int i = 0 ; i != operation_clients.length ; i++){
      for(int j = 0 ; j != operation_clients[0].length ; j++){
      operations_temp[i][j] = operation_clients[i][j];
      }
      }
      new Operation(operations_temp , b1);
      }
   
   }

   public static void main(String[] args){
   
      String [][] data = new String[12][7];
   
      new Operation(data , true);
   
   }

}