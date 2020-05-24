//Record the Doctors of a Hospital
public class Doctor_Record{

//we get the doctors info by these private variables
   private Key LogIn_Key;
   private String Doctor_Name;
   private String Doctor_Surname;
   private int Doctor_Age;
   private String Doctor_Specialization;
   private String Doctor_Qualify;
   private String Phone_Number;

/* *Constructor Doctor_Record costructs the doctors info
   *@param k - the Doctor's log in info
   *@param dn - doctor name;
   *@param ds - doctor surname;
   *@param da - doctor age
   *@param dsc - Doctor specialization
   *@param dq - doctor qualify */

   public Doctor_Record(Key k , String dn , String ds ,int da, String dsc , String dq , String nr){
      LogIn_Key = k;
      Doctor_Name = dn;
      Doctor_Surname = ds;
      Doctor_Age = da;
      Doctor_Specialization = dsc;
      Doctor_Qualify = dq;
      Phone_Number = nr;
   }

/* *getKey returns the key that identifies the doctor */
   public Key getKey(){ 
      return LogIn_Key; }
   public String getName(){ 
      return Doctor_Name; }                       //return the Doctor's Name
   public String getSurname(){ 
      return Doctor_Surname; }                 //return the Doctor's Username
   public int getAge(){ 
      return Doctor_Age; }                            //return the Doctor's Age
   public String getSpecialization(){ 
      return Doctor_Specialization; }   //return the Doctor's Specialization
   public String getQualify(){ 
      return Doctor_Qualify; }                 //return the Doctor's Qualify
   public String getPhoneNumber(){
      return Phone_Number;                      //return the Doctor's Phone Number
   }

}