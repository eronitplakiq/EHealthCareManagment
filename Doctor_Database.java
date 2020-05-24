/** Class Doctor_Database is a container that contains doctor's infos */
public class Doctor_Database{

   private Doctor_Record [] Doctors;
   private int NOT_FOUND = -1;

/*Constructor Doctor_Database initializies the database
   *@param initial_size - the initial database size */
   public Doctor_Database(int initial_size){
      if(initial_size > 0){ Doctors = new Doctor_Record[initial_size];}
      else{ Doctors = new Doctor_Record[1]; }
   }

/* *findLocation is a helper method that searches for Doctors record
   *whose key is k. If found , the index of record is returned if not
   * NOT_FOUND is returned */
   public int findLocation(Key k){
      int result = NOT_FOUND;
      boolean found = false;
      int i = 0;
      while(!found && i < Doctors.length){
         if(Doctors[i] != null && Doctors[i].getKey().equals(k)){
            found = true;
            result = i;
         }
         else{ i++; }
      }
      return result;
   }

/* *find is a method taht locates a record in Doctors by it's Key
   *@param key - the key of desired Record
   *@return the address of wanted record , return null otherwise */
   public Doctor_Record find(Key key){
      Doctor_Record doctor = null;
      int index = findLocation(key);
      if( index != NOT_FOUND){
         doctor = Doctors[index];
      }
      return doctor;
   }

/* *insert inserts a record on the database
   *@param r - Record
   *@return true if record is added successfully into the database , false otherwise */
   public boolean insert(Doctor_Record dr){
      boolean success = false;
      if(findLocation(dr.getKey()) == NOT_FOUND){
         boolean found_empty_element = false;
         int i = 0;
         while(!found_empty_element && i < Doctors.length){
            if( Doctors[i] == null){ found_empty_element = true; }
            else { i++; }
         }
         if(found_empty_element){
            Doctors[i] = dr;
         }
         else{
            Doctor_Record [] temp = new Doctor_Record[Doctors.length+1];
            for(int j = 0; j < Doctors.length ; j++){
               temp[j] = Doctors[j];
            }
            temp[Doctors.length] = dr;
            Doctors = temp;
         }
         success = true;
      }
      return success;
   }

/* *delete removes a record on Doctors based on it;s Key
   *@param key - the Key of a Record
   *@return true if the Record is deleted successfully , false otherwise */
   public boolean delete(Key key){
      boolean success = false;
      int index = findLocation(key);
      while(Doctors[index] != null && index != NOT_FOUND){
         Doctors[index] = null;
         success = true;
      }
      return success;
   }

   public String[] allDoctors(){
      String[] doctor = new String[Doctors.length];
      for(int i = 0 ; i < Doctors.length ; i++){
         if(Doctors[i] != null){
            doctor[i] = Doctors[i].getName() + " " + Doctors[i].getSurname() + " ( " + Doctors[i].getKey().getUsername() + " ) : Specialization - " + Doctors[i].getSpecialization() + " ; Phone Number - " + Doctors[i].getPhoneNumber();
         }
      }
      return doctor;
   }
   
   public String[] DoctorsKeys(){
      String[] doctor = new String[Doctors.length];
      for(int i = 0 ; i < Doctors.length ; i++){
         if(Doctors[i] != null){
            doctor[i] = Doctors[i].getName() + " " + Doctors[i].getSurname() + " ( " + Doctors[i].getKey().getUsername() + " ) ( " + Doctors[i].getKey().getPassword() + " )";  }
      }
      return doctor;
   }

}