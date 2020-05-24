/* *Client_Record record the clients of a hospital */

public class Client_Record{

//Client's info
   private Key Client_Key;
   private String Client_Doctor;
   private String Client_Name;
   private String Client_Surname; 
   private String Client_Date;
   private String Client_Therapy;
   private String Client_Visit;
   private String Client_Diagnose;
   private int Client_Charge;
   private int Client_Bed;
   
/* *Constructor Client_Record construct the client info
   *@param k - the client's log in info
   *@param n - the client's name
   *@param s - the client's surname
   *@param id - the id and password of client
   *@param d - the clients diagnose
   *@param th - therapy of client
   *@param v - the time doctor visit's the client
   *@param ch - the client's chare(how much he owe to hospital  */
   public Client_Record(Key k , String doctor , String name , String sname , String day , String diagnose, String therapy , String visit , int charge , int bed){
      Client_Key = k;
      Client_Doctor = doctor;
      Client_Name = name;
      Client_Surname = sname;
      Client_Date = day;
      Client_Diagnose = diagnose;
      Client_Therapy = therapy;
      Client_Visit = visit;
      Client_Charge = charge;
      Client_Bed = bed;
   }

   public Key getKey(){ 
      return Client_Key; }                  //return the client's Key
   public String getDoctor(){
      return Client_Doctor; }
   public String getName(){ 
      return Client_Name; }              //return the client's Name 
   public String getSurname(){ 
      return Client_Surname; }        //return the clint's Surname
   public String getDate(){ 
      return Client_Date; }                //return the client;s date he entered in hospital 
   public String getDiagnose(){ 
      return Client_Diagnose; }      //return the client's Diagnose
   public String getTherapy(){ 
      return Client_Therapy; }        //return the client;s therapy
   public String getVisit(){ 
      return Client_Visit; }            //return the client's time when Doctor visit him
   public String getCharge(){ 
      return Client_Charge + " $"; }   //return the client's charge by hospital
   public int getBed(){
      return Client_Bed; }
      
   public boolean sameBed(Client_Record cr){
      int b = cr.getBed();
      return b == Client_Bed;
   }
}