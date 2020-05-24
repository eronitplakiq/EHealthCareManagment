import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Shifts extends JPanel implements ActionListener{

   JFrame frame;
   JButton Back , DeleteAll , CreateMore;
   private String [][] shifts;
   private boolean b1;
   
   public Shifts(String [][] oc , boolean b){
      
      b1 = b;
      shifts = oc;      
      JPanel panel = new JPanel();
      panel.setBackground(Color.white);
      panel.setBounds(0,0,665,400);
      
      frame = new JFrame("Shifts");
      String [] shift_info = {"Shift 1" , "Shift 2" , "Shift 3"};
   
   //String [][] operation_clients = new String[30][7];
      JTable table = new JTable(shifts , shift_info);
      JScrollPane scroll = new JScrollPane(table);
      scroll.setBounds(20,20,345,343);
   
   //initialize Back button
      Back = new JButton("Back");
      Back.setBackground(E_Health_Writer.BUTTON);
      Back.setBounds(145,370,100,30);
      Back.addActionListener(this);
   
      //initialize Delete All button
      DeleteAll = new JButton("Delete All");
      DeleteAll.setBackground(E_Health_Writer.BUTTON);
      DeleteAll.addActionListener(this);
      DeleteAll.setBounds(255,370,100,30);
      DeleteAll.setVisible(b);
      
      //initialize Create More Button
      CreateMore = new JButton("More Space");
      CreateMore.setBackground(E_Health_Writer.BUTTON);
      CreateMore.addActionListener(this);
      CreateMore.setBounds(25,370,110,30);
      CreateMore.setVisible(b);
      
   //add the Table to frame
      frame.add(scroll);
   
   //add the buttons to the frame
      frame.add(Back);
      frame.add(DeleteAll);
      frame.add(CreateMore);

      //add panel to frame
      frame.add(panel);
   
   //frame contents
      frame.setSize(400,450);
      //frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   
   }

   public void actionPerformed(ActionEvent e){
   
      if(e.getSource() == Back){
         frame.setVisible(false);
      }
      else if(e.getSource() == DeleteAll){
      frame.setVisible(false);
      for(int i = 0 ; i != shifts.length ; i++){
      for(int j = 0 ; j != shifts[0].length ; j++){
      shifts[i][j] = null;
      }
      }
      new Shifts(shifts , b1);
      }
      else if(e.getSource() == CreateMore){
      frame.setVisible(false);
      String [][] shifts_temp = new String[shifts.length * 2][shifts[0].length];
      for(int i = 0 ; i != shifts.length ; i++){
      for(int j = 0 ; j != shifts[0].length ; j++){
      shifts_temp[i][j] = shifts[i][j];
      }
      }
      new Shifts(shifts_temp , b1);
      }
   
   }

   public static void main(String[] args){
   
      String [][] data = new String[20][7];
   
      new Shifts(data , false);
   
   }

}