/**
   The potion subclass extends the Equipment superclass.
   A potion object gives a player a variable amount of health.
*/

//Imported class to obtain methods
import java.util.Random; 

public class Potion extends Equipment 
{
   //Create Random object
   Random healthPotion = new Random();
   
   //Create field initialized using Random object.
   private double health = (healthPotion.nextInt(50)+healthPotion.nextInt(50)+20);
   

     
   /**
      The getHealingAmount returns a Potion object's health.
      @return The amount healed by the potion.
   */
   public double getHealingAmount()
   {
      return health;
   }
   
   /**
      The drink method adds the healing potion value to a Fighter object's health.
      @param person The character being healed by health potion/
   */
   public double drink(Character person)
   {
      if(person.getHealth()+health<=person.getMaxHealth()){
         person.setHealth(person.getHealth()+health);
         }
      else{
         person.setHealth(person.getMaxHealth());
         }
      return 0;
   }
   
   /**
      The getDescription method returns a description of the potion object.
      @return The description of the potion.
   */
   public String getDescription()
   {
      String str = "This health potion will heal "+health +" HP.";
      return str;
   }
}
