import javax.swing.*;

/*Key models a Log-In way
   @by username , password ,and what kind of user */

public class Key{

   private String username; //username of user
   private String password; //password of user

/* *Constructor Key constructs a user:
   *@param un - username of user
   *@param p - password
   *@param u - what kind of user he is */

   public Key(String un , String p){
   
      username = un;
      password = p;
   
   }

/* *equals returns whether the username , password, and user 
   * belongs to one of the users so he can log in
   *@return true if there is a user created with the identical info
   *return false otherwise */
   public boolean equals(Key k){
      String s1 = k.getUsername();
      String s2 = k.getPassword();
      return (s1.equals(username) && s2.equals(password));
   }
   
   public String getUsername(){
      return username.toLowerCase().trim(); //return the username
   }   
      
   public String getPassword(){
      return password.trim();   //return the password
   }

}