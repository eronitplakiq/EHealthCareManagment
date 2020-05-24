/* *Class Client_Database is a containter that contains the clients infos */
public class Client_Database{

   private Client_Record [] Clients;  //the collection of clients records
   private int NOT_FOUND = -1;   //int used to denote if a record is not found

/* *Client_Database initializes the database
   *@param initial_Size - the size of the database */

   public Client_Database(int initial_size){
   
      if(initial_size > 0){ Clients = new Client_Record[initial_size]; }
      else{ Clients = new Client_Record[1]; }
   
   }

/* *findLocation is a helper method that searches Clients for a record 
   *whose key is k. If found , the index of the record is returned,
   * else NOT_FOUND returned. */
   public int findLocation(Key k){
      int result = NOT_FOUND;
      boolean found = false;
      int i = 0;
      while(!found && i != Clients.length){
         if(Clients[i] != null && Clients[i].getKey().equals(k)){
            found = true;
            result = i;
         }
         else { i++; }
      }
      return result;
   }

/* *find locates a record in the database based on a key
   *@param key  - the key of the desired record
   *@return (the address of) the desired record
   *return null if the address is not found */
   public Client_Record find(Key k){
      Client_Record client = null;
      int index = findLocation(k);
      if(index != NOT_FOUND){
         client = Clients[index];}
      return client;
   }

/* *insert inserts a new record into the database
   *@param r - the record
   *@return true ,if record is added ; return false if record not added because another
   record with the same key exists in the database */
   public boolean insert(Client_Record cr){
      boolean success = false;
      if( findLocation(cr.getKey()) == NOT_FOUND ){
         boolean found_empty_element = false;
         int i = 0;
         while(!found_empty_element && i < Clients.length){
            if(Clients[i] == null){ found_empty_element = true; }
            else { i++; }
         }
         if(found_empty_element){
            Clients[i] = cr;
         }
         else{
            Client_Record [] temp = new Client_Record[Clients.length+1];
            for(int j = 0 ; j < Clients.length ; j++){
               temp[j] = Clients[j];   //Copy clients info to temp
            }
            temp[Clients.length] = cr;
            Clients = temp;
         }
         success = true;
      }
      return success;
   }

/* *delete removes a record in the database based on a key
   *@param key - the record's key
   *@return true , if record is found and deleted; return false otherwise */
   public boolean delete(Key k){
      boolean success = false;
      int index = findLocation(k);
      while(Clients[index] != null && index != NOT_FOUND){
         Clients[index] = null;
         success = true;
      }
      return success;
   }
   
   public String[] Patients(String s){
      String[] client = new String[Clients.length];
      for(int i = 0 ; i < Clients.length - 1 ; i++){
         if(Clients[i] != null && s.equals(Clients[i].getDoctor())){
            client[i] = Clients[i].getName() + " " + Clients[i].getSurname() + " ( " + Clients[i].getKey().getUsername() + " ) ; Visit Time : " + Clients[i].getVisit() + " ; Bed : " + Clients[i].getBed();
         }
         else{ client[i] = client[i+1]; }
      }
      return client;
   }
   
   public String[] allPatients(){
      String[] client = new String[Clients.length];
      for(int i = 0 ; i < Clients.length ; i++){
         if(Clients[i] != null){
            client[i] = Clients[i].getName() + " " + Clients[i].getSurname() + " ( " + Clients[i].getKey().getUsername() + " ) ; First Day : " + Clients[i].getDate() + " ; Charge : " + Clients[i].getCharge();
         }
      }
      return client;
   }
   
   public String[] PatientsKeys(){
      String[] client = new String[Clients.length];
      for(int i = 0 ; i < Clients.length ; i++){
         if(Clients[i] != null){
            client[i] = Clients[i].getName() + " " + Clients[i].getSurname() + " ( " + Clients[i].getKey().getUsername() + " ) ( " + Clients[i].getKey().getPassword() + " )";
         }
      }
      return client;
   }
   
}